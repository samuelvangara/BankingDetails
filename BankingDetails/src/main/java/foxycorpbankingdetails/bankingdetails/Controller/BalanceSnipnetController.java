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
@RequestMapping(value="/balanceSnipnet")
public class BalanceSnipnetController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String BalanceSnippetControlPagePathGet(HttpServletRequest request)
    {
        request.setAttribute("Balance","");
        request.setAttribute("ID","");  
        return "BalanceSnipnet";
    }
    
     @RequestMapping(method = RequestMethod.POST)
    public String BalanceSnippetControlPagePathPost(HttpServletRequest request)
    { 
        
    String UsernameForBalance=null,RetrievedBalance=null,Retrievedid=null;
    UsernameForBalance = WelcomeController.Username;
    DatabaseConnection databaseconnection = new DatabaseConnection();
    RetrievedBalance=databaseconnection.RetrieveBalance(UsernameForBalance);
    Retrievedid=databaseconnection.RetrievedId;
    System.out.println(RetrievedBalance+Retrievedid);
    request.setAttribute("Balance",RetrievedBalance);
    request.setAttribute("ID",Retrievedid);
      
    return "BalanceSnipnet"; 
    }
}
