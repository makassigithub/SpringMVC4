
function Climat ($scope,$http) {
       $http.get('http://localhost:8080/ClimateTracker/datas.json')
       .success(function(data){
         $scope.AllClimatData = data;
       });
}