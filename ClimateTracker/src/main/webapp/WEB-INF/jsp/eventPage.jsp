<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Event Page</title>
<style>
 .error{
  color:#ff0000;
 }
 
 .errorblock{
  color:#000;
  backgroundColor:#66cccc; 
  padding:8px;
  marging: 16px;
 }
</style>
</head>
<body>
<form:form commandName="first">
  <form:errors path="*" cssClass="errorblock" element="div" /> 
  <label for="textinput1">Enter Day</label>
  <form:input path="name" cssErrorClass="error"/>
  <form:errors path="name" cssClass="error" />
  <input type="submit" class="btn" value="Enter Event">
</form:form>
</body>
</html>