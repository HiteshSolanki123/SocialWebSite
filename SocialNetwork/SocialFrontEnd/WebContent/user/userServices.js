app.factory("userService", function($http) {
	var BASE_URL = "http://localhost:8090/SocialNetworkAppRest/";
	var userService = {};

	userService.getAllUser = function() {
		return $http.get(BASE_URL + "/getAllUsers");
	}
});