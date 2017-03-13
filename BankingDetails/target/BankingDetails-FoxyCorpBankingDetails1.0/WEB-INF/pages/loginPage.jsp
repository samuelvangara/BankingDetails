<%-- 
    Document   : loginPage
    Created on : Mar 8, 2017, 5:41:43 PM
    Author     : Foxy
--%>
<META Http-Equiv="Cache-Control" Content="no-cache">
<META Http-Equiv="Pragma" Content="no-cache">
<META Http-Equiv="Expires" Content="0"> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <h1><center>Welcome to Foxy Corp</center></h1>
    </head>
    <body style="background-color:darkseagreen">
        <hr>
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
         
             <hr>
  <footer align="center">
      <p><center>Powered By <a href="https://www.google.com/">FOXYCORP!</a></center></p>
</footer>
    </body>
</html>
