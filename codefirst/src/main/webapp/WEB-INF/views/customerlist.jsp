<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<h3>Persons List</h3>
<c:if test="${!empty custList}">
	<table>
	<tr>
		<th width="80">customer ID</th>
		<th width="120"> Name</th>
		<th width="120">address</th>
		<th width="60">phone number</th>
		<th width="60">email</th>
	</tr>
	<c:forEach items="${custList}" var="customer">
		<tr>
			<td>${customer.custID}</td>
			<td>${customer.name}</td>
			<td>${customer.address}</td>
			<td>${customer.phno}</td>
			<td>${customer.email}</td>
			
		</tr>
	</c:forEach>
	</table>
</c:if>
