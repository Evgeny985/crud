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
    <title>Update Department</title>

</head>
<script>
    function validateForm() {
        var x = document.forms["registration_form"]["cityId"].value;
        var y = document.forms["registration_form"]["name"].value;
        if (x === "" ) {
            alert("All forms must be filled out");
            return false;
        } else if (y === "") {
            alert("All forms must be filled out");
            return false;
        }
    }
</script>
<body>
<c:url value="/updateDepartment" var="var"/>
<form action="${var}" name="registration_form" onsubmit="return validateForm()" method="POST">
    <input type="hidden" value="${department.id}" name="id">
    <label>City Id</label>
    <input type="text" name="cityId">
    <label for="name">Department</label>
    <input type="text" name="name" id="name">
    <input type="submit" value="Update">

</form>

</body>
</html>
