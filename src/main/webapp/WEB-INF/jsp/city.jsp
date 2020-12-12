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
        <th>Id</th>
        <th>City</th>
        <th>action</th>
    </tr>
    <c:forEach var="city" items="${cityFromServer}">
        <tr>
            <td>${city.id}</td>
            <td>
                <c:url value="/department" var="department"/>
                <a href="/department/${city.id}">${city.name}</a>
            </td>
            <td>
                <a href="/${city.id}/edit">update</a>
                <a href="/city/${city.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<c:url value="/city/new" var="city"/>
<a href="${city}">Add city</a>
</body>
</html>