/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeServlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ethan
 */
@WebServlet(name = "AdminOptions", urlPatterns = {"/AdminOptions"})
public class AdminOptions extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<style>");
            out.println("body{\n" +
"                text-align: center;\n" +
"                background-color: yellow;\n" +
"                background-image: url(\"Images/pizza.jpg\");\n" +
"            }\n" +
"            form, h1{\n" +
"                padding-left: 400px;\n" +
"                padding-right: 400px;\n" +
"                margin-left: 30px;\n" +
"                text-align: center;\n" +
"                width: 500px;\n" +
"                background-color: red;\n" +
"            }");
            out.println("</style>");
            out.println("<title>Admin Dashboard</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Admin Options</h1>");
            out.println("<form action='Admin/ManageToppings.jsp'>");
            out.println("<button id='toppings'>Manage Toppings</button><br><br>");
            out.println("</form>");
            out.println("<form action='Admin/ManageOrders.jsp'>"); //change this to what the manager order page is
            out.println("<button id='orders'>Manage Orders</button>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
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
