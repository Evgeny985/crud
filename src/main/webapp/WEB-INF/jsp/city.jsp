<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 06.11.2020
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <c:forEach var="city" items="${CityFromServer}">
        <tr>
            <td>${city.id}</td>
       <td>
           <c:url value="/department" var="department"/>
           <a href="${pageContext.request.contextPath}/department?id=${city.id}">${city.name}</a>
       </td>
            <td>
                <a href="/updateCity/${city.id}">update</a>
                <a href="/deleteCity/${city.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
    </table>


    <c:url value="/addCity" var="addCity"/>
    <a href="${addCity}">Add City</a>


</body>
</html>