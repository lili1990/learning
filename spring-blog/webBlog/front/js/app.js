'use strict';

var app = angular.module('app', ['ui.router', 'appControllers', 'appServices']);

var appServices = angular.module('appServices', []);
var appControllers = angular.module('appControllers', []);

var options = {};
options.api = {};
options.api.base_url = "http://localhost:9100";

app.filter('trustHtml', function ($sce) {
    return function (input) {
        return $sce.trustAsHtml(input);
    }
});



app.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/index");

    $stateProvider
        .state('index', {
            url: '/index',
            views: {
                '': {templateUrl: 'templates/main.html',controller:"homeCtrl"},
            }

        })
        .state('catalog', {
            url: '/catalog/:catalogName',
            views: {
                '': {templateUrl: 'templates/list.html',controller:"BlogCatalogCtrl"}
            }
        })
        .state('books', {
            url: '/books',
            views: {
                '': {templateUrl: 'templates/main.html'},
            }
        })
        .state('about', {
            url: '/about',
            views: {
                '': {templateUrl: 'templates/about.html',controller:'AboutCtrl'},
            }
        })
        .state('article', {
        url: '/article/:articleId',
        views: {
            '': {templateUrl: 'templates/article.html',controller:"ArticleCtrl"}
        }
    })

});