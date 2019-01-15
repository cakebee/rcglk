    var app = angular.module('prize_class',[]);
    app.controller('prize_classCtrl',function($scope){
    	$scope.selectclass1="0";
    	$scope.class1 = ['科研类','文体类','应用技能类','组织管理类','社会实践类','其他...'];
    	$scope.selectclass2="0";
    	var science=['科研竞赛','学术论文','科技发明专利','项目获奖','其他'];
    	var recreation=['新生杯系列体育比赛','征文比赛','辩论赛','合唱比赛','运动会获奖','其他'];
    	var skill=['英语','计算机','其他'];
    	var manage=['学生组织优秀个人','优秀干部','组织先进活动','其他'];
    	var practice=['优秀集体','优秀领导者','优秀个人','其他'];
    	var others=['其他...'];
    	$scope.class2menu=function(){
    		if ($scope.selectclass1=='科研类') {
    			$scope.class2=science;
    		}
    		if ($scope.selectclass1=='文体类') {
    			$scope.class2=recreation;
    		}
    		if ($scope.selectclass1=='应用技能类') {
    			$scope.class2=skill;
    		}
    		if ($scope.selectclass1=='组织管理类') {
    			$scope.class2=manage;
    		}
    		if ($scope.selectclass1=='社会实践类') {
    			$scope.class2=practice;
    		}
    		if ($scope.selectclass1=='其他...') {
    			$scope.class2=others;
    		}
    	}
    });
    // 以上为angularJS控制表单关联