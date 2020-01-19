/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrderServlet;

import BusinessLayer.CrustTypes;
import BusinessLayer.Pizza;
import BusinessLayer.PizzaSizes;
import BusinessLayer.ToppingBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ethan
 */
@WebServlet(name = "CreatePizza_proc", urlPatterns = {"/CreatePizza_proc"})
public class CreatePizza_proc extends HttpServlet {

    @EJB
    private CrustTypes crustTypes;

    @EJB
    private PizzaSizes pizzaSizes;

    @EJB
    private ToppingBean toppingBean;

    @EJB
    private Pizza pizza;

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
            HttpSession session = request.getSession();
           
         
            
            //This block of code checks to see if session exist for pizza + count until returns a null session in which case
            //saves the new pizza to "Pizza" + count
            int count = 1;
            Pizza p = (Pizza)session.getAttribute("Pizza" + count);
           // out.println(p.getSizeId() + "should be the size id of p" + count + "<br>");
          //  out.println("Pizza" + count);
            while(p != null){
                count++;
                p = (Pizza)session.getAttribute("Pizza" + count);
            }
           // out.println(count);
           
           
            int size = Integer.parseInt(request.getParameter("sizes"));
            int crust = Integer.parseInt(request.getParameter("crust"));
            float num = 0;
            String[] toppings = request.getParameterValues("topping");
            //out.println(toppings);
            
               if(toppings != null){
                  for(String top : toppings){
                        num += toppingBean.fetchToppingPriceByName(top);
                    }
                   // out.println(num + " num<br>");
                    float price = pizzaSizes.GetPriceById(size);
                  //  out.println(price);
                    price += crustTypes.GetPriceById(crust);
                    out.println(price);
                    price += num;
                    Pizza pi = new Pizza();
                    pi.setSizeId(size);
                    pi.setIsFinished(0);
                    pi.setCrustTypeId(crust);
                    pi.setPrice(price);
                    //will need to add order id once order is complete

                    session.setAttribute("Pizza" + count, pi);
                    session.setAttribute("Topping" + count, toppings);
                    response.sendRedirect("Order/AdditionPizzas.jsp");
                }
               else{
                   //if no topping is selected then return error message
                    response.sendRedirect("Order/orderPage.jsp?msg=Please Select at least 1 topping");
               }
          
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
