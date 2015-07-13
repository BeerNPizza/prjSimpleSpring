package com.catalyst.User.Service;

import com.catalyst.User.Model.User;
import com.catalyst.User.DAO.UserDAO;
import com.catalyst.User.DAO.GenericDAO;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

@Service("userService") // Declares This Class As A Service To Spring
public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements UserService
{
    private UserDAO userDAO;
    
    public UserServiceImpl()
    {
    
    }
    
    @Autowired
    public UserServiceImpl(@Qualifier("userDAO") GenericDAO<User, Integer> genericDAO)
    {
        super(genericDAO);
        this.userDAO = (UserDAO)genericDAO;
    }
/*
    To Do:
    Add Methods Unique to Users Here
    
*/   
    @Override
    @Transactional
    public User getUserByEmail(String argEmail)
    {
        return(this.userDAO.getUserByEmail(argEmail));
    }
    
    @Override
    @Transactional
    public String getPasswordByEmail(String argEmail)
    {
        return(this.userDAO.getPasswordByEmail(argEmail));
    }
    
    @Override
    @Transactional
    public List getUsersByFirstname(String argName)
    {
        return(this.userDAO.getUsersByFirstname(argName));
    }
}