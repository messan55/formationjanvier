var app = angular.module('assetApp', ['ngFileUpload']);

app.controller('assetCtrl', ['$scope', 'Upload', '$timeout', function($scope, Upload, $timeout) {
    // je surveille la variable files du scope
    // le callback sera rappelé a sa mise à jour
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
        if (!file.$error) {
            Upload.upload({
                url : 'uploadImage',
                data : {
                    upload: file
                }
            }).progress(function(evt) {
                var percent = parseInt(100.0 * evt.loaded / evt.total);
                console.log("progression = " + percent + " % pour " + evt.config.data.file.name);
            }).success(function (data, status, headers, config) {
               console.log("upload réussi, reponse = " + JSON.stringify(data)); 
            });
        }
    };
    
}]);