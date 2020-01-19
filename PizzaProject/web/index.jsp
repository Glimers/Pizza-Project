<%-- 
    Document   : index
    Created on : Dec. 2, 2019, 8:05:53 a.m.
    Author     : ethan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Pizza Ordering</title>
        <style>
            body{
                text-align: center;
                background-color: yellow;
                background-image: url("Images/pizza.jpg");
            }
            form, h1{
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
        <h1>Welcome to Pizza Ordering</h1>
        <form action="Order/CustomerInfo.xhtml" method="get">
            <button name="order" type="submit">Order Pizza</button>
            <br><br><br>
        </form>
        <form action="Admin/EmployeeLogin.jsp">
            <button type="submit">Employee Login</button>
        </form>
        <%
            session.setAttribute("custId", 0);
            //creating a session variable now, this will allow code to not overwrite customer id on later page
            %>
    </body>
</html>
