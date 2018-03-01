addressBookApp = angular.module('addressBookApp', ['ngRoute']);

addressBookApp.controller('ContactController', function($scope, $http, $location, $routeParams) {
	
	$scope.page = 0;

	$scope.getContacts = function() {
		var request_params = {}
		if ($scope.search) {
			request_params['firstname'] = $scope.search;
//			request_params['lastname'] = $scope.search;
//			request_params['contgroup'] = $scope.search;
		}
		request_params['page'] = $scope.page;	
		
		$http.get('api/contacts', { params : request_params } )
			.success(function(data, status, headers) {
				$scope.contacts = data;
				$scope.successMessage = 'Everything is ok.';
			
				$scope.totalPages = headers()['total-pages']
				$scope.totalElements = headers()['total-elements']
			})
			.error(function() {
				$scope.errorMessage = 'Oops, something went wrong!';
			});
	};
	
	$scope.deleteContact = function(id, index) {
		$http.delete('api/contacts/' + id)
				.success(function() {
					$scope.contacts.splice(index, 1);
				})
				.error(function() {
					$scope.errorMessage = 'Oops, something went wrong.';
				});
	};

	
	$scope.initContact = function() {
		$scope.contact = {};
		
		if ($routeParams && $routeParams.id) {
			$http.get('api/contacts/' + $routeParams.id)
					.success(function(data) {
						$scope.contact = data;
					});
		}
	};
	
	$scope.saveContact = function() {
		if ($scope.contact.id) {
			$http.put('api/contacts/'+ $scope.contact.id, $scope.contact)
					.success(function() {
						$location.path('/contacts');
					})
					.error(function() {
						$scope.errorMessage = 'Oops, something went wrong.';
					});
		}
		else {
			$http.post('api/contacts', $scope.contact)
					.success(function() {
						$location.path('/contacts');
					})
					.error(function() {
						$scope.errorMessage = 'Oops, something went wrong.';
					});
		}
	};
	
	$scope.changePage = function(page) {
		$scope.page = page;
		$scope.getContacts();
	}
});

addressBookApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl : 'static/html/home.html'
        })
        .when('/contacts', {
            templateUrl : 'static/html/contacts.html',
            controller  : 'ContactController'
        })
        .when('/contacts/add', {
        	templateUrl : 'static/html/addEditContact.html',
        	controller  : 'ContactController'
        })
        .when('/contacts/edit/:id', {
        	templateUrl : 'static/html/addEditContact.html',
        	controller  : 'ContactController'
        })
        .otherwise({
            redirectTo: '/'
        });
}]);