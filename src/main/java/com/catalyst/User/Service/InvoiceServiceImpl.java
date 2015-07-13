package com.catalyst.User.Service;

import com.catalyst.User.Model.Invoice;
import com.catalyst.User.DAO.GenericDAO;
import com.catalyst.User.DAO.InvoiceDAO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Service("invoiceService")
public class InvoiceServiceImpl extends GenericServiceImpl<Invoice, Integer> implements InvoiceService
{
    private InvoiceDAO invoiceDAO;
    
    public InvoiceServiceImpl()
    {
        
    }
    
    @Autowired
    public InvoiceServiceImpl(@Qualifier("invoiceDAO") GenericDAO<Invoice, Integer> genericDAO)
    {
        super(genericDAO);
        this.invoiceDAO = (InvoiceDAO)genericDAO;
    }
    
/*
    To Do:
    Add Methods Unique to Invoicing Here
    
*/
}