/*app.factory("userService", function($http) {
	var BASE_URL = "http://localhost:8080/SocialNetworkAppRest/";
	var userService = {};

	userService.getAllUser = function() {
		return $http.get(BASE_URL + "/getAllUsers");
	}

	userService.createUser=function(user){
		console.log("****** inside user service--createUser()******")
		return $http.post(BASE_URL+ "/register" ,user);		
	}
	return userService;
});*/