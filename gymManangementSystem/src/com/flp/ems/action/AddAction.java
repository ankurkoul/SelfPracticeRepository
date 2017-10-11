package com.flp.ems.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flp.ems.domain.GymMember;
import com.flp.ems.service.GymMemberService;
import com.flp.ems.service.IGymMemberService;

public class AddAction  {


	public AddAction() {
		super();

		System.out.println(".......");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public String execute(HttpServletRequest request) {
		GymMember emp = new GymMember();

		String name = request.getParameter("name");
		String kinId = request.getParameter("kinId");

		String email = request.getParameter("email");

		String ph = request.getParameter("phone");
		String address = request.getParameter("add");

		String dob = request.getParameter("dob");
		System.out.println(dob);
		String doj = request.getParameter("doj");
		String trainingProgram = request.getParameter("trainingProgram");

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
		System.out.println(e.getMessage());
		}
		int trainingProgramId= Integer.parseInt(trainingProgram);
		
		long phone =Long.parseLong(ph);
		int trainingSchemesId= Integer.parseInt(trainingSchemes);
		int roleId=Integer.parseInt(role);

		emp.setDateOfBirth(dateOfBirth);
		emp.setAddress(address);
		emp.setDateOfJoining(dateOfJoining);
		emp.setDateOfJoining(dateOfJoining);
		emp.setEmailId(email);
		emp.setPhoneNo(phone);
		emp.setName(name);
		emp.setKinId(kinId);
		IGymMemberService  service=new GymMemberService();

		
			int status = 0;
			try {
				status = service.addGymMember(emp,trainingProgramId,roleId,trainingSchemesId);
			
			} catch (Exception e) {
			System.out.println(e.getMessage());
			return "GymMember can't be added";
			}
			System.out.println("is............................."+status);
			if(status==-1){
			return "Duplicate entry";	
			}
			return "GymMember added";
			
		
	}

	}
	
