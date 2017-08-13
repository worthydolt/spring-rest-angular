angular.module('viewRatings').component('viewRatings', {
    templateUrl: 'view-ratings/view-ratings.template.html',
    controller: ['$scope', 'sharedData',
        function ViewRatingsController($scope, sharedData) {
            $scope.$watch(function () {
                    $scope.establishments = sharedData.establishments;
                    $scope.totalRatings = sharedData.totalRatings();
                }

                // function (newValue, oldValue) {
                //     if (newValue !== oldValue) {
                //         console.log('changed scope establishments value');
                //     }
                // }
            );

            /**
             * Formats the label column to provide the '-star' suffix on those ratings that require it. We discover
             * which require it by trying to parse the labels (all strings) as numbers and see what the result is
             * @param label - the label text
             * @returns the formatted or untouched label
             */
            $scope.formatLabel = function (label) {
                var parsed = parseInt(label);
                if (!isNaN(parsed) && angular.isNumber(parsed)){
                    return label + '-star';
                } else {
                    return label;
                }
            }
        }
    ]
})