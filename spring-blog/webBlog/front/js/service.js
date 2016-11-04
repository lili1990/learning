





appServices.factory('BlogService', function($http) {
    return {
        findTest : function(){
            return $http.get('data/data.json');
        },
        findToped: function() {
            return $http.get(options.api.base_url + '/blog/top');
        },
        findLatested: function() {
            return $http.get(options.api.base_url + '/blog/latested');
        },
        findByCatalog: function(catalog) {
            return $http.get(options.api.base_url + '/blog/catalog/' + catalog);
        },
        findByTag: function(tag) {
            return $http.get(options.api.base_url + '/blog/tag/' + tag);
        },
        findById: function(id) {
            return $http.get(options.api.base_url + '/blog/' + id);
        },

        findAll: function() {
            return $http.get(options.api.base_url + '/blog/all');
        }

    };
});


appServices.factory('BlogAdminService', function($http) {
    return {


        findAll: function() {
            return $http.get(options.api.base_url + '/blog/all');
        },

        delete: function(id) {
            return $http.delete(options.api.base_url + '/blog/delete' + id);
        },

        create: function(post) {
            return $http.post(options.api.base_url + '/blog', {'post': post});
        },

        update: function(post) {
            return $http.put(options.api.base_url + '/blog', {'post': post});
        },

        like: function(id) {
            return $http.post(options.api.base_url  + '/blog/like', {'id': id});
        },

        unlike: function(id) {
            return $http.post(options.api.base_url  + '/blog/unlike', {'id': id});
        }
    };
});


