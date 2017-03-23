angular.
    module('showAuthorities').
    component('showAuthorities', {
      template:
        '<select>'+
            '<option ng-repeat="auth in $ctrl.authorities" value="{{auth.id}}">'+
                '{{auth.name}}'+
            '</option>'+
        '</select>',
      controller: function ViewRatingsController($http) {
          var self = this;
          $http.get('api/allAuthorities').then(function (response) {
              self.authorities = response.data;
          });
          // this.authorities = [
          //     {
          //         name: 'one',
          //         id: '111'
          //     },
          //     {
          //         name: 'two',
          //         id: '112'
          //     }
          // ];
      }
})