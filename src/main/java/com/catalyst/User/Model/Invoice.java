package com.catalyst.User.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;
import java.sql.Timestamp;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Proxy;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonInclude;
/*
    Has A ManyToOne Relationship With Pets
*/
@Entity
@Table(name = "Invoices")
// @Proxy(lazy = false)            // Was Causing Problems With JSON Output
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Invoice implements Serializable
{
    @Id
    @GenericGenerator(name = "ID_Generator", strategy = "increment") // Generating The ID Value In Sequence
    @GeneratedValue(generator = "ID_Generator")
    @Column(name = "Invoice_ID")
    private int ID;
    
    @Column(name = "Invoice_Amount")
    private int InvoiceAmount;
    
    @Column(name = "Invoice_Description")
    private String InvoiceDescription;
    
    @Column(name = "Invoice_Created")
    @Temporal(TemporalType.TIMESTAMP) // (Casting) Creating A Timestamp
    private Date InvoiceCreated;
    
    @Column(name = "Invoice_Modified")
    @Temporal(TemporalType.TIMESTAMP) // (Casting) Creating A Timestamp
    private Date InvoiceModified;

    //////////////////////////////////////////
    // Relationships
    //////////////////////////////////////////
    @ManyToOne
    @JoinColumn(name = "Pet_ID")
    private Pet PetInInvoice;
    //////////////////////////////////////////
    
    public Invoice() {
    
    }
    
    // For Single Line Instantiation
    public Invoice(int argAmount, String argDescription, Timestamp argCreated, Timestamp argModified)
    {
        this.InvoiceAmount      = argAmount;
        this.InvoiceDescription = argDescription;
        this.InvoiceCreated     = argCreated;
        this.InvoiceModified    = argModified;
    }

    // Accessors
    public int getID()
    {
        return(ID);
    }
    
    public int getInvoiceAmount()
    {
        return(InvoiceAmount);
    }
    
    public String getInvoiceDescription()
    {
        return(InvoiceDescription);
    }
    
    public Date getInvoiceCreated()
    {
        return(InvoiceCreated);
    }
    
    public Date getInvoiceModified()
    {
        return(InvoiceModified);
    }

    @JsonBackReference("pet-invoice")
    public Pet getPetInInvoice()
    {
        return(PetInInvoice);
    }
    
    // Mutators
    public void setID(int argID)
    {
        this.ID = argID;
    }
    
    public void setInvoiceAmount(int argAmount)
    {
        this.InvoiceAmount = argAmount;
    }
    
    public void setInvoiceDescription(String argDescription)
    {
        this.InvoiceDescription = argDescription;
    }
    
    public void setInvoiceCreated(Date argDate)
    {
        this.InvoiceCreated = argDate;
    }
    
    public void setInvoiceModified(Date argDate)
    {
        this.InvoiceModified = argDate;
    }

    public void setPetInInvoice(Pet argPet)
    {
        this.PetInInvoice = argPet;
    }
}
