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
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
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
                                Contact Me
                            </h1>
                            <hr class="small">
                            <span class="subheading">Have questions? I have
                            answers (maybe).</span>
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
                        Want to get in touch with me? Fill out the form below
                        to send me a message and I will try to get back to you
                        within 24 hours!
                    </p>
                    <!-- Contact Form - Enter your email address on line 19 of the mail/contact_me.php file to make this form work. -->
                    <!-- WARNING: Some web hosts do not allow emails to be sent through forms to common mail hosts like Gmail or Yahoo. It's recommended that you use a private domain email address! -->
                    <!-- NOTE: To use the contact form, your site must be on a live web host with PHP! The form will not work locally! -->
                    <form id="contactForm" name="sentMessage" novalidate="">
                        <div class="row control-group">
                            <div class=
                            "form-group col-xs-12 floating-label-form-group controls">
                            <label>Name</label> <input class="form-control"
                            data-validation-required-message=
                            "Please enter your name." id="name"
                                placeholder="Name" required="" type="text">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="row control-group">
                            <div class=
                            "form-group col-xs-12 floating-label-form-group controls">
                            <label>Email Address</label> <input class=
                            "form-control"
                                data-validation-required-message="Please enter your email address."
                                id="email" placeholder="Email Address"
                                required="" type="email">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="row control-group">
                            <div class=
                            "form-group col-xs-12 floating-label-form-group controls">
                            <label>Phone Number</label> <input class=
                            "form-control"
                                data-validation-required-message="Please enter your phone number."
                                id="phone" placeholder="Phone Number" required=
                                "" type="tel">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="row control-group">
                            <div class=
                            "form-group col-xs-12 floating-label-form-group controls">
                            <label>Message</label> 
                                <textarea class="form-control" data-validation-required-message="Please enter a message." id="message" placeholder="Message" required="" rows="5"></textarea>
                                <p class="help-block text-danger"></p>
                            </div>
                        </div><br>
                        <div id="success"></div>
                        <div class="row">
                            <div class="form-group col-xs-12">
                                <button class="btn btn-default" type=
                                "submit">Send</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <hr>
                <script>            
			jQuery(document).ready(function() {
				var offset = 220;
				var duration = 500;
				jQuery(window).scroll(function() {
					if (jQuery(this).scrollTop() > offset) {
						jQuery('.back-to-top').fadeIn(duration);
					} else {
						jQuery('.back-to-top').fadeOut(duration);
					}
				});
				
				jQuery('.back-to-top').click(function(event) {
					event.preventDefault();
					jQuery('html, body').animate({scrollTop: 0}, duration);
					return false;
				})
			});
		</script>
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