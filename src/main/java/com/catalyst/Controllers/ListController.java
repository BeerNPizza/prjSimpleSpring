package com.catalyst.Controllers;

import com.catalyst.Config.Global;
import com.catalyst.User.Model.Pet;
import com.catalyst.User.Model.User;
import org.springframework.ui.ModelMap;
import com.catalyst.User.Model.Invoice;
import com.catalyst.User.Model.Procedure;
import com.catalyst.User.Service.PetService;
import com.catalyst.User.Service.UserService;
import com.catalyst.User.Service.InvoiceService;
import com.catalyst.User.Service.ProcedureService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListController
{
    @Autowired
    UserService userService;
    
    @Autowired
    PetService petService;
    
    @Autowired
    InvoiceService invoiceService;
    
    @Autowired
    ProcedureService procedureService;
    
    @RequestMapping(value = "/List", method = RequestMethod.GET)
    public String List_GET(ModelMap DInjMap)
    {
        DInjMap.put("PageTitle", Global.ListPageTitle);                         // Page Title
        DInjMap.put("INJECT_STUFF_HERE", Global.ProjectTitle);                  // Project Name
        
        DInjMap.put("user", new User());                                        // Create/Inject New User Bean
        DInjMap.put("listUsers", this.userService.listAll());                   // Inject List Of Users

        DInjMap.put("pet", new Pet());                                          // Create/Inject New Pet Bean
        DInjMap.put("listPets", this.petService.listAll());                     // Inject List of Pets
        
        DInjMap.put("invoice", new Invoice());                                  // Create/Inject New Invoice Bean
        DInjMap.put("listInvoices", this.invoiceService.listAll());             // Inject List Of Invoices
        
        DInjMap.put("procedure", new Procedure());                              // Create/Inject New Procedure Bean
        DInjMap.put("listProcedures", this.procedureService.listAll());         // Inject List Of Procedures
        
        return "List";
    }
}