/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxycorpbankingdetails.bankingdetails.Controller;

import foxycorpbankingdetails.bankingdetails.DatabaseConnection.DatabaseConnection;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Foxy
 */
@Controller
@RequestMapping(value="/forgotpassword")
public class ForgotPasswordController {
    
     @RequestMapping(method = RequestMethod.GET)
    public String ForgotPasswordControlPagePathGet(Model model)
    {
        return "ForgotPassword";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView ForgotPasswordControlPagePathPost(HttpServletRequest request)
    {   
        boolean passwordCheck=true;
        DatabaseConnection databaseconnection = new DatabaseConnection();
        String Username=null, Hint=null;
        Username = request.getParameter("username");
        Hint = request.getParameter("hint");
        passwordCheck =(databaseconnection.ChangePasswordCheck(Username, Hint));
        if(passwordCheck)
        {
           ModelAndView model = new ModelAndView("ForgotPasswordChangePasswordPage");
           model.addObject("DetailsEnteredForgotPasswordMessage","Thank you! your credentials have been verified, please enter new password");
           request.setAttribute("Username", Username);
           request.setAttribute("Hint", Hint);
           return model;
        }
        if(Username.equals("") || Hint.equals(""))
        {
           ModelAndView model = new ModelAndView("ForgotPassword");
           model.addObject("DetailsNotEnteredForgotPasswordMessage","Please fill in the details to verify your credentials!");
           return model;  
        }
           ModelAndView model = new ModelAndView("ForgotPassword");
           model.addObject("DetailsNotEnteredForgotPasswordMessage","Your Credentails does not exist , enter the correct credentials");
           return model;
    }
    
    @RequestMapping(value="/credentialsConfirmed", method = RequestMethod.POST)
    public ModelAndView ForgotPasswordcredentialsConfirmedControlPagePathPost(HttpServletRequest request)
    {   
        DatabaseConnection databaseconnection = new DatabaseConnection();
        String Username=null,Password=null,Hint=null,ConfirmPassword=null;
        Username = request.getParameter("username");
        Password = request.getParameter("password");
        ConfirmPassword = request.getParameter("confirmpassword");
        Hint = request.getParameter("hint");
        System.out.println(ConfirmPassword.length()+""+Password.length());
        
        if(ConfirmPassword.length()==0 || Password.length()==0)
        {
          ModelAndView model = new ModelAndView("ForgotPasswordChangePasswordPage");
          model.addObject("DetailsNotEnteredForgotPasswordChangePasswordPageMessage","Please fill in the password details to proceed with password change.");
          request.setAttribute("Username", Username);
          request.setAttribute("Hint", Hint);
          return model;    
        }
        
        if(!ConfirmPassword.equalsIgnoreCase(Password))
        {
             ModelAndView model = new ModelAndView("ForgotPasswordChangePasswordPage");
             model.addObject("DetailsNotEnteredForgotPasswordChangePasswordPageMessage","Password doesnot match confirm password!");
             request.setAttribute("Username", Username);
             request.setAttribute("Hint", Hint);
             return model;
        }
        
       int PasswordChangeUpdateCheck = databaseconnection.ChangePasswordUpdate(Username, Hint, Password);
       System.out.println(PasswordChangeUpdateCheck);
       if(PasswordChangeUpdateCheck==1)
       {     
           ModelAndView model = new ModelAndView("loginPage");
           model.addObject("SuccessRegistrationMessage","Congrats! you have successfully changed your password, try loggin now.");
           return model;
       } 

             ModelAndView model = new ModelAndView("ForgotPasswordChangePasswordPage");
             model.addObject("DetailsNotEnteredForgotPasswordChangePasswordPageMessage","Password doesnot match confirm password!");
             return model;

    }
}