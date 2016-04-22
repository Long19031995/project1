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
@WebServlet(name = "DeleteProduct", urlPatterns = {"/deleteProduct"})
public class DeleteProduct extends HttpServlet {

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
            out.println("<title>Servlet DeleteProduct</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteProduct at " + request.getContextPath() + "</h1>");
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeleteProduct</title>");
            out.println("</head>");
            out.println("<body>");
            if (CheckException.checkProductCode(product.getCode(), getServletContext().getRealPath("/") + "WEB-INF/products.txt")) {
                out.println("<h1>This product does not exist!</h1>");
                out.println("<a href='displayProducts'>View Products</a>");
                out.println("</body>");
                out.println("</html>");
                return;
            }
            out.println("<h1>Are you sure you want to delete this product?</h1>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td align='right'>Product Code:</td>");
            out.println("<td align='left'>" + product.getCode() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td align='right'>Product Description:</td>");
            out.println("<td align='left'>" + product.getDescription() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td align='right'>Product Price:</td>");
            out.println("<td align='left'>" + product.getPrice() + "</td>");
            out.println("</tr>");
            out.println("</table><br>");
            out.println("<form action='deleteProduct' method='post'>");
            out.println("<input type='hidden' name='productCode' value='" + product.getCode() + "'/>");
            out.println("<input type='submit' value='Yes'/>");
            out.println("<a href='displayProducts'><input type='button' value='No'/></a>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
        Product product = ProductIO.getProduct(request.getParameter("productCode"), getServletContext().getRealPath("/") + "WEB-INF/products.txt");

        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeleteProduct</title>");
            out.println("</head>");
            out.println("<body>");
            if (CheckException.checkProductCode(product.getCode(), getServletContext().getRealPath("/") + "WEB-INF/products.txt")) {
                out.println("<h1>This product does not exist!</h1>");
                out.println("<a href='displayProducts'>View Products</a>");
                out.println("</body>");
                out.println("</html>");
                return;
            }

            ProductIO.delete(product, getServletContext().getRealPath("/") + "WEB-INF/products.txt");

            out.println("<h1>This product has been deleted!</h1>");
            out.println("<a href='displayProducts'>View Products</a>");

            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
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
