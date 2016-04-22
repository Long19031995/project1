/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import business.Product;
import data.ProductIO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tutyb_000
 */
@WebServlet(name = "ProductsManaging", urlPatterns = {"/productsManaging"})
public class ProductsManaging extends HttpServlet {

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
        String action = request.getParameter("action");
        if (action.equals("deleteConfirmed")) {
            deleteProduct(request, response);
        } else if (action.equals("showUpdateProduct")) {
            showUpdateProduct(request, response);
        } else if (action.equals("confirmDeleteProduct")) {
            confirmDeleteProduct(request, response);
        } else if (action.equals("deleteConfirmed")) {
            deleteProduct(request, response);
        } else {
            displayProducts(request, response);
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
        String productCode = request.getParameter("productCode");
        String productDescription = request.getParameter("productDescription");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));

//        System.out.println(productCode + " " + productDescription + " " + productPrice);
        Product product = new Product();
        product.setCode(productCode);
        product.setDescription(productDescription);
        product.setPrice(productPrice);

        request.setAttribute("product", product);

        if (ProductIO.exists(productCode, getServletContext().getRealPath("/") + "WEB-INF/products.txt")) {
            ProductIO.update(product, getServletContext().getRealPath("/") + "WEB-INF/products.txt");

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/successUpdateProduct.jsp");
            requestDispatcher.forward(request, response);
        } else {
            ProductIO.insert(product, getServletContext().getRealPath("/") + "WEB-INF/products.txt");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/successAddProduct.jsp");
            requestDispatcher.forward(request, response);
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

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Product product = ProductIO.getProduct(request.getParameter("productCode"), getServletContext().getRealPath("/") + "WEB-INF/products.txt");

        ProductIO.delete(product, getServletContext().getRealPath("/") + "WEB-INF/products.txt");

        request.setAttribute("productCode", request.getParameter("productCode"));

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/successDeleteProduct.jsp");
        dispatcher.forward(request, response);
    }

    private void displayProducts(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ArrayList<Product> products = ProductIO.getProducts(getServletContext().getRealPath("/") + "WEB-INF/products.txt");
        request.setAttribute("products", products);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/displayProducts.jsp");
        dispatcher.forward(request, response);
    }

    private void showUpdateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (ProductIO.exists(request.getParameter("productCode"), getServletContext().getRealPath("/") + "WEB-INF\\products.txt")) {

            Product product = ProductIO.getProduct(request.getParameter("productCode"), getServletContext().getRealPath("/") + "WEB-INF\\products.txt");
            request.setAttribute("product", product);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/showUpdateProduct.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("productCode", request.getParameter("productCode"));

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/notFoundProduct.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void confirmDeleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Product product = ProductIO.getProduct(request.getParameter("productCode"), getServletContext().getRealPath("/") + "WEB-INF\\products.txt");
        request.setAttribute("product", product);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/confirmDeleteProduct.jsp");
        dispatcher.forward(request, response);
    }

}
