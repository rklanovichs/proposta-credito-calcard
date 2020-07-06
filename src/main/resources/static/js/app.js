var propostaCredito = angular.module("propostaCredito", ['ngRoute']);

propostaCredito.config(function ($routeProvider, $locationProvider) {
	$routeProvider
		.when('/proposta-credito-cliente', {
			templateUrl: 'view/propostaCreditoCliente.html', 
			controller: 'propostaCreditoClienteController'
		}).when('/adicionar-proposta', {
			templateUrl: 'view/propostaCreditoClienteAdd.html', 
			controller: 'propostaCreditoClienteController'
		}).otherwise({
			redirectTo:'/'
		});
	
	$locationProvider.html5Mode(true)
});