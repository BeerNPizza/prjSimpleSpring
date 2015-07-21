package com.catalyst.Controllers;

import com.catalyst.DTO.ClientRegistrationDTO;
import com.catalyst.DTO.PatientRegistrationDTO;
import com.catalyst.DTO.ProcedureRegistrationDTO;
import com.catalyst.User.Model.Pet;
import com.catalyst.User.Model.Procedure;
import com.catalyst.User.Model.User;
import com.catalyst.User.Service.PetService;
import com.catalyst.User.Service.ProcedureService;
import org.springframework.ui.ModelMap;
import com.catalyst.User.Service.UserService;
import javax.validation.Valid;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
/*
    Reminders:
    @Valid is an annotation that marks an object for JSR-303 bean validation.
    @ModelAttribute is used to map/bind a a method parameter or method return type to a named model attribute.
*/
@Controller
public class RegistrationController
{
    @Autowired
    PetService hPetService;

    @Autowired
    MapperFacade autoMapper;
    
    @Autowired
    UserService hUserService;

    @Autowired
    ProcedureService hProcedureService;
    
    @Autowired
    BCryptPasswordEncoder getBCryptPasswordEncoder;
    
    /*
        This Method Handles Registration Of New Clients
    */
    @RequestMapping(value = { "/Register/Client" }, method = RequestMethod.POST)
    public String Register_POST_Client(ModelMap DInjMap,
            @Valid ClientRegistrationDTO hClientRegDTO,
            BindingResult hBindResult)
    {
        // Check If Client Submitted Bad Data, If So, Redirect And Try Again
        if(hBindResult.hasErrors()) {
            return "Admin/Clients";
        }
        
        // Automap The DTO To A New User Entity
        User hUser = autoMapper.map(hClientRegDTO, User.class);
        
        // Encode The Password And Set It
        hUser.setPassword(getBCryptPasswordEncoder.encode(hClientRegDTO.getPassword()));

        // Finally, We Save The New User Entity
        this.hUserService.addByEntity(hUser);
        
        // Redirect Client Back To Their Page
        return "redirect:/Admin/Clients";
    }
    
    /*
        This Method Handles Registration Of New Patients
    */
    @RequestMapping(value = { "/Register/Patient" }, method = RequestMethod.POST)
    public String Register_POST_Patient(ModelMap DInjMap,
            @Valid PatientRegistrationDTO hPatientRegDTO,
            @RequestParam(value = "UserID") int UserID,
            BindingResult hBindResult)
    {
        // Check If Form Has Errors
        if(hBindResult.hasErrors()) {
            return "Admin/Patients";
        }
        
        // Automap DTO To A New Pet Entity
        Pet hPet = autoMapper.map(hPatientRegDTO, Pet.class);
        
        // Looking Up The Pets Owner And Assigning Them To Pet
        hPet.setUserInPet(this.hUserService.findByID(UserID, false));
        
        // Saving New Pet
        this.hPetService.addByEntity(hPet);

        // Return Patient Back To Their Page
        return "redirect:/Admin/Patients";
    }
    
    /*
        This Method Handles Registration Of New Procedures
    */
    @RequestMapping(value = { "/Register/Procedure" }, method = RequestMethod.POST)
    public String Register_POST_Procedure(ModelMap DInjMap,
            @Valid ProcedureRegistrationDTO hProcedureRegDTO,
            @RequestParam(value = "PetID") int PetID,
            BindingResult hBindResult
            )
    {
        // Check If Form Has Errors
        if(hBindResult.hasErrors()) {
            return "Admin/Patients";
        }
        
        // Automap DTO To A New Entity
        Procedure hProcedure = autoMapper.map(hProcedureRegDTO, Procedure.class);
        
        // Looking Up The Pet And Assigning Them To Procedure
        hProcedure.setPetInProcedure(this.hPetService.findByID(PetID, false));
        
        // Saving New Procedure
        this.hProcedureService.addByEntity(hProcedure);
        
        // Return Patient Back To Their Page
        return "redirect:/Admin/Patients";
    }
}