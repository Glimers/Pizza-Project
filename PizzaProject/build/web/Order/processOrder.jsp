<%-- 
    Document   : processOrder
    Created on : Dec. 9, 2019, 11:08:00 a.m.
    Author     : ethan
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="BusinessLayer.CustomerBackingBean"%>
<%@page import="BusinessLayer.Pizza"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment</title>
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
        <h1>Please confirm your order</h1>
        <%
            NumberFormat formatter = new DecimalFormat("###,###,###.##");
           out.println("<div>");
            float cost = 0;
            int count = 1;
            Pizza p = (Pizza)session.getAttribute("Pizza" + count);
            while(p != null){
                //out.println("Pizza " + count);
                
                int pizzaQuant = Integer.parseInt(request.getParameter("Pizza" + count));
                //out.println(pizzaQuant + "pizza quant<br>");
                p.setQuantity(pizzaQuant);
                //out.println("this should be the new quantity set in object " + p.getQuantity());
                session.setAttribute("Pizza" + count, p);
                cost += p.getPrice() * pizzaQuant;
                
                count++;
                p = (Pizza)session.getAttribute("Pizza" + count);
            }
            out.println("Cost of Pizzas: $" + formatter.format(cost));
            float tax = cost * (float)0.15;
            float total = cost + tax;
            out.println("<br>Tax of Pizza: $" + formatter.format(tax));
            out.println("<br> Grand Total: $" + formatter.format(total) + "<br>");
            session.setAttribute("TotalCost", total);
            int custId = Integer.parseInt(session.getAttribute("custId").toString());
            //out.println(custId);
            int delivery = CustomerBackingBean.GetCustomerById(custId);
            out.println("</div>");
            if(delivery == 0){
               // out.println("this should be a pickup order will need to ask what time they are picking up");
                out.println("<form method='get' action='../confirmation_proc?price='" + total + "'>");
               
                out.println("How long to wait for order");
                 out.println(" <select name='time' id='time'>");
                    out.println("<option value='30'>30 Minutes</option>");
                    out.println("<option value='60'>1 hour</option>");
                    out.println("<option value='90'>1 hour and 30 minutes</option>");
                    out.println("<option value='120'>2 hours</option>");
                    out.println("<option value='150'>2 hours and 30 minutes</option>");
                    out.println("<option value='180'>3 hours</option>"); 
                 out.println("</select><br/><br/>");
                 
                 out.println("To Pay Online Click here <a href='http://www.paypal.com'>PayPal Pay Now</a>");
                 out.println("<input type='submit' value='Confirm Order'/>");
                 
                out.println("</form>");
                 
            }
            else{
                //out.println("just credit card info and create a 30 minute addition time");
                // out.println("this should be a pickup order will need to ask what time they are picking up");
                 out.println("<form method='get' action='../confirmation_proc'><br>");
                 out.println("Your order will be ready in 30 minutes after you recieve your order number <br>");
                 out.println("To Pay Online Click here <a href='www.paypal.com'>PayPal Pay Now</a><br>");
                 out.println("Otherwise payment will be recieved at the door<br>");
                 out.println("<input type='hidden' name='time' value='30' id='time'/>");
                 out.println("<input type='submit' value='Confirm Order'/>");
                 out.println("</form>");
            }
            
        %>
    </body>
</html>
