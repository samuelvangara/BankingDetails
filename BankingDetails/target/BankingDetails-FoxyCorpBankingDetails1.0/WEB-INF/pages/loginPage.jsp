<%-- 
    Document   : loginPage
    Created on : Mar 8, 2017, 5:41:43 PM
    Author     : Foxy
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >
<link rel="shortcut icon" href="http://nasuke.net/wp-content/uploads/favorite.ico" />
<style>
.fa {
  padding: 4px;
  font-size: 25px;
  width: 30px;
  text-align: center;
  text-decoration: none;
  margin: 2px 2px 2px 2px;
}

.fa:hover {
    opacity: 0.7;
}

.fa-facebook {
  background: #3B5998;
  color: white;
}

.fa-twitter {
  background: #55ACEE;
  color: white;
}

.fa-google {
  background: #dd4b39;
  color: white;
}

.fa-linkedin {
  background: #007bb5;
  color: white;
}

.fa-youtube {
  background: #bb0000;
  color: white;
}

.fa-instagram {
  background: #125688;
  color: white;
}

.fa-pinterest {
  background: #cb2027;
  color: white;
}

.fa-snapchat-ghost {
  background: #fffc00;
  color: white;
  text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
}

.fa-skype {
  background: #00aff0;
  color: white;
}

.fa-android {
  background: #a4c639;
  color: white;
}

.fa-dribbble {
  background: #ea4c89;
  color: white;
}

.fa-vimeo {
  background: #45bbff;
  color: white;
}

.fa-tumblr {
  background: #2c4762;
  color: white;
}

.fa-vine {
  background: #00b489;
  color: white;
}

.fa-foursquare {
  background: #45bbff;
  color: white;
}

.fa-stumbleupon {
  background: #eb4924;
  color: white;
}

.fa-flickr {
  background: #f40083;
  color: white;
}

.fa-yahoo {
  background: #430297;
  color: white;
}

.fa-soundcloud {
  background: #ff5500;
  color: white;
}

.fa-reddit {
  background: #ff5700;
  color: white;
}

.fa-rss {
  background: #ff6600;
  color: white;
}
</style>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <h1><center>Foxy Corp</center></h1>
          <hr>
    </head>
    <body background="http://www.africalegalnetwork.com/kenya/wp-content/uploads/sites/22/2016/07/Banking.jpg">
        
 <script type="text/javascript">
window.onloadlogin=function(){
    window.history.forward();
window.window.console.log("hi");
};
     </script>    
        <h3> <center>${FailureLoginMessage}</center></h3>
        <h3> <center>${SuccessRegistrationMessage}</center></h3>
         <form action="${pageContext.request.contextPath}/welcome" method="post">

             <table align="center">
                 <tr>
                     <td  colspan="2" align="center">
                         Log In Details
                     </td>
                 </tr>
                 <tr>
                     <td> User Name </td>
                     <td><input type="text" title="Enter User name" name="username"/></td>
                 </tr>
                 <tr>
                     <td>Password</td>
                     <td><input type="password"title="Enter Password" name="password"/></td>
                 </tr>
                 <tr>
                     <td align="center" colspan="2">
                 <button type="Submit">Log In</button>
                       </td>
                 </tr>
                 </form>
             <form name="forgotpassword" action="${pageContext.request.contextPath}/forgotpassword"> 
                 <tr>
                     <td colspan="2" align="center">
                         <a href="javascript:document.forgotpassword.submit()">Forgot Password?</a>
                     </td>
                 </tr>
             </form>
            <form name="register" action="${pageContext.request.contextPath}/register">      
                 <tr>
                     <td colspan="2" align="center">
                         <a href="javascript:document.register.submit()">Register Now!</a>
                     </td>
                 </tr>
            </form>
           </table>
 </div>  
     </body> 
     <div>
             <footer>
                 <hr>
 <center>Powered By &copy;FoxyCorp</center>
  <center>  
<a href="https://www.facebook.com/samuelnv?ref=bookmarks" class="fa fa-facebook"></a>
<a href="https://twitter.com/?lang=en" class="fa fa-twitter"></a>
<a href="https://www.instagram.com/nitinvangara/?hl=en" class="fa fa-instagram"></a></center>
</footer>        
     </div>
   </html>
