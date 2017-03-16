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
@RequestMapping(value="/rewardsSnippet")
public class RewardsSnippetController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String RewardsSnippetControlPagePathGet(HttpServletRequest request)
    {
        request.setAttribute("Rewards","30");
        return "RewardsSnippet";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String RewardsSnippetControlPagePathPost(HttpServletRequest request)
    { 
        
    String UsernameForBalance=null,RetrievedRewards=null,Retrievedid=null;
    UsernameForBalance = WelcomeController.Username;
    DatabaseConnection databaseconnection = new DatabaseConnection();
    RetrievedRewards=databaseconnection.RetrievedRewards;
    request.setAttribute("Rewards",RetrievedRewards);
    
    return "RewardsSnippet"; 
    }
}
