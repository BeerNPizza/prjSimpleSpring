package com.catalyst.User.Service;

import java.util.List;
import com.catalyst.User.Model.User;

public interface UserService extends GenericService<User, Integer>
{
/*
    To Do:
    Add Methods Unique to Users Here
    
*/
    
    public User getUserByEmail(String argEmail);
    public String getPasswordByEmail(String argEmail);
    public List getUsersByFirstname(String argName);
    
    public boolean checkEmailAndPassword(String argEmail, String argPassword);
}