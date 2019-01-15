<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>学生信息</title>
<meta charset="utf-8">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="../js/angular.min.js"></script>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/sidebar.css">
<script type="text/javascript" src="../js/sidebar.js"></script>
<link rel="stylesheet" type="text/css" href="../css/navigator.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css"
	href="../Font-Awesome-3.2.1/css/font-awesome.min.css">
<script type="text/javascript" src="../js/studentinformation.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/css/bootstrap-select.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>
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
						<li class="mynav"><a class="mynav">我的信息</a></li>
						<li class="mynav"><a class="mynav" href="search.html">查询信息</a></li>
						<li class="mynav"><a class="mynav" href="">生成简历</a></li>
					</ul>
				</div>
				<div class="col-sm-2" style="text-align: right;">
					欢迎您,${sessionScope.username}<span id="username"></span>
				</div>
				<div class="col-sm-2">
					<a href="" class="mynav">退出登录</a>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2 sidebarstyle">
				<ul class="mysidebar">
					<li class="mysidebar"><a class="mysidebar">学生信息</a></li>
					<li class="mysidebar"><a class="mysidebar" href="prizeManager.jsp">获奖信息</a></li>
					<li class="mysidebar"><a class="mysidebar" href="orgManager.jsp">活动经历</a></li>
				</ul>
			</div>
			<div class="col-sm-10" ng-app="UserApp" ng-controller="ViewCtrl">
				<div class="panel panel-default">
					<div class="panel-heading">
						<label>学生信息</label>
						<button class="btn btn-primary" data-toggle="modal"
							data-target="#addUser" style="margin-left: 30px;">添加信息
						</button>
						<button class="btn btn-success" data-toggle="modal" data-target="#importfile" style="margin-left: 30px;">批量导入</button>
					</div>
					<table class="table">
						<tr>
							<th>学号</th>
							<th>姓名</th>
							<th>寝室号</th>
							<th>联系方式</th>
							<th>QQ</th>
							<th>详情</th>
						</tr>
						<tr ng-repeat="user in users">
							<td>{{user.stuId}}</td>
							<td>{{user.stuName}}</td>
							<td>{{user.stuDorm}}</td>
							<td>{{user.stuTel}}</td>
							<td>{{user.stuQq}}</td>
							<td><a href="#">查看</a></td>
						</tr>
					</table>
					<nav aria-label="Page navigation" style="text-align: center;">
						<ul class="pagination">
							<li><a ng-click="prepage()" aria-label="Previous"> <span
									aria-hidden="true">&laquo;</span>
							</a></li>
							<li ng-repeat="page in pages"><a ng-click="changepage()">{{ page }}</a></li>
							<li><a ng-click="nextpage()" aria-label="Next"> <span
									aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</nav>
				</div>
				<div class="modal fade" id="addUser" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">添加学生用户</h4>
							</div>
							<div class="modal-body">
								<label>学号：</label><input id="stuId" type="text"> <br>
								<br> <label>姓名：</label><input type="text" id="stuName">
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button type="button" id="addUserbtn" class="btn btn-primary">提交</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>
				
				<div class="modal fade" id="importfile" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">添加学生用户</h4>
							</div>
							<div class="modal-body">
								<label>文件：</label><input id="File" type="file"> <br>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button type="button" onclick="submitFile()" id="addUser" class="btn btn-primary">提交</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>
				
<script type="text/javascript">
var app = angular.module('UserApp', []);
app.controller('ViewCtrl', function($scope) {
	var studentsInfo = [];
	var pageamount;
	$scope.currentpage = 1;
	function getInfo(){
		$.ajax({
	        url : "/rcglk/Studentsinfos" /*+此处填写用户账号*/,
	        type : "GET",
	        dataType:"json",
	        data: {'pageSize': 5,'pageNo': $scope.currentpage},
	        contentType : "application/json;charset=UTF-8",
	        async : false,
	        //向后端发送的数据
	        success:function(data) {
	        	$scope.users=data.extend.pageInfo.list;
	        	pageamount=data.extend.pageInfo.navigateLastPage;
	        },
	        error:function(data){
	        	console.log(data)
	            alert("服务器未响应，请稍后再试");
	        }
	        //处理后端返回的数据
	    });
		//$scope.users=[{'stuId':'2016220202004','stuName':'Wang','stuTel':'15520772689'}]
	    console.log($scope.users)
	}
	getInfo();
	var page = [];
	for(var i=1;i<=pageamount;i++){
		page.push(i);
	}
	$scope.pages=page;
	$scope.nextpage = function() {
		$scope.currentpage++;
		$.ajax({
	        url : "/rcglk/Studentsinfos" /*+此处填写用户账号*/,
	        type : "GET",
	        dataType:"json",
	        data: {'pageSize': 5,'pageNo': $scope.currentpage},
	        contentType : "application/json;charset=UTF-8",
	        async : false,
	        //向后端发送的数据
	        success:function(data) {
	        	$scope.users=data.extend.pageInfo.list;
	        	pageamount=data.extend.pageInfo.navigateLastPage;
	        },
	        error:function(data){
	        	console.log(data)
	            alert("服务器未响应，请稍后再试");
	        }
	        //处理后端返回的数据
	    });
		//$scope.users=[{'stuId':'2016220202004','stuName':'Wang','stuTel':'15520772689'}]
	    console.log($scope.users)
	}
	$scope.prepage = function() {
		$scope.currentpage--;
		$.ajax({
	        url : "/rcglk/Studentsinfos" /*+此处填写用户账号*/,
	        type : "GET",
	        dataType:"json",
	        aysnc: false,
	        data: {'pageSize': 5,'pageNo': $scope.currentpage},
	        contentType : "application/json;charset=UTF-8",
	        async : false,
	        //向后端发送的数据
	        success:function(data) {
	        	$scope.users=data.extend.pageInfo.list;
	        	pageamount=data.extend.pageInfo.navigateLastPage;
	        },
	        error:function(data){
	            alert("服务器未响应，请稍后再试");
	        }
	        //处理后端返回的数据
	    });
		//$scope.users=[{'stuId':'2016220202004','stuName':'Wang','stuTel':'15520772689'}]
	    console.log($scope.users)
	}
	$scope.changepage = function(i) {
		$.ajax({
	        url : "/rcglk/Studentsinfos" /*+此处填写用户账号*/,
	        type : "GET",
	        dataType:"json",
	        data: {'pageSize': 5,'pageNo': i},
	        contentType : "application/json;charset=UTF-8",
	        async : false,
	        //向后端发送的数据
	        success:function(data) {
	        	$scope.currentpage=i;
	        	studentsInfo.push(data.extend.pageInfo.list);
	        	pageamount=data.extend.pageInfo.navigateLastPage;
	        },
	        error:function(data){
	        	console.log(data)
	            alert("服务器未响应，请稍后再试");
	        }
	        //处理后端返回的数据
	    });
		//$scope.users=[{'stuId':'2016220202004','stuName':'Wang','stuTel':'15520772689'}]
	    $scope.users=studentsInfo[1];
	    console.log($scope.users);
	}
});
</script>

<script>
var formdata = new FormData();
formdata.append('file',document.getElementById('File').files[0])
function submitFile(){
$.ajax({
	url: '/rcglk/excel',
	method: 'post',
	data: formdata,
	processData: false,
	contentType: false,
	success: function(){
		console.log("file success")
	},
	error: function(){
		console.log('file err');
	}
})
}
</script>


<script type="text/javascript">
$('#addUserbtn').click(function() {
	var stuId =$('#stuId').val();
	$.ajax({
		url : "/rcglk/Studentsinfos/"+stuId,
		method : 'POST',
		
		success : function(data) {
			alert("提交成功")
		},
		error : function(err) {
			alert("提交失败")
		}
	})
})
</script>
</body>
</html>