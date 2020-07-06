propostaCredito.controller("propostaCreditoClienteController", function($scope, $http, $location) {
	$scope.propostas=[];
	$scope.proposta={};
	$scope.buscarPropostas={};
	$scope.buscarProposta=[];
	
	var server_url = 'http://localhost:8080';
	
	carregarPropostaCredito = function () {
		$http({method:'GET', url:server_url+'/proposta-credito-cliente'})
		.then(function (response) {
			$scope.propostas = response.data;			
		}, function (response) {
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	carregarPropostaCredito();
	
	$scope.adicionarPropostaCredito = function() {
		if ($scope.frmProposta.$valid) {
			$scope.proposta.registerDt = new Date();
			$http({method:'POST', url:server_url+'/proposta-credito-cliente', data: $scope.proposta})
			.then(function (response) {
				$scope.propostas.push(response.data);
				carregarPropostaCredito();
				$scope.frmProposta.$setPristine(true);
				$location.path('/proposta-credito-cliente');
			}, function (response) {
				console.log(response.data);
				console.log(response.status);
			});
		} else {
			window.alert("Dados invalidos");
		}
	};
	
	$scope.buscarProposta = function(proposta) {
		if ((proposta.nome == undefined | proposta.nome == '') && (proposta.cpf == undefined | proposta.cpf == '')) {
			carregarPropostaCredito();
			$scope.frmSearch.$setPristine(true);
			$location.path('/');
			$location.path('/proposta-credito-cliente');
			
		} else {			
			proposta.nome = proposta.nome == '' ? null : proposta.nome; 
			proposta.cpf = proposta.cpf == '' ? null : proposta.cpf; 
			
			$scope.proposta = proposta;
			$http({method:'POST', url:'http://localhost:8080/find-propostas', data: proposta})
			.then(function (response) {
				$scope.propostas = (response.data);				
				$scope.frmSearch.$setPristine(true);
				$scope.proposta = {}
				$location.path('/');
				$location.path('/proposta-credito-cliente');
			}, function (response) {
				console.log(response.data);
				console.log(response.status);
			});
		}
	};
	
	$scope.excluirProposta = function(proposta) {
		$http({method:'DELETE', url:'http://localhost:8080/propostas/'+proposta.id})
		.then(function (response) {			
			pos = $scope.propostas.indexOf(proposta);
			$scope.propostas.splice(pos, 1);
		}, function (response) {
			console.log(response.data);
			console.log(response.status);
		});
	};
	
	$scope.alterarCliente = function (cli) {
		$scope.cliente = angular.copy(cli);
		
	};
	
	$scope.cancelAltProposta = function () {
		$scope.proposta = {};
	};	
	
});