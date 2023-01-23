<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%-- <%@include file="./autentication.jsp"%> --%>
<%-- 	<%@include file="./header.jsp"%> --%>
	<%int id = Integer.parseInt(request.getParameter("id"));%>
<%
String insertPassword="";
if(request.getAttribute("insertPassword")=="KO")
{
insertPassword = "Password non corrisposta";
}
else{
	insertPassword="";
}
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete Registration</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1><%= insertPassword%></h1>

	<form method="post" action="./CompleteRegistrationServlet"
		class="autentication">
		<h1>Inserimento Password</h1>
		<input type="hidden" id="id" placeholder="Id" name="id_input" value="<%=id%>" readonly="readonly" >
		<input type="text" id="password" placeholder="Password" name="password_input" maxlength="50" required>
		<input type="text" id="password" placeholder="Password" name="confirmpassword_input" maxlength="50" required>
		<button type="submit" name="register" class="btn btn-warning">Inserisci Password</button>
	</form>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
</body>
</html>