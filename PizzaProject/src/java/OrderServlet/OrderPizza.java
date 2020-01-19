/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrderServlet;

import BusinessLayer.CrustTypes;
import BusinessLayer.OrderBackingBean;
import BusinessLayer.Orders;
import BusinessLayer.Pizza;
import BusinessLayer.PizzaBackingBean;
import BusinessLayer.PizzaSizes;
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

/**
 *
 * @author ethan
 */
@WebServlet(name = "OrderPizza", urlPatterns = {"/OrderPizza"})
public class OrderPizza extends HttpServlet {

    @EJB
    private ToppingMappingBackingBean tmbb;

    @EJB
    private ToppingMappingBean tmp;

    @EJB
    private PizzaBackingBean pizzaBacking;

    @EJB
    private Pizza p;

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
            out.println("<title>Servlet OrderPizza</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderPizza at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            int size = Integer.parseInt(request.getParameter("sizes"));
            int crust = Integer.parseInt(request.getParameter("crust"));
            float num = 0;
            String[] toppings = request.getParameterValues("topping");
            for(String top : toppings){
                num += ToppingBean.fetchToppingPriceByName(top);
            }
            //out.println(num + " num<br>");
            float price = PizzaSizes.GetPriceById(size);
            //out.println(price);
            price += CrustTypes.GetPriceById(crust); 
           
            price += num;
            //Check to see if you can get order values
            //out.println(price);
            //orders.setCustomerId(crust);
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime done = now.plusMinutes(45);
            out.println("after localdatetime <br>");
            int id = Integer.parseInt(request.getSession().getAttribute("custId").toString());
            out.println(id + " this should be my customer id <br>");
            o.setCustomerId(id);
            out.println(o.getCustomerId() + " this should be the id in orders <br>");
            o.setPlacedDateTime(now);
            o.setDeliveryDateTime(done);
            o.setOrderStatus("ordering");
            int orderId = ob.AddNewOrder(o);
            out.println("this should be my order id " + orderId + "<br>");
            //YOU NEED TO STORE ORDER IN SESSION SO FUTURE PIZZAS CAN USE THAT ID
            if(orderId > 0){
                p.setSizeId(size);
                p.setIsFinished(0);
                p.setCrustTypeId(crust);
                p.setPrice(price);
                p.setOrderId(orderId);
                
                int pizzaId = pizzaBacking.AddPizza(p);
                out.println("This is my pizza id " + pizzaId + "<br>");
                if(pizzaId != 0){
                    String toppingName;
                    int toppingId;
                    tmp.setPizzaId(pizzaId);
                    for(String top : toppings){
                         out.println(top + " this is the topping name <br>");
                      /*   toppingId = ToppingBean.fetchToppingIdByName(top);
                         out.println(toppingId + " topping id<br>");
                         tmp.setToppingId(toppingId);
                         out.println(tmp.getPizzaId() + " pizza id<br>");
                         out.println(tmp.getToppingId() + "topping id<br>");
                         out.println(tmbb.ToppingMap(tmp) + " is the topping map id<br>");*/
                         
                    }
                }
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
