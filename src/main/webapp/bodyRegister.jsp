<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Register" style="margin: 50px 0">
	  <label for="fname">user email:</label>
		  <input type="text" id="fname" name="usermailR" value=""><br>
		  <label for="lname">password:</label>
		  <input type="password" id="lname" name="passwordR" value=""><br>
		  <label for="fname">user name:</label>
		  <input type="text" id="fname" name="usernameR" value=""><br>
		  <label for="fname">user address:</label>
		  <input type="text" id="fname" name="address" value=""><br>
		   <label for="lname">user phone:</label>
		  <input type="text" id="lname" name="phone" value=""><br>
		  <input type="submit" value="Submit">
	</form>
<input type="hidden" name="error" value="${requestScope.errorRegister}">	
</body>
</html>