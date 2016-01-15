angular.module("storeDirectives", [])
        .directive("productsCount", function(){
           return {
             restrict: "E",
             templateUrl: "components/productCount.html",
             controller: function($scope) {
                 console.log("demarrage scope directive");
             }
           }; 
        });