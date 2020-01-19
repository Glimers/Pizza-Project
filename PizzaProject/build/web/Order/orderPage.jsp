<%-- 
    Document   : orderPage
    Created on : Dec. 2, 2019, 6:32:52 p.m.
    Author     : ethan
--%>

<%@page import="BusinessLayer.ToppingBean"%>
<%@page import="BusinessLayer.CrustTypes"%>
<%@page import="BusinessLayer.PizzaSizes"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Your Pizza</title>
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
        <h1>Create Your Pizza</h1>
        <% 
     /* check to see if customer id exist if does then leave it alone if not then change customer id to cust id */  
        int id = Integer.parseInt(session.getAttribute("custId").toString());
        
            if(id == 0){
                id = Integer.parseInt(request.getParameter("custId"));
                session.setAttribute("custId", id);
            }
       
        %>
        
        <%
            //return any error message
          String message = request.getParameter("msg");
        
          if(message != null){
        out.println("<script>");
          out.println("alert('" + message + "');");  
        out.println("</script>");
          }
        %>
        <form method="get" action="../CreatePizza_proc">
            Select Your Size<br>
            
            <%
                
                
                ArrayList<PizzaSizes> sizeList = PizzaSizes.ListOfSizes();
                for(PizzaSizes p : sizeList){
                    out.println("<input type='radio' name='sizes' checked value='" + p.getSizeId() + "'>" + p.getName() +  " $" + p.getPrice() +"<br>");
                }
                
                out.println("<br> Select Your Crust Type <br>");
                
                ArrayList<CrustTypes> crustList = CrustTypes.GetCrustList();
                for(CrustTypes c : crustList){
                    out.println("<input type='radio' checked name='crust' value='" + c.getCrustId() + "'>" + c.getName() + " $" + c.getPrice()  +"<br>");
                }
                
                out.println("<br> Select Your Toppings <br>");
                ArrayList<ToppingBean> toppingList = ToppingBean.FetchActiveToppings();
                //int i = 0;
                for(ToppingBean t : toppingList){
                    if(t.getActive() == 1){
                    out.println("<input type='checkbox' name='topping" + "' value='" + t.getName() + "'>" + t.getName() + " $" + t.getPrice());
                    out.println("<br>");
                    //i++;
                    }
                }
                
               out.println("<input type='submit' value='Place Order'>");
            %>
        </form>
    </body>
</html>
