<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>gym membership</title>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="bootstrap/dist/css/bootstrap.min.css">
  <script src="css/jquery.min.js"></script>
  <script src="bootstrap/dist/js/bootstrap.min.js"></script>
<link href="css/bootstrap-responsive.css" rel="stylesheet">
 <script src=" bootstrap/js/carousel.js"></script>
 
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
 </head>
<script type="text/javascript">
	
</script>
<body style="background-color: #333435">
	<div class="span1"></div>
	<div class="container span11">		<div class="arrow " style="background-color: #b9c0cc">
				<h1 align="center">Gym Management System</h1>
		</div>
		<div class="row">
			<div class="row-fluid ">
			<form action="serve" class="form-search ">
				<div class="span1"></div>
					<input type="button" class="btn btn-warning btn-large" onClick="window.location.href = 'index.jsp'"
		value="home">
				<input type="button" class="btn btn-warning btn-large"
					onClick="window.location.href = 'addMember.jsp'"
					value="Add Member"> <input type="button"
					class="btn btn-info btn-large"
					onClick="window.location.href = 'removeMember.jsp'"
					value="remove Member"> <input type="button"
					class="btn btn-warning btn-large"
					onClick="window.location.href = 'searchMember.jsp'"
					value="search Member"> <input type="button"
					class="btn btn-warning btn-large"
					onClick="window.location.href = 'modifyMember.jsp'"
					value="update Member"> 
 <input type="submit"
						value="get all Members" class="btn btn-warning btn-large" name="submit">
</form>
			</div>
		</div>


	<form action="serve">
			<div class="form-actions" align="center">
				<input type="text" name="txt" class="search-query"><select
					name="choice" class="dropdown-submenu ">
					<option value="kinID">KinID</option>
					<option value="emailID">EmailID</option>
					<option value="name">Name</option>
				</select> <INPUT TYPE="image" SRC="clips/dirt.png" WIDTH="120" HEIGHT="100"
					BORDER="0" ALT="SUBMIT" name="submit" value="remove">
<h3>
					<div class="span2"></div>
		
					<div class="span3 text-error " id="texting" style=" background-image: url('clips/exit.jpg');background-size:cover">${requestScope.message}</h1> </div>
				</h3>
</div>
</body>
</html>
</html>