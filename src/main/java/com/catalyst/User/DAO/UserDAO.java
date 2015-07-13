package com.catalyst.User.DAO;

import com.catalyst.User.Model.User;
import java.util.List;
import java.util.Set;

public interface UserDAO extends GenericDAO<User, Integer>
{
/*
    To Do:
    Add Methods Unique to Users Here
    
*/
    
    public User getUserByEmail(String argEmail);
    public String getPasswordByEmail(String argEmail);
    public List getUsersByFirstname(String argName);
}