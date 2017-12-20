// create the module and name it app
var app = angular.module('myApp', [ 'ngRoute' ]);

// configure our routes
app.config(function($routeProvider, $locationProvider) {
	$locationProvider.hashPrefix('');
	$routeProvider


	.when('/blog', {templateUrl : 'blog/blog.html',	controller : 'blogController'})
	.when('/forum',{templateUrl : 'forum/forum.html',controller : 'forumController'	})
	.when('/adminBlog',{templateUrl : 'blog/adminBlog.html',controller : 'adminBlogController'})
	.when('/jobs',{templateUrl : 'jobs/jobs.html',controller : 'jobsController'	})
	.when('/', {templateUrl : 'pages/home.html',controller : 'mainController'})
	.when('/registration', {templateUrl : 'user/registration.html',controller : 'userController'})
	.when('/login', {templateUrl : 'user/login.html',controller : 'userController'})
	.when('/friend', {templateUrl : 'friend/friend.html',controller : 'userController'})
	.when('/UserHome', {templateUrl : 'pages/home.html',controller : 'mainController'})
	.when('/showFriendRequest', {templateUrl : 'friend/showFriendRequest.html',controller : 'friendController'});

});
/*app.run(function($rootScope,$cookieStore){
	console.log('i am in run function');
	console.log($rootScope.currentUser);
	if($rootScope.currentUser==undefined)
		{
		$rootScope.currentUser=$cookieStore.get('user');
		}
	else{
		console.log($rootScope.currentUser.username);
		console.log($rootScope.currentUser.role);
	}
});*/

app.controller('mainController', function($scope) {
	$scope.message = 'This is home page';
});
