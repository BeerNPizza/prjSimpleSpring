package com.catalyst.Config;

/*
                                Info:
    Database Script Is Attached To Project Inside The 'Other Sources' Folder
    
    1.) Edit The SQL Script With Correct Path For Your PC (At Top Of File)
    2.) Configure Database Settings Below
*/
public class Global
{    
    // Web Page Titles And Stuff
    public static final String ProjectTitle         = "<b>Val's</b> Vet Clinic";
    public static final String IndexPageTitle       = "Welcome!";
    public static final String LoginPageTitle       = "Please Login To Continue";
    public static final String ListPageTitle        = "User List";
    public static final String RegisterPageTitle    = "Create An Account To Continue";
    public static final String AdminPageTitle       = "Admin Dashboard";
    public static final String PatientPageTitle     = "Patients List";
    public static final String ClientPageTitle      = "Client List";
    
    // Database Configuration Below
    public static final String DBName               = "APP";
    public static final String DBInstance           = "PC30124";    // Edit This
    public static final String DBUrl                = "jdbc:jtds:sqlserver://127.0.0.1;instance=" + DBInstance + ";DatabaseName=" + DBName;
    public static final String DBDriver             = "net.sourceforge.jtds.jdbc.Driver";
    public static final String DBUser               = "sa";             // Edit This
    public static final String DBPass               = "root";           // Edit This
    public static final String DBDialect            = "org.hibernate.dialect.SQLServerDialect";
    
    // For Me
    public static final String ProjectVersion       = "v1.1";
    public static final String ProjectDateTime      = "7/10/15-5:33pm";
    
/*
                            Change Log:
    [*] = Fix
    [+] = Added
    [-] = Removed
    [!] = To Do
    
    [!][7.9.15]  - To Do Display Only 10 Results Per Page (Clients/Patients..etc)
    [!][7.7.15]  - To Do Create An 'Advanced Search Module'
    [!][7.7.15]  - To Do Create Procedure Table
    [!][7.2.15]  - To Do Conceive Methods Unique To Entities
    [!][7.2.15]  - To Do Add An 'Edit' Page With User's ID In The Request Example: ( /Edit/{Id} )
    [!][7.2.15]  - To Do Add Javax Validation To Models
    [!][7.2.15]  - To Do Add Binding Result To Registration Controller (+ Any Controller With Input)

    [+][7.16.15] - Fixed API Problem! Prior, I was doing an EAGER load on entities to load all their pointers.
                   Now I created a new method in the service layer that Automaps entity to entity.
                   Reason why this remedys the problem is because I am copying the entity out of state.
                   Method is -> findByID_API(int argID) and its a generic method across service layers.
    [+][7.13.15] - Added Procedures Table + Modal To Create New Procedures
    [+][7.11.15] - Added Create Procedure Modal To Patients Page
    [+][7.11.15] - Added JQuery Validation To All Fields In Client/Add Modal
    [+][7.10.15] - Added Dropdown To Patient Wizard To Display Users To Associate With (Patients Page)
    [*][7.10.15] - Fixed JSON API To Output Relational Data (Data From Multiple Tables)
    [*][7.9.15]  - Changed All Existing Plain Javascript Into JQuery
    [+][7.9.15]  - Added Form Validation To Clients.jsp
    [+][7.9.15]  - Added Create User Modal [NOT Functional Yet]
    [+][7.9.15]  - Added JacksonJSON Web API Example
    [+][7.7.15]  - Added Error Handling To JSTL Table Output For Clients / Pets (Empty Check)
    [+][7.7.15]  - Added Logout Confirmation Modal To All Pages
    [+][7.7.15]  - Added More Info To Patient Tracking (Owner's Firstname / Lastname)
    [+][7.7.15]  - Added Logic To Front/Middle Layer To Search Pets By Name
    [+][7.7.15]  - Added Logic To Front/Middle Layer To Search Users By Firstname
    [+][7.7.15]  - Added getUsersByFirstname() In User Functionality
    [+][7.7.15]  - Added getPetsByName() In Pet Functionality
    [+][7.7.15]  - Added New Admin Template
    [+][7.6.15]  - Added getPasswordByEmail(String argEmail) -> Returns (String)Password
    [+][7.6.15]  - Added Login Functionality
    [+][7.6.15]  - Added Custom Exception Handling During Runtime
    [+][7.6.15]  - Added getUserByEmailAndPassword() But I Think I Need To Re-Write This
    [+][7.6.15]  - Added getUserByEmail()
    [+][7.6.15]  - Added Appointment And Invoice Entities
    [+][7.2.15]  - Added Empty DAO's For Each Entity (So We Can Put Custom Functions In There)
    [+][7.2.15]  - Added Generic Service Layer
    [+][7.2.15]  - Added Generic DAO Layer
    [-][7.2.15]  - Removed Utility Functions From User Service Layer (Gonna Make A Utility Service)
    [+][7.2.15]  - Registration Page Displays Output Of Registration Operation (Bootstrap Alert)
    [+][7.2.15]  - Added Pet List And Invoice List To List Page
    [+][7.2.15]  - Added Invoice Entity + Assigned It To A Pet
    [+][7.1.15]  - Added Pet Entity + Assigned It To A User
    [+][7.1.15]  - Added Password Encryption
    [+][6.30.15] - Added findUserByEmail() Method
    [+][6.30.15] - Added AbstractDAO Class To Handle Session & Hibernate API Calls
    [*][6.30.15] - Fixed Listing Of All Users. Problem Was Null ID Values
    [+][6.29.15] - Added Registration Page/Controller To Insert New Users
*/
}