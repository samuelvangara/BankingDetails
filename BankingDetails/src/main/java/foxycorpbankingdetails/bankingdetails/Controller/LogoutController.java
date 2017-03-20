/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxycorpbankingdetails.bankingdetails.Controller;

import foxycorpbankingdetails.bankingdetails.DatabaseConnection.DatabaseConnection;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Foxy
 */
@Controller
@RequestMapping(value="/logout")
public class LogoutController{
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView LogoutControlPagePathGet(HttpServletRequest
request, HttpServletResponse response) throws IOException,
ServletException
    {
        HttpSession session = request.getSession();
        session.invalidate();
        return new ModelAndView("redirect:http://localhost:8080/BankingDetails/");
    }
    
    @RequestMapping(method = RequestMethod.POST)
     public ModelAndView LogoutControlPagePathPost(HttpServletRequest
request, HttpServletResponse response) throws IOException,
ServletException
    {
        HttpSession session = request.getSession();
        session.invalidate();
        DatabaseConnection dbc = new DatabaseConnection();
        dbc.closeConnection();
        return new ModelAndView("redirect:http://localhost:8080/BankingDetails/");
       
    }
    
}
