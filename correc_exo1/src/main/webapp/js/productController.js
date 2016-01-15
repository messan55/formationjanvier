angular.module("productsModule", [])
       .controller("editCtrl", function($scope, $http) {
           $scope.addProduct = function (product) {
                console.log(product.nom + " - " + product.prix);
                $scope.navigateTo('views/productsList.html'); 
            };
       });