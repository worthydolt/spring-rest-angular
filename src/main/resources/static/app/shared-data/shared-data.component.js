angular.module('iWorksRatingsApp').factory('sharedData', function () {
    var serviceData = {};

    function setData(key, data) {
        serviceData[key] = data;
    }

    function getData(key) {
        return serviceData[key];
    }

    var service = {
        getData: getData,
        setData: setData
    };
    return service;

})