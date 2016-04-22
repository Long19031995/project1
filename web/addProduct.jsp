<%-- 
    Document   : addProduct
    Created on : Apr 12, 2016, 8:43:21 PM
    Author     : tutyb_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <h1>Product</h1>
        <br>You must enter all of these:
        <form action="productsManaging" method="post">
            <table style="width: 500px;">
                <tr>
                    <td align='left'>Product Code:</td>
                    <td align='left'><input type='text' name='productCode' id="productCode" />
                        <span id="productCodeFalse"></span></td>
                </tr>
                <tr>
                    <td align='left'>Product Description:</td>
                    <td align='left'><input type='text' name='productDescription' id="productDescription" />
                        <span id="productDescriptionFalse"></span></td>
                </tr>
                <tr>
                    <td align='left'>Product Price:</td>
                    <td align='left'><input type='text' name='productPrice' id="productPrice" />
                        <span id="productPriceFalse"></span></td>
                </tr>
            </table>
            <button type='submit' value='Add Product' id="submit">Add Product</button>
            <a href='productsManaging?action=displayProducts'><button type='button' value='View Products'>View Products</button></a>
        </form>
    </body>
</html>
