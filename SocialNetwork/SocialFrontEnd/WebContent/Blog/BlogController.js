app.controller("blogController",function($scope,$http)
{
	console.log("Http Service Called");
	$http.get("http://localhost:8080/SocialNetworkAppRest/getAllBlogs")
	
	.then(function(response)
	{
		$scope.blogdata=response.data;
		console.log("Data stored");
	});
	$scope.insertBlog=function()
	{
		console.log('entered insertBlog');
		$http.post('http://localhost:8080/SocialNetworkAppRest/insertBlog',$scope.blog)
		.then(function(response)
				{
				console.log("successful blog entered");
				});
	}
});