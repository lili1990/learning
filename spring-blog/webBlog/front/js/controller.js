

appControllers.controller('homeCtrl', ['$scope', '$rootScope', 'BlogService',
    function homeCtrl($scope,$rootScope, BlogService) {

        $scope.blogs = [];
        $rootScope.latestBlogs=[];
        $rootScope.hotBlogs=[];
        $rootScope.catalogName = 'index';

        BlogService.findLatested().success(function(data) {
            $rootScope.latestBlogs=data.list;
        }).error(function(data, status) {
            console.log(status);
            console.log(data);
        });

        BlogService.findHot().success(function(data) {
            $rootScope.hotBlogs=data.list;
        }).error(function(data, status) {
            console.log(status);
            console.log(data);
        });

        BlogService.findToped().success(function(data) {
            $scope.blogs = data.list;
        }).error(function(data, status) {
            console.log(status);
            console.log(data);
        });
    }
]);

appControllers.controller('BlogCatalogCtrl', ['$scope','$rootScope', '$stateParams', 'BlogService',
    function BlogCatalogCtrl($scope,$rootScope, $stateParams, BlogService) {

        $scope.blogs = [];
        var catalogName = $stateParams.catalogName;
        $rootScope.catalogName=catalogName;

        BlogService.findByCatalog(catalogName).success(function(data) {
            $scope.blogs = data.list;
        }).error(function(status, data) {
            console.log(status);
            console.log(data);
        });

    }
]);
appControllers.controller('AboutCtrl', ['$scope','$rootScope', '$stateParams',
    function AboutCtrl($scope,$rootScope, $stateParams) {
        $rootScope.catalogName='about';
    }
]);

appControllers.controller('ArticleCtrl', ['$scope','$rootScope', '$stateParams', 'BlogService',
    function ArticleCtrl($scope,$rootScope, $stateParams, BlogService) {

        $scope.article = [];
        $scope.tags = [];
        $scope.beforeArticles = [];
        $scope.afterArticles = [];
        var articleId = $stateParams.articleId;

        BlogService.findById(articleId).success(function(data) {
            $scope.article = data.result;
        }).error(function(status, data) {
            console.log(status);
            console.log(data);
        });


        $rootScope.latestBlogs=[];
        $rootScope.hotBlogs=[];

        BlogService.findLatested().success(function(data) {
            $rootScope.latestBlogs=data.list;
        }).error(function(data, status) {
            console.log(status);
            console.log(data);
        });

        BlogService.findHot().success(function(data) {
            $rootScope.hotBlogs=data.list;
        }).error(function(data, status) {
            console.log(status);
            console.log(data);
        });

        BlogService.findTags(articleId).success(function(data) {
            console.log(data);
            $scope.tags=data.list;
        }).error(function(data, status) {
            console.log(status);
            console.log(data);
        });
        BlogService.findCatalog(articleId).success(function(data) {
            $scope.catalog=data.result;
        }).error(function(data, status) {
            console.log(status);
            console.log(data);
        });

        BlogService.findBefore(articleId).success(function(data) {
            console.log(data);
            $scope.beforeArticles=data.list;
        }).error(function(data, status) {
            console.log(status);
            console.log(data);
        });
        BlogService.findAfter(articleId).success(function(data) {
            console.log(data);
            $scope.afterArticles=data.list;
        }).error(function(data, status) {
            console.log(status);
            console.log(data);
        });

    }
]);



appControllers.controller("navaCtroller", function ($scope, $state, $rootScope,BlogService) {

    $rootScope.catalogs=[];
    BlogService.findCatalogs().success(function(data) {
        console.log(data.list);
        $rootScope.catalogs=data.list;
    }).error(function(data, status) {
        console.log(status);
        console.log(data);
    });

})
