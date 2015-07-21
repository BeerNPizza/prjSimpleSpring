package com.catalyst.DTO;

import java.util.Date;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProcedureRegistrationDTO
{
    @Size(min = 2, max = 32, message = "Procedure Name must be between 2 and 32 characters")
    private String ProcedureName;

    @Size(min = 0, max = 256, message = "Procedure Description must be between 0 and 256 characters")
    private String ProcedureDescription;
    
    @NotNull(message = "Procedure Cost cannot be empty")
    private int ProcedureCost;
    
    @Future
    private Date ProcedureDate;

    public String getProcedureName() {
        return ProcedureName;
    }

    public String getProcedureDescription() {
        return ProcedureDescription;
    }

    public int getProcedureCost() {
        return ProcedureCost;
    }

    public Date getProcedureDate() {
        return ProcedureDate;
    }

    public void setProcedureName(String ProcedureName) {
        this.ProcedureName = ProcedureName;
    }

    public void setProcedureDescription(String ProcedureDescription) {
        this.ProcedureDescription = ProcedureDescription;
    }

    public void setProcedureCost(int ProcedureCost) {
        this.ProcedureCost = ProcedureCost;
    }

    public void setProcedureDate(Date ProcedureDate) {
        this.ProcedureDate = ProcedureDate;
    }
}