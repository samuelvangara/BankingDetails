<%-- 
    Document   : ProfileSnippet
    Created on : Mar 16, 2017, 4:53:34 PM
    Author     : Foxy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Snippet</title>
          <%
            String EmailID = "";
            String PhoneNumber = "";
                 EmailID=request.getAttribute("EmailID").toString();
                 PhoneNumber=request.getAttribute("PhoneNumber").toString();
        %>
    </head>
    <body style="background-color:gainsboro">
         <h4>
            Your Current Email ID : <%out.println(EmailID);%>**************
        </h4>
        <h4>
            Your Current Phone Number : xxx-xxxx-<%out.println(PhoneNumber);%>
        </h4>
        <marquee behavior="scroll" direction="left">Always keep your profile updated, for any changes please visit the profile page and edit your information...</marquee>
    </body>
</html>
