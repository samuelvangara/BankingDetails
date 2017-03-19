/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxycorpbankingdetails.bankingdetails.Controller;

import static foxycorpbankingdetails.bankingdetails.Controller.WelcomeController.Password;
import static foxycorpbankingdetails.bankingdetails.Controller.WelcomeController.Username;
import foxycorpbankingdetails.bankingdetails.DatabaseConnection.DatabaseConnection;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Foxy
 */
@Controller
@RequestMapping(value="/linkAnAccount")
public class LinkAnAccountController {
     
    @RequestMapping(method = RequestMethod.GET)
    public String LinkAnAccountControlPagePathGet(HttpServletRequest request)
    {
         request.setAttribute("Username", Username);  
         request.setAttribute("Password","2");
       return "BalancePage";
    }
    
     @RequestMapping(method = RequestMethod.POST)
    public ModelAndView LinkAnAccountControlPagePathPost(HttpServletRequest request)
    {  
        String UserName=null,EmailID=null,RetrievedEmailId=null,RetrievedUsername=null;
        UserName=request.getParameter("username");
        EmailID=request.getParameter("emailid");
        System.out.println(UserName+EmailID);
        DatabaseConnection databaseconnection = new DatabaseConnection();
        RetrievedEmailId = databaseconnection.RegisterationDetailsRetrevial(UserName).get(0).getEmailid();
        RetrievedUsername=databaseconnection.RegisterationDetailsRetrevial(UserName).get(0).getUsername();
       
        if(RetrievedEmailId!=null && RetrievedUsername!=null)
        {
            ModelAndView modelView = new ModelAndView("WelcomePageFrame");
            modelView.addObject("DetailsNotEnteredRegistrationMessage","Account has been linked successfully!");
            request.setAttribute("Username",Username);
            request.setAttribute("Emailid",Username);
            return modelView;
        
        }
       ModelAndView modelView = new ModelAndView("WelcomePageFrame");
       modelView.addObject("FailureRegistrationMessage","The Account linked with the username does not exist! Please try again");
       request.setAttribute("Username",Username);
       request.setAttribute("Password","2");
       return modelView;
}
    
}
