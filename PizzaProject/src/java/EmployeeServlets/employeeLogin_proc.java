/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeServlets;

import DatabaseLayer.DatabaseBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ethan
 */
@WebServlet(name = "employeeLogin_proc", urlPatterns = {"/employeeLogin_proc"})
public class employeeLogin_proc extends HttpServlet {
    
    @EJB
    private DatabaseBean db;
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
           
            
            String userName = request.getParameter("username");
            out.println(userName);
            
            String password = request.getParameter("password");
            out.println(password);
            
            Connection conn = db.GetConnection();
            
            if(conn != null){
                out.println("connected");
                if(db.Login(userName, password)){
                    out.println("Successful password and username");
                    response.sendRedirect("AdminOptions");
                }
                else{
                    out.println("Incorrect Username or password");
                    response.sendRedirect("Admin/EmployeeLogin.jsp?msg=Incorrect Username or Password");
                }
            }
            else{
                out.println("not connected");
                out.println(conn);
            }
            
            //Resultset rs = 
            
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
