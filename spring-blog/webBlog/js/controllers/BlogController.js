

var blogControllers = angular.module('blogControllers', []);


blogControllers.controller('latestBlogController', function($scope,$http) {

    $http({
        url:'data/data.json',
        method:'GET'
    }).success(function(data,header,config,status){
        console.log(data);
        //响应成功
        $scope.latestBlogs=data.blogs;

    }).error(function(data,header,config,status){
        //处理响应失败
    });
 });


blogControllers.controller('hotBlogController', function($scope,$http) {

    $http({
        url:'data/data.json',
        method:'GET'
    }).success(function(data,header,config,status){
        console.log(data);
        //响应成功
        $scope.hotBlogs=data.blogs;

    }).error(function(data,header,config,status){
        //处理响应失败
    });
});


blogControllers.controller('topBlogController', function($scope,$http) {

    $http({
        url:'data/data.json',
        method:'GET'
    }).success(function(data,header,config,status){
        console.log(data);
        //响应成功
        $scope.topBlogs=data.blogs;

    }).error(function(data,header,config,status){
        //处理响应失败
    });
});


blogControllers.controller("navaCtroller", function ($scope, $state, $rootScope) {

    $scope.catalogs = [{'name':"index",'title':'首页'},{'catalog':"java",'title':'JAVA'}, {'catalog':"linux",'title':'Linux'},
        {'catalog':"architecture",'title':'架构'},{'catalog':"life",'title':'生活'},{'catalog':"books",'title':'读书'},{'catalog':"about",'title':'关于我'}]
    $scope.srefs=["index","java","linux","architecture","life","books","about"];

    $scope.selectCatalog=function(index){
        $scope.catalogIndex = index;
        $state.go($scope.srefs[index]);

    }
})

