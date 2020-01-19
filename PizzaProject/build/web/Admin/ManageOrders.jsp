<%-- 
    Document   : ManageOrders
    Created on : Dec. 8, 2019, 2:21:46 p.m.
    Author     : ethan
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BusinessLayer.OrderBackingBean"%>
<%@page import="BusinessLayer.Orders"%>
<%@page import="BusinessLayer.ToppingBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Active Pizza Orders</title>
        <%
          String message = request.getParameter("msg");
        
          if(message != null){
        out.println("<script>");
          out.println("alert('" + message + "');");  
        out.println("</script>");
          }
        %>
        
        <style>
            body{
                text-align: center;
                background-color: yellow;
                background-image: url("../Images/pizza.jpg");
            }
            form, h1, div{
                padding-left: 400px;
                padding-right: 400px;
                margin-left: 30px;
                text-align: center;
                width: 500px;
                background-color: white;
            }
           
        </style>
    </head>
    <body>
        <form method="get" action="../PizzaStatus">
            
            <u>Orders</u>
            
            <br>
            
            <%
                ArrayList<Orders> orderList = OrderBackingBean.listOfOrders();
                
                
                for(Orders o : orderList){
                    if(o.getOrderStatus().equals("pending")){
                      //  float i = o.getTotalPrice();
                        NumberFormat formatter = new DecimalFormat("###,###,###.##");
                        out.println("<input type='checkbox' name='order" + "' value='" + o.getOrderId() + "'>" + o.getCustomerName() + " $" + formatter.format(o.getTotalPrice()) + " Pending: Yes");
                        out.println("<br>");
                    } 
                }
               out.println("<input type='submit' value='Order Complete' />");
               out.println("</form>");
                out.println("<br>");
                out.println("<div><u>Order History</u><br>");
                for(Orders o : orderList){
                    if(o.getOrderStatus().equals("filled")){
                    
                     
                    out.println("Order number: " + o.getOrderId() + "    Price: " + o.getTotalPrice() + "      Completed at: " + o.getDeliveryDateTime());
                    out.println("<br>");
                    }
                }
                out.println("</div>");
            %>
            
        </form>
    </body>
</html>
