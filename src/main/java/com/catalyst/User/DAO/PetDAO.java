package com.catalyst.User.DAO;

import com.catalyst.User.Model.Pet;
import java.util.List;

public interface PetDAO extends GenericDAO<Pet, Integer>
{
/*
    To Do:
    Add Methods Unique to Pets Here
    
*/
    public List getPetsByName(String argName);
}