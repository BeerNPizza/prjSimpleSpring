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
    
    <!-- Calendar Stuff -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/Resources/CSS/Calendar/FullCalendar.css" />" >
    <link rel="stylesheet" type="text/css" media="print" href="<c:url value="/Resources/CSS/Calendar/FullCalendar.print.css" />" >
    <link rel="stylesheet" type="text/css" href="<c:url value="/Resources/CSS/DateTimePicker.css" />" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/Resources/CSS/JQuery.UI.css" />" />
    
    <script src="<c:url value="/Resources/JS/Calendar/Moment.min.js" />"></script>
    <script src="<c:url value="/Resources/JS/JQuery.min.js" />"></script>
    <script src="<c:url value="/Resources/JS/Calendar/FullCalendar.min.js" />"></script>
    <script src="<c:url value="/Resources/JS/DateTimePicker.js" />"></script>
    
    
    <!-- JQuery Typeahead Plugin -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/Resources/CSS/JQuery.Typeahead.css" />" />
    <script src="<c:url value="/Resources/JS/JQuery.Typeahead.js" />"></script>
    
<script>
	$(document).ready(function()
	{
            $('#calendar').fullCalendar(
            {
                /* Function For When You Click A Day Block */
                dayClick: function(date, jsEvent, view)
                {
                    /*
                     * Need To Do A JQuery Listener To Intercept Modal Closing Or Hiding And Clear Then
                     */
                    $("#EventModal").html("<i class='fa fa-user'></i> Create An Event");
                    $("#EventTitle").val("");
                    $("#EventDescription").val("");
                    $("#DateTime").val("");
                    $("#SearchInput").val("");
                    $('#CreateEventModal').modal('show');
//                  alert('Clicked on: ' + date.format("D-MM-YYYY"));
//                  alert('Coordinates: ' + jsEvent.pageX + ',' + jsEvent.pageY);
//                  alert('Current View Name: ' + view.name);
//                  $(this).css('background-color', 'green'); 
                },
                /* Function For When You Click An Event */
                eventClick: function(event, element)
                {
                //    event.title = "CLICKED!";
                //    $('#calendar').fullCalendar('updateEvent', event);
                // EventModal
                    $("#EventModal").html("<i class='fa fa-user'></i> Edit An Event");
                    $("#EventTitle").val(event.title);
                    $("#EventDescription").val(event.description);
                    $("#DateTime").val(moment(event.start).format('D-MM-YYYY h:mm'));
                    $("#SearchInput").val("");
                    $('#CreateEventModal').modal('show');
                },
		header:
                {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'month,agendaWeek,agendaDay'
		},
		defaultDate: new Date(), // Todays Date
		editable: true,
		eventLimit: true, // allow "more" link when too many events
		events:
                {
                    url: '<c:url value="/Resources/Other/events.json" />',
                    error: function()
                    {
			$('#script-warning').show();
                    }
		},
		loading: function(bool)
                {
                    $('#loading').toggle(bool);
		}
            });	
	});
</script>
<style>
/*	body {
		margin-top: 40px;
		text-align: center;
		font-size: 14px;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
	}
*/		
	#wrap {
		width: 1000px;
		margin: 0 auto;
	}
		
	#external-events {
		float: left;
		width: 150px;
		padding: 0 5px;
		border: 1px solid #ccc;
		background: #eee;
		text-align: left;
	}
		
	#external-events h4 {
		font-size: 16px;
		margin-top: 0;
		padding-top: 1em;
	}
		
	#external-events .fc-event {
		margin: 10px 0;
		cursor: pointer;
	}
		
	#external-events p {
		margin: 1.5em 0;
		font-size: 11px;
		color: #666;
	}
		
	#external-events p input {
		margin: 0 auto;
		vertical-align: middle;
	}

	#calendar {
		float: left;
		width: 1050px;
	}

</style>
<!-- END OF CALENDAR STUFF -->

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
          <li><a href="${pageContext.request.contextPath}/Admin/Clients"><i class="fa fa-users"></i><span class="badge pull-right">57</span> Clients</a></li>
          <li><a href="${pageContext.request.contextPath}/Admin/Patients"><i class="fa fa-paw"></i><span class="badge pull-right">63</span> Patients</a></li>
          <li class="active"><a href="${pageContext.request.contextPath}/Admin/Appointments"><i class="fa fa-calendar"></i><span class="badge pull-right">9</span> Appointments</a></li>
          <li><a href="${pageContext.request.contextPath}/#"><i class="fa fa-book"></i><span class="badge pull-right">42</span> Inventory</a></li>
          <li><a href="${pageContext.request.contextPath}/Admin/Invoices"><i class="fa fa-credit-card"></i><span class="badge pull-right">12</span> Invoices</a></li>
          <li><a href="${pageContext.request.contextPath}/#"><i class="fa fa-cog"></i>Preferences</a></li>
          <li><a href="javascript:;" data-toggle="modal" data-target="#confirmLogoutModal"><i class="fa fa-sign-out"></i>Sign Out</a></li>
        </ul>
      </div><!--/.navbar-collapse -->

      <div class="templatemo-content-wrapper">
        <div class="templatemo-content">
          <ol class="breadcrumb">
            <li><a href="index.html">Admin Panel</a></li>
            <li><a href="#">Dashboard</a></li>
            <li class="active">Schedule</li>
          </ol>
          <h1>Dashboard</h1>
          <p>Welcome To Your Dashboard!</p>
          
          <!-- Start Of Calendar -->
                <div id='calendar'></div>
                <div style='clear:both'></div>
                <br>
          <!-- End Of Calendar -->
          
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
              
      <!-- Add Event Modal -->
      <div class="modal fade" id="CreateEventModal" tabindex="-1" role="dialog" aria-labelledby="EventModal" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
              <h4 class="modal-title" id="EventModal"><i class="fa fa-user"></i> Create A New Event</h4>
            </div>
            <div class="modal-body text-center">
            <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/Register/Client" method="POST">
            <fieldset>

                <div class="form-group">
                    <div class="col-sm-12">
                      <input class="form-control" type="text" placeholder="Appointment Title" name="EventTitle" id="EventTitle">
                    </div>
                </div>
                
                <div class="form-group">
                    <div class="col-sm-12">
                       <textarea class="form-control" rows="5" placeholder="Appointment Description" name="EventDescription" id="EventDescription"></textarea>
                    </div>
                </div>
                  
                <div class="form-group">
                    <div class="col-sm-4">
                        <input type="text" id="DateTime" name="DateTime" data-field="datetime" readonly placeholder="Date/Time" class="form-control">
                        <div id="dtBox"></div>
                    </div>

                    <div class="col-sm-8">
                    <div class="typeahead-container">
                        <div class="typeahead-field">
                            <span class="typeahead-query">
				<input id="SearchInput" name="SearchInput" type="search" autofocus autocomplete="off">
                            </span>
                            <span class="typeahead-button">
				<button type="submit">
                                    <span class="typeahead-search-icon"></span>
				</button>
                            </span>
                        </div>
                    </div>
                    </div>
                </div>
            
              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Cancel</button>
                <button type="submit" class="btn btn-primary"><i class="fa fa-check"></i> Save</button>
                <p align="left" id="result-container"></p> <!-- This Is Where Search Results Are Shown -->
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

    <script src="<c:url value="/Resources/JS/Bootstrap.min.js" />"></script>
    <script src="<c:url value="/Resources/JS/Templatemo_Script.js" />"></script>
    <script src="<c:url value="/Resources/JS/JQuery.UI.js" />"></script>
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
     * JQuery Typeahead 
     */
    var data = {
            countries: [${InjCountries}],
            capitals: [${InjCapitals}]
        };

        $('#SearchInput').typeahead({
            minLength: 1,
            order: "asc",
            group: true,
            groupMaxItem: 6,
            hint: true,
            dropdownFilter: "All",
            href: "https://en.wikipedia.org/?title={{display}}",
            template: "{{display}}, <small><em>{{group}}</em></small>",
            /* This Is Where We Define Our Sources Of Data */
            source:
            {
                Country:
                {
                    data: data.countries
                },
                Capital:
                {
                    data: data.capitals
                }
            },
            callback:
            {
                /* Event After A Result Is Clicked */
                onClickAfter: function (node, a, item, event)
		{
                    var r = confirm("You will be redirected to:\n" + item.href + "\n\nContinue?");
                    if (r == true)
                    {
                        window.open(item.href);
                    }

                    $('#result-container').text('');
                },
		/* Event That Responds To Change And Shows Number Of Options */
                onResult: function (node, query, obj, objCount)
		{
                    var text = "";
                    if (query !== "")
                    {
                        text = objCount + ' items matching "' + query + '"';
                    }
                    $('#result-container').text(text);
                }
            },
            debug: false
        });
    </script>
</body>
</html>