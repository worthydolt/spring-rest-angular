angular.module('showAuthorities').component('showAuthorities', {
    templateUrl: 'show-authorities/show-authorities.template.html',
    controller: ['$http', '$scope', 'sharedData',
        function ViewRatingsController($http, $scope, sharedData) {
            $http.get('/app/rest/allAuthorities').then(function (response) {
                $scope.authorities = response.data;
            });

            $scope.changed = function () {
                var id = $scope.authority.LocalAuthorityId;
                $http.get('/app/rest/authorityEstablishments?authorityId=' + id).then(function (response) {
                    sharedData.establishments = response.data;
                });
            }
        }
    ]
})
