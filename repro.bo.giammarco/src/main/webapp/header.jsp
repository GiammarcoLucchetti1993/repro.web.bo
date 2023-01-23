<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    
   <style>

/* .col-sm{ */
/* background-color:grey; */
/* } */

.back{
background-color:grey;
}

a{
color:white;}

// Small devices (landscape phones, 576px and up)
@media (min-width: 576px) {
background-color:orange; }

// Medium devices (tablets, 768px and up)
@media (min-width: 768px) { 
background-color:yellow; }

// Large devices (desktops, 992px and up)
@media (min-width: 992px) { 
background-color:blue; }

// Extra large devices (large desktops, 1200px and up)
@media (min-width: 1200px) {
background-color:red;  }

</style>

<%
String utente="";
String utenteLoggato="";
if(session.getAttribute("userLoggedEmail")==null){
	utente = "NON SEI LOGGATO";
	utenteLoggato = "";
}else{
	utente = "LOGGATO COME :";
	utenteLoggato = "" + session.getAttribute("userLoggedEmail");
}
%>   

<div class="back">
	<div class="row">
	<div class="col-sm-4">
    </div>
	<div class="col-auto">
      <a href="./users.jsp" class="badge badge-warning">Lista Utente</a>
    </div>
    <div class="col-auto">
      <a href="./insertUser.jsp" class="badge badge-warning">Inserisci Utente</a>
    </div>
    <div class="col-auto">
      <a href="./roles.jsp" class="badge badge-warning">Lista Ruoli</a>
    </div>
    <div class="col-auto">
      <a href="./insertRole.jsp" class="badge badge-warning">Inserisci Ruoli</a>
    </div>
     <div class="col-auto">
      <a href="./LogoutServlet" class="badge badge-warning">Log Out</a>
    </div>
    <div class="col-auto">
      <label style="color:white;"><%= utente%> <%= utenteLoggato%></label>
    </div>
    <div class="col-sm-4">
    </div>
	</div>
</div> 

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
