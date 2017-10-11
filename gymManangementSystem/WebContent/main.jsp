
<%@page import="com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.flp.ems.domain.GymMember"%>
<%@page import="com.flp.ems.service.GymMemberService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		GymMember member = new GymMember();

		String name = request.getParameter("name");
		String kinId = request.getParameter("kinID");

		String email = request.getParameter("email");

		String ph = request.getParameter("phone");
		String address = request.getParameter("add");

		String dob = request.getParameter("dob");
		System.out.println(dob);
		String doj = request.getParameter("doj");
		String dept = request.getParameter("dept");
		
		String trainingSchemes = request.getParameter("trainingSchemes");
		String role = request.getParameter("role");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOfJoining=null;
		Date dateOfBirth=null;
		try{
			dateOfJoining = sdf.parse(doj);
			 dateOfBirth = sdf.parse(dob);
		}
		
		catch(ParseException e){
			e.getMessage();
		}
		 int deptId= Integer.parseInt(dept);
		long phone =Long.parseLong(ph);
		int trainingSchemesId= Integer.parseInt(trainingSchemes);
		int roleId=Integer.parseInt(role);
		
		member.setDateOfBirth(dateOfBirth);
		member.setAddress(address);
		member.setDateOfJoining(dateOfJoining);
		member.setDateOfJoining(dateOfJoining);
		member.setEmailId(email);
		member.setPhoneNo(phone);
		member.setName(name);
		member.setKinId(kinId);
		int memberid=member.hashCode()*Math.abs((int)System.currentTimeMillis());
		member.setGymMemberId(memberid);
		GymMemberService  service=new GymMemberService();
		System.out.println(service.addGymMember(member,deptId,roleId,trainingSchemesId));
		//System.out.println(member);
		session.setAttribute("array",service.showGymMember(memberid));
	//service.showGymMember(memberid);  
%>
	<table>
	<c:forEach items="${sessionScope.array}" var="member">
<tr><td><c:out value="${member.id}"></c:out></td>
<td><c:out value="${member.name}"></c:out></td>
<td><c:out value="${member.kinId}"></c:out></td></tr>
</c:forEach>
</table>
</body>
</html>