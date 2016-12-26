<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Product List</h3>
<c:if test="${!empty listProduct}">
	<table border="1">
	<tr>
		<th width="80">Product ID</th>
		<th width="120">Product Name</th>
		<th width="120">Product details</th>
		<th width="60">Product price</th>
	</tr>
	<c:forEach items="${listProduct}" var="customer">
		<tr>
			<td>${product.productID}</td>
			<td>${product.ProductName}</td>
			<td>${product.description}</td>
			<td>${product.price}</td>
			
		</tr>
	</c:forEach>
	</table>
</c:if>


</body>
</html>