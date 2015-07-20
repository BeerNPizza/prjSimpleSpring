package com.catalyst.Controllers;

import com.catalyst.Config.Global;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Declares This Class As A MVC Controller To Spring
public class IndexController
{
    @RequestMapping(value = { "/", "/Index" }, method = RequestMethod.GET) // Tells Spring When/Where To Select This Method
    public String Index_GET(ModelMap DInjMap) // Method Names Can Be Anything. Never Called Directly
    {
        DInjMap.put("PageTitle", Global.IndexPageTitle);                // Page Title

        return "Index";
    }
    
    @RequestMapping(value = { "/About" }, method = RequestMethod.GET) // Tells Spring When/Where To Select This Method
    public String About_GET(ModelMap DInjMap) // Method Names Can Be Anything. Never Called Directly
    {
        DInjMap.put("PageTitle", Global.IndexPageTitle);                // Page Title

        return "About";
    }

    @RequestMapping(value = { "/Contact" }, method = RequestMethod.GET) // Tells Spring When/Where To Select This Method
    public String Contact_GET(ModelMap DInjMap) // Method Names Can Be Anything. Never Called Directly
    {
        DInjMap.put("PageTitle", Global.IndexPageTitle);                // Page Title

        return "Contact";
    }
}