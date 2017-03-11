<%-- 
    Document   : WelcomePAge
    Created on : Mar 10, 2017, 9:00:48 PM
    Author     : Foxy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <%
            String UserName = request.getAttribute("Username").toString();
            String Password = request.getAttribute("Password").toString();       
        %>
        <h1>Welcome to FoxyCorp!</h1>
        <%
        out.println(UserName+"<br>");    
        out.println(Password+"<br>");    
        %>
    </body>
</html>
