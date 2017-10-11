package com.flp.ems.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.flp.ems.domain.GymMember;
import com.flp.ems.service.GymMemberService;
import com.flp.ems.service.IGymMemberService;

public class ModifyAction {
	public List<GymMember> execute(String name,String value) throws Exception{
		IGymMemberService service=new GymMemberService();
			System.out.println("......................."+name);
			System.out.println("......................."+value);
			switch (name) {
			case "kinID":
				return service.searchByKinId(value);
			case "emailID":
				return service.searchByEmailId(value);
			case "name":
				return service.searchByName(value);
			default:
				break;
			}
			return null;
	}
	
	
	
			public String execute(HttpServletRequest request) {
				GymMember emp = new GymMember();
				int empId=Integer.parseInt(request.getParameter("empId"));
				String name1 = request.getParameter("name");
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
					e.getMessage();
				}
				System.out.println("trainingProgram....."+trainingProgram);
				System.out.println("trainingSchemes....."+trainingSchemes);
				System.out.println("role....."+role);
				int trainingProgramId= Integer.parseInt(trainingProgram);
				System.out.println(trainingProgram);
				long phone =Long.parseLong(ph);
				int trainingSchemesId= Integer.parseInt(trainingSchemes);
				int roleId=Integer.parseInt(role);

				emp.setDateOfBirth(dateOfBirth);
				emp.setAddress(address);
				emp.setDateOfJoining(dateOfJoining);
				emp.setDateOfJoining(dateOfJoining);
				emp.setEmailId(email);
				emp.setPhoneNo(phone);
				emp.setName(name1);
				emp.setKinId(kinId);
				IGymMemberService  service=new GymMemberService();

				
					String status="unable to update due to technical error";
					try {
						status = service.modifyGymMember(emp, trainingProgramId, roleId, trainingSchemesId,empId);
					
					} catch (Exception e) {
						System.out.println(e.getMessage());
					return "GymMember can't be updated";
					}
					System.out.println("is............................."+status);
					if(status.equalsIgnoreCase("error")){
					return "unable to update";	
					}
					if(status.equalsIgnoreCase("success")){
					return "GymMember updated";
					}
					return status;
				
			}
			//return service.search(name,value);
		}
		

