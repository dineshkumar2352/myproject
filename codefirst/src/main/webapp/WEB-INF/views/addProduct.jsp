<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add product</title>
</head>
<body>
<h1>Add New Employee</h1>  
       <form:form method="post" action="./addProduct" commandName="prodcmd">    
        <table >    
         <tr>    
          <td>Product Name : </td>   
          <td><form:input path="ProductName"  /></td>  
         </tr>    
         <tr>    
          <td>Salary :</td>    
          <td><form:input path="description" /></td>  
         </tr>   
         <tr>    
          <td>Designation :</td>    
          <td><form:input path="price" /></td>  
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" name="action" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    
       <table border="1">
    <tr>
        <td>Product Name</td>
        <td>${prod.ProductName}</td>
    </tr>
    <tr>
        <td>Details </td>
        <td>${prod.description}</td>
    </tr>
    <tr>
        <td>Cost</td>
        <td>${prod.price}</td>
    </tr>
    
</table>  
       

</body>
</html>