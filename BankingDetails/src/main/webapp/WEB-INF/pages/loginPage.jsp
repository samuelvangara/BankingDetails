<%-- 
    Document   : loginPage
    Created on : Mar 8, 2017, 5:41:43 PM
    Author     : Foxy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <h1><center>Welcome to Foxy Corp</center></h1>
    </head>
    <body style="background-color:darkseagreen" >
        <hr>
         <form action="${pageContext.request.contextPath}/welcome" method="post">
             <table border="1" align="center">
                 <tr>
                     <td  colspan="2" align="center">
                         Log In Details
                     </td>
                 </tr>
                 <tr>
                     <td> UserName </td>
                     <td><input type="text" title="Enter Username" name="username"/></td>
                 </tr>
                 <tr>
                     <td>Password</td>
                     <td><input type="password"title="Enter Passwords" name="password"/></td>
                 </tr>
                 <tr>
                     <td align="center" colspan="2">
                 <button type="Submit">Log In</button>
                       </td>
                 </tr>
           </table>
        </form>
             <hr>
  <footer align="center">
      <p>Powered By <a href="https://www.gmail.com">Good Job</a></p>
</footer>
    </body>
</html>
