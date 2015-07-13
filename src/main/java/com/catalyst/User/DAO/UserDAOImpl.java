package com.catalyst.User.DAO;

import com.catalyst.Config.CustomExceptions;
import com.catalyst.User.Model.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

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
            throw new CustomExceptions("No User With That Email Found");
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
            throw new CustomExceptions("No User With That Email Found");
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
            throw new CustomExceptions("No User(s) With That Firstname Found");
        }
    }
}