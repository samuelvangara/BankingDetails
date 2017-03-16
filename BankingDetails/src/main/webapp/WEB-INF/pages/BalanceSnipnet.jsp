<%-- 
    Document   : BalanceSnipnet
    Created on : Mar 16, 2017, 3:50:35 AM
    Author     : Foxy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Balance Snipnet</title>
         <%
            String Balance = request.getAttribute("Balance").toString();   
        %>
    </head>
    <body>
        <h3>
            You Current Balance is :<%out.println(Balance);%> 
        </h3>
    </body>
</html>
