app.controller('BlogController', ['BlogService','$http', function(BlogService, $http){
	
	var self = this;
	self.blogs = [];

	fetchAllBlogs();


	function fetchAllBlogs () {
		BlogService
		.fetchAllBlogs()
	    .then(function(data){
	   		self.blogs = data;
		 },function (errResponse) {
			console.error('Error while fetching the blogs');
		})
	}

	
}]);