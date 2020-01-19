/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrderServlet;

import BusinessLayer.OrderBackingBean;
import BusinessLayer.Orders;
import BusinessLayer.Pizza;
import BusinessLayer.PizzaBackingBean;
import BusinessLayer.ToppingBean;
import BusinessLayer.ToppingMappingBackingBean;
import BusinessLayer.ToppingMappingBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
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
@WebServlet(name = "confirmation_proc", urlPatterns = {"/confirmation_proc"})
public class confirmation_proc extends HttpServlet {

    @EJB
    private ToppingMappingBean tmb;

    @EJB
    private ToppingMappingBackingBean topMapBackBean;

    @EJB
    private ToppingBean toppingBean;

    @EJB
    private PizzaBackingBean pb;

    @EJB
    private Pizza pizza;

    @EJB
    private OrderBackingBean ob;

    @EJB
    private Orders o;

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
            out.println("<title>Servlet confirmation_proc</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet confirmation_proc at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            HttpSession session = request.getSession();
            
            //Create Order
            float cost = Float.parseFloat(session.getAttribute("TotalCost").toString());
            //out.println(cost);
            int minutes = Integer.parseInt(request.getParameter("time"));
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime expected = now.plusMinutes(minutes);
            int custId = Integer.parseInt(session.getAttribute("custId").toString());
            String orderStatus = "pending";
            o.setTotalPrice(cost);
            o.setDeliveryDateTime(expected);
            o.setPlacedDateTime(now);
            o.setCustomerId(custId);
            o.setOrderStatus(orderStatus);
            //new order id
            int orderId = ob.AddNewOrder(o);
            out.println(orderId + " is the orderid");
            
            //loops through all the pizzas stored in session and creates entries to database
            if(orderId != 0){
                int count = 1;
                Pizza p = (Pizza)session.getAttribute("Pizza" + count);
                while(p != null){
                    out.println("Pizza " + count);
                    pizza.setSizeId(p.getSizeId());
                    pizza.setIsFinished(p.getIsFinished());
                    pizza.setCrustTypeId(p.getCrustTypeId());
                    pizza.setPrice(p.getPrice());
                    pizza.setOrderId(orderId);
                    pizza.setQuantity(p.getQuantity());
                    int pizzaId = pb.AddPizza(pizza);
                    
                    if(pizzaId != 0){
                        //loops through all the toppings stored in session for where the count makes pizza makes db entries
                        String[] toppings = (String[])session.getAttribute("Topping" + count);
                        for(String top : toppings){
                            int toppingId = toppingBean.fetchToppingIdByName(top);
                            tmb.setToppingId(toppingId);
                            tmb.setPizzaId(pizzaId);
                            int topMapId = topMapBackBean.ToppingMap(tmb);
                            out.println(topMapId + " topping map id");
                        }
                    }
                    
                    count++;
                    p = (Pizza)session.getAttribute("Pizza" + count);
                }
                response.sendRedirect("Order/confirmation.jsp?time=" + o.getDeliveryDateTime() + "&orderId=" + orderId);
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
