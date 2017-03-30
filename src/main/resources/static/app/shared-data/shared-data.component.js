angular.module('iWorksRatingsApp').factory('sharedData', function () {
    var self = this;

    self.establishments = {};

    self.totalRatings = function(){
        var totalRating = 0;
        for (var key in self.establishments){
            if (self.establishments.hasOwnProperty(key)){
                totalRating += self.establishments[key];
            }
        }
        return totalRating;
    }

    return self;

})