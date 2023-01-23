<%@page import="proxima.informatica.academy.seventh.service.RoleService"%>
<%@page import="proxima.informatica.academy.dto.RoleDto"%>
<%@page import="proxima.informatica.academy.seventh.service.UserService"%>
<%@page import="proxima.informatica.academy.dto.UserDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@include file="./autentication.jsp"%>

<%
String roleEliminato="";
if(request.getAttribute("deleteRole") == "OK"){
	roleEliminato = "Sei riuscito ad eliminare il ruolo selezionato";
}if(request.getAttribute("deleteRole") == "KO"){
	roleEliminato = "Non sei riuscito ad eliminare il ruolo selezionato";
}
%>

<%
String roleModificato="";
if(request.getAttribute("updateRole") == "OK"){
	roleModificato = "Modifica andata a buon fine";
}if(request.getAttribute("updateRole") == "KO"){
	roleModificato = "Modificata non riuscita";
}
%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Roles</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<script type="text/javascript">
	//alert("io sono qui");
	function abilitaBottone() {
		console.log("questa è una stampa di console");
		document.getElementById("deleteButton").disabled=false;
		document.getElementById("modificaButton").disabled=false;
	}
	function modificaRole(){
		console.log("modifica");
		document.getElementById("formSelezioneRole").action = "./updateRole.jsp";
		document.getElementById("formSelezioneRole").submit();
	}
	function deleteRole(){
		console.log("delete");
		document.getElementById("formSelezioneRole").action = "./DeleteRoleServlet";
		document.getElementById("formSelezioneRole").submit();
	}
</script>
</head>
	<%@include file="./header.jsp"%>
<body>
<div class="container-fluid">
	
	
	<h3 style="text-align:center;"><%= roleEliminato%></h3>
	<h3 style="text-align:center;"><%= roleModificato%></h3>
	<%-- 	<%@include file="./header.jsp" %> --%>
	<%-- 	<h1>BENVENUTO TI SEI LOGGATO COME : <%= utenteLoggato%> </h1> --%>

	<form id="formSelezioneRole">
		<table class="table table-striped table-dark">
		<thead>
			<tr>
				<th scope="col"></th>
				<th scope="col">ID</th>
				<th scope="col">LABLE</th>
				<th scope="col">DESCRIPTION</th>
				<th scope="col">LEVEL</th>
			</tr>
			<%
			ArrayList<RoleDto> roles = RoleService.getInstance().selectAllRoles();
			for (RoleDto tableRoles : roles) {
			%>
			<tr>
				<td class="table-warning"><input type="radio" name="selectedRoleId"
					value="<%out.print(tableRoles.getId());%>"onclick="javascript:abilitaBottone();"></td>
				<td>
					<%
					out.print(tableRoles.getId());
					%>
				</td>
				<td>
					<%
					out.print(tableRoles.getLabel());
					%>
				</td>
				<td>
					<%
					out.print(tableRoles.getDescription());
					%>
				</td>
				<td>
					<%
					out.print(tableRoles.getLevel());
					%>
				</td>
			</tr>
			
			<%
			}
			%>
		</table>
		<br />
		<button type="submit" id="modificaButton" value="CANCELLA" class="btn btn-warning" disabled onclick="javascript:deleteRole();">ELIMINA</button>
		
		<button type="submit" id="deleteButton" value="MODIFICA" class="btn btn-warning" disabled onclick="javascript:modificaRole();">MODIFICA</button>
	</form>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
</body>
</html>