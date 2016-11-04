

appControllers.controller('homeCtrl', ['$scope', '$rootScope', 'BlogService',
    function homeCtrl($scope,$rootScope, BlogService) {

        $scope.blogs = [];
        $rootScope.latestBlogs=[];
        $rootScope.hotBlogs=[];
        $rootScope.catalogIndex = 0;

        BlogService.findTest().success(function(data) {
            $scope.blogs = data.blogs;
            $rootScope.latestBlogs=data.blogs;
            $rootScope.hotBlogs=data.blogs;
        }).error(function(data, status) {
            console.log(status);
            console.log(data);
        });

        //BlogService.findAllPublished().success(function(data) {
        //    $scope.blogs = data;
        //}).error(function(data, status) {
        //    console.log(status);
        //    console.log(data);
        //});
    }
]);

appControllers.controller('BlogCatalogCtrl', ['$scope', '$stateParams', 'BlogService',
    function BlogCatalogCtrl($scope, $stateParams, BlogService) {

        $scope.blogs = [];
        var catalogName = $stateParams.catalogName;

        BlogService.findTest().success(function(data) {
            $scope.blogs = data.blogs;
        }).error(function(data, status) {
            console.log(status);
            console.log(data);
        });

        //BlogService.findByCatalog(catalogName).success(function(data) {
        //    //$scope.blogs = data;
        //}).error(function(status, data) {
        //    console.log(status);
        //    console.log(data);
        //});

    }
]);



appControllers.controller("navaCtroller", function ($scope, $state, $rootScope) {

    $scope.catalogs = [{'name':"index",'title':'首页'},{'catalog':"java",'title':'JAVA'}, {'catalog':"linux",'title':'Linux'},
        {'catalog':"architecture",'title':'架构'},{'catalog':"life",'title':'生活'},{'catalog':"books",'title':'读书'},{'catalog':"about",'title':'关于我'}]
    $scope.srefs=["index","java","linux","architecture","life","books","about"];

    $scope.selectCatalog=function(index){
        $rootScope.catalogIndex = index;
        if(index== 0){
            $state.go("index");
        }else if(index == 6 ){
            $state.go("about");
        }else{
            $state.go("catalog",{"catalogName":$scope.srefs[index]});
        }

    }
    $scope.selectAbout=function(){
        $rootScope.catalogIndex = 6;
        $state.go("about");
    }
})
