package com.catalyst.User.Service;

import com.catalyst.User.Model.Pet;
import com.catalyst.User.DAO.PetDAO;
import com.catalyst.User.DAO.GenericDAO;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

@Service("petService")
public class PetServiceImpl extends GenericServiceImpl<Pet, Integer> implements PetService
{
    private PetDAO petDAO;
    
    public PetServiceImpl()
    {
        
    }
    
    @Autowired
    public PetServiceImpl(@Qualifier("petDAO") GenericDAO<Pet, Integer> genericDAO)
    {
        super(genericDAO);
        this.petDAO = (PetDAO)genericDAO;
    }

/*
    To Do:
    Add Methods Unique to Pets Here
    
*/
    @Override
    @Transactional
    public List getPetsByName(String argName)
    {
        return(this.petDAO.getPetsByName(argName));
    }
}
