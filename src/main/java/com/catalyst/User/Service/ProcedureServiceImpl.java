package com.catalyst.User.Service;

import com.catalyst.User.DAO.GenericDAO;
import com.catalyst.User.DAO.ProcedureDAO;
import com.catalyst.User.Model.Procedure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("procedureService")
public class ProcedureServiceImpl extends GenericServiceImpl<Procedure, Integer> implements ProcedureService
{
    private ProcedureDAO procedureDAO;
    
    public ProcedureServiceImpl()
    {
        
    }
    
    @Autowired
    public ProcedureServiceImpl(@Qualifier("procedureDAO") GenericDAO<Procedure, Integer> genericDAO)
    {
        super(genericDAO);
        this.procedureDAO = (ProcedureDAO)genericDAO;
    }
    
}