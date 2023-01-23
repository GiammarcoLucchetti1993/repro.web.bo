<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="proxima.informatica.academy.seventh.service.UserService"%>
<%@page import="proxima.informatica.academy.dto.UserDto"%>
<!DOCTYPE html>
<%@include file="./autentication.jsp"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>UpdateUsers</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
	<%@include file="./header.jsp"%>
<body>
<div class="container">

	<%int id = Integer.parseInt(request.getParameter("selectedUserId"));%>
	<%UserDto users = UserService.getInstance().selectUserById(id);%>
	
	<form method="post" action=./UpdateUserServlet>
	<table>
	<tr>
				<th>ID</th>
				<th>EMAIL</th>
				<th>PASSWORD</th>
				<th>FIRSTNAME</th>
				<th>LASTNAME</th>
				<th>BIRTHDATE</th>
				<th>REGDATE</th>
				<th>ROLE</th>
				<th>IMGPATH</th>
				<th>NOTE</th>
				<th>ENABLED</th>
	</tr>
	<tr>
				<td>
				  <input type=text id="id" placeholder="Id" name="id_input" value="<%=users.getId()%>" readonly="readonly">
				</td>
				<td>
					<input type=text id="email" placeholder="Email" name="email_input" value="<%=users.getEmail()%>">
				</td>
				<td>
					<input type=text id="password" placeholder="Password" name="password_input" value="<%=users.getPassword()%>">
				</td>
				<td>
					<input type=text id="firstname" placeholder="Firstname" name="firstname_input" value="<%=users.getFirstName()%>">
				</td>
				<td>
					<input type=text id="lastname" placeholder="Lastname" name="lastname_input" value="<%=users.getLastName()%>">
				</td>
				<td>
					<input type=date id="birthdate" placeholder="Birthdate" name="birthdate_input" value="<%=users.getDateOfBirth()%>">
				</td>
				<td>
					<input type=datetime-local id="regdate" placeholder="Regdate" name="regdate_input" value="<%=users.getRegDate()%>">
				</td>
				<td>
					<input type=number id="role" placeholder="Role" name="role_input" value="<%=users.getRole()%>">
				</td>
				<td>
					<input type=text id="imgpath" placeholder="Imgpath" name="imgpath_input" value="<%=users.getImgPath()%>">
				</td>
				<td>
					<input type=text id="note" placeholder="Note" name="note_input" value="<%=users.getNote()%>">
				</td>
				<td>
					<input type=number id="enabled" placeholder="Enabled" name="enabled_input" value="<%=users.getEnabled()%>">
				</td>
			</tr>
	</table>
	<br/>
	<button type="submit" name="modifica" class="btn btn-warning">Modifica</button>
	</form>
	<form action="./users.jsp" method="post">
	<button type="submit" name="Torna_Indietro" class="btn btn-warning">Torna Indietro</button>
	</form> 
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
</body>
</html>