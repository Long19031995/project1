<%-- 
    Document   : updateProduct
    Created on : Apr 14, 2016, 1:05:05 PM
    Author     : tutyb_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="business.Product"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <script src="js/jquery-2.1.4.min.js"></script>
        <script src="js/checkInfo.js"></script>
        
    </head>
    <body>
        <%
            Product product = (Product) request.getAttribute("product");
        %>
        <h1>Product</h1>
        <br>You must enter a description for the product.
        <form method='post' action='productsManaging'>
            <br><table style="width: 500px">
                <tr>
                    <td align='left'>Product Code:</td>
                    <td align='left'><input type='text' value='<%=product.getCode()%>' name='productCode' id="productCode"/></td>
                </tr>
                <tr>
                    <td align='left'>Product Description:</td>
                    <td align='left'><input type='text' value='<%=product.getDescription()%>' name='productDescription' id="productDescription"/>
                        <span id="productDescriptionFalse"></span></td>
                </tr>
                <tr>
                    <td align='left'>Product Price:</td>
                    <td align='left'><input type='text' value='<%=product.getPrice()%>' name='productPrice' id="productPrice"/>
                        <span id="productPriceFalse"></span></td>
                </tr>
            </table><br>
            <input type='submit' value='Update Product' id="submit"/>
            <a href='productsManaging?action=displayProducts'><input type='button' value='View Products'/></a>
        </form>
    </body>
</html>
