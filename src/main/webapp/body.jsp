<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
 <head>     
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<style>

</style>
    </head>
    <body>
    <div class="row" style="margin: 50px 0">
  <div class="leftcolumn">
		<div class= "container-fluid">
	<div class= "row d-inline-flex">
		  <h4>${requestScope.error}</h4>
	      <c:forEach items="${requestScope.products}" var="list">

  			<!-- Gallery Item  -->
	   <div class ="col-xs-6 col-sm-4 col-md-3 p-2">
		  <div class="card h-100">
			 <a href="ImformationProductController?id=${list.getId()}"><img class="card-img-top" src="${list.getSrc()}" style="width:150px;height:150px;" ></a>
			 <h6 style="color:grey">${list.getType().toUpperCase()}</h6>
			 <p> ${list.getName()} </p>
			 <p style="color:red">${list.getPrice()}$</p>
		  </div>
	   </div>

		</c:forEach>
	 
	</div>
 </div>
  </div>
</div>
    

    </body>
