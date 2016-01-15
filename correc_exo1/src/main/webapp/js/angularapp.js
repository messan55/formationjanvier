
// cette ligne creer un nouveau module angular
// le tableau en deuxieme argument contient les
// dépendances a injecter dans ce module
var todoApp = angular.module("storeApp", []);

// creation d'un controlleur "toDoCtrl" dans notre module
// le scope est automatiquement injecté par angular
todoApp.controller("StoreCtrl", function($scope, $http) {
   $scope.produits = [];
   
   $http.get('rest/produit').then(function (response) {
       $scope.produits = response.data.produits;
   });
 
});