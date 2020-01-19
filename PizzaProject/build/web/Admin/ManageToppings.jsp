<%-- 
    Document   : ManageToppings
    Created on : Dec. 8, 2019, 12:36:14 p.m.
    Author     : ethan
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="BusinessLayer.ToppingBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Toppings</title>
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
        <form method="get" action="../toppingActivate">
            <u>Toppings</u><br>
            <%
               
                ArrayList<ToppingBean> toppingList = ToppingBean.FetchAllToppings();
                
                
                for(ToppingBean t : toppingList){
                    if(t.getActive() == 1){
                    out.println("<input type='checkbox' name='topping" + "' value='" + t.getId() + "'>" + t.getName() + " $" + t.getPrice() + " Active: Yes");
                    out.println("<br>");
                    }
                    else{
                    out.println("<input type='checkbox' name='topping" + "' value='" + t.getId() + "'>" + t.getName() + " $" + t.getPrice() + " Active: No");
                    out.println("<br>");
                    }
                }
            %>
            <input type="radio" name="active" checked value="active"/> Make Active
            <input type="radio" name="active" value="inactive"/> Make Inactive <br/>
          <input type="submit" value="Submit"/>
          
        </form>
            
            <br><br>
            
            <form method="get" action="../CreateNewTopping">
                <u>Create New Topping</u><br>
                Topping Name: <input type="text" id="txtToppingName" name="txtToppingName" required="true" value=""/><br/>
               Price: <input type="text" id="txtPrice" name="txtPrice" required="true" value=""/><br/>
               <input type="submit" value="Submit"/>
            </form>
            
    </body>
</html>
