angular.module("productsModule", [])
       .controller("editCtrl", function($scope, $http) {
           $scope.addProduct = function (product) {
                console.log(product.nom + " - " + product.prix);
                $http.post('rest/productSave',
                  {
                      "produitNom" : product.nom,
                      "produitCategorie" : product.categorie,
                      "produitPrix" : product.prix,
                      "produitStock" : product.stock,
                      "produitID" : product.ID
                  }
                 ).then(function(response){
                    $scope.produits.push(response.data.produit); 
                    $scope.navigateTo('views/productsList.html');
                });

            };
       });