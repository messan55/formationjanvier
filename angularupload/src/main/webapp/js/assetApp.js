var app = angular.module('assetApp', ['ngFileUpload']);

app.controller('assetCtrl', ['$scope', 'Upload', '$timeout', function($scope, Upload, $timeout) {
    // je surveille la variable files du scope
    // le callback sera rappelé a sa mise à jour
    $scope.$watch('files', function() {
        if ($scope.files && $scope.files.length > 0) {
            console.log($scope.files.length);
            for (var idx in $scope.files) {
                console.log($scope.files[idx].name);
                $scope.uploadImage(files[0]);
            }
        }
    });
    
    $scope.uploadImage = function(file) {
        
    };
    
}]);