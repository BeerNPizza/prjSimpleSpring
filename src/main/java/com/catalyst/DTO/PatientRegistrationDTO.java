package com.catalyst.DTO;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.NotEmpty;

public class PatientRegistrationDTO
{
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters")
    private String Name;

    @Size(min = 2, max = 32, message = "Type must be between 2 and 32 characters")
    private String Type;

    @NotEmpty
    private String Breed;
    
    @NotNull
    @Range(min = 0, max = 100, message = "Age must be between 0 and 100")
    private int Age;


    public String getName() {
        return Name;
    }

    public String getType() {
        return Type;
    }

    public String getBreed() {
        return Breed;
    }

    public int getAge() {
        return Age;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setBreed(String Breed) {
        this.Breed = Breed;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }
}