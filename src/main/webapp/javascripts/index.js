

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
            }
        ],
        onSuccess: function(data) {
        /*
        {"id":"1"}
        */
        	if(data.id == 2){
//        		刷新页面
        		$(location).attr('href', 'http://192.168.137.1:8080/app/index.jsp');
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
	dd.error(function(err) {
		alert('dd error: ' + JSON.stringify(err));
	});
});




