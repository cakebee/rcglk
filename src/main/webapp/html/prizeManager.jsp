"src/main/webapp/html/viewPrize.jsp"<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>查询获奖信息</title>
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
          <div class="panel-heading">个人奖项</div>
          <table class="table">
            <tr>
              <th>序号</th>
              <th>名称</th>
              <th>级别</th>
              <th>获奖时间</th>
              <th>审核状态</th>
              <th>详情</th>
            </tr>
            <tr ng-repeat="prize in prizes">
              <td>{{ $index + 1 }}</td>
              <td>{{prize.prizeName}}</td>
              <td>{{prize.prizeLevel}}</td>
              <td>{{prize.prizeDate}}</td>
              <td>{{prize.status}}</td>
              <td><a ng-href="/rcglk/html/check.jsp?{{prize.prizeId}}">查看</a></td>
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
	var prizeInfo = [];
		$.ajax({
	        url : "../Studentsprize/0/0" /*+此处填写用户账号*/,
	        type : "GET",
	        dataType:"json",
	        contentType : "application/json;charset=UTF-8",
	        async : false,
	        //向后端发送的数据
	        success:function(data) {
	        	prizeInfo=data.extend.studentsprizeList;
	        	for(var i = 0;i<prizeInfo.length;i++){
	        		var da = prizeInfo[i].prizeDate;
	        		da = new Date(da);
	        	    var year = da.getFullYear();
	        	    var month = da.getMonth()+1;
	        	    var date = da.getDate();
	        	    prizeInfo[i].prizeDate=([year,month,date].join('-'));
	        	}
	        	for(var i = 0;i<prizeInfo.length;i++){
	        		if(prizeInfo[i].status == '0'){
	        			prizeInfo[i].status ="待审核";
	        		}
	        		if(prizeInfo[i].status == '1'){
	        			prizeInfo[i].status ="审核通过";
	        		}
	        		if(prizeInfo[i].status == '2'){
	        			prizeInfo[i].status ="审核未通过";
	        		}
	        	}
	        },
	        error:function(data){
	            alert("服务器未响应，请稍后再试");
	        }
	        //处理后端返回的数据
	    });
	    $scope.prizes=prizeInfo;
	    console.log($scope.prizes)
	    $.ajax({
	        url : "../Studentsprize/0/1" /*+此处填写用户账号*/,
	        type : "GET",
	        dataType:"json",
	        contentType : "application/json;charset=UTF-8",
	        async : false,
	        //向后端发送的数据
	        success:function(data) {
	        	for(var i = 0;i<data.extend.studentsprizeList.length;i++){
	        		prizeInfo.push(data.extend.studentsprizeList[i])
	        	}
	        	for(var i = 0;i<prizeInfo.length;i++){
	        		var da = prizeInfo[i].prizeDate;
	        		da = new Date(da);
	        	    var year = da.getFullYear();
	        	    var month = da.getMonth()+1;
	        	    var date = da.getDate();
	        	    prizeInfo[i].prizeDate=([year,month,date].join('-'));
	        	}
	        	for(var i = 0;i<prizeInfo.length;i++){
	        		if(prizeInfo[i].status == '0'){
	        			prizeInfo[i].status ="待审核";
	        		}
	        		if(prizeInfo[i].status == '1'){
	        			prizeInfo[i].status ="审核通过";
	        		}
	        		if(prizeInfo[i].status == '2'){
	        			prizeInfo[i].status ="审核未通过";
	        		}
	        	}
	        },
	        error:function(data){
	            alert("服务器未响应，请稍后再试");
	        }
	        //处理后端返回的数据
	    });
	    $scope.prizes=prizeInfo;
	    console.log($scope.prizes)
	    $.ajax({
	        url : "../Studentsprize/0/2" /*+此处填写用户账号*/,
	        type : "GET",
	        dataType:"json",
	        contentType : "application/json;charset=UTF-8",
	        async : false,
	        //向后端发送的数据
	        success:function(data) {
	        	for(var i = 0;i<data.extend.studentsprizeList.length;i++){
	        		prizeInfo.push(data.extend.studentsprizeList[i])
	        	}
	        	for(var i = 0;i<prizeInfo.length;i++){
	        		var da = prizeInfo[i].prizeDate;
	        		da = new Date(da);
	        	    var year = da.getFullYear();
	        	    var month = da.getMonth()+1;
	        	    var date = da.getDate();
	        	    prizeInfo[i].prizeDate=([year,month,date].join('-'));
	        	}
	        	for(var i = 0;i<prizeInfo.length;i++){
	        		if(prizeInfo[i].status == '0'){
	        			prizeInfo[i].status ="待审核";
	        		}
	        		if(prizeInfo[i].status == '1'){
	        			prizeInfo[i].status ="审核通过";
	        		}
	        		if(prizeInfo[i].status == '2'){
	        			prizeInfo[i].status ="审核未通过";
	        		}
	        	}
	        },
	        error:function(data){
	            alert("服务器未响应，请稍后再试");
	        }
	        //处理后端返回的数据
	    });
	    $scope.prizes=prizeInfo;
	    console.log($scope.prizes)
});
</script>
