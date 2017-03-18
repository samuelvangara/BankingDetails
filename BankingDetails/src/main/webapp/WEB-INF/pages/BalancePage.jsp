<%-- 
    Document   : BalancePage
    Created on : Mar 13, 2017, 4:07:39 AM
    Author     : Foxy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Balance</title>
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
input[type=text] {
    width: 130px;
    box-sizing: border-box;
    border: 2px solid #333;
    border-radius: 4px;
    font-size: 16px;
    background-color: #ddd;
    background-image: url('searchicon.png');
    background-position: 10px 10px; 
    background-repeat: no-repeat;
    padding: 12px 20px 12px 40px;
    -webkit-transition: width 0.4s ease-in-out;
    transition: width 0.4s ease-in-out;
}

input[type=text]:focus {
    width: 15%;
    border: solid #333;
    }
    .dropdown {
    float: left;
    overflow: hidden;
}

.dropdown .dropbtn {
    font-size: 16px;    
    border: none;
    outline: none;
    color: white;
    padding: 14px 16px;
    background-color: inherit;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    float: none;
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {
    background-color: #ddd;
}

.dropdown:hover .dropdown-content {
    display: block;
}
</style>
         </head>
    <body style="background-color:whitesmoke">
 
<div class="topnav">
    <form name="WelcomePage" action="${pageContext.request.contextPath}/welcome/WelcomePageFrame" method="post"> 
  <a href="javascript:document.WelcomePage.submit()">Home</a>
  </form>
  <form name="balancePage" action="${pageContext.request.contextPath}/balance"  method="post"> 
  <a class="active" href="javascript:document.balancePage.submit()">Balance</a>
  </form>
   <div class="dropdown">
    <button class="dropbtn">Dropdown</button>
    <div class="dropdown-content">
      <a href="#">Link 1</a>
      <a href="#">Link 2</a>
      <a href="#">Link 3</a>
    </div>
   </div>
   <form name="rewardsPage" action="${pageContext.request.contextPath}/rewards"  method="post"> 
  <a href="javascript:document.rewardsPage.submit()">Rewards</a>
  </form>
  <form name="profilePage" action="${pageContext.request.contextPath}/profile" method="post"> 
  <a href="javascript:document.profilePage.submit()">Profile</a>
  </form>
  <form name="logoutPage" action="${pageContext.request.contextPath}/logout" method="post"> 
  <a href="javascript:document.logoutPage.submit()">Logout</a>
  </form>
    <form>
  <input type="text" name="search" placeholder="Search...">
</form>
</div>
<hr>
<div style="padding-left:16px">
  <h2>Top Navigation Example</h2>
  <p>Some content..</p>
</div>
    </body>
    <div>
             <footer>
                 <hr>
 <center>Powered By &copy;FoxyCorp</center>
  </footer>        
     </div>
</html>
