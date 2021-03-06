package com.catalyst.Controllers;

import org.springframework.ui.ModelMap;
import com.catalyst.User.Service.PetService;
import com.catalyst.User.Service.UserService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PatientController
{
    @Autowired // Dependency Injection. Tells Spring It Needs To Happen Here
    PetService hPetService;
    
    @Autowired
    UserService hUserService;

    @RequestMapping(value = {"/Admin/Patients" }, method = RequestMethod.GET) // Tells Spring When/Where To Select This Method
    public String Patients_GET(ModelMap DInjMap) // Method Names Can Be Anything. Never Called Directly
    {
        DInjMap.put("listPets", this.hPetService.listAll());            // Inject List of Pets 
        DInjMap.put("listUsers", this.hUserService.listAll());          // Inject List Of Users
        
        return "Patients"; 
    }
    
    @RequestMapping(value = {"/Admin/Patients/Name" }, method = RequestMethod.GET)
    public String Clients_Search_Empty_GET(ModelMap DInjMap)
    {
        return "redirect:/Admin/Patients";
    }
    
    @RequestMapping(value = {"/Admin/Patients/Name/{argName}" }, method = RequestMethod.GET)
    public String Clients_Search_GET(ModelMap DInjMap, @PathVariable("argName") String argName)
    {
        DInjMap.put("listPets", this.hPetService.getPetsByName(argName));   // Inject List Of Pets With That Name
        
        return "Patients";
    }
}