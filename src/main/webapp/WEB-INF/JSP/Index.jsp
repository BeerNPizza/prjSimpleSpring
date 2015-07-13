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
                    <button class="navbar-toggle" data-target="#bs-example-navbar-collapse-1" data-toggle="collapse"type="button">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
					<span class="icon-bar"></span></button>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
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
                        <div class="site-heading">
                            <h1>Val's Vet Clinic</h1>
                            <hr class="small">
                            <span class="subheading">The best care for your best friend.</span>
                        </div>
                    </div>
                </div>
            </div>
        </header><!-- Main Content -->
        <div class="container">
            <div class="row">
                <div class=
                "col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <div class="post-preview">
                        <a href="http://www.petpoisonhelpline.com/2013/03/keeping-pets-safe-poison-prevention-week/">
							<h2 class="post-title">Poison Prevention Awareness</h2>
							<h3 class="post-subtitle">National Poison Prevention Week</h3>
						</a>
                        <p class="post-meta">
                            Posted by <a href="#">Valerie</a> on
                            March 2, 2014
                        </p>
                    </div>
                    <hr>
                    <div class="post-preview">
                        <a href="http://blog.allstate.com/woof-10-pet-safety-tips-for-the-holidays/">
							<h2 class="post-title">Christmas Safety for Your Pets</h2>
							<h3 class="post-subtitle">Christmas trees can pose numerous problems for pets</h3>
						</a>
                        <p class="post-meta">
                            Posted by <a href="#">Valerie</a> on
                            September 18, 2014
                        </p>
                    </div>
                    <hr>
                    <div class="post-preview">
                        <a href="https://www.daysoftheyear.com/days/pet-obesity-awareness-day/">
							<h2 class="post-title">Pet Obesity Awareness Day</h2>
							<h3 class="post-subtitle">October 14 is National Pet Obesity Awareness Day!</h3>
						</a>
                        <p class="post-meta">
                            Posted by <a href="#">Valerie</a> on August
                            24, 2014
                        </p>
                    </div>
                    <hr>
                    <div class="post-preview">
                        <a href="http://www.logicproducts.com/pages/important-flea-facts">
							<h2 class="post-title">FLEA Facts</h2>
						</a>
                        <p class="post-meta">
                            Posted by <a href="#">Valerie</a> on July
                            8, 2014
                        </p>
                    </div>
                    <hr>
                    <!-- Pager -->
                    <ul class="pager">
                        <li class="next">
                            <a href="#">Older Posts &rarr;</a>
                        </li>
                    </ul>
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
