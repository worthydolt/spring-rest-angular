angular.module('showAuthorities').component('showAuthorities', {
    templateUrl: 'show-authorities/show-authorities.template.html',
    controller: ['$http', '$scope', 'sharedData', 'usSpinnerService',
        function ViewRatingsController($http, $scope, sharedData, usSpinnerService) {
            usSpinnerService.spin('spinner-1');
            $http.get('/app/rest/allAuthorities')
                .then(function (response) {
                        $scope.authorities = response.data;
                        usSpinnerService.stop('spinner-1');
                    },
                    // ReST call to back end returned error status
                    function (response) {
                        alert('It has not been possible to retrieve a list of local authorities. Please try again');
                        usSpinnerService.stop('spinner-1');
                    });


            $scope.changed = function () {
                usSpinnerService.spin('spinner-1');
                var id = $scope.authority.LocalAuthorityId;
                $http.get('/app/rest/authorityEstablishments?authorityId=' + id)
                    .then(function (response) {
                            sharedData.establishments = response.data;
                            usSpinnerService.stop('spinner-1');
                        },
                        // ReST call to back end returned error status
                        function (response) {
                            alert('It has not been possible to retrieve ratings for this authority. Please try again');
                            usSpinnerService.stop('spinner-1');
                        });
            }
        }
    ]
})
