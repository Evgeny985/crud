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

    <title>Update</title>

</head>
<script>
    function validateForm() {
        var x = document.forms["registration_form"]["name"].value;
        if (x === "") {
            alert("Name must be filled out");
            return false;
        }
    }
</script>
<body>
<c:url value="/updateCity" var="var"/>
<form action="${var}" name="registration_form" onsubmit="return validateForm()" method="POST">
    <input type="hidden" value="${city.id}" name="id">
    <label for="name">City</label>
    <input type="text" name="name" id="name">
    <input type="submit" value="Update">
</form>
</body>
</html>
