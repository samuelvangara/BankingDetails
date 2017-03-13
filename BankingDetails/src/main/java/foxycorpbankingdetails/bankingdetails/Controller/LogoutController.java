/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxycorpbankingdetails.bankingdetails.Controller;

import javax.servlet.http.HttpSession;
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
public class LogoutController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String LogoutControlPagePathGet(Model model)
    {
        return "loginPage";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String LogoutControlPagePathPost(HttpSession request)
    {
       return "loginPage";
    }
    
}
