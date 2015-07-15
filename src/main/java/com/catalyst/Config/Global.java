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
    
    
    // This Is Temporary
    public static final String strCountries = "\"Afghanistan\", \"Albania\", \"Algeria\", \"Andorra\", \"Angola\", \"Antigua and Barbuda\",\n" +
"\"Argentina\", \"Armenia\", \"Australia\", \"Austria\", \"Azerbaijan\", \"Bahamas\", \"Bahrain\", \"Bangladesh\",\n" +
"\"Barbados\", \"Belarus\", \"Belgium\", \"Belize\", \"Benin\", \"Bermuda\", \"Bhutan\", \"Bolivia\",\n" +
"\"Bosnia and Herzegovina\", \"Botswana\", \"Brazil\", \"Brunei\", \"Bulgaria\", \"Burkina Faso\", \"Burma\",\n" +
"\"Burundi\", \"Cambodia\", \"Cameroon\", \"Canada\", \"Cape Verde\", \"Central African Republic\", \"Chad\",\n" +
"\"Chile\", \"China\", \"Colombia\", \"Comoros\", \"Congo, Democratic Republic\", \"Congo, Republic of the\",\n" +
"\"Costa Rica\", \"Cote d'Ivoire\", \"Croatia\", \"Cuba\", \"Cyprus\", \"Czech Republic\", \"Denmark\", \"Djibouti\",\n" +
"\"Dominica\", \"Dominican Republic\", \"East Timor\", \"Ecuador\", \"Egypt\", \"El Salvador\",\n" +
"\"Equatorial Guinea\", \"Eritrea\", \"Estonia\", \"Ethiopia\", \"Fiji\", \"Finland\", \"France\", \"Gabon\",\n" +
"\"Gambia\", \"Georgia\", \"Germany\", \"Ghana\", \"Greece\", \"Greenland\", \"Grenada\", \"Guatemala\", \"Guinea\",\n" +
"\"Guinea-Bissau\", \"Guyana\", \"Haiti\", \"Honduras\", \"Hong Kong\", \"Hungary\", \"Iceland\", \"India\",\n" +
"\"Indonesia\", \"Iran\", \"Iraq\", \"Ireland\", \"Israel\", \"Italy\", \"Jamaica\", \"Japan\", \"Jordan\",\n" +
"\"Kazakhstan\", \"Kenya\", \"Kiribati\", \"Korea, North\", \"Korea, South\", \"Kuwait\", \"Kyrgyzstan\", \"Laos\",\n" +
"\"Latvia\", \"Lebanon\", \"Lesotho\", \"Liberia\", \"Libya\", \"Liechtenstein\", \"Lithuania\", \"Luxembourg\",\n" +
"\"Macedonia\", \"Madagascar\", \"Malawi\", \"Malaysia\", \"Maldives\", \"Mali\", \"Malta\", \"Marshall Islands\",\n" +
"\"Mauritania\", \"Mauritius\", \"Mexico\", \"Micronesia\", \"Moldova\", \"Mongolia\", \"Morocco\", \"Monaco\",\n" +
"\"Mozambique\", \"Namibia\", \"Nauru\", \"Nepal\", \"Netherlands\", \"New Zealand\", \"Nicaragua\", \"Niger\",\n" +
"\"Nigeria\", \"Norway\", \"Oman\", \"Pakistan\", \"Panama\", \"Papua New Guinea\", \"Paraguay\", \"Peru\",\n" +
"\"Philippines\", \"Poland\", \"Portugal\", \"Qatar\", \"Romania\", \"Russia\", \"Rwanda\", \"Samoa\", \"San Marino\",\n" +
"\"Sao Tome\", \"Saudi Arabia\", \"Senegal\", \"Serbia and Montenegro\", \"Seychelles\", \"Sierra Leone\",\n" +
"\"Singapore\", \"Slovakia\", \"Slovenia\", \"Solomon Islands\", \"Somalia\", \"South Africa\", \"Spain\",\n" +
"\"Sri Lanka\", \"Sudan\", \"Suriname\", \"Swaziland\", \"Sweden\", \"Switzerland\", \"Syria\", \"Taiwan\",\n" +
"\"Tajikistan\", \"Tanzania\", \"Thailand\", \"Togo\", \"Tonga\", \"Trinidad and Tobago\", \"Tunisia\", \"Turkey\",\n" +
"\"Turkmenistan\", \"Uganda\", \"Ukraine\", \"United Arab Emirates\", \"United Kingdom\", \"United States\",\n" +
"\"Uruguay\", \"Uzbekistan\", \"Vanuatu\", \"Venezuela\", \"Vietnam\", \"Yemen\", \"Zambia\", \"Zimbabwe\"";
    
    public static final String strCapitals = "\"Abu Dhabi\", \"Abuja\", \"Accra\", \"Adamstown\", \"Addis Ababa\", \"Algiers\", \"Alofi\", \"Amman\", \"Amsterdam\",\n" +
"\"Andorra la Vella\", \"Ankara\", \"Antananarivo\", \"Apia\", \"Ashgabat\", \"Asmara\", \"Astana\", \"Asunción\", \"Athens\",\n" +
"\"Avarua\", \"Baghdad\", \"Baku\", \"Bamako\", \"Bandar Seri Begawan\", \"Bangkok\", \"Bangui\", \"Banjul\", \"Basseterre\",\n" +
"\"Beijing\", \"Beirut\", \"Belgrade\", \"Belmopan\", \"Berlin\", \"Bern\", \"Bishkek\", \"Bissau\", \"Bogotá\", \"Brasília\",\n" +
"\"Bratislava\", \"Brazzaville\", \"Bridgetown\", \"Brussels\", \"Bucharest\", \"Budapest\", \"Buenos Aires\", \"Bujumbura\",\n" +
"\"Cairo\", \"Canberra\", \"Caracas\", \"Castries\", \"Cayenne\", \"Charlotte Amalie\", \"Chisinau\", \"Cockburn Town\",\n" +
"\"Conakry\", \"Copenhagen\", \"Dakar\", \"Damascus\", \"Dhaka\", \"Dili\", \"Djibouti\", \"Dodoma\", \"Doha\", \"Douglas\",\n" +
"\"Dublin\", \"Dushanbe\", \"Edinburgh of the Seven Seas\", \"El Aaiún\", \"Episkopi Cantonment\", \"Flying Fish Cove\",\n" +
"\"Freetown\", \"Funafuti\", \"Gaborone\", \"George Town\", \"Georgetown\", \"Georgetown\", \"Gibraltar\", \"King Edward Point\",\n" +
"\"Guatemala City\", \"Gustavia\", \"Hagåtña\", \"Hamilton\", \"Hanga Roa\", \"Hanoi\", \"Harare\", \"Hargeisa\", \"Havana\",\n" +
"\"Helsinki\", \"Honiara\", \"Islamabad\", \"Jakarta\", \"Jamestown\", \"Jerusalem\", \"Juba\", \"Kabul\", \"Kampala\",\n" +
"\"Kathmandu\", \"Khartoum\", \"Kiev\", \"Kigali\", \"Kingston\", \"Kingston\", \"Kingstown\", \"Kinshasa\", \"Kuala Lumpur\",\n" +
"\"Kuwait City\", \"Libreville\", \"Lilongwe\", \"Lima\", \"Lisbon\", \"Ljubljana\", \"Lomé\", \"London\", \"Luanda\", \"Lusaka\",\n" +
"\"Luxembourg\", \"Madrid\", \"Majuro\", \"Malabo\", \"Malé\", \"Managua\", \"Manama\", \"Manila\", \"Maputo\", \"Marigot\",\n" +
"\"Maseru\", \"Mata-Utu\", \"Mbabane Lobamba\", \"Melekeok Ngerulmud\", \"Mexico City\", \"Minsk\", \"Mogadishu\", \"Monaco\",\n" +
"\"Monrovia\", \"Montevideo\", \"Moroni\", \"Moscow\", \"Muscat\", \"Nairobi\", \"Nassau\", \"Naypyidaw\", \"N'Djamena\",\n" +
"\"New Delhi\", \"Niamey\", \"Nicosia\", \"Nicosia\", \"Nouakchott\", \"Nouméa\", \"Nukuʻalofa\", \"Nuuk\", \"Oranjestad\",\n" +
"\"Oslo\", \"Ottawa\", \"Ouagadougou\", \"Pago Pago\", \"Palikir\", \"Panama City\", \"Papeete\", \"Paramaribo\", \"Paris\",\n" +
"\"Philipsburg\", \"Phnom Penh\", \"Plymouth Brades Estate\", \"Podgorica Cetinje\", \"Port Louis\", \"Port Moresby\",\n" +
"\"Port Vila\", \"Port-au-Prince\", \"Port of Spain\", \"Porto-Novo Cotonou\", \"Prague\", \"Praia\", \"Cape Town\",\n" +
"\"Pristina\", \"Pyongyang\", \"Quito\", \"Rabat\", \"Reykjavík\", \"Riga\", \"Riyadh\", \"Road Town\", \"Rome\", \"Roseau\",\n" +
"\"Saipan\", \"San José\", \"San Juan\", \"San Marino\", \"San Salvador\", \"Sana'a\", \"Santiago\", \"Santo Domingo\",\n" +
"\"São Tomé\", \"Sarajevo\", \"Seoul\", \"Singapore\", \"Skopje\", \"Sofia\", \"Sri Jayawardenepura Kotte\", \"St. George's\",\n" +
"\"St. Helier\", \"St. John's\", \"St. Peter Port\", \"St. Pierre\", \"Stanley\", \"Stepanakert\", \"Stockholm\", \"Sucre\",\n" +
"\"Sukhumi\", \"Suva\", \"Taipei\", \"Tallinn\", \"Tarawa Atoll\", \"Tashkent\", \"Tbilisi\", \"Tegucigalpa\", \"Tehran\",\n" +
"\"Thimphu\", \"Tirana\", \"Tiraspol\", \"Tokyo\", \"Tórshavn\", \"Tripoli\", \"Tskhinvali\", \"Tunis\", \"Ulan Bator\", \"Vaduz\",\n" +
"\"Valletta\", \"The Valley\", \"Vatican City\", \"Victoria\", \"Vienna\", \"Vientiane\", \"Vilnius\", \"Warsaw\",\n" +
"\"Washington, D.C.\", \"Wellington\", \"West Island\", \"Willemstad\", \"Windhoek\", \"Yamoussoukro\", \"Yaoundé\", \"Yaren\",\n" +
"\"Yerevan\", \"Zagreb\"";
    
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