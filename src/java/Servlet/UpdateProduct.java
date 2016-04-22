/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Check.CheckException;
import business.Product;
import data.ProductIO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tutyb_000
 */
@WebServlet(name = "UpdateProduct", urlPatterns = {"/updateProduct"})
public class UpdateProduct extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateProduct</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateProduct at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Product product = ProductIO.getProduct(request.getParameter("productCode"), getServletContext().getRealPath("/") + "WEB-INF/products.txt");

        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateProduct</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Product</h1>");
            out.println("<br>You must enter a description for the product.");
            out.println("<form method='post' action='updateProduct'>");
            out.println("<br><table>");
            out.println("<tr>");
            out.println("<td align='right'>Product Code:</td>");
            out.println("<td align='left'><input type='text' value='" + product.getCode() + "' name='productCode'/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td align='right'>Product Description:</td>");
            out.println("<td align='left'><input type='text' value='" + product.getDescription() + "' name='productDescription'/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td align='right'>Product Price:</td>");
            out.println("<td align='left'><input type='text' value='" + product.getPrice() + "' name='productPrice'/></td>");
            out.println("</tr>");
            out.println("</table><br>");
            out.println("<input type='submit' value='Update Product'/>");
            out.println("<a href='displayProducts'><input type='button' value='View Products'/></a>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet UpdateProduct</title>");
        out.println("</head>");
        out.println("<body>");

        if (CheckException.checkProductCode(request.getParameter("productCode"), getServletContext().getRealPath("/") + "WEB-INF/products.txt")) {
            out.println("<h1>This Product Code is not exists!</h1>");
            out.println("<a href='displayProducts'>View Products</a>");
            out.println("</body>");
            out.println("</html>");
            return;
        }

        if (!CheckException.checkProductDescription(request.getParameter("productDescription"))) {
            out.println("<h1>Description can not be empty</h1>");
            out.println("<a href='displayProducts'>View Products</a>");
            out.println("</body>");
            out.println("</html>");
            return;
        }

        if (!CheckException.checkProductPrice1(request.getParameter("productPrice"))) {
            out.println("<h1>Price can not be empty</h1>");
            out.println("<a href='displayProducts'>View Products</a>");
            out.println("</body>");
            out.println("</html>");
            return;
        }

        if (!CheckException.checkProductPrice2(request.getParameter("productPrice"))) {
            out.println("<h1>Price must be a number</h1>");
            out.println("<a href='displayProducts'>View Products</a>");
            out.println("</body>");
            out.println("</html>");
            return;
        }

        String productCode = request.getParameter("productCode");
        String productDescription = request.getParameter("productDescription");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));

        System.out.println(productCode + " " + productDescription + " " + productPrice);

        Product product = new Product();
        product.setCode(productCode);
        product.setDescription(productDescription);
        product.setPrice(productPrice);

        ProductIO.update(product, getServletContext().getRealPath("/") + "WEB-INF/products.txt");

        out.println("<h1>Product has been updated!</h1>");
        out.println("<a href='displayProducts'>View Products</a>");
        out.println("</body>");
        out.println("</html>");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
