<%@page import="proxima.informatica.academy.seventh.service.RoleService"%>
<%@page import="proxima.informatica.academy.dto.RoleDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="proxima.informatica.academy.seventh.service.UserService"%>
<%@page import="proxima.informatica.academy.dto.UserDto"%>
<!DOCTYPE html>
<%@include file="./autentication.jsp"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Roles</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
	<%@include file="./header.jsp"%>
<body>
<div class="container">

	<%int id = Integer.parseInt(request.getParameter("selectedRoleId"));%>
	<%RoleDto roles = RoleService.getInstance().selectRoleById(id);%>
	
	<form method="post" action=./UpdateRoleServlet>
	<table>
	<tr>
				<th>ID</th>
				<th>LABEL</th>
				<th>DESCRIPTION</th>
				<th>LEVEL</th>
	</tr>
	<tr>
				<td>
				  <input type=text id="id" placeholder="Id" name="id_input" value="<%=roles.getId()%>" readonly="readonly">
				</td>
				<td>
					<input type=text id="label" placeholder="Label" name="label_input" value="<%=roles.getLabel()%>">
				</td>
				<td>
					<input type=text id="description" placeholder="Descriptnon" name="description_input" value="<%=roles.getDescription()%>">
				</td>
				<td>
					<input type=number id="level" placeholder="Level" name="level_input" value="<%=roles.getLevel()%>">
				</td>
			</tr>
	</table>
	<br/>
	<button type="submit" name="modifica" class="btn btn-warning">Modifica</button>
	</form>
	<form action="./roles.jsp" method="post">
	<button type="submit" name="Torna_Indietro" class="btn btn-warning">Torna Indietro</button>
	</form> 
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
</body>
</html>