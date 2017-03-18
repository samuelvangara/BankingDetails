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
 .container {
    overflow: hidden;
    background-color: #333;
    font-family: Arial;
}

.container a {
    float: left;
    font-size: 16px;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
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
    size:10px
}

.dropdown .dropbtn a.active {
    background-color: #4CAF50;
    color: white;
}

.container a:hover, .dropdown:hover .dropbtn {
    background-color: red;
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
    
/*----------------------------------*/
/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 20px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ffffff;
    box-sizing: border-box;
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.loginbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #H44336;
}

/* Center the image and position the close button */
.imgcontainer {
    text-align: center;
    margin: 12px 0 12px 0;
    position: relative;
    }

img.avatar {
    width: 40%;
    border-radius: 50%;
}

.container {
    padding: 16px;
}

span.psw {
    float: outside;
    padding-top: 16px;
}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.2); /* Black w/ opacity */
    padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
    background-color: rgba(255,0,0,0.8); 
    margin: 10% auto auto auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 40%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
    position: absolute;
    right: 25px;
    top: 0;
    color: #000;
    font-size: 35px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: red;
    cursor: pointer;
}

/* Add Zoom Animation */
.animate {
    -webkit-animation: animatezoom 0.6s;
    animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
    from {-webkit-transform: scale(0)} 
    to {-webkit-transform: scale(1)}
}
    
@keyframes animatezoom {
    from {transform: scale(0)} 
    to {transform: scale(1)}
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
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
 <!--starts here-->
  <div name ="id01" id="id01" class="modal">
   <form class="modal-content animate" action="/action_page.php">
    <div class="container">
        <center><label style="color: #ffffff"><b>Username</b></label></center>
      <input type="text" placeholder="Enter Username" name="uname" required>
<br>
   <center><label style="color: #ffffff"><b>Email Id</b></label></center>
      <input type="password" placeholder="Enter Email Id" name="psw" required>
        
      <center><button type="submit" class="loginbtn">Add</button>
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button></center>
  </div>
 </form>
</div>
<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target === modal) {
        modal.style.display = "none";
    }
};
</script>
<!--ends here-->
<div class="topnav">
    <div class="dropdown">
    <form name="WelcomePage" action="${pageContext.request.contextPath}/welcome/WelcomePageFrame" method="post"> 
       <button class="dropbtn" style="background-color:#4CAF50;">Home</button> 
  </form>
    </div>
   <div class="dropdown">
       <button class="dropbtn">Transactions</button>
    <div class="dropdown-content">
      <a href="#" onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Link an Account</a>
      <a href="#">Remove an Account</a>
      <a href="#">View Linked Accounts</a>
      <a href="#">Transfer Money</a>
      <a href="#">Pay Due</a>
      <a href="#">Request Money</a>
      <form name="balancePage" action="${pageContext.request.contextPath}/balance" method="post"> 
      <a href="javascript:document.balancePage.submit()">View Recent Transactions</a>
      </form>
    </div>
     </div>
  <div class="dropdown">
    <button class="dropbtn">Rewards</button>
    <div class="dropdown-content">
    <form name="rewardsPage" action="${pageContext.request.contextPath}/rewards" method="post">     
      <a href="javascript:document.profilePage.submit()">View Rewards</a>
      </form>
      <a href="#">Claim Rewards</a>
    </div>
    </div>
  <div class="dropdown">
     <button class="dropbtn">Profile</button>
    <div class="dropdown-content">
     <form name="profilePage" action="${pageContext.request.contextPath}/profile" method="post"> 
      <a href="javascript:document.profilePage.submit()">View Profile</a>
       </form>
      <a href="#">Edit Profile</a>
    </div>
   </div>
      <div class="dropdown">
  <form name="logoutPage" action="${pageContext.request.contextPath}/logout" method="post"> 
   <button class="dropbtn">Logout</button>  
    </form>
   </div>
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
<iframe name="contactUsSnippetFrame" scrolling="no" width="45%" src="http://localhost:8080/BankingDetails/contactusSnippet"></iframe>  
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
