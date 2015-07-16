<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
    <title>${PageTitle}</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width">
    <!-- Favicon -->
    <link rel="icon" type="image/png" sizes="32x32" href="<c:url value="/Resources/Images/Favico.png" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/Resources/CSS/Templatemo_Main.css" />" >
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
          <li class="active"><a href="${pageContext.request.contextPath}/Admin"><i class="fa fa-home"></i>Home</a></li>
          <li><a href="${pageContext.request.contextPath}/Admin/Clients"><i class="fa fa-users"></i>Clients</a></li>
          <li><a href="${pageContext.request.contextPath}/Admin/Patients"><i class="fa fa-paw"></i>Patients</a></li>
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
            <li class="active">Overview</li>
          </ol>
          <h1>Dashboard</h1>
          <p>Welcome To Your Dashboard!</p>

          <div class="margin-bottom-30">
            <div class="row">
              <div class="col-md-12">
                <ul class="nav nav-pills">
                  <li class="active"><a href="#">Home</a></li>
                  <li class="active"><a href="#">Appointments <span class="badge">6</span></a></li>
                  <li class="active"><a href="#">Messages <span class="badge">3</span></a></li>
                  <li class="active"><a href="#">Reminders <span class="badge">5</span></a></li>
                </ul>          
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
              
      <footer class="templatemo-footer">
        <div class="templatemo-copyright">
          <p>Copyright &copy; 2015 Val's Vet Office</p>
        </div>
      </footer>
    </div>

    <script src="<c:url value="/Resources/JS/JQuery.min.js" />"></script>
    <script src="<c:url value="/Resources/JS/Bootstrap.min.js" />"></script>
    <script src="<c:url value="/Resources/JS/Templatemo_Script.js" />"></script>
</body>
</html>