<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bookList.css" />
<title>List of Products</title>
</head>
<body>
	<div class="survey-page">
        <h1 id="title">Black Books</h1>
        <div id="form-container">
        <h2>
        	<a href="book?action=new">Add New Book</a>
        	
        </h2>
        <table cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="product" items="${listBook}">
                <tr>
                    <td><c:out value="${book.id}" /></td>
                    <td><c:out value="${book.title}" /></td>
                    <td><c:out value="${book.description}" /></td>
                    <td><c:out value="${book.price}" /></td>
                    <td>
                    	<a href="book?action=edit&id=<c:out value='${book.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="book?action=delete&id=<c:out value='${book.id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
        </div>
    </div>	
</body>
</html>