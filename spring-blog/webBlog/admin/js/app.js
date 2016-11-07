'use strict';

var admin = angular.module('admin', ['ui.router', 'adminControllers', 'adminServices']);

var adminServices = angular.module('adminControllers', []);
var adminControllers = angular.module('adminServices', []);

var options = {};
options.api = {};
options.api.base_url = "http://localhost:9100";



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
            url: '/article',
            views: {
                '': {templateUrl: 'templates/article_list.html'}
            }
        })
        .state('draft', {
            url: '/draft',
            views: {
                '': {templateUrl: 'templates/article_draft.html'}
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
        });


});

