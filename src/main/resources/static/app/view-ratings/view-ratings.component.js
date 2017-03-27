angular.module('viewRatings').component('viewRatings', {
    templateUrl: 'view-ratings/view-ratings.template.html',
    controller: ['$http', 'sharedData',
        function ViewRatingsController() {
            var self = this;

            self.getRatings = function (authorityId) {
                console.log('Called onChange method');
            }
        }
    ]
})