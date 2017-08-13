angular.module('showAuthorities').component('showAuthorities', {
    templateUrl: 'show-authorities/show-authorities.template.html',
    controller: ['$http', '$scope', 'sharedData', 'usSpinnerService',
        function ViewRatingsController($http, $scope, sharedData, usSpinnerService) {
            $http.get('/app/rest/allAuthorities').then(function (response) {
                $scope.authorities = response.data;
                usSpinnerService.stop('spinner-1');

            });

            $scope.changed = function () {
                usSpinnerService.spin('spinner-1');
                var id = $scope.authority.LocalAuthorityId;
                $http.get('/app/rest/authorityEstablishments?authorityId=' + id).then(function (response) {
                    sharedData.establishments = response.data;
                    usSpinnerService.stop('spinner-1');
                });
            }
        }
    ]
})
