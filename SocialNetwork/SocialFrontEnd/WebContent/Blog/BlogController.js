app.controller("blogController", function($scope, $http, $location) {
	function fetchAllBlog() {
		console.log("Fetching all blogs");
		$http.get("http://localhost:8080/SocialNetworkAppRest/getAllBlogs")

		.then(function(response) {
			$scope.blogdata = response.data;
			console.log("Blog fetched");
		});
	}
	;
	fetchAllBlog();
	$scope.insertBlog = function() {
		console.log('entered insertBlog');
		$http.post('http://localhost:8080/SocialNetworkAppRest/insertBlog',
				$scope.blog).then(fetchAllBlog(), function(response) {
			console.log("successful blog entered");
			$location.path("/blog")
		});
	};
	$scope.deleteBlog = function(blogId) {
		console.log("entering in delete blog");
		$http.delete("http://localhost:8080/SocialNetworkAppRest/deleteBlog/",
				$scope.blog).success(fetchAllBlog(), function(response) {
					$scope.refresh();
			console.log("successful deleted");
			
		});
	};
});