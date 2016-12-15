<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
    <tr>
        <td>Name</td>
        <td>${cust.name}</td>
    </tr>
    <tr>
        <td>Address</td>
        <td>${cust.address}</td>
    </tr>
    <tr>
        <td>Phone number</td>
        <td>${cust.phno}</td>
    </tr>
    <tr>
        <td>email</td>
        <td>${cust.email}</td>
    </tr>
</table>  

</body>
</html>