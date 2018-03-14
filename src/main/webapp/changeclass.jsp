<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程详情</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<link rel="shortcut icon" href="/favicon.ico">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<link rel="stylesheet" href="static/css/light7.min.css">
<link rel="stylesheet" href="static/css/light7-swiper.min.css">

<base href="<%=basePath%>">

<script type='text/javascript' src='static/js/jquery-1.8.3.min.js' charset='utf-8'></script>
<script type='text/javascript' src='static/js/light7.min.js' charset='utf-8'></script>
<script type='text/javascript' src="static/js/light7-swiper.min.js" charset='utf-8'></script>
<script type="text/javascript">
	//在此拿到jsAPI权限验证配置所需要的信息
	var _config = <%=com.alibaba.dingtalk.openapi.demo.auth.AuthHelper
	.getConfig(request)%>;
		
</script>
<script type='text/javascript' src="tab/js/dingtalk.js"></script>
<script type="text/javascript" src="javascripts/demo.js"></script>
<script>
  $.config = {
    autoInit: true //no recommend
  }

  $(function(){
	  
	  $("#date").calendar();
	  	  
	  //班级下拉列表里获取的所有班级信息并且选中默认信息
	  $.post("getAllClasses.do",function(result){
		  $.each(result,function(){
			  
			  if(('${classtime.className}')==this.className){
			  var $option = $('<option selected value="'+this.classPk+'">'+this.className+'</option>');
			  
			  $("#classname").append($option);
			  
			  return true;
			  }
			  
			  var $option = $('<option value="'+this.classPk+'">'+this.className+'</option>');
			  $("#classname").append($option);
		  });
	  });
	  
	  //教室下拉列表里获取的所有的教室信息并且选中默认信息
	  $.post("getAllRoom.do",function(result){
		  $.each(result,function(){
			  
			 if('${classtime.roomName}'==this.roomName){
			 var $option = $('<option selected value="'+this.roomId+'">'+this.roomName+'</option>');
			 $("#room").append($option);
			 return true;
			 }
			 
			 var $option = $('<option value="'+this.roomId+'">'+this.roomName+'</option>');
			 $("#room").append($option);
			 
		  });
	  });
	  
	  //课程下拉列表里获取的所有的课程信息
	  $.post("getAllCourse.do",function(result){
		  
		 $.each(result,function(){
			if('${classtime.courseContent}'==this.courseContent){ 
				
			var $option = $('<option selected value="'+this.coursePk+'">'+this.courseContent+'</option>');
			$("#course").append($option);
			return true;
		 }
			var $option = $('<option  value="'+this.coursePk+'">'+this.courseContent+'</option>');
			$("#course").append($option);
			
		 });
	  });
	  
	  
	  //教师下拉框里获取所有的教师信息并且选中默认的教师 
	  $.post("getAllTeacher.do",function(result){
		  $.each(result,function(){
			  
			  if('${classtime.teacherName}'==this.name){
				  
				  var $option = $('<option selected value="'+this.teacherId+'">'+this.name+'</option>');
				  $("#teachername").append($option);
				  return true;
			  }
			  var $option = $('<option value="'+this.teacherId+'">'+this.name+'</option>');
			  $("#teachername").append($option);
		  });
	  });
	  
	  //获取所有老师(审批人)
		  $.post("getAllTeacher.do",function(result){
			  $.each(result,function(){
				  var $option = $('<option value="'+this.teacherId+'">'+this.name+'</option>');
				  $("#shenpiren").append($option);
			  });
		  });
	  
	//获取所有老师(抄送人)
		  $.post("getAllTeacher.do",function(result){
			  $.each(result,function(){
				  var $option = $('<option value="'+this.teacherId+'">'+this.name+'</option>');
				  $("#chaosongren").append($option);
			  });
		  });
	
	
	  //单点提交审批按钮提交申请
	  var param = {};
	  
	  $("#sub").bind("click",function(){
		 
		  
		  param["schedulePk"] = '${classtime.schedulePk}';//课程主键
		  param["beginTeacherId"] ='${emplId}';//发起人钉钉id
		  param["examineTeacherId"] = $("#shenpiren").val();//审批老师id
		  param["ccTeacherId"] = $("#chaosongren").val();//抄送人id
		  
		  param["schDate"] = new Date($("#date").val().replace(/-/g,"/"));//课程日期
		 
		  param["schTime"] = $("#class_time").val();//时段
		  param["classesId"] = $("#classname").val();//班级id
		  param["roomId"] = $("#room").val();//教室id
		  param["teacherId"] = $("#teachername").val();//教师id
		  param["courseId"] = $("#course").val();//课程名称id
		  param["cause"] = $("#cause").val();//调课原因
		  
		  
		  dd.device.notification.confirm({
			    message: "确定提交吗",
			    title: "提示",
			    buttonLabels: ['确认', '取消'],
			    onSuccess : function(result) {
			    	if(result.buttonIndex==0){
			    		
			    	$.post("examine.do",param,function(result){
			    	
						  if(result==1){
			     			  $.toast("提交成功");
			     			  //window.location.href='http://192.168.137.1:8080/app/MyTable1.jsp?dd_orientation=landscape&dd_orientation=auto';
			     			 window.location.href='http://192.168.137.1:8080/app/index.jsp';
						  }
					  });
			    	}
			    },
			    onFail : function(err) {}
			});
		  
		  
		  
	  });
	  
	  
  });
  
  
</script>


</head>
<body>

<!-- page 容器 -->
<div class="page">
<!--   <header class="bar bar-nav"> -->
<!--     <h1 class="title">2018-01-25日课表</h1> -->
<!--   </header> -->

  <div class="content">
  <div class="list-block" style="padding:0 11px">
    <ul>
      <!-- Text inputs -->
      <li>
        <div class="item-content">
          <div class="item-inner">
            <div class="item-title label">日期</div>
            <div class="item-input">
              <input type="text" id='date' value='<fmt:formatDate value="${classtime.schDate }"/>' />
            </div>
          </div>
        </div>
      </li>
      <li>
        <div class="item-content">
          <div class="item-inner">
            <div class="item-title label">时段</div>
            <div class="item-input">
              <select id="class_time">
              	<option ${am } value="AM">上午</option>
              	<option ${pm } value="PM">下午</option>
              	<option ${em } value="EM">晚上</option>
              </select>
            </div>
          </div>
        </div>
      </li>
      <li>
        <div class="item-content">
          <div class="item-inner">
            <div class="item-title label">班级</div>
            <div class="item-input">
			  <select id="classname">
                
              </select>            
            </div>
          </div>
        </div>
      </li>

      <!-- Select -->
      <li>
        <div class="item-content">
          <div class="item-inner">
            <div class="item-title label">教室</div>
            <div class="item-input">
              <select id="room" >
                
              </select>
            </div>
          </div>
        </div>
      </li>
      <li>
        <div class="item-content">
          <div class="item-inner">
            <div class="item-title label">课程内容</div>
            <div class="item-input">
              <select id="course">
               
              </select>
            </div>
          </div>
        </div>
      </li>
      <li>
        <div class="item-content">
          <div class="item-inner">
            <div class="item-title label">老师</div>
            <div class="item-input">
			  <select id="teachername">
                
              </select>
            </div>
          </div>
        </div>
      </li>
      <li>
      	<div class="item-content">
      	  <div class="item-inner">
      		<div class="item-title label">调课事由</div>
      		<div class="item-input">
      			<textarea name="a" style="width:200px;height:100px;" id="cause"></textarea>
      		</div>
      	  </div>
      	</div>
      </li>
    </ul>
  </div>
  <div class="card">
    <div class="card-header">审批人</div>
    <div class="card-content">
      <div id="shenpiren1" class="card-content-inner">
          <div class="list-block" style="padding:0 11px">
          	<ul>
          	  <div class="item-content">
		          <div class="item-inner">
		            <div class="item-title label icon icon-me">选择审批人</div>
		            <div class="item-input">
		              <select id="shenpiren">
		              	<option value="0"></option>
		              </select>
		            </div>
		          </div>
		        </div>
          	</ul>
          </div>
      </div>
    </div>  
  </div>
  <div class="card">
    <div class="card-header">抄送人</div>
    <div class="card-content">
      <div id="chaosongren1" class="card-content-inner">
      	<div class="list-block" style="padding:0 11px">
          	<ul>
          	  <div class="item-content">
		          <div class="item-inner">
		            <div class="item-title label icon icon-me">选择抄送人</div>
		            <div class="item-input">
		              <select id="chaosongren">
		              	<option value="0"></option>
		              </select>
		            </div>
		          </div>
		        </div>
          	</ul>
          </div>
      </div>
    </div>  
  </div>
  <div class="content-block">
    <p><a class="button button-big button-round" id="sub">提交审批</a></p>
  </div>
</div>

 
</div>
</body>
</html>