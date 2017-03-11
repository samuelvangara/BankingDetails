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
@RequestMapping(value="/welcome")
public class WelcomeController {
    
      @RequestMapping(method = RequestMethod.GET)
    public String WelcomeControlPagePathGet(Model model)
    {
        return "WelcomePage";
    }
    
      @RequestMapping(method = RequestMethod.POST)
    public String WelcomeControlPagePathPost(HttpServletRequest request)
    {   
        DatabaseConnection databaseconnection = new DatabaseConnection();
        String Username = request.getParameter("username");
        String Password = request.getParameter("password");
        boolean loginCheck = databaseconnection.LoginCheck(Username, Password);
        System.out.println("Controller "+loginCheck);
        if(loginCheck)
        {
            request.setAttribute("Username", Username);
            request.setAttribute("Password", Password);
            return "WelcomePage";    
        }         
        return "loginPage";
               
    }
    
}
