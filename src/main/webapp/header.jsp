<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<head>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style>
@media screen and (max-width: 600px) {
  .container,.form {   
    margin-top: 30px;
  }
  .dropdown-toggle{
  display:none;
  }
}
</style>
</head>
<div class="header">
<div class="logo">
	<h2 style="color:white">PRJ321x</h2>
  <p style="color:yellow"> Welcome to my website </p>
</div>
  <form action="SearchController" class="form" >
  <div class="container">
    <div class="row">    
        <div class="col-xs-9 ">
		    <div class="input-group">
                <div class="input-group-btn search-panel">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    	<span id="search_concept">Categories</span> <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
                      <li><a href="#contains">Apple</a></li>
                      <li><a href="#its_equal">Samsung</a></li>
                      <li><a href="#greather_than">Oppo</a></li>
                      <li><a href="#less_than">Vivo </a></li>
                      <li class="divider"></li>
                      <li><a href="#all">Anything</a></li>
                    </ul>
                </div>
    
                	<input type="hidden" name="search_param" value="all" id="search_param">         
                <input type="text" class="form-control" name="Search" placeholder="${requestScope.z}">
                <span class="input-group-btn" >
                    <button class="btn btn-default" type="submit"  style="background-color: orange"><span class="glyphicon glyphicon-search"></span></button>
                </span>

                
            </div>
        </div>
	</div>
</div>
</form>
</div>

<div class="topnav">
  <a href="ListController">Home</a>
  <a href="#">Products</a>
  <a href="#">About Us</a>
  <a href="Register.jsp" style="float:right">Register</a>
  <c:if test='${sessionScope.user==null}'>
		 <a href="login.jsp" style="float:right">Log in</a>
  </c:if>
  <c:if test='${sessionScope.user!=null}'>
		<a href="LogoutServlet" style="float:right">Log out</a>
		<a href="SearchController2" style="float:right">Account</a>
  </c:if>
</div>
<c:if test='${sessionScope.user!=null}'>
		<p>Welcome ${sessionScope.user} </p>
</c:if>

