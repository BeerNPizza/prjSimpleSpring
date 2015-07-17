package com.catalyst.Controllers;

import com.catalyst.User.Model.Pet;
import com.catalyst.User.Model.User;
import com.catalyst.User.Service.PetService;
import com.catalyst.User.Service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/*
    Web API Example
*/
@RestController
public class WebAPI
{
    @Autowired
    PetService petService;
    
    @Autowired
    UserService userService;
    
    // This Method Handles Improper/Unhandled Requests
    @RequestMapping(value = { "/API/Client", "/API/Patient" }, method = RequestMethod.GET)
    public String getAPIInJSON_Bad()
    {
        return "Bad Input";
    }

    // This Method Returns A Clients Data And Any/All Relational Data
    @RequestMapping(value = { "/API/Client/{argUserID}" }, method = RequestMethod.GET)
    public User getClientInJSON(@PathVariable("argUserID") int argUserID)
    {
        return(this.userService.findByID_API(argUserID));
    }
    
    // This Method Returns A Patients Data And Any/All Relational Data
    @RequestMapping(value = { "/API/Patient/{argPatientID}" }, method = RequestMethod.GET)
    public Pet getPatientInJSON(@PathVariable("argPatientID") int argPatientID)
    {    
        return(this.petService.findByID_API(argPatientID));
    }
}