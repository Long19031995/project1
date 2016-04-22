<%-- 
    Document   : successAddProduct
    Created on : Apr 14, 2016, 10:19:59 PM
    Author     : tutyb_000
--%>

<%@page import="business.Product"%>
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
            Product product = (Product) request.getAttribute("product");
        %>
        <h1>Product has been added</h1>
        <br>
        <table>
            <tr>
                <td align='right'>Product Code:</td>
                <td align='left'><input type='text' value='<%=product.getCode()%>' name='productCode' disabled/></td>
            </tr>
            <tr>
                <td align='right'>Product Description:</td>
                <td align='left'><input type='text' value='<%=product.getDescription()%>' name='productDescription' disabled/></td>
            </tr>
            <tr>
                <td align='right'>Product Price:</td>
                <td align='left'><input type='text' value='<%=product.getPrice()%>' name='productPrice' disabled/></td>
            </tr>
        </table>
        <br>
        <a href='productsManaging?action=displayProducts'><input type='button' value='View Products'/></a>
    </body>
</html>
