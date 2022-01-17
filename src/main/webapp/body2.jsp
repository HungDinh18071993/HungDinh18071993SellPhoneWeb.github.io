<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
 <head>     
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<style>
@media screen and (min-width: 760px) {
  .a {   
    padding-left: 100px;
  }
 .b{
 	width: 40%;
   }
}
</style>
    </head>
    <body>
    <c:set scope="page" var="pd" value="${requestScope.product}"/>
    <h4 style="margin-left:30px"> ${pd.getName()}</h4> 
    <hr>
    <div class="row" style="margin-bottom: 50px">
  		<div class="a col-sm-4" >
  			<a href="#"><img src="${pd.getSrc()}" style="width:200px;height:200px;" ></a>
  		</div>
  		<div class="b  col-sm-8" >
  			<h3 style="color:red">${pd.getPrice()}$</h3>
  			<p >${pd.getDescription()}</p>
  				<button type="button" style="backgound:orange" onclick="location.href='AddToCartController?action=add&id=${pd.getId()}';"
                class="btn btn-default btn-sm">
                <span class="glyphicon 
                    glyphicon-shopping-cart">
                </span>
                <b> Add to Cart </b>
            </button>
  		</div>
	</div>
   
    </body>
