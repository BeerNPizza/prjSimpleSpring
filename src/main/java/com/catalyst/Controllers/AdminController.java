package com.catalyst.Controllers;

import com.catalyst.Config.Global;
import com.catalyst.User.Model.User;
import com.catalyst.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController
{
    @Autowired // Dependency Injection. Tells Spring It Needs To Happen Here
    UserService hUserService;

    @RequestMapping(value = {"/Admin" }, method = RequestMethod.GET) // Tells Spring When/Where To Select This Method
    public String Admin_GET(ModelMap DInjMap) // Method Names Can Be Anything. Never Called Directly
    {
        DInjMap.put("PageTitle", Global.AdminPageTitle);                // Page Title
        DInjMap.put("INJECT_STUFF_HERE", Global.ProjectTitle);          // Project Name
        
        DInjMap.put("user", new User());                                // Create/Inject New User Bean
        DInjMap.put("listUsers", this.hUserService.listAll());          // Inject List Of Users
        
        return "Admin"; 
    }
}