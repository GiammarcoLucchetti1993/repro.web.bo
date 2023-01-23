<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
String logoutMessage = "";
if(request.getAttribute("logoutMessage")!= null)
{
logoutMessage = "" + request.getAttribute("logoutMessage");
}
else{
	logoutMessage = "" ;
}
%>

<%
String loginFailure = "";
if(request.getAttribute("loginFailure")!= null)
{
loginFailure = "" + request.getAttribute("loginFailure");
}
else{
	loginFailure = "";
}
%>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<style>

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
<%@include file ="./header.jsp" %>
</head>
<body>


<div class="container">

<h1 style="margin-left : 300px;"><%=loginFailure %></h1>
<h3 style="margin-left : 300px;"><%=logoutMessage %></h3>
<form action="./LoginServlet" method="post" >
<div class="row justify-content-md-center">
    <div class="col col-lg-2">
      <h1>Login</h1>
    </div>
    </div>
<!-- <div class="row justify-content-md-center"> -->
<!--     <div class="col-sm-6 col-lg-2"> -->
<!--       <input type="email"  name="email" placeholder="email"> -->
<!--     </div> -->
<!--     <div class="col-sm-4 col-lg-2"> -->
<!--      <input type="password"  name="password" placeholder="password"> -->
<!--     </div> -->
<div class="row justify-content-md-center">
  <div class="col-sm-2">
    <label for="inputEmail" class="col-form-label"> Email </label>
  </div>
  <div class="col-sm-4">
    <input type="email" name="email" placeholder="email" id="inputEmail" class="form-control" aria-describedby="passwordHelpInline">
  </div>
  </div>

    <div class="row justify-content-md-center">
  <div class="col-sm-2">
    <label for="inputPassword6" class="col-form-label">Password</label>
  </div>
  <div class="col-sm-4">
    <input type="password" name="password" placeholder="password" id="inputPassword6" class="form-control" aria-describedby="passwordHelpInline">
  </div>
</div>
    <br/>
<div class="row justify-content-md-center">
    <div class="col col-lg-2">
      <button type="submit" value="SIGN-IN" class="btn btn-warning">Accedi</button>
    </div>
   </div>
</form> 
</div>
<br/>
<div class="container">
<form action="./registration.html" method="post">
<div class="row justify-content-md-center">
    <div class="col col-lg-2">
      <button type="submit" value="REGISTRATI" class="btn btn-warning">Registrati</button>
    </div>
   </div>
   </form>
    
<!--   		<input type="email"  name="email" placeholder="email"> -->
<!--   		<input type="password"  name="password" placeholder="password"><br/> -->
<!--   		<button type="submit" value="SIGN-IN" >Accedi</button> -->
<!-- <form action="./registration.html" method="post"> -->
<!-- 	<button type="submit" value="REGISTRATI">Registrati</button> -->
<!-- </form>  -->
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
</body>
</html>