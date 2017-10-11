<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title></title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link href="../css/bootstrap-responsive.min.css" rel="stylesheet">
</head>
<script type="text/javascript" src="validation.js"></script>


<body style="background-color: #333435">
	<div class="span1">1</div>
	<div class="container-fluid span11">
		<div class="arrow " style="background-color: #b9c0cc">
			<h1 align="center">Gym Management System</h1>
		</div>
		<div class="row">

			<div class="row-fluid ">
				<form action="serve" class="form-search ">
					<div class="span1"></div>
					<input type="button" class="btn btn-warning btn-large"
						onClick="window.location.href = 'index.jsp'" value="home">
					<input type="button" class="btn btn-info btn-large"
						onClick="window.location.href = 'addMember.jsp'"
						value="Add Member"> <input type="button"
						class="btn-warning  btn btn-large"
						onClick="window.location.href = 'removeMember.jsp'"
						value="remove Member"> <input type="button"
						class="btn btn-warning btn-large"
						onClick="window.location.href = 'searchMember.jsp'"
						value="search Member"> <input type="button"
						class="btn btn-warning btn-large"
						onClick="window.location.href = 'modifyMember.jsp'"
						value="update Member"> <input type="submit"
						value="get all Members" class="btn btn-warning btn-large"
						name="submit">
				</form>
			</div>
</div>



			<div class="row-fluid">
				<div class="span1"></div>
				<div id="form" class="hero-unit span5"
					style="background-color: #b3b3b3">
					<form action="serve" onsubmit="return validate(); " method="post"
						class="form-actions span11">

						Name <input type="text" name="name" id="name"
							placeholder="enter your name" required> <br>kinId <input
							type="text" name="kinId" id="kinId"
							placeholder="enter your valid kinId" required> <br>Email
						<input type="email" name="email" id="email"
							placeholder="enter your email @ " required> <br>Contact
						number <input type="text" name="phone" id="phone"
							placeholder="enter your contact details" required> <br>Date
						Of birth <input type="date" name="dob" id="dob" required>

						<br>Date of Joining <input type="date" name="doj" id="doj"
							required> <br>Address
						<textarea rows="10" cols="10" name="add" id="add"
							placeholder="enter your permanent address"></textarea>

						<br>Training Programm <select name="trainingProgram"
							id="trainingProgram" class="dropdown-toggle">
							<!-- <option value="1" selected="selected">1</option>
										<option value="2">2</option>
										<option value="3">3</option> -->

							<c:forEach var="trainingProgram"
								items="${applicationScope.trainingProgramList }">
								<option value="${trainingProgram[0]}"><c:out
										value="${trainingProgram[1]}"></c:out></option>
							</c:forEach>

						</select> <br> Schemes <select name="trainingSchemes"
							id="trainingSchemes" class="dropdown-toggle">
							<!-- <option value="1" selected="selected">1</option>
										<option value="2">2</option>
										<option value="3">3</option> -->
							<c:forEach var="trainingSchemes"
								items="${applicationScope.trainingSchemesList }">
								<option value="${trainingSchemes[0]}"><c:out
										value="${trainingSchemes[1]}"></c:out></option>
							</c:forEach>
						</select> <br> role <select name="role" id="role"
							class="dropdown-toggle">
							<!-- <option value="1" selected="selected">1</option>
										<option value="2">2</option>
										<option value="3">3</option> -->

							<c:forEach var="role" items="${applicationScope.roleList }">
								<option value="${role[0]}"><c:out value="${role[1]}"></c:out></option>
							</c:forEach>
						</select> <input type="submit" value="register" name="submit"
							class="btn-success btn-large">


					</form>
				</div>

				<h3>
					<div class="span2"></div>

					<div class="span3 text-error " id="texting">
						Please give your Registration Details<BR>
						<BR>
						<BR>
						<BR>
						<BR>
						<h1>${requestScope.message}</h1>
					</div>
				</h3>
				<div
					style="background-image: url('clips/gymready.jpg'); background-size: cover"></div>
			</div>
			<div class="span1"></div>
</body>
</html>