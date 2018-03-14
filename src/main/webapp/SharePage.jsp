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

<script type="text/javascript">
 $(function(){
// 	 获取请求URL的参数
	 function GetRequest() {   
		   var url = location.search; //获取url中"?"符后的字串   
// 				   alert(url);
		   var theRequest = new Object();   
		   if (url.indexOf("?") != -1) {   
		      var str = url.substr(1);   
		      strs = str.split("&");   
		      for(var i = 0; i < strs.length; i ++) {   
		         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);   
		      }   
		   }   
		   return theRequest;   
		}
	 
	 
	 var sharePk = {};
	 sharePk["classPk"] = GetRequest().classPk;
// 	 alert(sharePk["classPk"]);
	 $.post("myClassSchedule.do",sharePk,function(result){
// 		 		alert(JSON.stringify(sharePk));
// 		 		alert(JSON.stringify(result));
				 		
				var $tr = "";
				$.each(result, function() {
// 					alert(JSON.stringify(this));
			 		
					$tr += "<tr><td><span>" + getDateStr(this.curDate)
					+ "</span>/<span>" + getWeek(getDateStr(this.curDate))
					+ "</span></td>";
					
					$.each(this.classTime,function(){
//		 				在表头显示班级名称
						$("#tab>thead>tr>td").text(this.className);
						if (this && this.className ) {
							$tr += "<td name='schedulePk' value="+this.schedulePk+">" + this.roomName +" "+ this.courseContent+ "</td>";
						} else {
							$tr += "<td></td>";
						}
					});
					
					$tr += "</tr>";
				});
				$("#tab>tbody").append($tr);
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
 });
</script>

<body>
	<div id="by">
		<div class="table-responsive" style="text-align: center; margin: auto 0">
			<table class="table table-bordered" id="tab">
				<thead>
					<tr style="background-color: #d9edf7">
						<td colspan="4"></td>
					</tr>
				</thead>
				<tbody>
					<tr style="background-color: #f5f5f5;">
						<td>日期/星期</td>
						<td>上午（8:10-12:20）</td>
						<td>下午（13:40-5:50）</td>
						<td>晚上（18:30-20:20）</td>
					</tr>
				</tbody>
			</table>
			
		</div>
	</div>
</body>
</html>

