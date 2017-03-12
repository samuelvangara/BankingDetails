<%-- 
    Document   : RegisterPage
    Created on : Mar 11, 2017, 4:40:39 AM
    Author     : Foxy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <h1><center>Registration Required!</center></h1>
    </head>
    <body style="background-color:darkgrey">
             <hr>
              <h3><center> ${DetailsNotEnteredRegistrationMessage}</center></h3>
             <h3><center> ${FailureRegistrationMessage}</center></h3>
          <form action="${pageContext.request.contextPath}/register" method="post">
                    <table align="center">
                 <tr>
                     <td  colspan="2" align="center">
                         Enter your Details to Register
                     </td>
                 </tr>
                 <tr>
                     <td> First Name </td>
                     <td><input type="text" title="Enter First Name" name="firstname"/></td>
                 </tr>
                  <tr>
                     <td> Last Name </td>
                     <td><input type="text" title="Enter Last Name" name="lastname"/></td>
                 </tr>
                  <tr>
                     <td> Email ID </td>
                     <td><input type="email" title="Enter Email ID" name="emailid"/></td>
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
                     <td> Phone Number </td>
                     <td><input type="number" minlength="10" maxlength="10" title="Enter Phone Number" value ="0" name="phonenumber"/></td>
                 </tr>
                  <tr>
                     <td> Mother's Maiden Name </td>
                     <td><input type="text" title="Enter Mother's Maiden Name" name="hint"/></td>
                 </tr>
                 <tr>
                     <td align="center" colspan="2">
                 <button type="Submit">Register</button>
                       </td>
                 </tr>
                 </form>
            
           </table>
         
             <hr>
  <footer align="center">
      <p>Powered By <a href="https://www.google.com/">FOXYCORP!</a></p>
</footer>
    </body>
</html>
