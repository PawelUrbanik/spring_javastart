angular.module('app', [])
.controller('ProductController', function ($http) {
        var vm = this;
        function refreshData() {
            $http({
                method:'GET',
                url:'api/products'
            }).then(function succes(response) {
                vm.products = response.data;
                console.log(vm.products);
            },function error(response) {
                console.log("API error: " + response.status)
            });
        }

        vm.addProduct= function(product){
            $http({
                method:'POST',
                url:'api/products',
                data: product
            }).then(function succes(response) {
                refreshData();
                vm.product = {}
            },function error(response) {
                console.log("Data not saved error: " + response.status)
            });
        }

        vm.appName = 'Product Manager';
        refreshData();
})