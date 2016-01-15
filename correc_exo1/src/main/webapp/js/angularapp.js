
// cette ligne creer un nouveau module angular
// le tableau en deuxieme argument contient les
// dépendances a injecter dans ce module
var todoApp = angular.module("storeApp", []);

// creation d'un controlleur "toDoCtrl" dans notre module
// le scope est automatiquement injecté par angular
todoApp.controller("StoreCtrl", function($scope, $http) {
   $scope.produits = [];
   $scope.currentView = 'views/productsList.html';
   
   $http.get('rest/produit').then(function (response) {
       $scope.produits = response.data.produits;
   });
   
   $scope.navigateTo = function(view) {
       $scope.currentView = view;
   };
 
   $scope.addProduct = function (product) {
       console.log(product.nom + " - " + product.prix);
       $scope.navigateTo('views/productsList.html'); 
   };
});