'use strict';

var admin = angular.module('admin', ['ui.router', 'adminControllers', 'adminServices']);

var adminServices = angular.module('adminControllers', []);
var adminControllers = angular.module('adminServices', []);

var options = {};
options.api = {};
options.api.base_url = "http://localhost:9100";

var pageNo=1,pageSize=15;

admin.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/index");

    $stateProvider
        .state('index', {
            url: '/index',
            views: {
                '': {templateUrl: 'templates/index.html',controller:"homeCtrl"}
            }
        })
        .state('tag', {
            url: '/tag',
            views: {
                '': {templateUrl: 'templates/tag.html',controller:"tagCtrl"}
            }
        })
        .state('article', {
            url: '/article/:status',
            views: {
                '': {templateUrl: 'templates/article_list.html',controller:'ArticleCtrl'}
            }
        })
        .state('draft', {
            url: '/draft/:status',
            views: {
                '': {templateUrl: 'templates/article_draft.html',controller:'ArticleCtrl'}
            }
        })
        .state('create', {
            url: '/create',
            views: {
                '': {templateUrl: 'templates/article_create.html',controller:"BlogCreateCtrl"}
            }
        })
        .state('createMark', {
              url: '/createMark',
              views: {
                  '': {templateUrl: 'templates/article_createMark.html',controller:"BlogCreateCtrl"}
              }
        })
        .state('mdeditArticle', {
            url: '/mdeditArticle/:articleId',
            views: {
                '': {templateUrl: 'templates/article_createMark.html',controller:"BlogCreateCtrl"}
            }
        })
        .state('editArticle ', {
            url: '/editArticle/:articleId',
            views: {
                '': {templateUrl: 'templates/article_create.html',controller:"BlogEditCtrl"}
            }
        });


});

