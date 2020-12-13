<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08.11.2020
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Employee</title>
</head>
<script>
    function validateForm() {
        var x = document.forms["registration_form"]["firstName"].value;
        var y = document.forms["registration_form"]["lastName"].value;
        var z = document.forms["registration_form"]["cityId"].value;
        var d = document.forms["registration_form"]["departmentId"].value;
        if (x === "" ) {
            alert("All forms must be filled out");
            return false;
        } else if (y === "") {
            alert("All forms must be filled out");
            return false;
        }
        else if (z === "") {
            alert("All forms must be filled out");
            return false;
        }
        else if (d === "") {
            alert("All forms must be filled out");
            return false;
        }
    }
</script>
<body>
<c:url value="/updateEmployee" var="var"/>
<form action="${var}" name="registration_form" onsubmit="return validateForm()" method="POST">
    <input type="hidden" value="${employee.id}" name="id">
    <label for="firstName">FirstName</label>
    <input type="text" name="firstName" id="firstName">
    <label for="lastName">LastName</label>
    <input type="text" name="lastName" id="lastName">
    <label>City Id</label>
    <input type="text" name="cityId">
    <label>Department Id</label>
    <input type="text" name="departmentId">
    <input type="submit" value="Update">

</form>
</body>
</html>
