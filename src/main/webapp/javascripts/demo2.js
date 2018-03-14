/**
 * Created by liqiao on 8/10/15.
 */

/**
 * _config comes from server-side template. see views/index.jade
 */
dd.config({
	 
	agentId : _config.agentid,
	corpId : _config.corpId,
	timeStamp : _config.timeStamp,
	nonceStr : _config.nonceStr,
	signature : _config.signature,
	jsApiList : [ 'runtime.info', 'biz.contact.choose',
			'device.notification.confirm', 'device.notification.alert',
			'device.notification.prompt', 'biz.ding.post',
			'device.screen.rotateView', 'device.screen.resetView',
			'biz.util.openLink', 'biz.contact.chooseMobileContacts',
			'device.launcher.launchApp','biz.user.get' ]
});

// 用来存储用户信息
var user = {};
var classes = {};
var sharePk = "";

dd.ready(function() {
	
/**
 * 运行信息
 */
	dd.runtime.info({
		onSuccess : function(info) {
			logger.e('runtime info: ' + JSON.stringify(info));
		}
	});
	
	/**
	 * 设置标题栏
	 */
	dd.biz.navigation.setTitle({
		title : '我的班级',
		onSuccess : function(data) {

		},
		onFail : function(err) {
			log.e(JSON.stringify(err));
		}
	});

	dd.ui.pullToRefresh.disable({
	    onSuccess: function() {
	    },
	    onFail: function() {
	    }
	})

	/**
	 * 获取用户信息
	 */ 
	dd.biz.user.get({
		corpId : _config.corpId, // 可选参数，如果不传则使用用户当前企业的corpId。
		onSuccess : function(info) {
			user["emplId"] = info.emplId;
			user["name"] = info.nickName;
			
			classList(user);
		},
		onFail : function(err) {
			logger.e('userGet fail: ' + JSON.stringify(err));
		}
	});
	
	
	dd.biz.navigation.setMenu({
        backgroundColor : "#f3f3f3",
        textColor : "white",
        items : [
			{
			    "id":"1",//字符串
			"iconId":"more",//字符串，图标命名
			  "text":"帮助"
			},
            {
                "id":"2",
            "iconId":"photo",
              "text":"刷新"
            },
            {
                "id":"3",
            "iconId":"reply",
              "text":"分享",
            }
        ],
        onSuccess: function(data) {
        	
        /*
        {"id":"1"}
        */
        	if(data.id==2){
        		$(location).attr('href', 'http://192.168.137.1:8080/app/MyTable.jsp');
        	};
        	if(data.id==3){
        		// 分享
        		 dd.biz.util.share({
        		 type: 0,//分享类型，0:全部组件 默认； 1:只能分享到钉钉；2:不能分享，只有刷新按钮
        		 url: "http://192.168.137.1:8080/app/SharePage.jsp?classPk="+sharePk,
        		 title: "班级课表",
        		 content: "新的一周课表已经出来啦！猛戳我查看！",
        		 image: "http://192.168.137.1:8080/app/src/main/webapp/light7/img/猛戳.png",
        		 onSuccess : function() {
        		 //onSuccess将在调起分享组件成功之后回调
        		 /**/
        		 },
        		 onFail : function(err) {}
        		 })
        	}
        },
        onFail: function(err) {
        }
    });
	
	dd.runtime.permission.requestAuthCode({
		corpId : _config.corpId,
		onSuccess : function(info) {
			// alert('authcode: ' + info.code);
			$.ajax({
				url : 'userinfo?code=' + info.code + '&corpid='
						+ _config.corpId,
				type : 'GET',
				success : function(data, status, xhr) {
					// alert(data);
					var info = JSON.parse(data);
					// 图片
					if (info.avatar.length != 0) {
						var img = document.getElementById("userImg");
						img.src = info.avatar;
						img.height = '100';
						img.width = '100';
					}
				},
				error : function(xhr, errorType, error) {
					logger.e("yinyien:" + _config.corpId);
					alert(errorType + ', ' + error);
				}
			});
		},
		onFail : function(err) {
			alert('fail: ' + JSON.stringify(err));
		}
	});
	
	dd.error(function(err) {
		alert('dd error: ' + JSON.stringify(err));
	});
	
});



/**
 * 后台返回一个时间毫秒数，通过此方法转换成指定格式的字符串
 * @param date
 * @returns {String}
 */
function getDateStr(date) {
	if (date == null) {
		return "";
	}
	var d = new Date(date);
	
	return d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
}



/**
 * 根据日期字符串获取星期几
 */ 
function getWeek(dateString) {
	if (dateString == ""){
		return "";
	}
	var dateArray = dateString.split("-");
	var date = new Date(dateArray[0], parseInt(dateArray[1] - 1), dateArray[2]);
	// var weeks = new Array("日", "一", "二", "三", "四", "五", "六");
	// return "星期" + weeks[date.getDay()];
	return "星期" + "日一二三四五六".charAt(date.getDay());
};


/**
 * 班级列表
 * @param userinfo
 */
function classList(userinfo){
	
	$.post("myClassList.do",userinfo,function(result){
//		alert(JSON.stringify(result));
		var $tabs = "";
//		班级列表
		$.each(result, function() {
			$tabs += "<div class='tabClasses' value="+this.classPk+">"+this.className+"</div>";
		});
		
		$("#tabs").append($tabs);
//		给班级列表动态设置宽度
		var length = $("#tabs").children().length;
		var width = 100/length;
		$(".tabClasses").css("width",width+"%");
//		当页面加载时，默认显示第一个班级课表
		classes["classPk"] = result[0].classPk;
		myClassSchedule(classes);
//		分享时传入的班级pk
		sharePk = result[0].classPk;
		
//		alert(JSON.stringify(classes["classPk"]));
		$("#tabs .tabClasses:eq(0)").addClass("color");
		
//		绑定点击事件加载对应班级的课表
		$("#tabs .tabClasses").on('click',function(){
			
//			每次加载班级课表前移除之前课表
			$("#tab>tbody tr:gt(0)").remove();
//			给选中班级添加样式
			$(this).addClass("color");
			$(this).siblings().removeClass("color");
//			分享时传入的班级pk
			sharePk = $(this).attr("value");
//			alert(sharePk);
//			获取选中班级课表
			classes["classPk"] = $(this).attr("value");
//			alert(JSON.stringify(classes["classPk"]));
			myClassSchedule(classes);
//			alert(JSON.stringify(classes));
		});
	});
	
}

/**
 * 通过班级id的一个班级一周课表
 * @param emplId
 */
function myClassSchedule(data) {
	
	$.post("myClassSchedule.do", data, function(result) {
//		alert(JSON.stringify(data));
		var $tr = "";
		$.each(result, function() {
			
			$tr = "<tr><td><span>" + getDateStr(this.curDate)
			+ "</span>/<span>" + getWeek(getDateStr(this.curDate))
			+ "</span></td>";
			$.each(this.classTime,function(){
//				alert(JSON.stringify(this.courseName));
				if (this && this.className ) {
					$tr += "<td name='schedulePk' value="+this.schedulePk+">" + this.roomName + "  " +this.courseContent+"</td>";
				} else {
					$tr += "<td></td>";
				}
			});
			$tr += "</tr>";
			
			$("#tab>tbody").append($tr);
		});
//		给单元格绑定点击事件，跳转到调课页面
		$("#tab>tbody>tr:gt(0) td:gt(0)").on('click',function(event){
			if($(this).index()>0 && $(this).text() != ""){
				var schedulePK = $(this).attr("value");
				var emplId = user["emplId"];
				$(location).attr('href', 'getOneScheduleById.do?schedulePK='+schedulePK+'&emplId='+emplId);
			}
		});
	});
}



