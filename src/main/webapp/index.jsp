<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title></title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no, maximum-scale=1">
<meta name="description" content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<link rel="stylesheet" type="text/css" href="WEUI/weui.min.css" />
<link rel="stylesheet" type="text/css" href="WEUI/demos.css" />

<script src="WEUI/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="WEUI/zepto.min.js"></script>
<script type="text/javascript">
	_config = <%=com.alibaba.dingtalk.openapi.demo.auth.AuthHelper.getConfig(request)%>;
</script>
<script type="text/javascript" src="tab/js/dingtalk.js"></script>
<!--  免登相关代码 -->
<script type="text/javascript" src="javascripts/index.js"></script>
<script>
	$(function() {
		dd.ready(function() {
			dd.ui.pullToRefresh.disable()
		
			dd.device.screen.rotateView({
			    showStatusBar : true, // 否显示statusbar
			    clockwise : true, // 是否顺时针方向
			    onSuccess : function(result) {
			    },
			    onFail : function(err) {}
			});
		})
	});
</script>
<style>
.weui-footer {
	margin: 25px 0 10px 0;
}
</style>
</head>

<body ontouchstart>
	<header class='demos-header'>
		<h3 class="demos-title">自动排课系统</h3>
		<p class='demos-sub-title'>课程的安排、调整、管理......</p>
	</header>
	<div class="weui-grids">

		<a href="MyTable1.jsp?dd_orientation=auto&dd_orientation=landscape" class="weui-grid js_grid">
			<div class="weui-grid__icon">
				<img src="light7/img/icon_fileupload.png" alt="">
			</div>
			<p class="weui-grid__label">我的课表</p>
		</a>
		<a href="MyTable.jsp?dd_orientation=auto&dd_orientation=landscape" class="weui-grid js_grid">
			<div class="weui-grid__icon">
				<img src="light7/img/icon_maillist.png" alt="">
			</div>
			<p class="weui-grid__label">班级课表</p>
		</a>
		<a href="approval.jsp" class="weui-grid js_grid">
			<div class="weui-grid__icon">
				<img src="light7/img/icon_approvalmanager.png" alt="">
			</div>
			<p class="weui-grid__label">审批管理</p>
		</a>
		<script type="text/javascript">
			function tongxin() {
				dd.ready(function() {
							dd.biz.contact.complexPicker({
										title : "通讯", //标题
										corpId : "ding390a41a80a68b44335c2f4657eb6378f", //企业的corpId
										multiple : false, //是否多选
										limitTips : "超出了", //超过限定人数返回提示
										maxUsers : 10, //最大可选人数
										pickedUsers : [], //已选用户
										pickedDepartments : [], //已选部门
										disabledUsers : [], //不可选用户
										disabledDepartments : [], //不可选部门
										requiredUsers : [], //必选用户（不可取消选中状态）
										requiredDepartments : [], //必选部门（不可取消选中状态）
										appId : 157593334, //微应用的Id
										permissionType : "xxx", //选人权限，目前只有GLOBAL这个参数
										responseUserOnly : true, //返回人，或者返回人和部门
										onSuccess : function(result) {
											/**
											{
											    selectedCount:1,                              //选择人数
											    users:[{"name":"","avatar":"","emplId":""}]，//返回选人的列表，列表中的对象包含name（用户名），avatar（用户头像），emplId（用户工号）三个字段
											    departments:[{"id":,"name":"","number":}]//返回已选部门列表，列表中每个对象包含id（部门id）、name（部门名称）、number（部门人数）
											}
											 */
											var _emplId = result.users[0].emplId
											dd.ready(function() {
														//打开担任消息页面
														dd.biz.chat
																.openSingleChat({
																	corpId : 'ding390a41a80a68b44335c2f4657eb6378f', // 企业id
																	userId : _emplId, // 用户的工号
																	onSuccess : function() {
																	},
																	onFail : function() {
																	}
																})
														
													});
										},
										onFail : function(err) {
										}
									});
						});
			}
		</script>
		<a href="selectfile.jsp?dd_orientation=landscape&dd_orientation=auto" class="weui-grid js_grid">
			<div class="weui-grid__icon">
				<img src="light7/img/icon_record.png" alt="">
			</div>
			<p class="weui-grid__label">课程调整</p>
		</a>
		<a href="information.jsp" class="weui-grid js_grid">
			<div class="weui-grid__icon">
				<img src="light7/img/icon_personal.png" alt="">
			</div>
			<p class="weui-grid__label">个人中心</p>
		</a> 
		<a href="setting.jsp" class="weui-grid js_grid">
			<div class="weui-grid__icon">
				<img src="light7/img/icon_QRcode.png" alt="">
			</div>
			<p class="weui-grid__label">生成二维码</p>
		</a> 
		<a href="javascript:void(0);" onclick="shaoma();"
			class="weui-grid js_grid">
			<div class="weui-grid__icon">
				<img src="light7/img/icon_scan.png" alt="">
			</div>
			<p class="weui-grid__label">扫一扫</p>
		</a>
		<script type="text/javascript">
			function shaoma() {
				dd.ready(function() {
					dd.biz.util.scan({
						type : "all", // type 为 all、qrCode、barCode，默认是all。
						onSuccess : function(data) {
							/*onSuccess将在扫码成功之后回调
							   data结构
							    { 'text': String}
							 */
						},
						onFail : function(err) {
						}
					})
				});
			}
		</script>

		<a href="useinfo.jsp" class="weui-grid js_grid">
			<div class="weui-grid__icon">
				<img src="light7/img/icon_introduction.png" alt="">
			</div>
			<p class="weui-grid__label">使用说明</p>
		</a> 
		<a href="setting.jsp" class="weui-grid js_grid">
			<div class="weui-grid__icon">
				<img src="light7/img/icon_config.png" alt="">
			</div>
			<p class="weui-grid__label">设置</p>
		</a>
	</div>
	<div class="weui-footer weui-footer_fixed-bottom">
		<p class="weui-footer__links">
			<a href="javascript:;" class="weui-footer__link">自动排课系统 首页</a>
		</p>
		<p class="weui-footer__text">Create © 2018 By bdqn</p>
	</div>
</body>
</html>