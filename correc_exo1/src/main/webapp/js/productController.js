
// creation d'un module regroupant les fonctionnalités produit
angular.module("productsModule", [])
       .controller("editCtrl", function($scope, $http) { //mise en place d'une controlleur pour l'edition
            // fonction d'ajout d'un produit depuis le formulaire
           $scope.addProduct = function (product) {
                console.log(product.nom + " - " + product.prix);
                // requette post vers le serveur avec transimission d'un objet json
                // contenant les détails de notre produit
                // cette objet json sera désérialisé ppar l'intercepteur json de
                // struts2 dans le cas présent
                $http.post('rest/productSave',
                  {
                      "produitNom" : product.nom,
                      "produitCategorie" : product.categorie,
                      "produitPrix" : product.prix,
                      "produitStock" : product.stock,
                      "produitID" : product.ID
                  }
                 ).then(function(response){
                     // dans la réponse, le serveur nous renvoie
                     // le produit inséré, nous l'ajoutons dans
                     // la liste des produits
                     // remarquons que nous pouvons acceder
                     // au $scope du controlleur parent (storeCtrl)
                     // grace a l'héritage de $scope d'angular
                    $scope.produits.push(response.data.produit);
                    // on retourne sur la vue liste des produits 
                    $scope.navigateTo('views/productsList.html');
                });

            };
       });