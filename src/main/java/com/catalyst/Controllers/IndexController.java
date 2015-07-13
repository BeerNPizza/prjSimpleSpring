package com.catalyst.Controllers;

import com.catalyst.Config.Global;
import org.springframework.ui.ModelMap;
import com.catalyst.User.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Declares This Class As A MVC Controller To Spring
public class IndexController
{
    @Autowired // Dependency Injection. Tells Spring It Needs To Happen Here
    UserService hUserService;

    @RequestMapping(value = { "/", "/Index" }, method = RequestMethod.GET) // Tells Spring When/Where To Select This Method
    public String Index_GET(ModelMap DInjMap) // Method Names Can Be Anything. Never Called Directly
    {
        DInjMap.put("PageTitle", Global.IndexPageTitle);                // Page Title

        return "Index"; // Return Index(.jsp) Contents After Injection Of Content To Placeholders
    }
    
    @RequestMapping(value = { "/About" }, method = RequestMethod.GET) // Tells Spring When/Where To Select This Method
    public String About_GET(ModelMap DInjMap) // Method Names Can Be Anything. Never Called Directly
    {
        DInjMap.put("PageTitle", Global.IndexPageTitle);                // Page Title

        return "About"; // Return Index(.jsp) Contents After Injection Of Content To Placeholders
    }

    @RequestMapping(value = { "/Contact" }, method = RequestMethod.GET) // Tells Spring When/Where To Select This Method
    public String Contact_GET(ModelMap DInjMap) // Method Names Can Be Anything. Never Called Directly
    {
        DInjMap.put("PageTitle", Global.IndexPageTitle);                // Page Title

        return "Contact"; // Return Index(.jsp) Contents After Injection Of Content To Placeholders
    }
}