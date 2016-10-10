app.config(['$routeProvider', '$locationProvider',function($routeProvider, $locationProvider) {	
	$routeProvider.
		when('/home', {
			templateUrl: 'app/components/page/homeView.html',
			controller: 'HomeController',
			controllerAs: 'homeCtrl'
		})
		.when('/about', {
			templateUrl: 'app/components/page/aboutView.html',
			controller: 'AboutController',
			controllerAs: 'aboutCtrl'
		})
		.when('/contact', {
			templateUrl: 'app/components/page/contactView.html',
			controller: 'ContactController',
			controllerAs: 'contactCtrl'
		})
		.when('/blog', {
			templateUrl: 'app/components/blog/blogView.html',
			controller: 'BlogController',
			controllerAs: 'blogCtrl'
		})
		.otherwise({
			redirectTo: '/home'
		})
	//$locationProvider.html5Mode(true); // requires a base tag	
}]);