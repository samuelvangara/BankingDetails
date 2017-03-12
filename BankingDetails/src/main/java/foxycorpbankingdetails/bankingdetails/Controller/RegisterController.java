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
@RequestMapping(value="/register")
public class RegisterController {
    
      @RequestMapping(method = RequestMethod.GET)
    public String RegisterControlPagePathGet(Model model)
    {
        return "RegisterPage";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView RegisterControlPagePathPost(HttpServletRequest request)
    {   
        String Firstname=null,Lastname=null,Emailid=null,Username=null,Password=null,Hint=null;
        long Phonenumber =0;
        DatabaseConnection databaseconnection = new DatabaseConnection();
        Firstname = request.getParameter("firstname");
        Lastname = request.getParameter("lastname");
        Emailid = request.getParameter("emailid");
        Username = request.getParameter("username");
        Password = request.getParameter("password");
        Phonenumber = Long.parseLong(request.getParameter("phonenumber"));
        Hint = request.getParameter("hint");
        if(Firstname==null || Lastname==null || Emailid==null || Username==null || Password==null || Hint==null || Phonenumber==0)
        {
          ModelAndView model = new ModelAndView("RegisterPage");
           model.addObject("DetailsNotEnteredRegistrationMessage","Please fill in the details to proceed with registration.");
            return model;    
        }
        System.out.println(Firstname+Lastname+Emailid+Username+Password+Phonenumber+Hint);
      int RegistrationDetailsInsertionCheck = databaseconnection.RegisterationDetailsInsertion(Firstname, Lastname,Emailid,Username,Password,Phonenumber,Hint);
       if(RegistrationDetailsInsertionCheck==1)
       {     
        
           ModelAndView model = new ModelAndView("loginPage");
           model.addObject("SuccessRegistrationMessage","Congrats! you have registered successfully.");
           return model;
       }     
           ModelAndView model = new ModelAndView("RegisterPage");
           model.addObject("FailureRegistrationMessage","OOPS! something went wrong, please try again.");
            return model;       
    }
    
}
