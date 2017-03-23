angular.
    module('viewRatings').
    component('viewRatings', {
      template:
        '<table><tr><td ng-repeat="auth in $ctrl.authorities">{{auth.name}}</td></tr></table>'
       ,
      controller: function ViewRatingsController() {
          this.authorities = [
              {
                  name: 'one'
              },
              {
                  name: 'two'
              }
          ];
      }
})