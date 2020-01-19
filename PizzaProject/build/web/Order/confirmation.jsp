<%-- 
    Document   : confirmation
    Created on : Dec. 9, 2019, 2:00:34 p.m.
    Author     : ethan
--%>

<%@page import="java.time.LocalDateTime"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Received</title>
    </head>
    <body>
        <h1>Your Order has been received</h1>
        <div>
        <%
            //output confirmation to customer
            
            String time = request.getParameter("time");
            LocalDateTime dt = LocalDateTime.parse(time);
            
            out.print("Your order should be ready at: " + dt.getHour() + ":" + dt.getMinute());
            
            String orderId = request.getParameter("orderId");
            out.println("<br> Your order number is: " + orderId);
            %>
        </div>   
    </body>
</html>
