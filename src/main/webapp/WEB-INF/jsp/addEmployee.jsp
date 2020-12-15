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
    <title>Add Employee</title>
</head>
<script>
    function validateForm() {
        var x = document.forms["registration_form"]["firstName"].value;
        var y = document.forms["registration_form"]["lastName"].value;
        var z = document.forms["registration_form"]["departmentId"].value;
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
    }
</script>
<body>
<c:url value="/addEmployee" var="employee"/>
<form action="${employee}" name="registration_form" onsubmit="return validateForm()" method="POST">
    <label for="firstName">FirstName</label>
    <input type="text" name="firstName" id="firstName">
    <label for="lastName">LastName</label>
    <input type="text" name="lastName" id="lastName">
    <label for="Id">Department_Id</label>
    <input type="text" name="departmentId" id="Id">
    <input type="submit" value="Add Employee">
</form>
</body>
</html>
