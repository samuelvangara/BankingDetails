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
        <title>Home</title>
        <%
            String UserName = request.getAttribute("Username").toString();
            String Password = request.getAttribute("Password").toString();       
        %>
        <h3 align="left">Hello!<%out.print(UserName);%></h3>
    <hr>
    <style>
body {margin:0;}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
    background-color: #4CAF50;
    color: white;
}
</style>
         </head>
    <body style="background-color:whitesmoke">
 
<div class="topnav">
    <form name="WelcomePage" action="${pageContext.request.contextPath}/welcome/WelcomePageFrame" method="post"> 
  <a class="active" href="javascript:document.WelcomePage.submit()">Home</a>
  </form>
  <form name="balancePage" action="${pageContext.request.contextPath}/balance" method="post"> 
  <a href="javascript:document.balancePage.submit()">Balance</a>
  </form>
   <form name="rewardsPage" action="${pageContext.request.contextPath}/rewards" method="post"> 
  <a href="javascript:document.rewardsPage.submit()">Rewards</a>
  </form>
  <form name="logoutPage" action="${pageContext.request.contextPath}/logout" method="post"> 
  <a href="javascript:document.logoutPage.submit()">Logout</a>
  </form>
</div>
<hr>
<div style="padding-left:16px">
  <h2>Top Navigation Example</h2>
  <p>Some content..</p>
</div>
    </body>
</html>
