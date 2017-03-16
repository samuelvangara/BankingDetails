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
        <title>Balance Snippet</title>
         <%
            String Balance = "";
            String ID="";
                 Balance=request.getAttribute("Balance").toString();
                 ID=request.getAttribute("ID").toString();
        %>
    </head>
    <body style="background-color:gainsboro"> 
        <h3>
            Account Number : <%out.println(ID);%>
        </h3>
        <h3>
            <center>Your Current Credit is : $<%out.println(Balance);%></center>   
        </h3>
        <marquee behavior="scroll" direction="left">Click on the balance tab to know more...</marquee>
     </body>
   </html>
