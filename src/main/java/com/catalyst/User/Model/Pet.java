package com.catalyst.User.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import org.hibernate.annotations.Proxy;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
/*
    Has A ManyToOne Relationship With User (Slave)
    Has A OneToMany Relationship With Invoice (Master)
*/
@Entity
@Table(name = "Pets")
@Proxy(lazy = false)            // Was Causing Problems With JSON Output
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Pet implements Serializable
{
    @Id
    @GenericGenerator(name = "ID_Generator", strategy = "increment") // Generating The ID Value In Sequence
    @GeneratedValue(generator = "ID_Generator")
    @Column(name = "Pet_ID")
    private int ID;
    
    @Column(name = "Pet_Name")
    private String Name;
    
    @Column(name = "Pet_Type")
    private String Type;
    
    @Column(name = "Pet_Breed")
    private String Breed;
    
    @Column(name = "Pet_Age")
    private int Age;

    //////////////////////////////////////////
    // Relationships
    //////////////////////////////////////////
    @ManyToOne
    @JoinColumn(name = "User_ID")
    private User UserInPet;
    
    @OneToMany(mappedBy = "PetInInvoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Invoice> invoices = new HashSet<>();
    
    @OneToMany(mappedBy = "PetInProcedure", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Procedure> procedures = new HashSet<>();
    //////////////////////////////////////////
    
    public Pet() {
        
    }
    
    public Pet(String argName, String argType, String argBreed, int argAge, User user)
    {
        this.Name           = argName;
        this.Type           = argType;
        this.Breed          = argBreed;
        this.Age            = argAge;
        this.UserInPet      = user;
    }
    
    // Accessors
    public int getID()
    {
        return(ID);
    }
    
    public String getName()
    {
        return(Name);
    }
    
    public String getType()
    {
        return(Type);
    }
    
    public String getBreed()
    {
        return(Breed);
    }
    
    public int getAge()
    {
        return(Age);
    }
    
    @JsonBackReference("user-pet")
    public User getUserInPet()
    {
        return(UserInPet);
    }
    
    @JsonManagedReference("pet-invoice")
    public Set<Invoice> getInvoices()
    {
        return(invoices);
    }
    
    @JsonManagedReference("pet-procedure")
    public Set<Procedure> getProcedures()
    {
        return(procedures);
    }
    
    // Mutators
    public void setID(int argID)
    {
        this.ID = argID;
    }
    
    public void setName(String argName)
    {
        this.Name = argName;
    }
    
    public void setType(String argType)
    {
        this.Type = argType;
    }
    
    public void setBreed(String argBreed)
    {
        this.Breed = argBreed;
    }
    
    public void setAge(int argAge)
    {
        this.Age = argAge;
    }
    
    public void setUserInPet(User argUser)
    {
        this.UserInPet = argUser;
    }
    
    public void setInvoice(Invoice argInvoice)
    {
        this.invoices.add(argInvoice);
    }
    
    public void setInvoices(Set argInvoice)
    {
        this.invoices = argInvoice;
    }
    
    public void setProcedure(Procedure arg)
    {
        this.procedures.add(arg);
    }
    
    public void setProcedures(Set arg)
    {
        this.procedures = arg;
    }
}
