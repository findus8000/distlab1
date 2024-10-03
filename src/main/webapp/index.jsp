<%@ page import="db.DBManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="static db.ProductDB.getAllProductsFromDB" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.Collection" %>
<%@ page import="bo.ProductHandler" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ui.ProductInfo" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<a href="login.jsp">Login</a>
<br/>
<a href="signup.jsp">Signup</a>
<br>
<a href="test-servlet">Hello Servlet</a>
<strong>${counter}</strong>
</body>
</html>