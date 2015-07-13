package com.catalyst.User.DAO;

import com.catalyst.Config.CustomExceptions;
import com.catalyst.User.Model.Pet;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("petDAO")
public class PetDAOImpl extends GenericDAOImpl<Pet, Integer> implements PetDAO
{
/*
    To Do:
    Add Methods Unique to Pets Here
    
    Methods:
    [+] getPetByUserID()
*/
    
    @Override
    public List getPetsByName(String argName)
    {
        Criteria crit = getSession().createCriteria(persistentClass);
        crit.add(Restrictions.eq("Name", argName));
        // Check Result Against Null
        if(crit.list() != null) {
            return crit.list();
        }
        else {
            throw new CustomExceptions("No Pets With That Name Found");
        }
    }
}