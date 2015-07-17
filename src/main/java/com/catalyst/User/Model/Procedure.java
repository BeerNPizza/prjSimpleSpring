package com.catalyst.User.Model;

import java.util.Date;
import java.io.Serializable;
import java.text.DateFormat;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import java.text.SimpleDateFormat;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.TemporalType;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Procedures")
public class Procedure implements Serializable
{
    @Id
    @GenericGenerator(name = "ID_Generator", strategy = "increment") // Generating The ID Value In Sequence
    @GeneratedValue(generator = "ID_Generator")
    @Column(name = "Procedure_ID")
    private int ID;
    
    @Column(name = "Procedure_Name")
    private String ProcedureName;
    
    @Column(name = "Procedure_Description")
    private String ProcedureDescription;
    
    @Column(name = "Procedure_Cost")
    private int ProcedureCost;
       
    //////////////////////////////////////////
    // Relationships
    //////////////////////////////////////////
    @ManyToOne
    @JoinColumn(name = "Pet_ID")
    private Pet PetInProcedure;
    //////////////////////////////////////////
    
    @Column(name = "Procedure_Date")
    @Temporal(TemporalType.TIMESTAMP) // (Casting) Creating A Timestamp
    private Date ProcedureDate;
    
    public Procedure() {
        
    }
    
    public int getID()
    {
        return(ID);
    }
    
    public String getProcedureName()
    {
        return(ProcedureName);
    }
    
    public String getProcedureDescription()
    {
        return(ProcedureDescription);
    }
    
    public int getProcedureCost()
    {
        return(ProcedureCost);
    }
    
    @JsonBackReference("pet-procedure")
    public Pet getPetInProcedure()
    {
        return(PetInProcedure);
    }
    
    public Date getProcedureDate()
    {
        return(ProcedureDate);
    }
    
    public void setID(int arg)
    {
        this.ID = arg;
    }
    
    public void setProcedureName(String arg)
    {
        this.ProcedureName = arg;
    }
    
    public void setProcedureDescription(String arg)
    {
        this.ProcedureDescription = arg;
    }
    
    public void setProcedureCost(int arg)
    {
        this.ProcedureCost= arg;
    }
    
    public void setPetInProcedure(Pet arg)
    {
        this.PetInProcedure = arg;
    }
    
    public void setProcedureDate(Date arg)
    {
        this.ProcedureDate = arg;
    }
    
    public void setProcedureDate(String arg)
    {
        try
        {
            DateFormat format = new SimpleDateFormat("MM-dd-yy HH:mm:ss");
            Date tDate = format.parse(arg);
            this.ProcedureDate = tDate;
        }
        catch(Exception E)
        {
            
        }
    }
}