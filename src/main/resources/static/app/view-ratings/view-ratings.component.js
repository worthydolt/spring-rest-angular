angular.module('viewRatings').component('viewRatings', {
    templateUrl: 'view-ratings/view-ratings.template.html',
    controller: ['$scope', 'sharedData',
        function ViewRatingsController($scope, sharedData) {
            $scope.establishments = sharedData.establishments;

            $scope.$watch(function() { $scope.establishments = sharedData.establishments; },

                function(newValue, oldValue) {
                    if (newValue !== oldValue){
                        console.log('changed scope establishments value');
                    }
                }
            );
            console.log(sharedData.establishments);
        }
    ]
})