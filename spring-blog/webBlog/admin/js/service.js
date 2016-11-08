





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

        delete: function(id) {
            return $http.delete(options.api.base_url + '/article/delete' + id);
        },

        create: function(article) {
            $http({
                method : "post",
                url : options.api.base_url + '/article/add',
                data : $.param(article),
                headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
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


