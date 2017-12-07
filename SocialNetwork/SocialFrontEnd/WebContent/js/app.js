// create the module and name it app
var app = angular.module('myApp', [ 'ngRoute' ]);

// configure our routes
app.config(function($routeProvider, $locationProvider) {
	$locationProvider.hashPrefix('');
	$routeProvider

	// route for the blog page
	.when('/blog', {
		templateUrl : 'blog/blog.html',
		controller : 'blogController'
	})
	// route for the forum page
	.when('/forum',{
		templateUrl : 'forum/forum.html',
		controller : 'forumController'
	})
	.when('/adminBlog',{
		templateUrl : 'blog/adminBlog.html',
		controller : 'adminBlogController'
	})
	
	//route for the jobs
	.when('/jobs',{
		templateUrl : 'jobs/jobs.html',
		controller : 'jobsController'
	})
	
	// route for the home page
	.when('/', {
		templateUrl : 'pages/home.html',
		controller : 'mainController'
	})

	.when('/registration', {
		templateUrl : 'user/registration.html',
		controller : 'userController'
	})
	// route for the about page
	.when('/login', {
		templateUrl : 'user/login.html',
		controller : 'userController'
	});
});

app.controller('mainController', function($scope) {
	$scope.message = 'This is home page';
});
