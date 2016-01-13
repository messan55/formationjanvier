
// cette ligne creer un nouveau module angular
// le tableau en deuxieme argument contient les
// dépendances a injecter dans ce module
var todoApp = angular.module("todoApp", []);

// creation d'un controlleur "toDoCtrl" dans notre module
// le scope est automatiquement injecté par angular
todoApp.controller("ToDoCtrl", function($scope) {
   $scope.message = "bonjour depuis controlleur ToDoCtrl"; 
   $scope.taches = [
       {    "category":"developement",
            "completed":false,
            "dateCreated":"2016-01-13T00:00:00",
            "id":1,
            "libelle":"ecrire la requette ajax JQuery"},
       {    "category":"maison",
            "completed":false,
            "dateCreated":"2016-01-13T00:00:00",
            "id":2,
            "libelle":"passer aspirateur"}
       ];
   
});
