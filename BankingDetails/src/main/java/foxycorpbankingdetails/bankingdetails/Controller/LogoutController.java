/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxycorpbankingdetails.bankingdetails.Controller;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Foxy
 */
@Controller
@RequestMapping(value="/logout")
public class LogoutController{
    
    @RequestMapping(method = RequestMethod.GET)
    public String LogoutControlPagePathGet(Model model)
    {
        return "loginPage";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String LogoutControlPagePathPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        return "loginPage";
    }
    
}
