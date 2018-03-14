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
 		$(function(){
 			
 			var id = {};
 			var eid ='';
			dd.ready(function() {
				//alert(431)
				 dd.ui.pullToRefresh.disable()
				 dd.biz.user.get({
		            corpId:'ding1a13187eee6ac35435c2f4657eb6378f', // 可选参数，如果不传则使用用户当前企业的corpId。
		            onSuccess: function (info) {
		                $("#userid").val(info.emplId);
		                id["emplId"] = info.emplId;
		                eid = info.emplId;
		                beginbyme(info.emplId);
		            },
		            onFail: function (err) {
		                logger.e('userGet fail: ' + JSON.stringify(err));
		            }
		        });
			 })
			 
			 $("#faqi").bind("click",function(){
			
				 beginbyme(eid);
				 
			 });
			 
			 
			 $("#chaosong").bind("click",function(){
				$.post("getExamineByCc.do",id,function(date){
					
					$("#concard div").remove();
					$.each(date,function(){
						var info ="";
						info +=('<div class="card weui-navbar__item">'
							+'<div style="padding: 0rem .75rem;" valign="bottom" class="card-header color-white no-border">调课申请</div>'
							+'<div class="weui-form-preview__bd" style="padding: 0rem .75rem;">'
								+'<div class="weui-form-preview__item">'
									+'<label class="weui-form-preview__label">发起人</label>'
									+'<span class="weui-form-preview__value">'+this.ccTeacher.name+'</span>'
								+'</div>'
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
								+'</div>')
						if(this.pass==0){
							info += ('<div class="weui-form-preview__item">'
										+'<label class="weui-form-preview__label">审批状态</label>'
										+'<span class="weui-form-preview__value">待审批</span>'
									+'</div>')
						}
						if(this.pass==1){
							info += ('<div class="weui-form-preview__item">'
										+'<label class="weui-form-preview__label">审批状态</label>'
										+'<span class="weui-form-preview__value">已通过</span>'
									+'</div>')
						}
						if(this.pass==2){
							info += ('<div class="weui-form-preview__item">'
										+'<label class="weui-form-preview__label">审批状态</label>'
										+'<span class="weui-form-preview__value">拒绝</span>'
									+'</div>')
						}
						info += ('</div>'
							    +'</div>')
						var $dom = $(info)
					$("#concard").append($dom);
					})
					
				}); 
			 });
		})
		
		function getDateStr(date) {
			if (date == null) {
				return "";
			}
			var d = new Date(date);
			
			return d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
		}
		
		function beginbyme(uid){
			var params = {};
			params["beginId"] = uid;
			$.post("getExamineByBeginId.do",params,function(date){
				
				$("#concard div").remove();
				$.each(date,function(){
					var info = "";
					info += ('<div class="card weui-navbar__item">'
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
								+'</div>')
								if(this.pass==0){
									info += ('<div class="weui-form-preview__item">'
												+'<label class="weui-form-preview__label">审批状态</label>'
												+'<span class="weui-form-preview__value">待审批</span>'
											+'</div>')
								}
								if(this.pass==1){
									info += ('<div class="weui-form-preview__item">'
												+'<label class="weui-form-preview__label">审批状态</label>'
												+'<span class="weui-form-preview__value">已通过</span>'
											+'</div>')
								}
								if(this.pass==2){
									info += ('<div class="weui-form-preview__item">'
												+'<label class="weui-form-preview__label">审批状态</label>'
												+'<span class="weui-form-preview__value">拒绝</span>'
											+'</div>')
								}
								info += ('</div>'
									    +'</div>')	
					var $dom = $(info)
				$("#concard").append($dom);
				})
			})
		}
		
// 		function beginbyme1(uid){
// 			beginbyme($(uid).parents(".weui-navbar").find(":hidden").val());
// 		}
		
// 		function approvalbyme1(uid){
// 			var params = {};
// 			params["registerId"] = $(uid).parents(".weui-navbar").find(":hidden").val();
// 			$.get("getDocumentByCopy",params,function(date){
// 				$("#concard div").remove();
// 				$.each(date,function(){
// 					var $dom = $('<div class="card weui-navbar__item" onclick="toinfo(this)" vae="'+this.id+'">'
// 							+'<div style="padding: 0rem .75rem;" valign="bottom" class="card-header color-white no-border">'+this.documentName+'</div>'
// 							+'<div class="weui-form-preview__bd" style="padding: 0rem .75rem;">'
// 							+'<div class="weui-form-preview__item">'
// 							+'<label class="weui-form-preview__label">文件类型</label>'
// 							+'<span class="weui-form-preview__value">'+this.documentCode+'</span>'
// 							+'</div>'
// 							+'<div class="weui-form-preview__item">'
// 							+'<label class="weui-form-preview__label">文件类型</label>'
// 							+'<span class="weui-form-preview__value">'+this.documentType.typeName+'</span>'
// 							+'</div>'
// 							+'<div class="weui-form-preview__item">'
// 							+'<label class="weui-form-preview__label">紧急程度</label>'
// 							+'<span class="weui-form-preview__value">'+this.urgencyDegree.urgencyDegreeName+'</span>'
// 							+'</div>'
// 							+'<div class="weui-form-preview__item">'
// 							+'<label class="weui-form-preview__label" style="color: #f44;">'+this.documentState.stateName+'</label>'
// 							+'</div>'
// 							+'</div>'
// 							+'</div>')
// 				$("#concard").append($dom);
// 				})
// 			})
// 		}
		
// 		function toinfo(todo){
// 			var id = $(todo).attr("vae");
// 			var uid = $("#userid").val()
// 			window.location = "getDocument?id="+id+"&userid="+uid+"&_method='GET'";
// 		}
		
		function appmana(){
			window.location = "approvalmanager.jsp";
		}
			
		</script>
		<style type="text/css">
			.weui-navbar img {
				width: 46px;
				height: 46px;
				margin-left: -10px;
			}
			.weui-navbar p {
				font-size: 14px;
			}
			.card{
				padding: 0px;
				cursor: pointer;
			}
			.card *{
				line-height: 20px;
			}
		</style>

	</head>

	<body>
		<div class="page" style="background-color: rgb(245,245,245);">
			<div class="weui-tab">
				<div class="weui-navbar">
					<input type="hidden" id="userid" value=""/>
					
					<div class="weui-navbar__item" id="faqi">
						<a href="javascript:;"  class="weui-tabbar__item">
							<div class="weui-tabbar__icon">
								<img src="WEUI/images/icon_launch.png" alt="">
							</div>
							<p class="weui-tabbar__label">我发起的</p>
						</a>
					</div>
					
					<div class="weui-navbar__item">
						<a href="javascript:;" onclick="appmana()" class="weui-tabbar__item">
<!-- 							<span class="weui-badge" style="position: absolute;top: .8em;right: 1em;"></span> -->
							<div class="weui-tabbar__icon">
								<img src="WEUI/images/icon_approval.png" alt="">
							</div>
							<p class="weui-tabbar__label">我审批的</p>
						</a>
					</div>
					
					<div class="weui-navbar__item" id="chaosong">
						<a href="javascript:;"  class="weui-tabbar__item">
							<div class="weui-tabbar__icon">
								<img src="WEUI/images/icon_tome.png" alt="">
							</div>
							<p class="weui-tabbar__label">抄送我的</p>
						</a>
					</div>
				</div>
				<div class="content" style="margin-top: 110px;padding-top: 20px;">
					<div class="page-index" id="concard">
						
<!-- 						<div class="card weui-navbar__item"> -->
<!-- 							<div style="padding: 0rem .75rem;" valign="bottom" class="card-header color-white no-border">发起人</div> -->
<!-- 							<div class="weui-form-preview__bd" style="padding: 0rem .75rem;"> -->
<!-- 								<div class="weui-form-preview__item"> -->
<!-- 									<label class="weui-form-preview__label">文件名</label> -->
<!-- 									<span class="weui-form-preview__value">电动打蛋机</span> -->
<!-- 								</div> -->
<!-- 								<div class="weui-form-preview__item"> -->
<!-- 									<label class="weui-form-preview__label">文件类型</label> -->
<!-- 									<span class="weui-form-preview__value">名字名字名字</span> -->
<!-- 								</div> -->
<!-- 								<div class="weui-form-preview__item"> -->
<!-- 									<label class="weui-form-preview__label">紧急程度</label> -->
<!-- 									<span class="weui-form-preview__value">很长的名字</span> -->
<!-- 								</div> -->
<!-- 								<div class="weui-form-preview__item"> -->
<!-- 									<label class="weui-form-preview__label" style="color: #f44;">审批状态</label> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div>					 -->

						
					</div>
				</div>

			</div>

		</div>
		</div>
	</body>

</html>