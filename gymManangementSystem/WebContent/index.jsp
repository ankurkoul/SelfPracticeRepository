<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<script type="text/javascript">
	
</script>
<body style="background-color: #6e6f72">
<div class="span1"></div>
	<div class="container span10">
		<div class="row-fluid">
			<div class="arrow " style="background-color: #b9c0cc">
				<h1 align="center">Gym Management System</h1>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span1"></div>

			<form action="serve" class="form-search ">


					<input type="button" class="btn-warning btn-large"
						onClick="window.location.href = 'addMember.jsp'"
						value="Add Member" style="width: 300; height: 300"> <input
						type="button" class="btn-warning btn-large"
						onClick="window.location.href = 'removeMember.jsp'"
						value="remove Member"> <input type="button"
						class="btn-warning btn-large"
						onClick="window.location.href = 'searchMember.jsp'"
						value="search Member"> <input type="button"
						class="btn-warning btn-large"
						onClick="window.location.href = 'modifyMember.jsp'"
						value="update Member"> <input type="submit"
						value="get all Members" class="btn-warning btn-large" name="submit">
</form>
</div>

<div class="span10">
<img src="clips/main1.jpg" width="900" height="800">
</div>
<div class="span1"></div>
</div>
<div class="span1"></div>

</body>
</html>