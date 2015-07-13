<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${PageTitle}</title>
        
        <!-- Bootstrap Styling -->
        <link rel="stylesheet" type="text/css" href="<c:url value="/Resources/CSS/Bootstrap.css" />" >
        
        <!-- Favicon -->
	<link rel="icon" type="image/png" sizes="32x32" href="<c:url value="/Resources/Images/Favico.png" />">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <h1>${INJECT_STUFF_HERE}</h1>
                    
                    <a href="<c:url value="/Index" />">Index</a> | 
                    <a href="<c:url value="/Login" />">Login</a> | 
                    <a href="<c:url value="/List" />">List</a>

                    <!-- User List -->
                    <h3>User List</h3>
                    <c:if test="${!empty listUsers}"> <!-- If Not Empty-->
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Address</th>
                                <th>City</th>
                                <th>State</th>
                                <th>Zip</th>
                                <th>Email</th>
                                <th>Password (Encrypted)</th>
                                <th>Role</th>
                                <th>Active</th>
                            </tr>
                            </thead>
                            <c:forEach items="${listUsers}" var="user">
                                <tbody>
                                    <tr>
                                        <td>${user.ID}</td>
                                        <td>${user.firstname}</td>
                                        <td>${user.lastname}</td>
                                        <td>${user.address}</td>
                                        <td>${user.city}</td>
                                        <td>${user.state}</td>
                                        <td>${user.zip}</td>
                                        <td>${user.email}</td>
                                        <td>${user.password}</td>
                                        <td>${user.role}</td>
                                            <c:choose>
                                                <c:when test="${user.active == 1}">
                                                    <td>Active</td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td>NOT Active</td>
                                                </c:otherwise>
                                            </c:choose>
                                    </tr>
                                </tbody>
                            </c:forEach>
                        </table>
                    </c:if>
                    
                    <!-- Pet List -->
                    <h3>Pet List</h3>
                    <c:if test="${!empty listPets}"> <!-- If Not Empty-->
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Type</th>
                                <th>Breed</th>
                                <th>Age</th>
                                <th>Owner (User_ID)</th>
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
                                        <td>${pet.userInPet.ID}</td>
                                    </tr>
                                </tbody>
                            </c:forEach>
                        </table>
                    </c:if>
                    
                    <!-- Invoice List -->
                    <h3>Invoice List</h3>
                    <c:if test="${!empty listInvoices}"> <!-- If Not Empty-->
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Pet ID</th>
                                <th>Amount ($)</th>
                                <th>Description</th>
                                <th>Created</th>
                                <th>Last Modified</th>
                            </tr>
                            </thead>
                            <c:forEach items="${listInvoices}" var="invoice">
                                <tbody>
                                    <tr>
                                        <td>${invoice.ID}</td>
                                        <td>${invoice.petInInvoice.ID}</td>
                                        <td>${invoice.invoiceAmount}</td>
                                        <td>${invoice.invoiceDescription}</td>
                                        <td>${invoice.invoiceCreated}</td>
                                        <td>${invoice.invoiceModified}</td>
                                    </tr>
                                </tbody>
                            </c:forEach>
                        </table>
                    </c:if>
                    
                    <!-- Invoice List -->
                    <h3>Procedure List</h3>
                    <c:if test="${!empty listProcedures}"> <!-- If Not Empty-->
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Description</th>
                                <th>Cost</th>
                                <th>Pet ID</th>
                                <th>Date</th>
                            </tr>
                            </thead>
                            <c:forEach items="${listProcedures}" var="procedure">
                                <tbody>
                                    <tr>
                                        <td>${procedure.ID}</td>
                                        <td>${procedure.procedureName}</td>
                                        <td>${procedure.procedureDescription}</td>
                                        <td>${procedure.procedureCost}</td>
                                        <td>${procedure.petInProcedure.ID}</td>
                                        <td>${procedure.procedureDate}</td>
                                    </tr>
                                </tbody>
                            </c:forEach>
                        </table>
                    </c:if>
                </div>
            </div>
        </div>
        
    </body>
</html>