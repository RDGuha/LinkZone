var home = angular.module('collaborationAppHome', []);

home.controller('HomeController', function($location) {

	// to highlight the active menu
	this.homeMenu = true;
});

home.controller('AboutController', function() {

	// to highlight the active menu
	this.aboutMenu = true;
});

home.controller('ContactController', function() {

	// to highlight the active menu
	this.contactMenu = true;
});
