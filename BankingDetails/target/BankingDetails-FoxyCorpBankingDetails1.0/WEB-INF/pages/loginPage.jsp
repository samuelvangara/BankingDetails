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
    </head>
    <body>
         <h1>Welcome to Foxy Corp</h1>
         <form action="${pageContext.request.contextPath}/welcome" method="post">
             UserName:<input type="text" title="Username" name="username"/><br>
             Password:<input type="password"title="Username" name="password"/><br>
             <button type="Submit">Log In</button>
        </form>
       
    </body>
</html>
