<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>添加经历信息</title>
	<meta charset="utf-8">
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="../css/sidebar.css">
	<script type="text/javascript" src="../js/sidebar.js" ></script>
	<link rel="stylesheet" type="text/css" href="../css/navigator.css">
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	<link rel="stylesheet" type="text/css" href="../Font-Awesome-3.2.1/css/font-awesome.min.css">
	<script type="text/javascript" src="../js/studentinformation.js"></script>
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
          <div id="addname">
            <label for="org_class">类别*:</label>
            <br>
            <select class="selectpicker" id="org_class">
            <option value="0">请选择...</option>
            <option value="科研、项目经历">科研、项目组织</option>
            <option value="文体类组织">文体类组织</option>
            <option value="社会实践经历">社会实践组织</option>
            <option value="学生组织经历">学生组织(如学生会、青志协)</option>
            <option value="志愿者组织">志愿者组织</option>
            <option value="班干部">班干部</option>
            <option value="others">其他...</option>
            </select>
            <br>
            <label for="organization_name">组织名称*:</label>
            <div class="input-group">
                <span class="input-group-addon"><i class="icon-list-alt"></i></span>
                <input type="text" class="form-control" placeholder="如:创青春，一路工作室等" id="orgName">
            </div>
            <label for="organization_position">担任职位*:</label>
            <div class="input-group">
                <span class="input-group-addon"><i class="icon-list-alt"></i></span>
                <input type="text" class="form-control" placeholder="如:工作室负责人、成员，学生会干事等" id="orgDuty">
            </div>
            <label>参与时间*:</label>
            <p><input type="date" id="orgBegin" style="width: 120px;">到<input type="date" id="orgEnd" style="width: 120px;"></p>
            <p>说明:</p>
            <textarea id="orgIntro" style="width: 250px;height: 100px;resize: none;"></textarea>
            <br>
            <button type="button" id="addbtn" class="btn btn-success">提交</button>
          </div>	
				</div>
			</div>
		</div>
	</div>
</body>


<script>
$('#addbtn').click(function(){
	var studentsorg = {
		"stuId":${sessionScope.username},
		"orgName": $('#orgName').val(),
		"orgDuty": $('#orgDuty').val(),
		"orgBegin": $('#orgBegin').val(),
		"orgEnd": $('#orgEnd').val(),
		"orgIntro": $('#orgIntro').val()
	};
	console.log(studentsorg)
	if(studentsorg.orgDuty == ""||studentsorg.orgName == ""||studentsorg.orgDuty== ""||studentsorg.orgBegin  == ""||studentsorg.orgEnd == ""){
		alert("请填写完整信息...");
		return;
	}
	// 获取当前日期
	var date = new Date();
	// 获取当前月份
	var nowMonth = date.getMonth() + 1;
	// 获取当前是几号
	var strDate = date.getDate();
	// 添加分隔符“-”
	var seperator = "-";
	// 对月份进行处理，1-9月在前面添加一个“0”
	if (nowMonth >= 1 && nowMonth <= 9) {
	   nowMonth = "0" + nowMonth;
	}
	// 对月份进行处理，1-9号在前面添加一个“0”
	if (strDate >= 0 && strDate <= 9) {
	   strDate = "0" + strDate;
	}
	// 最后拼接字符串，得到一个格式为(yyyy-MM-dd)的日期
	var nowDate = date.getFullYear() + seperator + nowMonth + seperator + strDate;
	if(studentsorg.orgBegin >= studentsorg.orgEnd||studentsorg.orgEnd > nowDate){
		alert("请填写正确的日期...");
		return;
	}
	console.log(studentsorg)
	$.ajax({
        url : "/rcglk/Studentsorg",
        type : "POST",
        data: studentsorg,
        
        //向后端发送的数据
        success:function(data) {
          alert("提交成功");
        },
        error:function(err){
        	alert("提交失败，请稍后再试")
        }
        //处理后端返回的数据
    });
})
</script>