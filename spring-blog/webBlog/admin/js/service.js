





adminServices.factory('TagService', function($http) {
    return {
        findTest : function(){
            return $http.get('data/tag.json');
        },
        findAll: function() {
            return $http.get(options.api.base_url + '/tag/list');
        },
        add:function(tag) {
            return $http.get(options.api.base_url + '/tag/add',{'tag':tag});
        },
        edit:function(tag) {
            return $http.get(options.api.base_url + '/tag/edit',{'tag':tag});
        },
        deleteTag : function() {
             return $http.get(options.api.base_url + '/tag/delete',{'id':id});
        }

    };
});

adminServices.factory('CatalogService', function($http) {
    return {
        findTest : function(){
            return $http.get('data/tag.json');
        },
        findAll: function() {
            return $http.get(options.api.base_url + '/catalog/list');
        },
        add:function(tag) {
            return $http.get(options.api.base_url + '/catalog/add',{'tag':tag});
        },
        edit:function(tag) {
            return $http.get(options.api.base_url + '/catalog/edit',{'tag':tag});
        },
        deleteTag : function() {
             return $http.get(options.api.base_url + '/catalog/delete',{'id':id});
        }

    };
});


adminServices.factory('BlogService', function($http) {
    return {
        findAll: function() {
            return $http.get(options.api.base_url + '/article/list');
        },
        findByStatus: function(status,pageNo,pageSize) {
            var page= new Object();
            page.pageNo=pageNo;
            page.pageSize=pageSize;
          return $http({
                           method : "POST",
                           url : options.api.base_url + '/article/list',
                           data :{
                               'status':status,
                               'page':page,
                           }

                       })

        },
        delete: function(id) {
            return $http.delete(options.api.base_url + '/article/delete' + id);
        },

        create: function(article,catalogId,tagIds) {
           return $http({
                    method : "post",
                    url : options.api.base_url + '/article/add',
                    data :{
                        'article':article,
                        'catalogId':catalogId,
                        'tagIds':tagIds
                    }
                })

        },

        update: function(post) {
            return $http.put(options.api.base_url + '/article/edit', {'article': article});
        },

        like: function(id) {
            return $http.post(options.api.base_url  + '/article/like', {'id': id});
        },

        unlike: function(id) {
            return $http.post(options.api.base_url  + '/article/unlike', {'id': id});
        }
    };
});


