package com.catalyst.Controllers;

import com.catalyst.Config.Global;
import com.catalyst.User.Model.Pet;
import com.catalyst.User.Model.User;
import org.springframework.ui.ModelMap;
import com.catalyst.User.Service.PetService;
import com.catalyst.User.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppointmentController
{
    @Autowired
    PetService hPetService;
    
    @Autowired
    UserService hUserService;
    
    @RequestMapping(value = {"/Admin/Appointments" }, method = RequestMethod.GET)
    public String Appointment_GET(ModelMap DInjMap)
    {
        DInjMap.put("listPets", this.hPetService.listAll());            // Inject List of Pets
        DInjMap.put("InjNames", this.hUserService.listAll());
        
        return "Appointments"; 
    }
}