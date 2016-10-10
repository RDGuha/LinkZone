app.factory('BlogService', ['$http','$q', function($http, $q){
	
	var REST_SERVICE_URI = "http://localhost:8085/collaborationbackend/blogs/";

	var factory = {
		fetchAllBlogs: fetchAllBlogs
	};

	return factory;

	function fetchAllBlogs () {
		// Create a Deferred object
		var deferred =$q.defer();

		// Call the $http get service
		$http.get(REST_SERVICE_URI)
			 .then(function (response) {
			 	deferred.resolve(response.data);
			 },function (errResponse) {
			 	console.error('Error while fetching blogs!');
			 	deferred.reject(errResponse);
		});

		// return the promise object
		return deferred.promise;	 
	}



}]);