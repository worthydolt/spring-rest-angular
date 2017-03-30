angular.module('viewRatings').component('viewRatings', {
    templateUrl: 'view-ratings/view-ratings.template.html',
    controller: ['$scope', 'sharedData',
        function ViewRatingsController($scope, sharedData) {
            $scope.$watch(function() {
                    $scope.establishments = sharedData.establishments;
                    $scope.totalRatings = sharedData.totalRatings();
                },

            function(newValue, oldValue) {
                if (newValue !== oldValue){
                    console.log('changed scope establishments value');
                }
            }
        );
        }
    ]
})