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
<script type="text/javascript" src="validation.js"></script>



<body style="background-color: #333435">
	<div class="span1"></div>
	<div class="container span11">
		<div class="row-fluid ">		<div class="arrow " style="background-color: #b9c0cc">
				<h1 align="center">Gym Management System</h1>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span1"></div>


			<div class="row">

				<form action="serve" class="form-search ">

		
					<input type="button" class=" btn btn-warning btn-large" onClick="window.location.href = 'index.jsp'"
		value="home">
					<input type="button" class="btn btn-warning btn-large"
						onClick="window.location.href = 'addMember.jsp'"
						value="Add Member" style="width: 300; height: 300"> <input
						type="button" class="btn btn-warning btn-large"
						onClick="window.location.href = 'removeMember.jsp'"
						value="remove Member"> <input type="button"
						class="btn btn-warning btn-large"
						onClick="window.location.href = 'searchMember.jsp'"
						value="search Member"> <input type="button"
						class="btn btn-warning btn-large"
						onClick="window.location.href = 'modifyMember.jsp'"
						value="update Member"> <input type="submit"
						value="get all Members" class="btn btn-info btn-large" name="submit">


				</form>
			</div>

			<div class="row-fluid">
				<div class="arrow" style="background-color: #df8505">
					<h1 align="center">List of all Members</h1>

				</div>
				<div class="row-fluid">
					<div class="span1"></div>
					<div id="form" class="hero-unit span9"
						style=" background-image: url('clips/main2.jpg');background-size:cover">
						<table class="table form form-actions" border="1">
						<c:if test="${not empty requestScope.list}">


									<tr>
										<td class="btn-info">Id</td>
										<td class="btn-info">kinId</td>
										<td class="btn-info">name</td>
										<td class="btn-info">emailId</td>

										<td class="btn-info">role name</td>

										<td class="btn-info">training program name</td>

										<td class="btn-info">training scheme name</td>


									</tr>
								</c:if>
						<c:forEach var="i" items="${requestScope.list}"
							varStatus="status">

							
								
								
								<tr>
									<td><c:out value=" ${status.count}"></c:out></td>

									<td><c:out value="${i.kinId}"></c:out></td>
									<td><c:out value="${i.name}"></c:out></td>
									<td><c:out value="${i.emailId}"></c:out></td>

									<td><c:out value="${i.role.name}"></c:out></td>
									<td><c:out value="${i.trainingProgram.name}"></c:out></td>

									<td><c:out value="${i.trainingSchemes.name}"></c:out></td>

								</tr>

	</c:forEach>
							</table>
					
					</div>
</body>


</html>