/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxycorpbankingdetails.bankingdetails.Controller;

import foxycorpbankingdetails.bankingdetails.DatabaseConnection.DatabaseConnection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author Foxy
 */
@Controller
@RequestMapping(value="/")
public class LoginController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String LoginControlPagePathGet(Model model)
    {   
        DatabaseConnection databaseconnection= new DatabaseConnection();
        boolean databaseCheck = databaseconnection.checkDatabase();
        if(databaseCheck)
        {
            return "loginPage";
        }
        databaseconnection.createDatabase();
        databaseconnection.createSequence();
        databaseconnection.createTable();
        return "loginPage";
    }
  }
