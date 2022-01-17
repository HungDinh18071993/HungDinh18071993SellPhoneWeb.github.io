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
    
		<form action="PayController" style="margin: 50px 0">
   <div class="table-responsive">
  		<table class="table">
    		<thead>
			    <tr>
			      <th scope="col">Products in cart: </th>
			      <th scope="col">Price</th>
			      <th scope="col">Quantity</th>
			      <th scope="col">Amount</th>
			      <th scope="col">Add </th>
			      <th scope="col">Divide</th>
			      <th scope="col">Delete</th>
			    </tr>
			  </thead>
			  
			  <tbody>
			  <c:forEach items="${sessionScope.cart.getItem()}" var="list">
			    <tr>
			      <td>${list.getName()} <br>
			      	  ${list.getId()}
			      </td>
			      <td>${list.getPrice()} ($)</td>
			      <td>${list.getNumber()}</td>
			      <td>${Math.round(list.getPrice()*list.getNumber()*100.0)/100.0} ($)</td>
			      <td><button type="button" onclick="location.href='AddToCartController?action=plus&id=${list.getId()}';"
                class="btn btn-default btn-sm">(+)</button></td> 
			      <td><button type="button" onclick="location.href='AddToCartController?action=div&id=${list.getId()}';"
                class="btn btn-default btn-sm">(-)</button></td> 
			      <td><button type="button" onclick="location.href='AddToCartController?action=delete&id=${list.getId()}';"
                class="btn btn-default btn-sm">Delete</button></td>  
			    </tr>
			   </c:forEach>
			   <tr><td> </td><td></td><td></td><td>Total : ${sessionScope.cart.getAmount()} ($) </td> </tr>
			  </tbody>
			  	
  		</table>
	</div>
		 <c:if test='${sessionScope.user==null}'>
		 <label for="fname">Customer name:</label>
		  <input type="text" id="fname" name="name" value=""><br>
		  <label for="lname">Customer address:</label>
		  <input type="text" id="lname" name="address" value=""><br>
  		</c:if>
  		<c:if test='${sessionScope.user!=null}'>
		<label for="fname">Customer name:</label>
		  <input type="text" id="fname" name="name" value='${sessionScope.nameUserLogin}'><br>
		  <label for="lname">Customer address:</label>
		  <input type="text" id="lname" name="address" value='${sessionScope.addressUserLogin}'><br>
 		 </c:if>
		  <label for="lname">Discount code (if any):</label>
		  <input type="text" id="lname" name="discount" value=""><br>
		  <input type="submit" value="Submit">
	</form>
    </body>