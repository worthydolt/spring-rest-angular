angular.module('showAuthorities').component('showAuthorities', {
    templateUrl: 'show-authorities/show-authorities.template.html',
    controller: ['$http',
        function ViewRatingsController($http) {
            var self = this;
            $http.get('/app/rest/allAuthorities').then(function (response) {
                self.authorities = response.data;
            });

            self.changed = function (authorityId) {
                console.log('Changed combo ' + authorityId);

            }
        }
    ]
})
