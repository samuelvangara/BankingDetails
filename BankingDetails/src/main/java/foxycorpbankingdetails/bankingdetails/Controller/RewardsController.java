/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxycorpbankingdetails.bankingdetails.Controller;

import static foxycorpbankingdetails.bankingdetails.Controller.WelcomeController.Password;
import static foxycorpbankingdetails.bankingdetails.Controller.WelcomeController.Username;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Foxy
 */
@Controller
@RequestMapping(value="/rewards")
public class RewardsController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String RewardsControlPagePathGet(Model model)
    {
       return "RewardsPage";
    }
    
      @RequestMapping(method = RequestMethod.POST)
    public ModelAndView RewardsControlPagePathPost(HttpServletRequest request)
    {  
        if(Username!=null && Password!=null)
        {
            ModelAndView modelView = new ModelAndView("RewardsPage");
            request.setAttribute("Username", Username);
            request.setAttribute("Password", Password);
            return modelView;
        
        }
       ModelAndView modelView = new ModelAndView("RewardsPage");
       modelView.addObject("FailureLoginMessage","Your session has expired please login again!");
       return modelView;
}
}
