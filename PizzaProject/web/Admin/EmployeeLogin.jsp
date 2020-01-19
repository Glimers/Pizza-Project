<%-- 
    Document   : EmployeeLogin
    Created on : Nov. 22, 2019, 10:11:49 a.m.
    Author     : ethan
--%>

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
            form, h1{
                padding-left: 400px;
                padding-right: 400px;
                margin-left: 30px;
                text-align: center;
                width: 500px;
                background-color: white;
            }
           
        </style>
        <%
          String message = request.getParameter("msg");
        
          if(message != null){
        out.println("<script>");
          out.println("alert('" + message + "');");  
        out.println("</script>");
          }
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employees Only</title>
    </head>
    <body>
        <div id="background">
        <h1>Pizza Co. Manager Login</h1>
        
        <form action="../employeeLogin_proc" method="GET">
            <label>Username:</label>
            <input type="text" name="username" required /> <br>
            <label>Password:</label>
            <input type="password" name="password" required /> <br>
            <input type="submit" id="btnSubmit" value="Submit" />
        </form>
        </div>
    </body>
</html>
