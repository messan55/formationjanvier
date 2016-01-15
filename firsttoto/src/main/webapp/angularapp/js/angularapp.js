
// cette ligne creer un nouveau module angular
// le tableau en deuxieme argument contient les
// dépendances a injecter dans ce module
var todoApp = angular.module("todoApp", []);

// creation d'un controlleur "toDoCtrl" dans notre module
// le scope est automatiquement injecté par angular
todoApp.controller("ToDoCtrl", function($scope, $http) {
   $scope.message = "bonjour depuis controlleur ToDoCtrl"; 
   $scope.taches = [];
   
   $http.get('../rest/tache').then(function (response) {
       $scope.taches = response.data.taches;
   });
   /*
   $scope.taches = [
        {    "category":"sport",
            "completed":false,
            "dateCreated":"2016-01-14T00:00:00",
            "id":5,
            "libelle":"courrir un semi marathon"},
        {    "category":"developement",
            "completed":false,
            "dateCreated":"2016-01-13T00:00:00",
            "id":1,
            "libelle":"ecrire la requette ajax JQuery"},
       {    "category":"developement",
            "completed":true,
            "dateCreated":"2016-01-13T00:00:00",
            "id":3,
            "libelle":"ecrire le squelette angular"},
       {    "category":"maison",
            "completed":true,
            "dateCreated":"2016-01-13T00:00:00",
            "id":4,
            "libelle":"descendre les poubelles"},
       {    "category":"maison",
            "completed":false,
            "dateCreated":"2016-01-13T00:00:00",
            "id":2,
            "libelle":"passer aspirateur"}
       ];
   */
   $scope.incompleteCount = function() {
     var count = 0;
     angular.forEach($scope.taches, function(t) {
       if (!t.completed) {
           count++;
       }  
     });
     return count;
   };
   
   $scope.warningLevel = function() {
     if ($scope.incompleteCount() < 3 ) {
        return "label-success";  
     }
     else {
        return "label-warning";
     }
   };
   // appelé quand le formulaire est soumis (click bouton)
   // on recoit le libelle de la tache a cree, et sa categorie
   $scope.addNewTask = function(libelle, category) {
     // j'envoie une requette POST pour demander au serveur de creer la tache en BDD
     $http.post('../rest/savetache/' + libelle + '/' + category, /* cette tache sera cree avec les parametres ci dessous*/ 
      {}).success(function(response) {
          // cette fonction est rappellée quand le serveur renvoie sa réponse
          // le serveur nous renvoie la tache inséré sous format JSON
          // angular deserialise le json dans response.data
          // nous ajoutons la tache insérée dans le tableau des taches du scope
         $scope.taches.push(response.tache);
      }); 
   };
   $scope.deleteTask = function(id) {
       console.log("delete taks no " + id);
   };

   $scope.addNewTask2 = function(libelle, category) {
     // j'envoie une requette POST pour demander au serveur de creer la tache en BDD
     $http.post('../rest/savetache2', {"tacheLibelle": libelle, "tacheCategory" : category} 
      ).success(function(response) {
          // cette fonction est rappellée quand le serveur renvoie sa réponse
          // le serveur nous renvoie la tache inséré sous format JSON
          // angular deserialise le json dans response.data
          // nous ajoutons la tache insérée dans le tableau des taches du scope
         $scope.taches.push(response.tache);
      }); 
   };


   
   /*
   $scope.addNewTask = function(libelle, category) {
     var tid =   $scope.taches.length + 1;
     var tdate = "" + new Date();
     $scope.taches.push({
       "libelle" : libelle,
       "category" : category,
       "completed" : false,
       "id" : tid,
       "dateCreated" : tdate 
     });
   };
   */
});

// filter prend en parametre le nom du filtre, et la fonction
// "factory" fabrique de la fonction filtre
todoApp.filter("completedTask", function() {
    // 2 parametre , la collection sur laquelle on travaille
    // un parametrage du filtre (ici un bolean pour determiner le filtrage)
   return function (items, showComplete) {
       var resultItems = [];
       angular.forEach(items, function(item) {
          if (item.completed == false || showComplete == true) {
              resultItems.push(item);
          }
       });
       return resultItems;
   };
});