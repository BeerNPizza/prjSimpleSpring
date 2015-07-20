package com.catalyst.Controllers;

import com.catalyst.User.Model.Pet;
import com.catalyst.User.Model.Procedure;
import com.catalyst.User.Model.User;
import com.catalyst.User.Service.PetService;
import com.catalyst.User.Service.ProcedureService;
import org.springframework.ui.ModelMap;
import com.catalyst.User.Service.UserService;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestParam;
/*
    Ugly!
    Business Logic In The Controllers?! GROSS!

    Refactor this with DTO's & Binding result!
*/
@Controller
public class RegistrationController
{
    @Autowired
    UserService hUserService;
    
    @Autowired
    PetService hPetService;
    
    @Autowired
    ProcedureService hProcedureService;
    
    @Autowired
    BCryptPasswordEncoder getBCryptPasswordEncoder;
    
    /*
        This Method Handles Registration Of New Clients
    */
    @RequestMapping(value = { "/Register/Client" }, method = RequestMethod.POST)
    public String Register_POST_Client(ModelMap DInjMap,
            @ModelAttribute("User") User hUser, // Putting Data Into Object
            HttpServletResponse hResponse)      // Get A Handle On ServletResponse (Not Used Yet)
    {
        String strEncodedPass = getBCryptPasswordEncoder.encode(hUser.getPassword()); // Encode User's Plaintext Password
        hUser.setPassword(strEncodedPass);      // Set Their Password As The New Encoded One
        
        this.hUserService.addByEntity(hUser);   // Add User To Database
        
        return "redirect:/Admin/Clients";
    }
    
    /*
        This Method Handles Registration Of New Patients
    */
    @RequestMapping(value = { "/Register/Patient" }, method = RequestMethod.POST)
    public String Register_POST_Patient(ModelMap DInjMap,
            @ModelAttribute("Pet") Pet hPet,
            @RequestParam(value = "UserID") int UserID,
            HttpServletResponse hResponse)
    {
        
        // Wish I could do this in a cooler way
        hPet.setUserInPet(this.hUserService.findByID(UserID, false));
        
        this.hPetService.addByEntity(hPet);

        return "redirect:/Admin/Patients";
    }
    
    /*
        This Method Handles Registration Of New Procedures
    
        Was Having Some Issues With The Date Using A Model To Capture Properties
        So Im Doing It This Lame Ass Way Right Now
        So Pardon Me.
    */
    @RequestMapping(value = { "/Register/Procedure" }, method = RequestMethod.POST)
    public String Register_POST_Procedure(ModelMap DInjMap,
            @RequestParam(value = "PetID") int PetID,
            @RequestParam(value = "ProcedureName") String ProcedureName,
            @RequestParam(value = "ProcedureDescription") String ProcedureDescription,
            @RequestParam(value = "ProcedureCost") int ProcedureCost,
            @RequestParam(value = "ProcedureDate") String ProcedureDate
            )
    {        
        Procedure hProcedure = new Procedure();
        hProcedure.setPetInProcedure(this.hPetService.findByID(PetID, false));
        hProcedure.setProcedureName(ProcedureName);
        hProcedure.setProcedureDescription(ProcedureDescription);
        hProcedure.setProcedureCost(ProcedureCost);
        hProcedure.setProcedureDate(ProcedureDate);
        
        
        this.hProcedureService.addByEntity(hProcedure);
        
        return "redirect:/Admin/Patients";
    }
}