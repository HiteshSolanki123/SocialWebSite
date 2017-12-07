/*app.controller('loginController', function($scope,$http) {
	$scope.message = 'Look! I am an login page.';
	console.log("login function");
	$http.post("http://localhost:8080/SocialNetworkAppRest/login")
	.then(function(response)
			{
				$scope.user=response.data;
				$location.path("/");
			});
});
*/
app.controller("userController", function($scope, $http, $location) {
	$scope.register=function()
	{
		console.log("enter register");
		$http.post("http://localhost:8080/SocialNetworkAppRest/register",$scope.user)
		.then(function(response)
				{
					console.log("successfully registered");
				});
	}
	$scope.login=function()
	{
		console.log("loggin function");
		$http.post("http://localhost:8080/SocialNetworkAppRest/login",$scope.user)
		.then(function(response){
			$scope.user=response.data;
			console.log("login successful");
			$location.path("/")
		});
	};
});







