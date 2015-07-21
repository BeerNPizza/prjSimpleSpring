package com.catalyst.DTO;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;

public class ClientRegistrationDTO
{
    @Size(min = 2, max = 32, message = "Firstname must be between 2 and 32 characters")
    private String Firstname;
    
    @Size(min = 2, max = 32, message = "Lastname must be between 2 and 32 characters")
    private String Lastname;
    
    @Size(min = 6, max = 64, message = "Address must be between 2 and 64 characters")
    private String Address;
    
    @Size(min = 2, max = 32, message = "City must be between 2 and 32 characters")
    private String City;
    
    @Size(min = 2, max = 2, message = "State must be 2 characters")
    private String State;
    
    @NotNull(message = "Zip cannot be empty")
    private int Zip;

    @Email(message = "Must be an Email")
    @Size(min = 6, max = 32, message = "Email must be between 6 and 32 characters")
    private String Email;
    
    @Size(min = 3, max = 128, message = "Password must be between 6 and 128 characters")
    private String Password;
    
    private String Role;
    
    private int Active;
    
    ///////////////////////////////////////////////////////////////////////

    public String getFirstname() {
        return Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public String getAddress() {
        return Address;
    }

    public String getCity() {
        return City;
    }

    public String getState() {
        return State;
    }

    public int getZip() {
        return Zip;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getRole() {
        return Role;
    }

    public int getActive() {
        return Active;
    }

    ///////////////////////////////////////////////////////////////////////
    
    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public void setState(String State) {
        this.State = State;
    }

    public void setZip(int Zip) {
        this.Zip = Zip;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPassword(String argPass) {
        this.Password = argPass;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public void setActive(int Active) {
        this.Active = Active;
    }
}