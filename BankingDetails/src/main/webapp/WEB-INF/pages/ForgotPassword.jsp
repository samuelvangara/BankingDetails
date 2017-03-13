<%-- 
    Document   : ForgotPassword
    Created on : Mar 11, 2017, 4:41:13 AM
    Author     : Foxy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Check</title>
         <h1><center>Password Change!</center></h1>
    </head>
    <body style="background-color:darkgoldenrod" >
      <hr>
             <h3><center> ${DetailsNotEnteredForgotPasswordMessage}</center></h3>
             <form action="${pageContext.request.contextPath}/forgotpassword" method="post">
                    <table align="center">
                 <tr>
                     <td  colspan="2" align="center"><b>
                             Enter your Details to change password</b>
                     </td>
                 </tr>
                  <tr>
                     <td> User Name </td>
                     <td><input type="text" title="Enter User name" name="username"/></td>
                 </tr>
                 <tr>
                     <td> Mother's Maiden Name </td>
                     <td><input type="text" title="Enter Mother's Maiden Name" name="hint"/></td>
                 </tr>
                 <tr>
                     <td align="center" colspan="2">
                         <button type="Submit">Change Password</button>
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
