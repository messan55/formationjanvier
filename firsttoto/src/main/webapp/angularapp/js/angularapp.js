
// cette ligne creer un nouveau module angular
// le tableau en deuxieme argument contient les
// dépendances a injecter dans ce module
var todoApp = angular.module("todoApp", []);

// creation d'un controlleur "toDoCtrl" dans notre module
// le scope est automatiquement injecté par angular
todoApp.controller("ToDoCtrl", function($scope) {
   $scope.message = "bonjour depuis controlleur ToDoCtrl"; 
});
