<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<html>
<body>
	<h1>Customer registration</h1>
	<form:form method="POST" action="./customer.do" commandName="regcmd"> 		<table>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td><form:label path="address">Address</form:label></td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td><form:label path="phno">Phone number</form:label></td>
				<td><form:input path="phno" /></td>
			</tr>
			<tr>
				<td><form:label path="email">email</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="action" value="ADD" />
					</td>
			</tr>
		</table>
		<br>
		
	</form:form>
</body>
</html>
