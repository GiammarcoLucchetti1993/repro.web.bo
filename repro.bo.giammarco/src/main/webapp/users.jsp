<%@page import="proxima.informatica.academy.seventh.service.UserService"%>
<%@page import="proxima.informatica.academy.dto.UserDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@include file="./autentication.jsp"%>

<%
String utenteEliminato="";
if(request.getAttribute("deleteUser") == "OK"){
	utenteEliminato = "Sei riuscito ad eliminare l utente selezionato";
}if(request.getAttribute("deleteUser") == "KO"){
	utenteEliminato = "Non sei riuscito ad eliminare l utente selezionato";
}
%>

<%
String utenteModificato="";
if(request.getAttribute("updateUser") == "OK"){
	utenteModificato = "Modifica andata a buon fine";
}if(request.getAttribute("updateUser") == "KO"){
	utenteModificato = "Modificata non riuscita";
}
%>

<%
String loginMessage = "";
if(request.getAttribute("loginMessage") != null){
	loginMessage = "" + request.getAttribute("loginMessage");
}else{
	loginMessage = "";
}
%>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<script type="text/javascript">
	function abilitaBottone() {
		console.log("questa è una stampa di console");
		document.getElementById("deleteButton").disabled=false;
		document.getElementById("modificaButton").disabled=false;
	}
	function modificaUser(){
		console.log("modifica");
		document.getElementById("formSelezioneUser").action = "./updateUser.jsp";
		document.getElementById("formSelezioneUser").submit();
	}
	function deleteUser(){
		console.log("delete");
		document.getElementById("formSelezioneUser").action = "./DeleteUserServlet";
		document.getElementById("formSelezioneUser").submit();
	}
</script>
	<%@include file="./header.jsp"%>
</head>
<body>
<div class="container-fluid">
	
	
	<h3 style="text-align:center;"><%= utenteEliminato%></h3>
	<h3 style="text-align:center;"><%= utenteModificato%></h3>
	<h3 style="text-align:center;"><%= loginMessage%></h3>
	<%-- 	<%@include file="./header.jsp" %> --%>
	<%-- 	<h1>BENVENUTO TI SEI LOGGATO COME : <%= utenteLoggato%> </h1> --%>

	<form id="formSelezioneUser">
		<table class="table table-striped table-dark">
		<thead>
			<tr>
				<th scope="col"></th>
				<th scope="col">ID</th>
				<th scope="col">EMAIL</th>
				<th scope="col">PASSWORD</th>
				<th scope="col">FIRSTNAME</th>
				<th scope="col">LASTNAME</th>
				<th scope="col">BIRTHDATE</th>
				<th scope="col">REGDATE</th>
				<th scope="col">ROLE</th>
				<th scope="col">IMGPATH</th>
				<th scope="col">NOTE</th>
				<th scope="col">ENABLED</th>
			</tr>
		</thead>
		<tbody>
			<%
			ArrayList<UserDto> users = UserService.getInstance().selectAllUsers();
			for (UserDto tableUsers : users) {
			%>
			<tr>
				<td class="table-warning"><input type="radio" name="selectedUserId"
					value="<%out.print(tableUsers.getId());%>"onclick="javascript:abilitaBottone();"></td>
				<td>
					<%
					out.print(tableUsers.getId());
					%>
				</td>
				<td>
					<%
					out.print(tableUsers.getEmail());
					%>
				</td>
				<td>
					<%
					out.print(tableUsers.getPassword());
					%>
				</td>
				<td>
					<%
					out.print(tableUsers.getFirstName());
					%>
				</td>
				<td>
					<%
					out.print(tableUsers.getLastName());
					%>
				</td>
				<td>
					<%
					out.print(tableUsers.getDateOfBirth());
					%>
				</td>
				<td>
					<%
					out.print(tableUsers.getRegDate());
					%>
				</td>
				<td>
					<%
					out.print(tableUsers.getRole());
					%>
				</td>
				<td>
					<%
					out.print(tableUsers.getImgPath());
					%>
				</td>
				<td>
					<%
					out.print(tableUsers.getNote());
					%>
				</td>
				<td>
					<%
					out.print(tableUsers.getEnabled());
					%>
				</td>
			</tr>	
			</tbody>
			<%
			}
			%>
		</table>
		<br />
		<button type="submit" id="modificaButton" value="CANCELLA" class="btn btn-warning" disabled onclick="javascript:deleteUser();">ELIMINA</button>
		<br/>
		<button type="submit" id="deleteButton" value="MODIFICA" class="btn btn-warning" disabled onclick="javascript:modificaUser();">MODIFICA</button>
	</form>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
</body>
</html>