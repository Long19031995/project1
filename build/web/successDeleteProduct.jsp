<%-- 
    Document   : deleteProduct
    Created on : Apr 14, 2016, 1:55:53 PM
    Author     : tutyb_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link rel="stylesheet" type="text/css" href="css/style.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String productCode = (String) request.getAttribute("productCode");
        %>
        <h1>Product <%=productCode%> has been deleted</h1>
        <a href='productsManaging?action=displayProducts'><button type='button' value='View Products'>View Products</button></a>
    </body>
</html>
