package com.catalyst.User.DAO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Criteria;
import com.catalyst.User.Model.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Repository("userDAO") // Declares (To Spring) This Class As Apart Of The Persistance Layer
public class UserDAOImpl extends GenericDAOImpl<User, Integer> implements UserDAO
{
/*
    To Do:
    Add Methods Unique to Users Here
    
    Methods:
    [+] getUserByPetID()
    [+] getUserByLastname()
    
*/
    @Autowired
    BCryptPasswordEncoder getBCryptPasswordEncoder;
    
    @Override
    public User getUserByEmail(String argEmail)
    {
        Criteria crit = getSession().createCriteria(persistentClass);
        crit.add(Restrictions.eq("Email", argEmail));
        crit.setFirstResult(0);                     // Result 0 Is First Result
        crit.setMaxResults(1);                      // Result 1 Is Max Result
        // Check Result
        if((User)crit.uniqueResult() != null) {
            return (User)crit.uniqueResult();
        }
        else {
            throw new RuntimeException("No User With That Email Found");
        }
    }
    
    @Override
    public String getPasswordByEmail(String argEmail)
    {
        Query query = getSession().createQuery("SELECT Password FROM User WHERE Email = :argemail"); //Entity NOT Table 
	query.setParameter("argemail", argEmail);
        query.setFirstResult(0);                     // Result 0 Is First Result
        query.setMaxResults(1);                      // Result 1 Is Max Result
        // Check Result
        if((String)query.uniqueResult() != null) {
            return((String)query.uniqueResult());
        }
        else {
            throw new RuntimeException("No User With That Email Found");
        }
    }
    
    @Override
    public List getUsersByFirstname(String argName)
    {
        Criteria crit = getSession().createCriteria(persistentClass);
        crit.add(Restrictions.eq("Firstname", argName));
        // Check Result Against Null
        if(crit.list() != null) {
            return crit.list();
        }
        else {
            throw new RuntimeException("No User(s) With That Firstname Found");
        }
    }
    
    @Override
    public boolean checkEmailAndPassword(String argEmail, String argPassword)
    {
        Query query = getSession().createQuery("SELECT Password FROM User WHERE Email = :argemail"); //Entity NOT Table 
	query.setParameter("argemail", argEmail);
        query.setFirstResult(0);                     // Result 0 Is First Result
        query.setMaxResults(1);                      // Result 1 Is Max Result
        // Check Result
        if((String)query.uniqueResult() != null)
        {
            if(this.getBCryptPasswordEncoder.matches(argPassword, (String)query.uniqueResult()))
            {
                return(true);   // Same
            }
            
            return(false);      // Not Same
        }
        else
        {
            return(false);      // Nobody With That Email Exists (Returned Null)
        }
    }
}