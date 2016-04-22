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
@WebServlet(name = "AddProduct", urlPatterns = {"/addProduct"})
public class AddProduct extends HttpServlet {

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
        processRequest(request, response);
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
//        processRequest(request, response);
        String productCode = request.getParameter("productCode");
        String productDescription = request.getParameter("productDescription");
        String productPrice = request.getParameter("productPrice");
        PrintWriter out = response.getWriter();

//        System.out.println(productCode + " " + productDescription + " " + productPrice);
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet AddProduct</title>");
        out.println("</head>");
        out.println("<body>");

        if (!CheckException.checkProductCode(productCode)) {
            out.println("<h1>Product Code can not be empty!</h1>");
            out.println("<br><a href='displayProducts'>Return to Display Page</a>");
            out.println("</body>");
            out.println("</html>");
            return;
        }
        
        System.out.println(getServletContext().getRealPath("/"));

        if (!CheckException.checkProductCode(productCode, getServletContext().getRealPath("/") + "WEB-INF/products.txt")) {
            out.println("<h1>This Product Code still exists!</h1>");
            out.println("<br><a href='displayProducts'>Return to Display Page</a>");
            out.println("</body>");
            out.println("</html>");
            return;
        }

        if (!CheckException.checkProductDescription(productDescription)) {
            out.println("<h1>Product Description can not be empty!</h1>");
            out.println("<br><a href='displayProducts'>Return to Display Page</a>");
            out.println("</body>");
            out.println("</html>");
            return;
        }

        if (!CheckException.checkProductPrice1(productPrice)) {
            out.println("<h1>Product Price can not be empty!</h1>");
            out.println("<br><a href='displayProducts'>Return to Display Page</a>");
            out.println("</body>");
            out.println("</html>");
            return;
        }

        if (!CheckException.checkProductPrice2(productPrice)) {
            out.println("<h1>Product Price must be a number!</h1>");
            out.println("<br><a href='displayProducts'>Return to Display Page</a>");
            out.println("</body>");
            out.println("</html>");
            return;
        }

        Product product = new Product();
        product.setCode(productCode);
        product.setDescription(productDescription);
        product.setPrice(Double.parseDouble(productPrice));

        ProductIO.insert(product, getServletContext().getRealPath("/") + "WEB-INF/products.txt");

        out.println("<h1>Product has been added!</h1>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<td align='right'>Product Code:</td>");
        out.println("<td align='left'>" + productCode + "</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td align='right'>Product Description:</td>");
        out.println("<td align='left'>" + productDescription + "</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td align='right'>Product Price:</td>");
        out.println("<td align='left'>" + productPrice + "</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("<br><a href='displayProducts'>Return to Display Page</a>");

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
