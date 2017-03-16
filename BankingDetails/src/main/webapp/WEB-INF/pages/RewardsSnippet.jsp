<%-- 
    Document   : RewardsSnippet
    Created on : Mar 16, 2017, 3:25:36 PM
    Author     : Foxy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rewards Snippet</title>
         <%
            String Rewards = "";
            String AccountType="";
            if(Integer.parseInt(request.getAttribute("Rewards").toString())<=100)
            {
                 Rewards=request.getAttribute("Rewards").toString();
                 AccountType="Bronze";
            }else if(Integer.parseInt(request.getAttribute("Rewards").toString())<=300)
            {
               Rewards=request.getAttribute("Rewards").toString();
               AccountType="Silver";
            }else if(Integer.parseInt(request.getAttribute("Rewards").toString())<=500)
            {
               Rewards=request.getAttribute("Rewards").toString();
               AccountType="Gold";
            }else if(Integer.parseInt(request.getAttribute("Rewards").toString())<=700)
            {
               Rewards=request.getAttribute("Rewards").toString();
               AccountType="Platinum";
            }else 
            {
               Rewards=request.getAttribute("Rewards").toString();
               AccountType="Diamond";
            }
            
        %>
    </head>
   <body style="background-color:gainsboro"> 
        <h3>
            Account Type : <%out.println(AccountType);%>
        </h3>
        <h3>
            <center>You have earned <%out.println(Rewards);%> Rewards so far...</center>   
        </h3>
        <marquee behavior="scroll" direction="left" scrollamount="2">Get 15 Reward points instantly for transactions more than $150...</marquee>
     </body>
</html>
