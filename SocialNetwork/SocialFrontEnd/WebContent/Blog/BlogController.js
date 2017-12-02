app.controller("BlogController",function($scope,$http)
{
	console.log("Http Service Called");
	$http.get("http://localhost:8080/SocialNetworkAppRest/getAllBlogs")
	
	.then(function(response)
	{
		$scope.blogdata=response.data;
		console.log("Data stored");
	});
});