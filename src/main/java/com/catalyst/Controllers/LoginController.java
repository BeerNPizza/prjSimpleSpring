package com.catalyst.Controllers;

import com.catalyst.Config.Global;
import com.catalyst.User.Model.User;
import org.springframework.ui.ModelMap;
import com.catalyst.User.Service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
public class LoginController
{
    @Autowired
    UserService hUserService;
    
    @Autowired
    BCryptPasswordEncoder getBCryptPasswordEncoder;
    
    @RequestMapping(value = { "/Login" }, method = RequestMethod.GET)
    public String Login_GET(ModelMap DInjMap)
    {
        DInjMap.put("PageTitle", Global.LoginPageTitle);                // Page Title
        DInjMap.put("INJECT_STUFF_HERE", Global.ProjectTitle);          // Project Name
        
        System.out.println("At Login Page");
        
        return "Login";
    }
    
    @RequestMapping(value = { "/Login" }, method = RequestMethod.POST)
    public String Login_POST(ModelMap DInjMap,
            @ModelAttribute("User") User hUser,
            HttpServletResponse hResponse,
            HttpServletRequest hRequest)
    {
        System.out.println("Got Login Input");
        
        try
        {
            String CorrectPass = this.hUserService.getPasswordByEmail(hUser.getEmail());
                
            System.out.println("Correct Password: " + CorrectPass);
                
            // Check If Password Is Same
            if(getBCryptPasswordEncoder.matches(hUser.getPassword(), CorrectPass) == true)
            {
                System.out.println("Success! User Logged In!");
                return "redirect:/Admin";  
            }
            else
            {
                System.out.println("Fail! User FAILED To Log In!");
                DInjMap.put("PageTitle", Global.LoginPageTitle);                // Page Title
                DInjMap.put("INJECT_STUFF_HERE", Global.ProjectTitle);          // Crap To Inject
                return "Login";
            }
        }
        catch(Exception hCust) // This Will Catch Runtime Exception Relating To Email Not Found In Database
        {
            System.out.println("Exception Occured! Details: " + hCust.getMessage());
        }
        
        DInjMap.put("PageTitle", Global.LoginPageTitle);                // Page Title
        DInjMap.put("INJECT_STUFF_HERE", Global.ProjectTitle);          // Crap To Inject
        return "Login";
    }
}
