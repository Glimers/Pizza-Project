<%-- 
    Document   : AdditionPizzas
    Created on : Dec. 8, 2019, 2:57:27 p.m.
    Author     : ethan
--%>

<%@page import="BusinessLayer.CrustTypes"%>
<%@page import="BusinessLayer.PizzaSizes"%>
<%@page import="BusinessLayer.Pizza"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Order</title>
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
        <h1> Your Order </h1>
        <form method="get" action="processOrder.jsp">
        <%
            float cost = 0;
            int count = 1;
            Pizza p = (Pizza)session.getAttribute("Pizza" + count);
            while(p != null){
            out.println("Pizza " + count);
            
            
            String[] toppings = (String[])session.getAttribute("Topping" + count);
            
            out.println(PizzaSizes.GetNameById(p.getSizeId()) + "<br>");
            out.println(CrustTypes.GetNameById(p.getCrustTypeId()) + "<br>");
            out.println("Price: " + p.getPrice() + "<br>");
            out.println("Toppings:<br>" );
            for(String top : toppings){
                out.println(top + "<br>");
            }
        
       out.println("Please Select Quantity of this pizza");
     /*  out.println("<input type='text' name='Pizza" + count + "' list='quant'>");
       out.println("<datalist id='quant'>");
       out.println("<option value='1'>");
       out.println("<option value='2'>");
       out.println("</datalist>");*/
       
        //let customer pick 1-5 pizzas per pizza
       out.println(" <select name='Pizza" + count + "' id='Pizza" + count + "'>");
          out.println("<option value='1'>1</option>");
            out.println("<option value='2'>2</option>");
            out.println("<option value='3'>3</option>");
            out.println("<option value='4'>4</option>");
            out.println("<option value='5'>5</option>");
        out.println("</select><br/><br/>");
        cost += p.getPrice();
        count++;
         p = (Pizza)session.getAttribute("Pizza" + count);
         }
            
      /*  cost *= 1.15;
        out.println("Your Order Total: " + cost);*/
      
//Add addition pizza link allows user to add another pizza to session
        %>
        <br/>
        <a href="orderPage.jsp?pizza=1"> Add Addition Pizza </a>
        
        <br><br>
        <input type="submit" value="Submit Order"/>
        </form>
        
    </body>
</html>
