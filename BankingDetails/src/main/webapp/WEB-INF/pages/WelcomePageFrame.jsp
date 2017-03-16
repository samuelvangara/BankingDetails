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
<script type="text/javascript">
    window.onload=function(){
      var auto = setTimeout(function(){ autoRefresh(); }, 0.1);

        function submitform(){
           document.forms["balanceSnipnetForm"].submit();
           document.forms["rewardsSnippetForm"].submit();
           document.forms["profileSnippetForm"].submit();
        }

        function autoRefresh(){
           clearTimeout(auto);
           auto = setTimeout(function(){ submitform();});
        }
    };
</script>
     </head>
    <body style="background-color:whitesmoke">
 <form name="balanceSnipnetForm" id="balanceSnipnetForm" target="balanceSnipnetFrame" action="${pageContext.request.contextPath}/balanceSnipnet" method="post"> 
</form>
 <form name="rewardsSnippetForm" id="rewardsSnippetForm" target="rewardsSnippetFrame" action="${pageContext.request.contextPath}/rewardsSnippet" method="post"> 
</form>
<form name="profileSnippetForm" id="profileSnippetForm" target="profileSnippetFrame" action="${pageContext.request.contextPath}/profileSnippet" method="post"> 
</form>
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
   <form name="profilePage" action="${pageContext.request.contextPath}/profile" method="post"> 
  <a href="javascript:document.profilePage.submit()">Profile</a>
  </form>
  <form name="logoutPage" action="${pageContext.request.contextPath}/logout" method="post"> 
  <a href="javascript:document.logoutPage.submit()">Logout</a>
  </form>
</div>
<hr>
<div style="padding-left:25px">
   <br>
<br>
<br>
<iframe name="balanceSnipnetFrame" scrolling="no" width="45%" src="${pageContext.request.contextPath}/balanceSnipnet"> </iframe>
<iframe name="rewardsSnippetFrame" scrolling="no" width="45%" src="${pageContext.request.contextPath}/rewardsSnippet"></iframe>
<br>
<br>
<br>
<hr>
<br>
<br>
<iframe name="profileSnippetFrame" scrolling="no" width="45%" src="http://localhost:8080/BankingDetails/profileSnippet"></iframe>
<iframe scrolling="no" width="45%" src="http://localhost:8080/BankingDetails/balance"></iframe>  
<br>
<br>
</div>
    </body>
     <div>
             <footer>
                 <hr>
 <center>Powered By &copy;FoxyCorp</center>
  </footer>        
     </div>
</html>
