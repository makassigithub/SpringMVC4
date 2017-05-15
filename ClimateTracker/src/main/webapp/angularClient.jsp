<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Angular Client</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
<script src="ngController.js"></script>
</head>
<body>
  <div  ng-app>
 <div ng-controller="Climat">
 
 We have {{AllClimatData.length}} numbers of record
   <ul> 
      <li ng-repeat="data in AllClimatData">
         {{data.name}}
      </li>
   </ul>
 </div>
 </div>
</body>
</html>