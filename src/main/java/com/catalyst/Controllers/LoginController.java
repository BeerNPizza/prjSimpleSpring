package com.catalyst.Controllers;

import com.catalyst.User.Model.User;
import org.springframework.ui.ModelMap;
import com.catalyst.User.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController
{
    @Autowired
    UserService hUserService;
    
    @RequestMapping(value = { "/Login" }, method = RequestMethod.GET)
    public String Login_GET(ModelMap DInjMap)
    {
        return "Login";
    }
    
    @RequestMapping(value = { "/Login" }, method = RequestMethod.POST)
    public String Login_POST(ModelMap DInjMap, @ModelAttribute("User") User hUser)
    {
        if(this.hUserService.checkEmailAndPassword(hUser.getEmail(), hUser.getPassword())) {
            System.out.println("Success! User Logged In!");
            return "redirect:/Admin";
        }
        else {
            System.out.println("Fail! User FAILED To Log In!");
            return "redirect:/Login";
        }
    }
}
