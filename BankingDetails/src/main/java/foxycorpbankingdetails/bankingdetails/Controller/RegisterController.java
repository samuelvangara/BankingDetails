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
@RequestMapping(value="/register")
public class RegisterController {
    
      @RequestMapping(method = RequestMethod.GET)
    public String RegisterControlPagePathGet(Model model)
    {
        return "RegisterPage";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String RegisterControlPagePathPost(HttpServletRequest request)
    {   
        DatabaseConnection databaseconnection = new DatabaseConnection();
        String Firstname = request.getParameter("firstname");
        String Lastname = request.getParameter("lastname");
        String Emailid = request.getParameter("emailid");
        String Username = request.getParameter("username");
        String Password = request.getParameter("password");
        long Phonenumber = Integer.parseInt(request.getParameter("phonenumber"));
        String Hint = request.getParameter("hint");
        System.out.println(Firstname+Lastname+Emailid+Username+Password+Phonenumber+Hint);
        boolean loginCheck = databaseconnection.LoginCheck(Username, Password);
        if(loginCheck)
        {
            request.setAttribute("Username", Username);
            request.setAttribute("Password", Password);
            return "WelcomePage";    
        }         
        return "loginPage";
               
    }
    
}
