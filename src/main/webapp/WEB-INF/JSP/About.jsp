<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
 
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta content="IE=edge" http-equiv="X-UA-Compatible">
        <meta content="width=device-width, initial-scale=1" name="viewport">
        <meta content="" name="description">
        <meta content="" name="author">
        <title>${PageTitle}</title>
	<!-- Bootstrap Core CSS -->
	<link rel="icon" type="image/png" sizes="32x32" href="${cp}/Resources/Images/Favico.png">
        <link href="${cp}/Resources/CSS/Bootstrap.min.css" rel="stylesheet">
        <link href="${cp}/Resources/CSS/Blog.min.css" rel="stylesheet">
        <!-- Custom Fonts -->
        <link href="${cp}/Resources/CSS/blog/Font-Awesome.min.css" rel="stylesheet" type="text/css">
        <link href='http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    	<style>
		.back-to-top {
			position: fixed;
			bottom: 2em;
			right: 0px;
			text-decoration: none;
			color: #000000;
			background-color: rgba(235, 235, 235, 0.80);
			font-size: 12px;
			padding: 1em;
			display: none;
		}

		.back-to-top:hover {	
			background-color: rgba(135, 135, 135, 0.50);
		}	
	</style>
    
    </head>
    <body>
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-custom navbar-fixed-top">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header page-scroll">
                    <button class="navbar-toggle" data-target=
                    "#bs-example-navbar-collapse-1" data-toggle="collapse"
                    type="button"><span class="sr-only">Toggle
                    navigation</span> <span class="icon-bar"></span>
                    <span class="icon-bar"></span> <span class=
                    "icon-bar"></span></button>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id=
                "bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="Index">Home</a></li>
                        <li><a href="About">About</a></li>
                        <li><a href="Contact">Contact</a></li>
                        <li><a href="List">Debugging</a></li>
                        <li><a href='Login'>Login</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container -->
        </nav><!-- Page Header -->
        <!-- Set your background image for this header on the line below. -->
        <header class="intro-header" style="background-image: url('${cp}/Resources/Images/Blog/home-bg.jpg')">
            <div class="container">
                <div class="row">
                    <div class=
                    "col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                        <div class="page-heading">
                            <h1>
                                About Us
                            </h1>
                            <hr class="small">
                            <span class="subheading">Providing top notch care
                            is what we do.</span>
                        </div>
                    </div>
                </div>
            </div>
        </header><!-- Main Content -->
        <div class="container">
            <div class="row">
                <div class=
                "col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <p>
                        Since 1870, Valerie's Veterinary Clinic has been
                        providing the highest level of care for our patients.
                        Guided by the professional values and principles of our
                        founder, the dedicated staff of doctors, nurses and
                        healthcare professionals fully commits themselves to
                        the lifetime health of your pet.
                    </p>
                    <p>
                        We invite you to learn more about our unique facilities
                        and exceptional staff by visiting the links provided on
                        this page.
                    </p>
                </div>
            </div>
        </div>
        <hr>
        <!-- Footer -->
        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                        <p class="copyright text-muted">
                            Copyright &copy; 2015 ValsVetClinic.com
                        </p>
                    </div>
                </div>
            </div>
        </footer><!-- jQuery -->

        <script src="${cp}/Resources/JS/JQuery.js"></script> <!-- Bootstrap Core JavaScript -->
        <script src="${cp}/Resources/JS/Bootstrap.min.js"></script> <!-- Custom Theme JavaScript -->
        <script src="${cp}/Resources/JS/Blog.min.js"></script>
    </body>
</html>