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
    <link rel="stylesheet" type="text/css" href="<c:url value="/Resources/CSS/Templatemo_Main.css" />" >
    
    <!-- Country Flags -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/Resources/CSS/Bootstrap-Formhelpers.css" />" >
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
          <li class="active"><a href="${pageContext.request.contextPath}/Admin/Clients"><i class="fa fa-users"></i><span class="badge pull-right">57</span> Clients</a></li>
          <li><a href="${pageContext.request.contextPath}/Admin/Patients"><i class="fa fa-paw"></i><span class="badge pull-right">63</span> Patients</a></li>
          <li><a href="${pageContext.request.contextPath}/Admin/Appointments"><i class="fa fa-calendar"></i><span class="badge pull-right">9</span> Appointments</a></li>
          <li><a href="${pageContext.request.contextPath}/#"><i class="fa fa-book"></i><span class="badge pull-right">42</span> Inventory</a></li>
          <li><a href="${pageContext.request.contextPath}/Admin/Invoices"><i class="fa fa-credit-card"></i><span class="badge pull-right">12</span> Invoices</a></li>
          <li><a href="${pageContext.request.contextPath}/#"><i class="fa fa-cog"></i>Preferences</a></li>
          <li><a href="javascript:;" data-toggle="modal" data-target="#confirmLogoutModal"><i class="fa fa-sign-out"></i>Sign Out</a></li>
        </ul>
      </div><!--/.navbar-collapse -->

      <div class="templatemo-content-wrapper">
        <div class="templatemo-content">
          <ol class="breadcrumb">
            <li><a href="Admin">Admin Panel</a></li>
            <li><a href="#">Dashboard</a></li>
            <li class="active">Clients</li>
          </ol>
          <h1>Clients</h1>
          <p>View, Edit Or Delete Clients</p>

          <div class="margin-bottom-30">
            <div class="row">
              <div class="col-md-12">
                <ul class="nav nav-pills">
                  <li class="active"><a href="javascript:;" data-toggle="modal" data-target="#CreateClientModal"><i class="fa fa-plus"></i> Add Client</a></li>
                </ul>          
              </div>
            </div>
          </div>         

        <!-- Search Bar -->
        <div class="row">
            <div class="col-md-4 pull-left">
                <div class="input-group">
                    <input type="text" class="form-control" name="client_search" id="client_search" placeholder="Search...">
                    <span class="input-group-btn"><a href="${pageContext.request.contextPath}/Admin/Clients/Firstname" class="btn btn-default" name="search_button" id="search_button"><i class="fa fa-search"></i></a></span>
                    <span class="input-group-btn"><button class="btn btn-default" type="button">Advanced</button></span>
                </div>
            </div>
        </div>
                  
          <div class="templatemo-panels">
            <c:if test="${!empty listUsers}"> <!-- If Not Empty-->
            <div class="row">
              <div class="col-md-12 col-sm-6 margin-bottom-30">
                <div class="panel panel-primary">
                  <div class="panel-heading">User Table</div>
                    <div class="table-responsive">
                    <table class="table table-striped table-hover table-bordered">
                      <thead>
                        <tr>
                          <th>#</th>
                          <th>First Name</th>
                          <th>Last Name</th>
                          <th>Address</th>
                          <th>City</th>
                          <th>State</th>
                          <th>Zip</th>
                          <th>Email</th>
                          <th>Actions</th>
                        </tr>
                      </thead>
                      <c:forEach items="${listUsers}" var="user">
                        <tbody>
                                <c:choose>
                                    <c:when test="${user.active == 1}"> <!-- When 1 Then Active -->
                                        <tr class="success">
                                    </c:when>
                                    <c:when test="${user.active == 0}"> <!-- When 0 Then Inactive -->
                                        <tr class="danger">
                                    </c:when>
                                    <c:otherwise>                       <!-- Otherwise: Consider Inactive -->
                                        <tr class="danger">
                                    </c:otherwise>
                                </c:choose>
                                <td>${user.ID}</td>
                                <td>${user.firstname}</td>
                                <td>${user.lastname}</td>
                                <td>${user.address}</td>
                                <td>${user.city}</td>
                                <td>${user.state}</td>
                                <td>${user.zip}</td>
                                <td>${user.email}</td>
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
                    <c:if test="${empty listUsers}"> <!-- If Empty-->
                        <h3>No Clients Found</h3>
                    </c:if>  
                  </div>
                </div>
              </div>       
            </div>
          </div>    
        </div>
      </div>
      <!-- Logout Confirmation Modal -->
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
      <div class="modal fade" id="CreateClientModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
              <h4 class="modal-title" id="myModalLabel"><i class="fa fa-user"></i> Create A New Client</h4>
            </div>
            <div class="modal-body text-center">
            <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/Register/Client" method="POST">
            <fieldset>

               <div class="form-group">
                <label class="col-sm-2 control-label" for="textinput">Firstname</label>
                <div class="col-sm-4">
                  <input type="text" name="Firstname" placeholder="First Name" class="form-control">
                </div>

                <label class="col-sm-2 control-label" for="textinput">Lastname</label>
                <div class="col-sm-4">
                  <input type="text" name="Lastname" placeholder="Last Name" class="form-control">
                </div>
              </div>

                <!-- Country Name + Flag Dropdown -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="textinput">Country</label>
                    <div class="col-sm-10">
                        <div id="countries_states2" class="bfh-selectbox bfh-countries" data-country="US" data-flags="true">
                            <input name="Country" type="hidden" value="">
                            <a class="bfh-selectbox-toggle" role="button" data-toggle="bfh-selectbox" href="#">
                                <span class="bfh-selectbox-option input-medium" data-option=""></span>
                                <b class="caret"></b>
                            </a>
                            <div class="bfh-selectbox-options">
                                <div role="listbox"></div>
                            </div>
                        </div>
                    </div>
                </div>
                              
              <!-- Text input-->
              <div class="form-group">
                <label class="col-sm-2 control-label" for="textinput">Address</label>
                <div class="col-sm-10">
                  <input type="text" name="Address" placeholder="Address" class="form-control">
                </div>
              </div>

              <!-- Text input-->
              <div class="form-group">
                <label class="col-sm-2 control-label" for="textinput">City</label>
                <div class="col-sm-10">
                  <input type="text" name="City" placeholder="City" class="form-control">
                </div>
              </div>

              <!-- Text input-->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="textinput">State</label>
                    <div class="col-sm-4">
                        <select id="State" name="State" class="form-control">
                            <option value="AL">Alabama</option>
                            <option value="AK">Alaska</option>
                            <option value="AZ">Arizona</option>
                            <option value="AR">Arkansas</option>
                            <option value="CA">California</option>
                            <option value="CO">Colorado</option>
                            <option value="CT">Connecticut</option>
                            <option value="DE">Delaware</option>
                            <option value="DC">District Of Columbia</option>
                            <option value="FL">Florida</option>
                            <option value="GA">Georgia</option>
                            <option value="HI">Hawaii</option>
                            <option value="ID">Idaho</option>
                            <option value="IL">Illinois</option>
                            <option value="IN">Indiana</option>
                            <option value="IA">Iowa</option>
                            <option value="KS">Kansas</option>
                            <option value="KY">Kentucky</option>
                            <option value="LA">Louisiana</option>
                            <option value="ME">Maine</option>
                            <option value="MD">Maryland</option>
                            <option value="MA">Massachusetts</option>
                            <option value="MI">Michigan</option>
                            <option value="MN">Minnesota</option>
                            <option value="MS">Mississippi</option>
                            <option value="MO">Missouri</option>
                            <option value="MT">Montana</option>
                            <option value="NE">Nebraska</option>
                            <option value="NV">Nevada</option>
                            <option value="NH">New Hampshire</option>
                            <option value="NJ">New Jersey</option>
                            <option value="NM">New Mexico</option>
                            <option value="NY">New York</option>
                            <option value="NC">North Carolina</option>
                            <option value="ND">North Dakota</option>
                            <option value="OH">Ohio</option>
                            <option value="OK">Oklahoma</option>
                            <option value="OR">Oregon</option>
                            <option value="PA">Pennsylvania</option>
                            <option value="RI">Rhode Island</option>
                            <option value="SC">South Carolina</option>
                            <option value="SD">South Dakota</option>
                            <option value="TN">Tennessee</option>
                            <option value="TX">Texas</option>
                            <option value="UT">Utah</option>
                            <option value="VT">Vermont</option>
                            <option value="VA">Virginia</option>
                            <option value="WA">Washington</option>
                            <option value="WV">West Virginia</option>
                            <option value="WI">Wisconsin</option>
                            <option value="WY">Wyoming</option>
                        </select>
                    </div>   

                <label class="col-sm-2 control-label" for="textinput">Postcode</label>
                <div class="col-sm-4">
                  <input type="text" name="Zip" placeholder="Post Code" class="form-control">
                </div>
              </div>              
              
              <div class="form-group">
                <label class="col-sm-2 control-label" for="textinput">Email</label>
                <div class="col-sm-10">
                  <input type="text" name="Email" placeholder="Email Address" class="form-control">
                </div>
              </div>
              
              <div class="form-group">
                <label class="col-sm-2 control-label" for="textinput">Password</label>
                <div class="col-sm-10">
                  <input type="password" name="Password" placeholder="Password" class="form-control">
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
          <p>Copyright &copy; 2015 Val's Vet Office</p>
        </div>
      </footer>
    </div>
    <!-- END Client Creation Modal -->

    <script src="<c:url value="/Resources/JS/JQuery.min.js" />"></script>
    <script src="<c:url value="/Resources/JS/Bootstrap.min.js" />"></script>
    <script src="<c:url value="/Resources/JS/Templatemo_Script.js" />"></script>
    
    <!-- Form Helper JQuery Plugin For Country Flags -->
    <script src="<c:url value="/Resources/JS/Bootstrap.Formhelpers.js" />"></script>
    
    <!-- Input Validator JQuery Plugin For Input Validation -->
    <script src="<c:url value="/Resources/JS/JQuery.Validate.js" />"></script>
    
    <!-- Used For Searching -->
    <script type="text/javascript">
    /*
     * 
     *  JQuery Form Validation
     */
    $('form').validate({
        rules:
        {
            Firstname: {
                minlength: 3,
                maxlength: 15,
                required: true
            },
            Lastname: {
                minlength: 3,
                maxlength: 15,
                required: true
            },
            Address: {
                minlength: 5,
                maxlength: 64,
                required: true
            },
            City: {
                minlength: 3,
                maxlength: 32,
                required: true
            },
            Zip: {
                minlength: 5,
                maxlength: 5,
                required: true
            },
            Email: {
                required: true,
                email: true
            },
            Password: {
                minlength: 6,
                maxlength: 32,
                required: true
            }
        },
        highlight: function(element) {
            $(element).closest('.form-group').addClass('has-error');
        },
        unhighlight: function(element) {
            $(element).closest('.form-group').removeClass('has-error');
        },
        errorElement: 'span',
        errorClass: 'help-block',
        errorPlacement: function(error, element) {
            if(element.parent('.input-group').length) {
                error.insertAfter(element.parent());
            } else {
                error.insertAfter(element);
            }
        }
    });    
        
    /*
     *  JQuery Function To Submit A Search After Pressing Enter In Search Box
     */
    $('#client_search').keypress(function(event)
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
        if($("#client_search").val().length > 0)
        {
            $(this).attr('href', $(this).attr("href") + '/' + $('#client_search').val());
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