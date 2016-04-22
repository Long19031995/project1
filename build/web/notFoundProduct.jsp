<%-- 
    Document   : notFoundProduct
    Created on : Apr 15, 2016, 2:30:27 PM
    Author     : tutyb_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <title>Not found</title>
    </head>
    <body>
        <h1>Not found product <%=(String) request.getAttribute("productCode")%>! </h1>
    </body>
</html>
