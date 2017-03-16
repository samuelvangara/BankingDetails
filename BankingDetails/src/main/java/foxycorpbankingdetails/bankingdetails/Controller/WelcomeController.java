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
@RequestMapping(value="/welcome")
public class WelcomeController {
    
    public static String Username="";
    public transient static String Password=""; 
    
    @RequestMapping(method = RequestMethod.GET)
    public String WelcomeControlPagePathGet(Model model)
    {
       return "loginPage";
    }
    
      @RequestMapping(method = RequestMethod.POST)
    public ModelAndView WelcomeControlPagePathPost(HttpServletRequest request)
    {   
        String RetrievedBalance=null;
        DatabaseConnection databaseconnection = new DatabaseConnection();
        Username = request.getParameter("username");
        Password = request.getParameter("password");
        RetrievedBalance=databaseconnection.RetrieveBalance(Username);
        request.setAttribute("Balance",RetrievedBalance);
        boolean loginCheck = databaseconnection.LoginCheck(Username, Password);
        if(loginCheck)
        {
            ModelAndView modelView = new ModelAndView("WelcomePageFrame");
            request.setAttribute("Username", Username);
            request.setAttribute("Password", Password);
            return modelView;
        }
        if(Username.length()==0 || Password.length()==0)
        {
           ModelAndView modelView = new ModelAndView("loginPage");
           modelView.addObject("FailureLoginMessage","Please enter your credentials to login.");
           return modelView; 
        }
           ModelAndView modelView = new ModelAndView("loginPage");
           modelView.addObject("FailureLoginMessage","Please enter the correct username and password.If you are not a registered user, please register!");
           return modelView;
   
    }
    
     @RequestMapping(value="/WelcomePageFrame" ,method = RequestMethod.POST)
    public ModelAndView WelcomeFrameControlPagePathPost(HttpServletRequest request)
    {  
        if(Username!=null && Password!=null)
        {
            ModelAndView modelView = new ModelAndView("WelcomePageFrame");
            request.setAttribute("Username", Username);
            request.setAttribute("Password", Password);
            return modelView;
        
        }
       ModelAndView modelView = new ModelAndView("loginPage");
       modelView.addObject("FailureLoginMessage","Your session has expired please login again!");
       return modelView;
}
    
}