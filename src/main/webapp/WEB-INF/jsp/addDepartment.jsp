
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08.11.2020
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<head>
    <meta charset="ISO-8859-1">
</head>
<script>
    function validateForm() {
        var x = document.forms["registration_form"]["cityId"].value;
        var y = document.forms["registration_form"]["name"].value;
        if (x === "") {
            alert("City Id must be filled out");
            return false;
        }
        else if (y===""){
            alert("Department must be filled out");
            return false;
        }
    }
</script>
<body>
    <c:url value="/addDepartment" var="department"/>
<form action="${department}" name="registration_form" onsubmit="return validateForm()" method="POST">
    <table>
         <tr>
            <td>
                <label>City</label>
                <input type="text" name="cityId" >
            </td>
        </tr>
        <tr>
            <td>
                <label for="name">Department</label>
            <input type="text" name="name" id="name">
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Add Department"></td>
        </tr>
    </table>
  </form>
</body>
</html>
