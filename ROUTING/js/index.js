var app = angular.module('app', ['ui.router', 'ngAnimate']);

app.service('PageSrv', function(){
  var page = 1;
  this.getPage = function(){
    return page;
  }
  this.setPage = function(newPage) {
    page = newPage;
  }
});

app.controller('menu', function($scope, PageSrv, $state){
  $scope.pages = [1,2,3,4,5,6,7,8,9,10];
  $scope.currentPage = PageSrv.getPage;
  
  $scope.changePage = function(page){
    PageSrv.setPage(page);
    $state.go(''+page);
  }
});

app.config(function($stateProvider, $urlRouterProvider){
  for (var i=1;i<=10;i++) {
    $stateProvider.state({
      name : ''+i,
      url: '/'+i,
      template : '<div class="page">Page '+i+'</div>'
    });  
  }
  
  
  $urlRouterProvider.otherwise('/1');
});