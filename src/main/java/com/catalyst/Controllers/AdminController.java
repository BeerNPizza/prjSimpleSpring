package com.catalyst.Controllers;

import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController
{
    @RequestMapping(value = {"/Admin" }, method = RequestMethod.GET) // Tells Spring When/Where To Select This Method
    public String Admin_GET(ModelMap DInjMap) // Method Names Can Be Anything. Never Called Directly
    {
        return "Admin"; 
    }
}