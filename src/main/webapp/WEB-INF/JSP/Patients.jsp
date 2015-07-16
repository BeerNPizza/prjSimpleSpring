<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <title>${PageTitle}</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width">
    
    <!-- Favicon -->
    <link rel="icon" type="image/png" sizes="32x32" href="<c:url value="/Resources/Images/Favico.png" />">
    
    <!-- Theme Style -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/Resources/CSS/Templatemo_Main.css" />" >
    
    <!-- JQuery Calendar -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/Resources/CSS/DateTimePicker.css" />" />
</head>
<body>
  <div class="navbar navbar-inverse" role="navigation">
      <div class="navbar-header">
        <div class="logo"><h1>${INJECT_STUFF_HERE}</h1></div>
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button> 
      </div>   
    </div>
    <div class="template-page-wrapper">
      <div class="navbar-collapse collapse templatemo-sidebar">
        <ul class="templatemo-sidebar-menu">
          <li><a href="${pageContext.request.contextPath}/Admin"><i class="fa fa-home"></i>Home</a></li>
          <li><a href="${pageContext.request.contextPath}/Admin/Clients"><i class="fa fa-users"></i>Clients</a></li>
          <li class="active"><a href="${pageContext.request.contextPath}/Admin/Patients"><i class="fa fa-paw"></i>Patients</a></li>
          <li><a href="${pageContext.request.contextPath}/Admin/Appointments"><i class="fa fa-calendar"></i>Appointments</a></li>
          <li><a href="${pageContext.request.contextPath}/Admin/#"><i class="fa fa-book"></i>Inventory <small>(Disabled)</small></a></li>
          <li><a href="${pageContext.request.contextPath}/Admin/#"><i class="fa fa-credit-card"></i>Invoices <small>(Disabled)</small></a></li>
          <li><a href="${pageContext.request.contextPath}/Admin/#"><i class="fa fa-cog"></i>Preferences <small>(Disabled)</small></a></li>
          <li><a href="#" onclick="$('#confirmLogoutModal').modal('show')"><i class="fa fa-sign-out"></i>Sign Out</a></li>
        </ul>
      </div><!--/.navbar-collapse -->

      <div class="templatemo-content-wrapper">
        <div class="templatemo-content">
          <ol class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/Admin">Admin Panel</a></li>
            <li><a href="${pageContext.request.contextPath}/Admin">Dashboard</a></li>
            <li class="active">Patients</li>
          </ol>
          <h1>Patients</h1>
          <p>View, Edit Or Delete Patients</p>

          <div class="margin-bottom-30">
            <div class="row">
              <div class="col-md-12">
                <ul class="nav nav-pills">
                    <li class="active"><a href="#" onclick="$('#CreatePatientModal').modal('show')"><i class="fa fa-plus"></i> Add Patient</a></li>
                    <li class="active"><a href="#" onclick="$('#CreateProcedureModal').modal('show')"><i class="fa fa-plus"></i> Add Procedure</a></li>
                </ul>          
              </div>
            </div>
          </div>         

        <!-- Search Bar -->
        <div class="row">
            <div class="col-md-4 pull-left">
                <div class="input-group">
                    <input type="text" class="form-control" name="patient_search" id="patient_search" placeholder="Search...">
                    <span class="input-group-btn"><a href="${pageContext.request.contextPath}/Admin/Patients/Name" class="btn btn-default" name="search_button" id="search_button" onclick="prepare_link();"><i class="fa fa-search"></i></a></span>
                    <span class="input-group-btn"><button class="btn btn-default" type="button">Advanced</button></span>
                </div>
            </div>
        </div>
        
          <div class="templatemo-panels">
            <c:if test="${!empty listPets}"> <!-- If Not Empty-->
            <div class="row">
              <div class="col-md-12 col-sm-6 margin-bottom-30">
                <div class="panel panel-primary">
                  <div class="panel-heading">Patient Table</div>
                    <div class="table-responsive">
                    <table class="table table-striped table-hover table-bordered">
                      <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Type</th>
                            <th>Breed</th>
                            <th>Age</th>
                            <th>Owner (User_ID)</th>
                            <th>Actions</th>
                        </tr>
                      </thead>
                      <c:forEach items="${listPets}" var="pet">
                        <tbody>
                            <tr>
                                <td>${pet.ID}</td>
                                <td>${pet.name}</td>
                                <td>${pet.type}</td>
                                <td>${pet.breed}</td>
                                <td>${pet.age}</td>
                                <td>${pet.userInPet.ID} (${pet.userInPet.firstname} ${pet.userInPet.lastname})<a href="#" class="btn btn-default pull-right">View</a></td>
                                <td>
                                <!-- Action Button -->
                                <div class="btn-group pull-right">
                                  <button type="button" class="btn btn-info">Action</button>
                                  <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown">
                                    <span class="caret"></span>
                                    <span class="sr-only">Toggle Dropdown</span>
                                  </button>
                                  <ul class="dropdown-menu" role="menu">
                                    <li><a href="#"><i class="fa fa-info-circle"></i> View</a></li>
                                    <li><a href="#"><i class="fa fa-pencil-square-o"></i> Edit</a></li>
                                    <li><a href="#"><i class="fa fa-times-circle"></i> Delete</a></li>
                                  </ul>
                                </div>
                              </td>
                            </tr>
                        </tbody>
                      </c:forEach>
                    </table>
                    </c:if>
                    <c:if test="${empty listPets}"> <!-- If Empty-->
                        <h3>No Patients Found</h3>
                    </c:if>    
                  </div>
                </div>
              </div>       
            </div>
          </div>    
        </div>
      </div>
      <!-- Logout Confirmation Module -->
      <div class="modal fade" id="confirmLogoutModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
              <h4 class="modal-title" id="myModalLabel"><i class="fa fa-question-circle"></i> Confirmation</h4>
            </div>
            <div class="modal-body text-center">
                <p>Are you sure you want to sign out?</p>
            </div>
            <div class="modal-footer">
              <a href="${pageContext.request.contextPath}/Login" class="btn btn-primary"><i class="fa fa-check"></i> Yes</a>
              <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> No</button>
            </div>
          </div>
        </div>
      </div>
      
            <!-- Add Client Modal (Country Not Used Yet)-->
      <div class="modal fade" id="CreatePatientModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
              <h4 class="modal-title" id="myModalLabel"><i class="fa fa-paw"></i> Create A New Patient</h4>
            </div>
            <div class="modal-body text-center">
            <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/Register/Patient" method="POST">
            <fieldset>

               <div class="form-group">
                    <label class="col-sm-2 control-label" for="textinput">Name</label>
                    <div class="col-sm-4">
                        <input type="text" name="Name" placeholder="Name" class="form-control">
                    </div>

                    <label class="col-sm-2 control-label" for="textinput">Type</label>
                    <div class="col-sm-4">
                        <select name="Type" class="form-control">
                            <option value="Bovine">Bovine (Cattle)</option>
                            <option value="Canine">Canine (Dog)</option>
                            <option value="Cervine">Cervine (Deer)</option>
                            <option value="Elapine">Elapine (Snake)</option>
                            <option value="Equine">Equine (Horse)</option>
                            <option value="Feline">Feline (Cat)</option>
                            <option value="Hircine">Hircine (Goat)</option>
                            <option value="Murine">Murine (Rodent)</option>
                            <option value="Piscine">Piscine (Fish)</option>
                            <option value="Porcine">Porcine (Pig)</option>
                            <option value="Ursine">Ursine (Bear)</option>
                            <option value="Vulpine">Vulpine (Fox)</option>
                        </select>
                    </div>   
              </div>

              <!-- Text input-->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="textinput">Breed</label>
                    <div class="col-sm-6">
                        <input type="text" name="Breed" placeholder="Breed (Ex: German Shepherd)" class="form-control">
                    </div>

                    <div class="col-sm-4">
                        <select name="Age" class="form-control">
                            <option value="" disabled selected>Age (Years)</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="1">3</option>
                            <option value="2">4</option>
                            <option value="1">5</option>
                            <option value="2">6</option>
                            <option value="1">7</option>
                            <option value="2">8</option>
                            <option value="1">9</option>
                            <option value="2">10</option>
                            <option value="1">11</option>
                            <option value="2">12</option>
                            <option value="1">13</option>
                            <option value="2">14</option>
                            <option value="1">15</option>
                            <option value="2">16</option>
                            <option value="1">17</option>
                            <option value="2">18</option>
                            <option value="1">19</option>
                            <option value="2">20</option>
                            <option value="1">21</option>
                            <option value="2">22</option>
                            <option value="1">23</option>
                            <option value="2">24</option>
                            <option value="1">25</option>
                            <option value="2">26</option>
                            <option value="1">27</option>
                            <option value="2">28</option>
                            <option value="1">29</option>
                            <option value="2">30</option>  
                        </select>
                    </div>
              </div>          
              
              <div class="form-group">
                <label class="col-sm-2 control-label" for="textinput">Owner</label>
                <div class="col-sm-10">
                    <select name="UserID" class="form-control">
                        <c:forEach items="${listUsers}" var="user">
                            <option value="${user.ID}">${user.firstname} ${user.lastname} (${user.email})</option>
                        </c:forEach> 
                    </select>
                </div>
              </div>

              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Cancel</button>
                <button type="submit" class="btn btn-primary"><i class="fa fa-check"></i> Save</button>
              </div>
            </fieldset>
            </form>
            </div>

          </div>
        </div>
      </div>
            
      <div class="modal fade" id="CreateProcedureModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
              <h4 class="modal-title" id="myModalLabel"><i class="fa fa-paw"></i> Create A New Procedure</h4>
            </div>
            <div class="modal-body text-center">
            <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/Register/Procedure" method="POST">
            <fieldset>

               <div class="form-group">
                <div class="col-sm-12">
                    <select name="PetID" class="form-control">
                        <c:forEach items="${listPets}" var="pet">
                            <option value="${pet.ID}">${pet.name} (${pet.type}/${pet.breed}) (${pet.userInPet.firstname} ${pet.userInPet.lastname})</option>
                        </c:forEach> 
                    </select>
                </div>
              </div> 

              <!-- Text input-->
                <div class="form-group">		
                    <div class="col-sm-12">
                        <input type="text" name="ProcedureName" placeholder="Procedure Name" class="form-control">
                    </div>
		</div>

              <div class="form-group">
                    <div class="col-sm-12">
                       <textarea class="form-control" rows="5" placeholder="Description Of The Procedure" name="ProcedureDescription" id="ProcedureDescription"></textarea>
                    </div>
                </div>
              
              <div class="form-group">
                    <div class="col-sm-6">
                        <input type="text" name="ProcedureCost" placeholder="Cost Of The Procedure ($)" class="form-control">
                    </div>
                    
                    <div class="col-sm-6">
                        <input type="text" name="ProcedureDate" data-field="datetime" readonly placeholder="Time/Date" class="form-control">
                        <div id="dtBox"></div>
                    </div>
                    
                    
                </div>

              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Cancel</button>
                <button type="submit" class="btn btn-primary"><i class="fa fa-check"></i> Save</button>
              </div>
            </fieldset>
            </form>
            </div>

          </div>
        </div>
      </div>
              
      <footer class="templatemo-footer">
        <div class="templatemo-copyright">
          <p>Copyright &copy; 2014 Val's Vet Office</p>
        </div>
      </footer>
    </div>
    <!-- END Client Creation Modal -->

    <script src="<c:url value="/Resources/JS/JQuery.min.js" />"></script>
    <script src="<c:url value="/Resources/JS/Bootstrap.min.js" />"></script>
    <script src="<c:url value="/Resources/JS/Templatemo_Script.js" />"></script>
    
    <!-- JQuery Calendar -->
    <script src="<c:url value="/Resources/JS/JQuery.UI.js" />"></script>
    <script src="<c:url value="/Resources/JS/DateTimePicker.js" />"></script>
    
    <script type="text/javascript">
    /*
     * JQuery Date Picker
     */
    $(function()
    {
        $( "#datepicker" ).datepicker();
    });
    
    $(document).ready(function()
    {
        $("#dtBox").DateTimePicker();
    });

    
    /*
     *  JQuery Function To Submit A Search After Pressing Enter In Search Box
     */
    $('#patient_search').keypress(function(event)
    {
        if(event.which == 13)
        {
            $('#search_button')[0].click();
        }
    });
    
    /*
     *  Convert Input To Formatted API Search
     */    
    $("#search_button").click(function()
    {
        if($("#patient_search").val().length > 0)
        {
            $(this).attr('href', $(this).attr("href") + '/' + $('#patient_search').val());
        }
        else
        {
            alert("Input Seems Bad");
            return(false);
        }
    });
    </script>
    
    
</body>
</html>