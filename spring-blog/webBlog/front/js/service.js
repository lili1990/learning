





appServices.factory('BlogService', function($http) {
    return {
        findTest : function(){
            return $http.get('data/data.json');
        },
        findToped: function() {
            return $http.get(options.api.base_url + '/article/top');
        },
        findLatested: function() {
            return $http.get(options.api.base_url + '/article/latested');
        },
        findHot: function() {
            return $http.get(options.api.base_url + '/article/hot');
        },
        findByCatalog: function(catalogId) {
            return $http.get(options.api.base_url + '/article/catalog/' + catalogId);
        },
        findByTag: function(tag) {
            return $http.get(options.api.base_url + '/article/tag/' + tag);
        },
        findById: function(id) {
            return $http.get(options.api.base_url + '/article/' + id);
        },
        findAll: function() {
            return $http.get(options.api.base_url + '/article/list');
        },
        findTags: function(articleId) {
            return $http.get(options.api.base_url + '/tag/'+articleId);
        },
        findCatalog: function(articleId) {
            return $http.get(options.api.base_url + '/catalog/'+articleId);
        },
        findCatalogs: function() {
            return $http.get(options.api.base_url + '/catalog/list');
        },
        findBefore: function(articleId) {
            return $http.get(options.api.base_url + '/article/before/'+articleId);
        },
        findAfter: function(articleId) {
            return $http.get(options.api.base_url + '/article/after/'+articleId);
        }

    };
});





