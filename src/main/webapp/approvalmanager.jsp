<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>审批管理</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
		<meta name="description" content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.">
		<link rel="stylesheet" type="text/css" href="WEUI/weui.min.css" />
		<link rel="stylesheet" type="text/css" href="static/css/light7.min.css" />
		<link rel="stylesheet" type="text/css" href="static/css/light7-swiper.min.css" />
		<script src="static/js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="WEUI/jquery-weui.min.js"></script>
		<script src="static/js/light7.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			_config = <%=com.alibaba.dingtalk.openapi.demo.auth.AuthHelper.getConfig(request)%>;
		</script>
		<script type="text/javascript" src="javascripts/zepto.min.js"></script>
		<script type="text/javascript" src="tab/js/dingtalk.js"></script>
		<!--  免登相关代码 -->
		<script type="text/javascript" src="javascripts/demo.js"></script>
		<script type="text/javascript">
			$(function() {
				dd.ready(function() {
					 dd.ui.pullToRefresh.disable()
					 dd.biz.user.get({
			            corpId:'ding1a13187eee6ac35435c2f4657eb6378f', // 可选参数，如果不传则使用用户当前企业的corpId。
			            onSuccess: function (info) {
			            	//alert(info.emplId)
			            	
			            	$("#userid").val(info.emplId)
			                approvalbyme2(info.emplId);
			                approvalbyme1(info.emplId);
			            },
			            onFail: function (err) {
			                logger.e('userGet fail: ' + JSON.stringify(err));
			            }
			        });
				 })
			})
			
			function toinfo(todo){
				var id = $(todo).attr("vae");
				var uid = $("#userid").val()
				window.location = "getDocument?id="+id+"&userid="+uid+"&_method='GET'";
			}
			
			function agree(examinePk){
				dd.device.notification.confirm({
				    message: "确定同意该申请吗",
				    title: "提示",
				    buttonLabels: ['确认', '取消'],
				    onSuccess : function(result) {
				    	if(result.buttonIndex==0){
				    		window.location = "agree.do?examinePk="+examinePk;
				    	}
				    },
				    onFail : function(err) {}
				});
				
// 				window.location.href = "approvalmanager.jsp";
			}
			
			function refuse(examinePk){
				dd.device.notification.confirm({
				    message: "确定拒绝该申请吗",
				    title: "提示",
				    buttonLabels: ['确认', '取消'],
				    onSuccess : function(result) {
				    	if(result.buttonIndex==0){
				    		window.location = "refuse.do?examinePk="+examinePk;
				    	}
				    },
				    onFail : function(err) {}
				});
				
			}
			
			function approvalbyme1(userid){
				var params = {};
				params["examineId"] = userid;
				$.post("getExamineByExamine.do",params,function(date){
					$("#content1 div").remove();
					$.each(date,function(){
						$dom = $(
								'<div class="card weui-navbar__item">'
								+'<div style="padding: 0rem .75rem;" valign="bottom" class="card-header color-white no-border">调课申请</div>'
								+'<div class="weui-form-preview__bd" style="padding: 0rem .75rem;">'
									+'<div class="weui-form-preview__item">'
										+'<label class="weui-form-preview__label">日期</label>'
										+'<span class="weui-form-preview__value">'+getDateStr(this.schDate)+'</span>'
									+'</div>'
									+'<div class="weui-form-preview__item">'
										+'<label class="weui-form-preview__label">班级名称</label>'
										+'<span class="weui-form-preview__value">'+this.className.className+'</span>'
									+'</div>'
									+'<div class="weui-form-preview__item">'
										+'<label class="weui-form-preview__label">老师</label>'
										+'<span class="weui-form-preview__value">'+this.teacherName.name+'</span>'
									+'</div>'
									+'<div class="weui-form-preview__item">'
										+'<label class="weui-form-preview__label">教室</label>'
										+'<span class="weui-form-preview__value">'+this.roomName.roomName+'</span>'
									+'</div>'
									+'<div class="weui-form-preview__item">'
										+'<label class="weui-form-preview__label">事由</label>'
										+'<span class="weui-form-preview__value">'+this.cause+'</span>'
									+'</div>'
									+'<div class="weui-form-preview__item">'
										+'<label class="weui-form-preview__label">操作</label>'
										+'<span class="weui-form-preview__value"><a href="javascript:;" onclick="agree('+this.examinePk+')">同意</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:;" onclick="refuse('+this.examinePk+')">拒绝</a></span>'
									+'</div>'
								+'</div>'
							+'</div>'
								)
					$("#content1").append($dom);
					})
				})
			}
			
			function approvalbyme2(userid){
				var params = {};
				params["examineId"] = userid;
				$.post("getExamineByExamine2.do",params,function(date){
					$("#content2 div").remove();
					$.each(date,function(){
						$dom = $(
								'<div class="card weui-navbar__item">'
								+'<div style="padding: 0rem .75rem;" valign="bottom" class="card-header color-white no-border">调课申请</div>'
								+'<div class="weui-form-preview__bd" style="padding: 0rem .75rem;">'
									+'<div class="weui-form-preview__item">'
										+'<label class="weui-form-preview__label">日期</label>'
										+'<span class="weui-form-preview__value">'+getDateStr(this.schDate)+'</span>'
									+'</div>'
									+'<div class="weui-form-preview__item">'
										+'<label class="weui-form-preview__label">班级名称</label>'
										+'<span class="weui-form-preview__value">'+this.className.className+'</span>'
									+'</div>'
									+'<div class="weui-form-preview__item">'
										+'<label class="weui-form-preview__label">老师</label>'
										+'<span class="weui-form-preview__value">'+this.teacherName.name+'</span>'
									+'</div>'
									+'<div class="weui-form-preview__item">'
										+'<label class="weui-form-preview__label">教室</label>'
										+'<span class="weui-form-preview__value">'+this.roomName.roomName+'</span>'
									+'</div>'
									+'<div class="weui-form-preview__item">'
										+'<label class="weui-form-preview__label">事由</label>'
										+'<span class="weui-form-preview__value">'+this.cause+'</span>'
									+'</div>'
								+'</div>'
							+'</div>'
								)
					$("#content2").append($dom);
					})
				})
			}
			
			
		</script>
		<style type="text/css">
			.card {
				padding: 0px;
				cursor: pointer;
			}
			.card * {
				line-height: 20px;
			}
		</style>

	</head>

	<body>

		<div class="page" style="background-color: rgb(245,245,245);">
			<input type="hidden" id="userid" value=""/>
			<div class="buttons-tab">
				<a href="#tab1" class="tab-link active button">待我审批的<span></span></a>
				<a href="#tab2" class="tab-link button">我已审批的</a>
			</div>
			<div class="content" style="margin-top: 20px;">
				<div class="content-block">
					<div class="tabs">
						<div id="tab1" class="tab active">
							<div class="page-index" id="content1">
							
							</div>
						</div>
						<div id="tab2" class="tab">
							<div class="page-index" id="content2">
<!-- 								<div class="card weui-navbar__item"> -->
<!-- 									<div style="padding: 0rem .75rem;" valign="bottom" class="card-header color-white no-border">发起人</div> -->
<!-- 									<div class="weui-form-preview__bd" style="padding: 0rem .75rem;"> -->
<!-- 										<div class="weui-form-preview__item"> -->
<!-- 											<label class="weui-form-preview__label">文件名</label> -->
<!-- 											<span class="weui-form-preview__value">电动打蛋机</span> -->
<!-- 										</div> -->
<!-- 										<div class="weui-form-preview__item"> -->
<!-- 											<label class="weui-form-preview__label">文件类型</label> -->
<!-- 											<span class="weui-form-preview__value">名字名字名字</span> -->
<!-- 										</div> -->
<!-- 										<div class="weui-form-preview__item"> -->
<!-- 											<label class="weui-form-preview__label">紧急程度</label> -->
<!-- 											<span class="weui-form-preview__value">很长的名字</span> -->
<!-- 										</div> -->
<!-- 										<div class="weui-form-preview__item"> -->
<!-- 											<label class="weui-form-preview__label" style="color: #f44;">审批状态</label> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</body>

</html>