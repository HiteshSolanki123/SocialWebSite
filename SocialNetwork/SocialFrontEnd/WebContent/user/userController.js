app.controller("userController", function($scope, $http, $location,$rootScope) {
	$scope.user={username:'',password:'',role:'',firstname:'',lastname:'',email:'',phone:'',isOnline:'',uid:''}
	$scope.allusers;
	$scope.user;
	$scope.register=function()
	{
		console.log("enter register");
		$http.post("http://localhost:8080/SocialNetworkAppRest/register",$scope.user)
		.then(function(response)
				{
					console.log("successfully registered");
					$location.path("/login");
				});
	}
	$scope.login=function()
	{
		console.log("loggin function");
		
		$http.post("http://localhost:8080/SocialNetworkAppRest/login",$rootScope.currentUser)
		.then(function(response){
			$scope.user=response.data;
			$rootScope.currentUser=response.data;
			console.log($rootScope.currentUser.role);
			$location.path("/")
		});
	};
	function fetchAllUsers()
	{
		console.log("fetching all users");
		$http.get("http://localhost:8080/SocialNetworkAppRest/getAllUsers")
		.then(function(response)
				{
					$scope.allusers=response.data;
				});
				};
				fetchAllUsers();
	});







