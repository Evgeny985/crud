<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 06.11.2020
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<h2>Employee</h2>
<table>
    <tr>
        <th>ID</th>
        <th>FirstName</th>
        <th>LastName</th>
        <th>DEPARTMENT_ID</th>
        <th>ACTION</th>
    </tr>
    <c:forEach var="employee" items="${employeeFromServer}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.department.id}</td>
            <td>
                <a href="/updateEmployee/${employee.id}">update</a>
                <a href="/deleteEmployee/${employee.id}/${employee.department.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<c:url value="/addEmployee" var="addEmployee"/>
<a href="${addEmployee}">Add</a>
<c:url value="/" var="city"/>
<a href="${city}">Back to city</a>
</body>
</html>