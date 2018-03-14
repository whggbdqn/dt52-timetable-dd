/**
 * Created by liqiao on 8/10/15.
 */

/**
 * _config comes from server-side template. see views/index.jade
 * 
 */

dd.config({
	 
	agentId : _config.agentid,
	corpId : _config.corpId,
	timeStamp : _config.timeStamp,
	nonceStr : _config.nonceStr,
	signature : _config.signature,
	jsApiList : ['runtime.info', 'biz.contact.choose',
			'device.notification.confirm', 'device.notification.alert',
			'device.notification.prompt', 'biz.ding.post',
			'device.screen.rotateView', 'device.screen.resetView',
			'biz.util.openLink', 'biz.contact.chooseMobileContacts',
			'device.launcher.launchApp','biz.user.get','biz.contact.complexChoose','biz.chat.pickConversation']
});

// 用来存储用户信息
var user = {};



dd.ready(function() {
	
	$(".shenpi").bind("click",function(){
		dd.biz.contact.complexChoose({
		"startWithDepartmentId":-1,
		"selectedUsers":[],
		"isNeedSearch":true,
		"corpId":"ding1a13187eee6ac35435c2f4657eb6378f",
		"disabledUsers":[],
		"selectedDepartments":[],
		"title":"测试1",
		"limitTips":"测试2",
		"pickTips":"测试3"
		});
	});

	
/**
 * 运行时信息
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
		title : '自动排课系统',
		onSuccess : function(data) {

		},
		onFail : function(err) {
			log.e(JSON.stringify(err));
		}
	});
/**
 * 禁止下拉刷新
 */
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
//			将用户信息存入json对象中
			user["emplId"] = info.emplId;
			user["name"] = info.nickName;
//			logger.e('userGet success: ' + JSON.stringify(info));
			
//			调用查询课表方法
			mySchedule2(user);
		},
		onFail : function(err) {
			
			logger.e('userGet fail: ' + JSON.stringify(err));
		}
	});
	
	
	/**
	 * 设置右侧导航栏
	 */
	dd.biz.navigation.setMenu({
        backgroundColor : "#f3f3f3",
        textColor : "white",
        items : [
            {
                "id":"1",//字符串
            "iconId":"send",//字符串，图标命名
              "text":"刷新"
            },
            {
                "id":"2",
                "iconId":"send",
                "text":"刷新"
            },
            {
                "id":"3",
            "iconId":"group",
              "text":"我的班级"
            }
        ],
        onSuccess: function(data) {
        /*
        {"id":"1"}
        */
        	if(data.id == 2){
//        		刷新页面
        		$(location).attr('href', 'http://192.168.137.1:8080/app/MyTable1.jsp?dd_orientation=auto&dd_orientation=landscape');
        	};
        	if(data.id == 3){
//        		跳转到我的班级页面
        		$(location).attr('href', 'http://192.168.137.1:8080/app/MyTable.jsp?dd_orientation=auto&dd_orientation=landscape');
        	};
        },
        onFail: function(err) {
        }
    });
	
	dd.runtime.permission.requestAuthCode({
		corpId : _config.corpId,
		onSuccess : function(info) {
			// alert('authcode: ' + info.code);
			$.ajax({
				url : 'userinfo?code=' + info.code + '&corpid=' + _config.corpId,
				type : 'GET',
				success : function(data, status, xhr) {
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
	//alert(147)
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

// 根据日期字符串获取星期几
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
 * 通过钉钉emplId 查询老师的一周课表
 * @param emplId
 */
function mySchedule2(data) {
	$.post("mySchedule.do", data, function(result) {
//		alert(123);
//		alert(JSON.stringify(data));
//		alert(JSON.stringify(result));
		var $tr = "";
		$.each(result, function() {
			
			$tr = "<tr><td><span>" + getDateStr(this.curDate)
			+ "</span>/<span>" + getWeek(getDateStr(this.curDate))
			+ "</span></td>";
			
//			$tr = "<tr><td>"+getCurTime()+"</td>";
			
			$.each(this.classTime,function(){
				
				if (this && this.className ) {
					$tr += "<td name='schedulePk' value="+this.schedulePk+">" + this.className + "  " +this.courseContent+ "  "+this.roomName+"</td>";
				} else {
					$tr += "<td></td>";
				}
			});
			
			$tr += "</tr>";
			$("#tab>tbody").append($tr);
		});
		
		$("#tab>tbody>tr:gt(0) td:gt(0)").on('click',function(event){
			if($(this).index()>0 && $(this).text() != ""){
//				alert(789);
				var i = $(this).attr("value");
				var y = user["emplId"];
				$(location).attr('href', 'getOneScheduleById.do?schedulePK='+i+'&emplId='+y);
			};
		});
	});
}



