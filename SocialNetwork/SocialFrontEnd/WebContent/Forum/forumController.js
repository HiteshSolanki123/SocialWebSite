app.controller("forumController", function($scope, $http, $location) {
	function fetchAllForum() {
		console.log("fetching all forum");
		$http.get("http://localhost:8080/SocialNetworkAppRest/getAllForums")

		.then(function(response) {
			$scope.forumdata = response.data;
			console.log("data fetched or forum");
		});

	}
	;
	fetchAllForum();
	$scope.insertForum = function() {
		console.log('entered insertForum');
		$http.post('http://localhost:8080/SocialNetworkAppRest/insertForum',
				$scope.forum).then(fetchAllForum(), function(response) {
			console.log("successful forum entered");
			$location.path("/forum")
		});
	}
});