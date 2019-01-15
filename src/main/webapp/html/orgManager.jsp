"src/main/webapp/html/viewPrize.jsp"<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>查询组织经历信息</title>
  <meta charset="utf-8">
  <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
  <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="../css/sidebar.css">
  <script src="../js/angular.min.js"></script>
  <script type="text/javascript" src="../js/sidebar.js" ></script>
  <link rel="stylesheet" type="text/css" href="../css/navigator.css">
  <link rel="stylesheet" type="text/css" href="../css/style.css">
  <link rel="stylesheet" type="text/css" href="../Font-Awesome-3.2.1/css/font-awesome.min.css">
  <script type="text/javascript" src="../js/studentinformation.js"></script>
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
            <li class="mynav"><a class="mynav" href="">查询信息</a></li>
            <li class="mynav"><a class="mynav" href="">生成简历</a></li>
          </ul>
        </div>
        <div class="col-sm-2" style="text-align: right;">欢迎您,${sessionScope.username}</div>
        <div class="col-sm-2"><a href="" class="mynav">退出登录</a>
      </div>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-2 sidebarstyle">
    			<ul class="mysidebar">
    				<li class="mysidebar"><a class="mysidebar" href="userManager.jsp">学生信息</a></li>
    				<li class="mysidebar"><a class="mysidebar" href="prizeManager.jsp">奖项管理</a></li>
    				<li class="mysidebar"><a class="mysidebar" href="orgManager.jsp">活动经历管理</a></li>
    			</ul>
			</div>
      <div class="col-sm-10" ng-app="ViewPrizeApp" ng-controller="ViewCtrl">
          <div class="panel panel-default">
          <div class="panel-heading">
          	学生活动组织经历查询:
          	&nbsp;&nbsp;&nbsp;
          	<input id="stuId" type="text" placeholder="请输入学号...">
          	<button class="btn btn-success" ng-click="search()">搜索</button>	
          </div>
          <table class="table">
            <tr>
              <th>序号</th>
              <th>名称</th>
              <th>职责</th>
              <th>时间</th>
              <th>详情</th>
            </tr>
            <tr ng-repeat="org in orgs">
              <td>{{$index+1}}</td>
              <td>{{org.orgName}}</td>
              <td>{{org.orgDuty}}</td>
              <td>{{org.orgBegin}} 至 {{org.orgEnd}}</td>
              <td><a ng-href="/rcglk/html/orgdetails.jsp?{{org.orgId}}">查看</a></td>
            </tr>
          </table>
		</div>
      </div>
  </div>
  </div>
</body>
</html>
<script src="/rcglk/js/jqueryCookie.js"></script>
<script>

var app = angular.module('ViewPrizeApp', []);
app.controller('ViewCtrl', function($scope) {
	$scope.search = function(){
		$.ajax({
			url: '/rcglk/Studentsorg/'+$('#stuId').val(),
			type: 'GET',
			dataType: 'json',
			async: false,
			success: function(data) {
				for(var i = 0;i<data.extend.list.length;i++){
	        		var da = data.extend.list[i].orgBegin;
	        		da = new Date(da);
	        	    var year = da.getFullYear();
	        	    var month = da.getMonth()+1;
	        	    var date = da.getDate();
	        	    data.extend.list[i].orgBegin=([year,month,date].join('-'));
	        	    da = data.extend.list[i].orgEnd;
	        	    da = new Date(da);
	        	    var year = da.getFullYear();
	        	    var month = da.getMonth()+1;
	        	    var date = da.getDate();
	        	    data.extend.list[i].orgEnd=([year,month,date].join('-'));
	        	}
				$scope.orgs = data.extend.list;
			},
			error: function(err){
				alert('服务器连接失败')
			}
		})
	}
});
</script>
