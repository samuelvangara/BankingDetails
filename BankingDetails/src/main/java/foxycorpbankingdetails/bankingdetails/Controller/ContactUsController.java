/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foxycorpbankingdetails.bankingdetails.Controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Foxy
 */
@Controller
@RequestMapping(value="/contactusSnippet")
public class ContactUsController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String BalanceSnippetControlPagePathGet(HttpServletRequest request)
    {
    return "ContactUsSnippet"; 
    }
    
}
