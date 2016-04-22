<%-- 
    Document   : displayProducts
    Created on : Apr 12, 2016, 4:27:59 PM
    Author     : tutyb_000
--%>

<%@page import="java.util.ArrayList"%>
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
        <h1>Products</h1>
        <table>
            <thead>
                <tr>
                    <td align='center'><b>Code</b></td>
                    <td align='center'><b>Description</b></td>
                    <td align='center'><b>Price</b></td>
                    <td colspan='2'></td>
                </tr>
            </thead>
            <%
                for (Product p : (ArrayList<Product>) request.getAttribute("products")) {
            %>
            <tbody>
                <tr>
                    <td><%=p.getCode()%></td>
                    <td><%=p.getDescription()%></td>
                    <td><%=p.getPrice()%></td>
                    <td> <a href ='productsManaging?action=showUpdateProduct&productCode=<%=p.getCode()%>'>Edit</a > </td>
                    <td> <a href ='productsManaging?action=confirmDeleteProduct&productCode=<%=p.getCode()%>'>Delete</a ></td>
                </tr>
            </tbody>
            <%
                }
            %>
        </table>
        <br><a href='addProduct.jsp'><button type='button' value='Add Product'>Add Product</button></a>
    </body>
</html>
