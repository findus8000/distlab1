<%--
  Created by IntelliJ IDEA.
  User: Decki
  Date: 2024-10-03
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Signup Page</title>
</head>
<body>
<h1>Create an Account</h1>

<!-- Display the error message if it exists in the request -->
<c:if test="${not empty requestScope.errorMessage}">
    <div style="color: red;">${requestScope.errorMessage}</div>
</c:if>

<form action="register" method="POST">
    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName" required><br><br>

    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName" required><br><br>

    <label for="email">Email:</label>
    <input type="text" id="email" name="email" required><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>

    <input type="submit" value="Create Account">
</form>
<br>
<a href="login.jsp">Already have an account? Login here.</a>
</body>
</html>
