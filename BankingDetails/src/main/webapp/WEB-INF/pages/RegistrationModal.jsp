<%-- 
    Document   : RegistrationModal
    Created on : Mar 18, 2017, 2:22:43 AM
    Author     : Foxy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
        <style>
/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
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
    background-color: #h44336;
}

/* Center the image and position the close button */
.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
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
    float: right;
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
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 80%; /* Could be more or less, depending on screen size */
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
    </head>
       <body>
           <div id="id01" class="modal">
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
                     <td><input type="text" title="Enter First Name" name="firstname" required/></td>
                 </tr>
                  <tr>
                     <td> Last Name </td>
                     <td><input type="text" title="Enter Last Name" name="lastname" required/></td>
                 </tr>
                  <tr>
                     <td> Email ID </td>
                     <td><input type="email" title="Enter Email ID" name="emailid" required/></td>
                 </tr>
                  <tr>
                     <td> User Name </td>
                     <td><input type="text" title="Enter User name" name="username" required/></td>
                 </tr>
                 <tr>
                     <td>Password</td>
                     <td><input type="password"title="Enter Password" name="password" required/></td>
                 </tr>
                  <tr>
                     <td> Phone Number </td>
                     <td><input type="number" minlength="10" maxlength="10" title="Enter Phone Number" value ="0" name="phonenumber" required/></td>
                 </tr>
                  <tr>
                     <td> Mother's Maiden Name </td>
                     <td><input type="text" title="Enter Mother's Maiden Name" name="hint" required/></td>
                 </tr>
                 <tr>
                     <td align="center" colspan="2">
                 <button type="Submit" class="loginbtn">Register</button>
                    </td>
                    <td align="center" colspan="2"> <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button></td>
                 </tr>
                 </form>
           </div>
           </table>
             <hr>
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
    </body>
    <div>
             <footer>
                 <hr>
 <center>Powered By &copy;FoxyCorp</center>
  </footer>        
     </div>
   </html>
