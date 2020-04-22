angular.module('app', ['ngResource'])
.controller('ProductController', function ($resource) {
        var vm = this;
        var Product= $resource('api/products/:productId');
        vm.product = new Product();

        function refreshData() {
            vm.products = Product.query(function succes(data, headers) {
                    console.log('Pobrano dane: ' + data)
            },
                function error(response) {
                        console.log(response.status);
                });
        }

        vm.addProduct = function (product){
                console.log(vm.product.__proto__);
                vm.product.$save(function (data) {
                        refreshData();
                        vm.product = new Product();
                });
        }

        vm.loadData = function(id)
        {
                vm.details = Product.get({productId:id});
        }

        vm.name = 'Product manager'
        refreshData();
});