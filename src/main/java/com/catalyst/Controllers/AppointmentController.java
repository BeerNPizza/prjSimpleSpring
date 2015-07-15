package com.catalyst.Controllers;

import com.catalyst.Config.Global;
import com.catalyst.User.Model.Pet;
import org.springframework.ui.ModelMap;
import com.catalyst.User.Service.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppointmentController
{
    @Autowired
    PetService hPetService;
    
    

    @RequestMapping(value = {"/Admin/Appointments" }, method = RequestMethod.GET)
    public String Appointment_GET(ModelMap DInjMap)
    {
        DInjMap.put("PageTitle", Global.AdminPageTitle);
        DInjMap.put("INJECT_STUFF_HERE", Global.ProjectTitle);
        
        DInjMap.put("pet", new Pet());                                  // Create/Inject New Pet Bean
        DInjMap.put("listPets", this.hPetService.listAll());            // Inject List of Pets
        
        DInjMap.put("InjCountries", Global.strCountries);
        DInjMap.put("InjCapitals", Global.strCapitals);
        
        return "Appointments"; 
    }
}