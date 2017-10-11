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
 
 <body style="background-color: #333435">
	<div class="span1"></div>
	<div class="container span11">		<div class="arrow " style="background-color: #b9c0cc">
				<h1 align="center">Gym Management System</h1>
		</div>
		<div class="row">
			<div class="row-fluid ">
			<form action="serve" class="form-search ">
				<div class="span1"></div>
				<input type="button" class="btn btn-warning btn-large"
					onClick="window.location.href = 'index.jsp'" value="home">
				<input type="button" class="btn btn-warning btn-large"
					onClick="window.location.href = 'addMember.jsp'"
					value="Add Member"> <input type="button"
					class="btn-warning  btn btn-large"
					onClick="window.location.href = 'removeMember.jsp'"
					value="remove Member"> <input type="button"
					class="btn btn-warning btn-large"
					onClick="window.location.href = 'searchMember.jsp'"
					value="search Member"> <input type="button"
					class="btn btn-info btn-large"
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
				</select> <INPUT TYPE="image" SRC="clips/save.jpg" WIDTH="120" HEIGHT="100"
					BORDER="0" ALT="SUBMIT" name="submit" value="update Search">
				<!-- <input type="submit"  name="submit" value="update Search"> -->
			</div>
		</form>
		<div class="row-fluid">
			<div class="arrow" style="background-color: #df8505">
			</div>

			<c:forEach var="i" items="${requestScope.modify}">
				<div class="row-fluid ">
					<div class="span1"></div>

<div background-image: url('clips/gymready.jpg');background-size:cover">
					<form action="serve" onsubmit="return validate(); " method="post"
						style="background-image: url('clips/gymready.jpg')" >
						<div id="form" class="span3 form-actions"
							style="text-align: left; margin-right: 30px">
							<input type="hidden" name="empId" value="${i.gymMemberId}">
							Name <input type="text" name="name" id="name" value="${ i.name}"
								required> <br> kinId <input type="text"
								name="kinId" id="kinId" value="${ i.kinId}" readonly="readonly">
							<br>Email <input type="email" name="email" id="email"
								value="${ i.emailId}" required> <br>Contact number
							<input type="text" name="phone" id="phone" value="${ i.phoneNo}"
								required> <br>Date Of birth <input type="date"
								name="dob" id="dob" value="${ i.dateOfBirth}" required>
							<br>Date of Joining <input type="date" name="doj" id="doj"
								value="${ i.dateOfJoining}" required> <br>Address
							<textarea  name="add" id="add">
                          <c:out value="${i.address}"></c:out>  
                        </textarea>
							<br>trainingProgram <select name="trainingProgram" id="trainingProgram"
								class="dropdown-toggle">
								<c:forEach var="trainingSchemes" items="${applicationScope.trainingProgramList }">
									<c:choose>

										<c:when test="${trainingSchemes[0] == i.trainingProgram.trainId}">
											<option value="${trainingSchemes[0]}" selected="selected">
												<c:out value="${trainingSchemes[1]}"></c:out>
											</option>
										</c:when>

										<c:otherwise>
											<option value="${trainingSchemes[0]}">
												<c:out value="${trainingSchemes[1]}"></c:out>
											</option>
										</c:otherwise>
									</c:choose>
									<%-- 	<option value="${trainingProgram}"><c:out value="${trainingProgram}"></c:out></option>
                                --%>
								</c:forEach>

							</select> <br> trainingSchemes <select name="trainingSchemes" id="trainingSchemes"
								class="dropdown-toggle">

								<c:forEach var="trainingSchemes"
									items="${applicationScope.trainingSchemesList }">
									<c:choose>

										<c:when test="${trainingSchemes[0] == i.trainingSchemes.schemeId}">
											<option value="${trainingSchemes[0]}" selected="selected">
												<c:out value="${trainingSchemes[1]}"></c:out>
											</option>
										</c:when>

										<c:otherwise>
											<option value="${trainingSchemes[0]}">
												<c:out value="${trainingSchemes[1]}"></c:out>
											</option>
										</c:otherwise>
									</c:choose>
									<%-- 	<option value="${trainingProgram}"><c:out value="${trainingProgram}"></c:out></option>
                                --%>
								</c:forEach>

							</select> <br> role <select name="role" id="role"
								class="dropdown-toggle">
								<c:forEach var="role" items="${applicationScope.roleList }">
									<c:choose>

										<c:when test="${role[0] == i.role.roleId}">
											<option value="${role[0]}" selected="selected">
												<c:out value="${role[1]}"></c:out>
											</option>
										</c:when>

										<c:otherwise>
											<option value="${role[0]}">
												<c:out value="${role[1]}"></c:out>
											</option>
										</c:otherwise>
									</c:choose>
									<%-- 	<option value="${trainingProgram}"><c:out value="${trainingProgram}"></c:out></option>
                                --%>
								</c:forEach>

							</select> <br> <input type="submit" value="update" name="submit"
								class="btn-success btn-large">
						</div>

					</form>
					</div>
			</c:forEach>
			<h3>
				</form>
		</div>

		<h3>
			<div class="span2"></div>

			<div class="span3 text-error " id="texting">
				${requestScope.message}
				</h1>
			</div>
		</h3>
	</div>
</body>
</html>