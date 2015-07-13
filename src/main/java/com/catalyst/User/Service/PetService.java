package com.catalyst.User.Service;

import com.catalyst.User.Model.Pet;
import java.util.List;

public interface PetService extends GenericService<Pet, Integer>
{
/*
    To Do:
    Add Methods Unique to Pets Here
    
*/
    public List getPetsByName(String argName);
}