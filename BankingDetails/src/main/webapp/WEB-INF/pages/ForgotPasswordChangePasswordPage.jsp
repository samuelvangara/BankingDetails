<%-- 
    Document   : ForgotPasswordChangePasswordPage
    Created on : Mar 11, 2017, 5:41:43 PM
    Author     : Foxy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password</title>
        <h1><center>Password Change!</center></h1>
    </head>
           <%
             String Username =" ",Hint="";
             Username=request.getAttribute("Username").toString();
             Hint = request.getAttribute("Hint").toString();
             %>
    <body style="background-color:darkgoldenrod" >
      <hr>
             <h3><center> ${DetailsEnteredForgotPasswordMessage}</center></h3>
             <h3><center> ${DetailsNotEnteredForgotPasswordChangePasswordPageMessage}</center></h3>
             <form action="${pageContext.request.contextPath}/forgotpassword/credentialsConfirmed" method="post">
                    <table align="center">
                 <tr>
                     <td  colspan="2" align="center"><b>
                             Enter your Details to change password</b>
                     </td>
                 </tr>
                  <tr>
                     <td> User Name </td>
                     <td><input type="text" title="Enter User name" name="username" value="<%out.println(Username);%>"/></td>
                 </tr>
                 <tr>
                     <td> Mother's Maiden Name </td>
                     <td><input type="text" title="Enter Mother's Maiden Name" name="hint" value="<%out.println(Hint);%>"/></td>
                 </tr>
                 <tr>
                       <td>Password</td>
                     <td><input type="Password" title="Enter Password" name="password"></td>
                 </tr>
                 <tr>
                     <td>Confirm Password </td>
                     <td><input type="Password" title="Enter Confirm Password" name="confirmpassword"/></td>
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
    <div>
             <footer>
                 <hr>
 <center>Powered By &copy;FoxyCorp</center>
  </footer>        
     </div>
</html>
