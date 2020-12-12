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
<h2>Department</h2>

    <table>
    <tr>
        <th>ID </th>
        <th>Department </th>
        <th>CITY_ID   </th>
        <th>action</th>
    </tr>
    <c:forEach var="department" items="${departmentFromServer}">
        <tr>
            <td>
                    ${department.id}
            </td>

            <td>
                <c:url value="/employee/${department.id}" var="employee"/>
                <a href="/employee/${department.id}">${department.name}</a>
            </td>
            <td>${department.city.id}</td>

            <td>
                <a href="/updateDepartment/${department.id}">update</a>
                <a href="/deleteDepartment/${department.id}" >delete</a>
            </td>
        </tr>

    </c:forEach>
    </table>

    <c:url value="/addDepartment" var="addDepartment"/>
    <a href="${addDepartment}">Add Department</a>
<c:url value="/" var="city"/>
<a href="${city}">Back</a>

</body>
</html>