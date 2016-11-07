

adminControllers.controller('homeCtrl', ['$scope', '$rootScope',
    function homeCtrl($scope,$rootScope) {



    }
]);

adminControllers.controller('tagCtrl', ['$scope', '$rootScope', 'TagService',
    function homeCtrl($scope,$rootScope, TagService) {

        $scope.tags = [];

        TagService.findTest().success(function(data) {
            $scope.tags = data.tags;
        }).error(function(data, status) {
            console.log(status);
            console.log(data);
        });

        //TagService.findAll().success(function(data) {
        //    $scope.tags = data;
        //}).error(function(data, status) {
        //    console.log(status);
        //    console.log(data);
        //});

        $scope.deleteTag = function(id){
            TagService.deleteTag().success(function(data) {
                 layer.msg('删除成功');
             }).error(function(data, status) {

             });

        }
    }
]);

//博客列表
adminControllers.controller('BlogCatalogCtrl', ['$scope', '$stateParams', 'BlogService',
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


//博客列表
adminControllers.controller('BlogCatalogCtrl', ['$scope', '$stateParams', 'BlogService',
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


//博客编辑
adminControllers.controller('BlogCreateCtrl', ['$scope', '$stateParams', 'TagService','BlogService',
    function BlogCatalogCtrl($scope, $stateParams, TagService,BlogService) {
        $scope.tags = [];
        $scope.catalogs = [];

        TagService.findTest().success(function(data) {
            $scope.tags = data.tags;
            $scope.catalogs =data.tags;
        }).error(function(data, status) {
            console.log(status);
            console.log(data);
        });

        $scope.saveArticle = function(){
            var article = new Object();
            //var catalogId, tags=[];
            $('input:radio[name=catalog]:checked').each(function(){
                article.catalogId = $(this).val();
            });
            $('input[name="tag"]:checked').each(function(){
                article.tags.push($(this).val());
            });
            article.article_content=$("#editor").val();
            console.log(article.article_content);
            BlogService.creat(article).success(function(){
                layer.mgs("保存成功");
            }).error(function(){
                layer.mgs("保存失败");
            })

        }



    }
]);



