

adminControllers.controller('homeCtrl', ['$scope', '$rootScope',
    function homeCtrl($scope,$rootScope) {



    }
]);

adminControllers.controller('tagCtrl', ['$scope', '$rootScope', 'TagService',
    function homeCtrl($scope,$rootScope, TagService) {

        $scope.tags = [];

        TagService.findAll().success(function(data) {
            $scope.tags = data.list;
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
adminControllers.controller('ArticleCtrl', ['$scope', '$stateParams', 'BlogService',
    function ArticleCtrl($scope, $stateParams, BlogService) {
        $scope.articles = [];
        var status = $stateParams.status;
        BlogService.findByStatus(status,pageNo,pageSize).success(function(data) {
            $scope.articles = data.list;
        }).error(function(status, data) {
            console.log(status);
            console.log(data);
        });


    }
]);


//博客列表
adminControllers.controller('BlogCatalogCtrl', ['$scope', '$stateParams', 'BlogService',
    function BlogCatalogCtrl($scope, $stateParams, BlogService) {

        $scope.blogs = [];
        var status = $stateParams.status;

        BlogService.findByStatus(status).success(function(data) {
            $scope.blogs = data.list;
        }).error(function(status, data) {
            console.log(status);
            console.log(data);
        });

    }
]);

//博客编辑(普通编辑器)
adminControllers.controller('BlogEditCtrl', ['$scope', '$stateParams', 'TagService','BlogService','CatalogService',
    function BlogEditCtrl($scope, $stateParams, TagService,BlogService,CatalogService) {
        $scope.tags = [];
        $scope.catalogs = [];
        $scope.article=null;
        var articleId = $stateParams.articleId;


        TagService.findAll().success(function(data) {
            $scope.tags = data.list;
        }).error(function(data, status) {
            console.log(status);
            console.log(data);
        });



        CatalogService.findAll().success(function(data) {
            $scope.catalogs =data.list;
        }).error(function(data, status) {
            console.log(status);
            console.log(data);
        });

        BlogService.findById(articleId).success(function(data) {
            $scope.article =data.result;
        }).error(function(data, status) {
            console.log(status);
            console.log(data);
        });

        $scope.publishArticle = function(){
            var articleAddModel=new Object();
            var article = new Object();
            var catalogId=null,tagIds=[];
            article.title=$("#title").val();
            $('input:radio[name=catalog]:checked').each(function(){
                catalogId = $(this).val();
            });
            $('input[name="tag"]:checked').each(function(){
                tagIds.push($(this).val());
            });
            article.content=$("#editor").val();
            article.status=1;//发布状态
            BlogService.create(article,catalogId,tagIds).success(function(){
                layer.mgs("保存成功");
            }).error(function(){
                layer.mgs("保存失败");
            })

        }

        $scope.saveArticle = function(){
            var articleAddModel=new Object();
            var article = new Object();
            var catalogId=null,tagIds=[];
            article.title=$("#title").val();
            $('input:radio[name=catalog]:checked').each(function(){
                catalogId = $(this).val();
            });
            $('input[name="tag"]:checked').each(function(){
                tagIds.push($(this).val());
            });
            article.content=$("#editor").val();
            article.status=0;//发布状态
            BlogService.create(article,catalogId,tagIds).success(function(){
                layer.mgs("保存成功");
            }).error(function(){
                layer.mgs("保存失败");
            })

        }



    }
]);

//博客编辑(普通编辑器)
adminControllers.controller('BlogCreateCtrl', ['$scope', '$stateParams', 'TagService','BlogService','CatalogService',
    function BlogCatalogCtrl($scope, $stateParams, TagService,BlogService,CatalogService) {
        $scope.tags = [];
        $scope.catalogs = [];

        TagService.findAll().success(function(data) {
            $scope.tags = data.list;
        }).error(function(data, status) {
            console.log(status);
            console.log(data);
        });

        CatalogService.findAll().success(function(data) {
            $scope.catalogs =data.list;
        }).error(function(data, status) {
            console.log(status);
            console.log(data);
        });

         $scope.publishArticle = function(){
            var articleAddModel=new Object();
            var article = new Object();
            var catalogId=null,tagIds=[];
            article.title=$("#title").val();
            $('input:radio[name=catalog]:checked').each(function(){
                catalogId = $(this).val();
            });
            $('input[name="tag"]:checked').each(function(){
                tagIds.push($(this).val());
            });
            article.content=$("#editor").val();
            article.status=1;//发布状态
            BlogService.create(article,catalogId,tagIds).success(function(){
                layer.mgs("保存成功");
            }).error(function(){
                layer.mgs("保存失败");
            })

        }

        $scope.saveArticle = function(){
            var articleAddModel=new Object();
            var article = new Object();
            var catalogId=null,tagIds=[];
            article.title=$("#title").val();
            $('input:radio[name=catalog]:checked').each(function(){
                catalogId = $(this).val();
            });
            $('input[name="tag"]:checked').each(function(){
                tagIds.push($(this).val());
            });
            article.content=$("#editor").val();
            article.status=0;//发布状态
            BlogService.create(article,catalogId,tagIds).success(function(){
                layer.mgs("保存成功");
            }).error(function(){
                layer.mgs("保存失败");
            })

        }



    }
]);



