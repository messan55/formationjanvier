var app = angular.module('assetApp', ['ngFileUpload']);

app.controller('assetCtrl', ['$scope', 'Upload', '$timeout', function($scope, Upload, $timeout) {
    // je surveille la variable files du scope
    // le callback sera rappelé a sa mise à jour (c.a.d lors d'un drop dans la drop-zone)
    $scope.$watch('files', function() {
        if ($scope.files && $scope.files.length > 0) {
            console.log($scope.files.length);
            for (var idx in $scope.files) {
                console.log($scope.files[idx].name);
                $scope.uploadImage($scope.files[0]);
            }
        }
    });
    
    $scope.uploadImage = function(file) {
        // si le fichier est en erreur (quelle qu'elle soit), ne pas faire d'upload
        if (!file.$error) {
            // on utilise l'objet Upload (en provenance de la librairie ngFileUpload)
            // cette objet encapsule une requette $http.post en l'étendant
            // pour supporter l'upload ajax de fichier
            Upload.upload({
                url : 'uploadImage',  // url de la requette post
                data : {  // data est l'objet json transmit
                    upload: file //dans cete objet, je transmet le fichier en choisissant le nom du champ, ici 'upload'
                }
            }).progress(function(evt) { // cette fonction est rappele lors de la progression de l'upload
                var percent = parseInt(100.0 * evt.loaded / evt.total);
                console.log("progression = " + percent + " % pour " + evt.config.data.upload.name);
            }).success(function (data, status, headers, config) { 
                // cette fonction est appelé lorsque l'upload est terminé
               console.log("upload réussi, reponse = " + JSON.stringify(data)); 
            });
        }
    };
    
}]);