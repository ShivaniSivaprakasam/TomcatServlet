<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Success</title>
</head>
<body>
    <h3><%= request.getAttribute("user") %>, Login successful.</h3>
    <a href="login.html">Back to Login Page</a>
</body>
</html>