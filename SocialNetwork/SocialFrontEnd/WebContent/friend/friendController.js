app.controller("friendController", function($scope, $http, $location,$rootScope) 
	{
		$scope.friend={friendId:0,username:'',friendname:'',status:''};
		$scope.allFriendRequest;
	
		function fetchAllFriendRequests() 
		{
		console.log("fetched all friendRequests");
		$http.get("http://localhost:8090/SocialNetworkAppRest/getAllFriendRequest")
		.then(function(response) 
			{
			$scope.allFriendRequest = response.data;
			console.log($scope.allFriendRequest);
			});
		}
		fetchAllFriendRequests();
	});