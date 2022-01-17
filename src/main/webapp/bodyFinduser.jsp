<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="table-responsive">
  		<table class="table">
    		<thead>
			    <tr>
			      <th scope="col">Order_id </th>
			      <th scope="col">Product_id</th>
			      <th scope="col">Amount_product</th>
			      <th scope="col">Price_product</th>
			    </tr>
			  </thead>
			  
			  <tbody>
			 <c:forEach items="${sessionScope.userLoginOrderDetail}" var="list">
			    <tr>
			      <td>${list.getOrder_id()} </td>
			      <td>${list.getProduct_id()}</td>
			      <td>${list.getAmount_product()}</td>
			      <td>${list.getPrice_product()} ($)</td>
			    </tr>
			   </c:forEach>
			  </tbody>
			</table>
</div>
</body>
</html>