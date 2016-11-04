'use strict';

var app = angular.module('app', ['ui.router', 'appControllers', 'appServices']);

var appServices = angular.module('appServices', []);
var appControllers = angular.module('appControllers', []);

var options = {};
options.api = {};
options.api.base_url = "http://localhost:63342";



app.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/index");

    $stateProvider
        .state('index', {
            url: '/index',
            views: {
                '': {templateUrl: 'templates/home.html',controller:"homeCtrl"},
                'main@index': {templateUrl: 'templates/main.html',controller:"homeCtrl"},
            }

        })
        .state('catalog', {
            url: '/catalog/:catalogName',
            views: {
                '': {templateUrl: 'templates/home.html'},
                //'header@java': {templateUrl: 'templates/head.html'},
                'main@catalog': {templateUrl: 'templates/list.html',controller:"BlogCatalogCtrl"}
                //'right@java': {templateUrl: 'templates/rightBar.html'}
            }
        })
        .state('books', {
            url: '/books',
            views: {
                '': {templateUrl: 'templates/home.html'},
                'header@books': {templateUrl: 'templates/head.html'},
                'main@books': {templateUrl: 'templates/main.html'},
                'right@books': {templateUrl: 'templates/rightBar.html'}
            }
        })
        .state('about', {
            url: '/about',
            views: {
                '': {templateUrl: 'templates/home.html'},
                'header@about': {templateUrl: 'templates/head.html'},
                'main@about': {templateUrl: 'templates/about.html'},
                'right@about': {templateUrl: 'templates/rightBar.html'}
            }
        })

});