/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxycorpbankingdetails.bankingdetails.Controller;

import foxycorpbankingdetails.bankingdetails.DatabaseConnection.DatabaseConnection;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Foxy
 */
@Controller
@RequestMapping(value="/profileSnippet")
public class ProfileSnippetController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String RewardsSnippetControlPagePathGet(HttpServletRequest request)
    {
       request.setAttribute("EmailID","...");
       request.setAttribute("PhoneNumber","xxx");
       return "ProfileSnippet";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String RewardsSnippetControlPagePathPost(HttpServletRequest request)
    { 
        
    String UsernameForBalance=null,RetrievedEmailId=null,SplitEmailID=null,SplitPhoneNumber=null;
    long RetrievedPhoneNumber;
    UsernameForBalance = WelcomeController.Username;
    DatabaseConnection databaseconnection = new DatabaseConnection();
    databaseconnection.RegisterationDetailsRetrevial(UsernameForBalance);
    RetrievedEmailId = databaseconnection.RegisterationDetailsRetrevial(UsernameForBalance).get(0).getEmailid();
    RetrievedPhoneNumber=databaseconnection.RegisterationDetailsRetrevial(UsernameForBalance).get(0).getPhonenumber();
    SplitEmailID=RetrievedEmailId.substring(0, 3);
    SplitPhoneNumber = String.valueOf(RetrievedPhoneNumber).substring(String.valueOf(RetrievedPhoneNumber).length()-3, String.valueOf(RetrievedPhoneNumber).length());
    request.setAttribute("EmailID",SplitEmailID);
    request.setAttribute("PhoneNumber",SplitPhoneNumber);
    return "ProfileSnippet"; 
    }
    
}
