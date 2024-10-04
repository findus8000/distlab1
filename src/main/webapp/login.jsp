<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login Page</title>
</head>
<body>
<h1>Login to Your Account</h1>

<c:if test="${not empty requestScope.errorMessage}">
  <div style="color: red;">${requestScope.errorMessage}</div>
</c:if>

<form action="login-servlet" method="POST">
  <label for="email">Email:</label>
  <input type="text" id="email" name="email" required><br><br>

  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required><br><br>

  <input type="submit" value="Login">
</form>
<br>
<a href="signup.jsp">Create an account</a>

</body>
</html>