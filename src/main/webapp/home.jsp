<%@ page import="ui.ProductInfo" %>
<%@ page import="bo.ProductHandler" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="ui.CustomerInfo" %>
<%@ page import="bo.CustomerHandler" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Decki
  Date: 2024-10-03
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Catalog page</title>
</head>
<body>
    <p>Hello, ${sessionScope.email}!</p>
    <h1>Products:<br> </h1>

    <div style="text-align: right">Cart:<br>

        <%
        HashMap<String, Integer> map = (HashMap<String, Integer>) session.getAttribute("cart");
        if (map != null){
            for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                %>
            <span style="display:inline-block;">
                <%= key + " : "%>  <%= value %>
                <form action="removeFromCart" method="POST" style="display:inline;">
                    <button type="submit" name="action" value=<%= key %>>-</button>
                </form>
            </span><br>
            <%
            }
            }else {
            %>
            Empty cart.
        <% } %>

    </div>
        <%
            Collection<ProductInfo> a = ProductHandler.getAllProducts();
            for(Iterator i = a.iterator(); i.hasNext();){
                ProductInfo p =(ProductInfo) i.next();%>
        <%= p.getProductName() %> -
        <%= p.getPrice() %>kr

        <form action="submitBuy" method="POST">
            <button type="submit" name="action" value=<%= p.getProductName() %>>Add to cart</button>
        </form>
        <br>
        <%     }%>

    <c:if test="${not empty requestScope.errorMessage}">
        <div style="color: red;">${requestScope.errorMessage}</div>
    </c:if>
    <a href="logout">Logout</a>
</body>
</html>
