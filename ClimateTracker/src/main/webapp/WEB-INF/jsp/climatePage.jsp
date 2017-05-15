<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Climate Page</title>
<style type="text/css">
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
<a href="?language=en">English</a>|<a href="?language=fr">French</a>

<form:form commandName="time">
  <form:errors path="*" cssClass="errorblock" element="div"/> 
  <label for="textinput1"><spring:message code="climate.Season"/></label>
  <form:input path="season" cssErrorClass="error"/>
  <form:errors path="season" cssClass="error"/>
  <br>
  <form:errors path="*" cssClass="errorblock" element="div"/> 
  <label for="textinput2"><spring:message code="climate.Temperature"/></label>
  <form:input path="temperature" cssErrorClass="error"/>
  
  <form:errors path="temperature" cssClass="error" />
  <input type="submit" class="btn" value="Enter Event">
</form:form>
</body>
</html>