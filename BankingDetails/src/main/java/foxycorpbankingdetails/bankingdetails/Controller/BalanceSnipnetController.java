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
/**
 *
 * @author Foxy
 */
@Controller
@RequestMapping(value="/balanceSnipnet")
public class BalanceSnipnetController {
    
       @RequestMapping(method = RequestMethod.GET)
    public String RegisterControlPagePathGet(Model model)
    {
        return "BalanceSnipnet";
    }
    
     @RequestMapping(method = RequestMethod.POST)
    public String RegisterControlPagePathPost(HttpServletRequest request)
    { 
//    String UsernameForBalance=null,RetrievedBalance=null;
//    UsernameForBalance = WelcomeController.Username;
//    System.out.println("userbalance is:"+RetrievedBalance);
//    DatabaseConnection databaseconnection = new DatabaseConnection();
//    RetrievedBalance=databaseconnection.RetrieveBalance(UsernameForBalance);
//    System.out.println("retrieved is:"+RetrievedBalance);
     request.setAttribute("Balance",5000);
    
    return "BalanceSnipnet"; 
    }
}
