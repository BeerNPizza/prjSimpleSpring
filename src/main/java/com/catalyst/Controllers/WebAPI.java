package com.catalyst.Controllers;

import org.hibernate.Session;
import com.catalyst.User.Model.Pet;
import org.hibernate.SessionFactory;
import com.catalyst.User.Model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/*
    Web API Example
    
    This Was A Bitch To Get Working.
    Had To Work With Hibernate At A Lower Level To Get Everything To Work
    @Transactional Annotation In Service Layer Was Messing With The Output.

*/
@RestController
public class WebAPI
{  
    @Autowired
    SessionFactory sessionFactory;
    
    @RequestMapping(value = { "/API/Client/{argUserID}" }, method = RequestMethod.GET)
    public User getClientInJSON(@PathVariable("argUserID") int argUserID)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User hUser = (User)session.load(User.class, argUserID);
        session.getTransaction().commit();
        
        return hUser;
    }
    
    @RequestMapping(value = { "/API/Patient/{argPatientID}" }, method = RequestMethod.GET)
    public Pet getPatientInJSON(@PathVariable("argPatientID") int argPatientID)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Pet hPet = (Pet)session.load(Pet.class, argPatientID);
        session.getTransaction().commit();
        
        return hPet;
    }
}