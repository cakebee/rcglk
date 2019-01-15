<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>學生信息</title>
	<meta charset="utf-8">
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="../css/sidebar.css">
	<script type="text/javascript" src="../js/sidebar.js" ></script>
	<link rel="stylesheet" type="text/css" href="../css/navigator.css">
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	<link rel="stylesheet" type="text/css" href="/rcglk/Font-Awesome-3.2.1/css/font-awesome.min.css">
	<script type="text/javascript" src="/rcglk/js/studentinformation.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/css/bootstrap-select.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>
</head>
<body style="background-color: #E5E8E8;">
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2 logofont">
				<p>ＵＥＳＴＣ</p>
			</div>
			<div class="navcss">
        <div class="col-sm-6">
          <ul class="mynav">
            <li class="mynav"><a class="mynav" href="">我的信息</a></li>
            <li class="mynav"><a class="mynav" href="./404.jsp">查询信息</a></li>
            <li class="mynav"><a class="mynav" href="./404.jsp">生成简历</a></li>
          </ul>
        </div>
        <div class="col-sm-2" style="text-align: right;">${sessionScope.username}</div>
        <div class="col-sm-2"><a href="" class="mynav">退出登录</a></div>
      </div>
		</div>
		<div class="row">
			<div class="col-sm-2 sidebarstyle">
    			<ul class="mysidebar">
    				<li class="mysidebar"><a class="mysidebar" href="studentInformation.jsp">基本信息</a></li>
					<li class="mysidebar"><a class="mysidebar" href="#details">详细信息</a></li>
					<li class="mysidebar" id="charchange2"><a class="mysidebar" onclick="opennav2()" style="cursor: pointer;">获奖情况&dtrif;</a></li>
					<li class="a" id="mySidebar3"><a class="mysidebar" href="addPrize.jsp">添加获奖信息</a></li>
					<li class="a" id="mySidebar4"><a class="mysidebar" href="viewPrize.jsp">查看获奖信息</a></li>
    				<li class="mysidebar" id="charchange1"><a class="mysidebar" onclick="opennav1()" style="cursor: pointer;">活动经历&dtrif;</a></li>
    				<li class="a" id="mySidebar1"><a class="mysidebar" href="addExperience.jsp">添加活动经历</a></li>
    				<li class="a" id="mySidebar2"><a class="mysidebar" href="viewActivity.jsp">查看活动经历</a></li>
    				<li class="mysidebar"><a class="mysidebar" href="status.jsp">审核进度</a></li>
    			</ul>
			</div>
			<div class="col-sm-10">
				<div class="formbox">
					<form id="basicform">
          				<p class="boxhead">基本信息</p>
          				<label class="labelcss" for="stuId">学号:</label>
          				<div class="input-group">
  							<span class="input-group-addon"><i class="icon-user"></i></span>
  							<input type="text" class="form-control" placeholder="Student ID" id="stuId" disabled="true">
						</div>
          				<label class="labelcss" for="stuName">姓名:</label>
          				<div class="input-group">
  							<span class="input-group-addon"><i class="icon-paper-clip"></i></span>
  							<input type="text" class="form-control" placeholder="Name" id="stuName" disabled="true">
						</div>
          				<label class="labelcss" for="stuYear">年级:</label>
          				<div class="input-group">
  							<span class="input-group-addon"><i class="icon-paper-clip"></i></span>
  							<input type="text" class="form-control" id="stuYear" disabled="true">
						</div>
          				<label class="labelcss" for="stu_major">专业名称:</label>
          				<div class="input-group">
  							<span class="input-group-addon"><i class="icon-laptop"></i></span>
  							<input type="text" class="form-control" placeholder="major" id="stuMajor" disabled="true">
						</div>
          				<label class="labelcss" for="student_class">班级:</label>
          				<div class="input-group">
  							<span class="input-group-addon"><i class="icon-group"></i></span>
  							<input type="text" class="form-control" placeholder="班级代码,如2016220202" id="stuClass" disabled="true">
						</div>
          				<label class="labelcss" for="stu_status">政治面貌:</label>
          				<div class="input-group">
  							<span class="input-group-addon"><i class="icon-group"></i></span>
  							<input type="text" class="form-control" id="stuIdentity" disabled="true">
						</div>
          				<label class="labelcss" for="student_dorm">宿舍号:</label>
          				<div class="input-group">
  							<span class="input-group-addon"><i class="icon-home"></i></span>
  							<input type="text" class="form-control" placeholder="楼栋-寝室号,如:XY02-520" id="stuDorm" disabled="true">
						</div>
					</form>
					<br>
			  </div>
		  </div>
    </div>
		<div class="row">
			<div class="col-sm-10 col-sm-offset-2">
				<div class="formbox">
					<form id="detailform">
          				<p class="boxhead">详细信息</p>
          				<label for="stu_tel">联系方式:</label>
          				<div class="input-group">
  							<span class="input-group-addon"><i class="icon-phone"></i></span>
  							<input type="text" class="form-control" placeholder="Phone Number" id="stuTel">
						</div>
						<label for="stu_qq">QQ:</label>
						<div class="input-group">
  							<span class="input-group-addon"><i class="icon-twitter"></i></span>
  							<input type="text" class="form-control" placeholder="number" id="stuQq">
						</div>
						<label for="stu_intro">个人说明:</label>
						<br>
						<textarea id="stuIntro" name="student_intro" style="width: 60%;height: 100px; resize: none;"></textarea>
						</form>
            		&nbsp;
            		<button type="button" onclick="submitinfo()" class="btn btn-success">提交</button>	
				</div>
			</div>
		</div>
    <span id="details"></span>
	</div>

	<script src="/rcglk/js/jqueryCookie.js"></script>
	<script type="text/javascript">
	$(function(){
	  $(document).ready(function() {
	    $.ajax({
	        url : "../Studentsinfos/"+$.cookie('user'),/*+此处填写用户账号*/
	        type : "GET",
	        dataType:"json",
	        contentType : "application/json;charset=UTF-8",
	        //向后端发送的数据
	        success:function(data) {
	        	console.log(data)
	        	$("#username").html(data.extend.studentsinfo.stuName);
	            $("#stuId").val(data.extend.studentsinfo.stuId);
	            $("#stuName").val(data.extend.studentsinfo.stuName);
	            $("#stuMajor").val(data.extend.studentsinfo.stuMajor);
	            $("#stuClass").val(data.extend.studentsinfo.stuClass);
	            $("#stuIdentity").val(data.extend.studentsinfo.identity);
	            $("#stuDorm").val(data.extend.studentsinfo.stuDorm);
	            $("#stuTel").val(data.extend.studentsinfo.stuTel);
	            $("#stuQq").val(data.extend.studentsinfo.stuQq);
	            $("#stuIntro").val(data.extend.studentsinfo.stuIntro);
	            $("#stuYear").val(data.extend.studentsinfo.stuId.slice(0,4))
	            
	            console.log(data.extend.studentsinfo.stuId.slice(0,4))
	        },
	        error:function(data){
	        	console.log(data)
	            alert("服务器未响应，请稍后再试");
	        }
	        //处理后端返回的数据
	    });
	  });
	});
	
	function submitinfo(){
		alert("提交成功")
	}
	</script>

</body>
</html>