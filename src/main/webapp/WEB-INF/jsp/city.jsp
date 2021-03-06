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
<h2>City</h2>
<table>
    <tr>
        <th>ID</th>
        <th>CITY</th>
        <th>ACTION</th>
    </tr>
    <c:forEach var="city" items="${cityFromServer}">
        <tr>
            <td>${city.id}</td>
            <td>
                <c:url value="/department/${city.id}" var="department"/>
                <a href="/department/${city.id}">${city.name}</a>
            </td>
            <td>
                <a href="/updateCity/${city.id}">update</a>
                <a href="/deleteCity/${city.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<c:url value="/addCity" var="addCity"/>
<a href="${addCity}">Add</a>
</body>
</html>