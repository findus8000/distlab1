<%@ page import="ui.ProductInfo" %>
<%@ page import="bo.ProductHandler" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="ui.CustomerInfo" %>
<%@ page import="bo.CustomerHandler" %><%--
  Created by IntelliJ IDEA.
  User: Decki
  Date: 2024-10-03
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
    <p>Hello, ${sessionScope.email}!</p>
    <h1>
        PRODUCTS:<br>
        <%
            Collection<ProductInfo> a = ProductHandler.getAllProducts();
            for(Iterator i = a.iterator(); i.hasNext();){
                ProductInfo p =(ProductInfo) i.next();%>
        <%= p.getProductName() %> :
        <%= p.getPrice() %> <br>
        <%     }%>
    </h1>

</head>
<body>

</body>
</html>
