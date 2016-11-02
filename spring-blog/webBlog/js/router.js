

var router = angular.module('router', ['ui.router','blogControllers']);



router.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/index");

    $stateProvider
        .state('index', {
            url: '/index',
            views: {
                '': {templateUrl: 'templates/home.html'},
                'header@index': {templateUrl: 'templates/head.html'},
                'main@index': {templateUrl: 'templates/main.html'},
                'right@index': {templateUrl: 'templates/rightBar.html'}
            }
        })
        .state('java', {
            url: '/java',
            views: {
                '': {templateUrl: 'templates/home.html'},
                'header@java': {templateUrl: 'templates/head.html'},
                'main@java': {templateUrl: 'templates/list.html'},
                'right@java': {templateUrl: 'templates/rightBar.html'}
            }
        })
        .state('linux', {
            url: '/linux',
            views: {
                '': {templateUrl: 'templates/home.html'},
                'header@linux': {templateUrl: 'templates/head.html'},
                'main@linux': {templateUrl: 'templates/list.html'},
                'right@linux': {templateUrl: 'templates/rightBar.html'}
            }
        })
        .state('architecture', {
            url: '/architecture',
            views: {
                '': {templateUrl: 'templates/home.html'},
                'header@architecture': {templateUrl: 'templates/head.html'},
                'main@architecture': {templateUrl: 'templates/main.html'},
                'right@architecture': {templateUrl: 'templates/rightBar.html'}
            }
        })
        .state('life', {
            url: '/life',
            views: {
                '': {templateUrl: 'templates/home.html'},
                'header@life': {templateUrl: 'templates/head.html'},
                'main@life': {templateUrl: 'templates/main.html'},
                'right@life': {templateUrl: 'templates/rightBar.html'}
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