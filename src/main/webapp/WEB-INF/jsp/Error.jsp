<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18.11.2020
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <script>
        function Previous() {
            window.history.go(-1);
        }
    </script>
</head>
<body>
<h2>The City Id or Department Id DOESN'T EXIST? </h2>
<input type="button" value="Back" onclick="Previous()">
</body>
</html>
