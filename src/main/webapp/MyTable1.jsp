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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>自动排课系统</title>
</head>

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
<script src="light7/js/jquery-3.2.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript" src="tab/js/dingtalk.js"></script>
<script type="text/javascript">
	//在此拿到jsAPI权限验证配置所需要的信息
	var _config =<%=com.alibaba.dingtalk.openapi.demo.auth.AuthHelper.getConfig(request)%>;
	
</script>
<script type="text/javascript" src="javascripts/demo.js"></script>

<body>
	<div id="by">
		<div class="table-responsive"
			style="text-align: center; margin: auto 0">
			<table class="table table-bordered" id="tab">
				<thead>
					<tr style="background-color: #d9edf7">
						<td colspan="4">我的课表</td>
					</tr>
				</thead>
				<tbody>
					<tr style="background-color: #f5f5f5;">
						<td>日期/星期</td>
						<td>上午（8:10-12:20）</td>
						<td>下午（13:40-17:50）</td>
						<td>晚上（18:30-20:20）</td>
					</tr>
				</tbody>
			</table>
			
		</div>
	</div>
</body>
</html>