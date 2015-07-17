package com.catalyst.User.Model;

import java.util.Set;
import java.util.HashSet;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import org.hibernate.validator.constraints.Email;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Users")
public class User implements Serializable
{
    @Id
    @GenericGenerator(name = "ID_Generator", strategy = "increment") // Generating The ID Value In Sequence
    @GeneratedValue(generator = "ID_Generator")
    @Column(name = "User_ID")
    private int ID;
    
    @Column(name = "Firstname")
    private String Firstname;
    
    @Column(name = "Lastname")
    private String Lastname;
    
    @Column(name = "Address")
    private String Address;
    
    @Column(name = "City")
    private String City;
    
    @Column(name = "State")
    private String State;
    
    @Column(name = "Zip")
    private int Zip;

    @Email
    @Column(name = "Email")
    private String Email;
    
    @Column(name = "Password")
    private String Password;
    
    @Column(name = "Role")
    private String Role;
    
    @Column(name = "Active")
    private int Active;

    //////////////////////////////////////////
    // Relationships
    //////////////////////////////////////////
    @OneToMany(mappedBy = "UserInPet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Pet> pets = new HashSet<>();
    //////////////////////////////////////////
    
    public User() {
    }

    public User(String argFirstname, String argLastname, String argAddress, String argCity, String argState, int argZip, String argEmail, String argPassword)
    {
        this.Firstname  = argFirstname;
        this.Lastname   = argLastname;
        this.Address    = argAddress;
        this.City       = argCity;
        this.State      = argState;
        this.Zip        = argZip;
        this.Email      = argEmail;
        this.Password   = argPassword;
    }
    
    // Getters
    public int getID()
    {
        return(ID);
    }

    public String getFirstname()
    {
        return(Firstname);
    }
    
    public String getLastname()
    {
        return(Lastname);
    }
    
    public String getAddress()
    {
        return(Address);
    }
    
    public String getCity()
    {
        return(City);
    }
    
    public String getState()
    {
        return(State);
    }
    
    public int getZip()
    {
        return(Zip);
    }
    
    public String getEmail()
    {
        return(Email);
    }
    
    public String getPassword()
    {
        return(Password);
    }
    
    public String getRole()
    {
        return(Role);
    }
    
    public int getActive()
    {
        return(Active);
    }
    
    @JsonManagedReference("user-pet")
    public Set<Pet> getPets()
    {
        return(pets);
    }
    
    ///////////////////////////
    
    public void setID(int arg)
    {
        this.ID = arg;
    }
    
    public void setFirstname(String arg)
    {
        this.Firstname = arg;
    }
    
    public void setLastname(String arg)
    {
        this.Lastname = arg;
    }
    
    public void setAddress(String arg)
    {
        this.Address = arg;
    }
    
    public void setCity(String arg)
    {
        this.City = arg;
    }
    
    public void setState(String arg)
    {
        this.State = arg;
    }
    
    public void setZip(int arg)
    {
        this.Zip = arg;
    }
    
    public void setEmail(String arg)
    {
        this.Email = arg;
    }
    
    public void setPassword(String arg)
    {
        this.Password = arg;
    }
    
    public void setRole(String arg)
    {
        this.Role = arg;
    }
    
    public void setActive(int arg)
    {
        this.Active = arg;
    }
    public void setPet(Pet argPet)
    {
        this.pets.add(argPet);
    }
    
    public void setPets(Set argPets)
    {
        this.pets = argPets;
    }
    
    // Method To Execute Before Being Persisted (Save)
    @PrePersist
    void prePersist()
    {
        this.Role   = "Normal User";
        this.Active = 1;
    }
    // Just Basically Inserting Default Values
}