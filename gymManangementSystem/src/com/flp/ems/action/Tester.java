package com.flp.ems.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.flp.ems.domain.TrainingProgram;
import com.flp.ems.domain.GymMember;
import com.flp.ems.domain.TrainingSchemes;
import com.flp.ems.domain.Role;
import com.flp.ems.service.GymMemberService;


public class Tester {
	public static void main(String[] args) throws Exception {
	
		GymMember emp=new GymMember();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		String dob="16/05/1988";
		Date dateOfBirth=sdf.parse(dob);
		emp.setDateOfBirth(dateOfBirth);
		String doj="10/03/2014";
		Date dateOfJoining=sdf.parse(dob);
		emp.setDateOfJoining(dateOfJoining);
		emp.setKinId("kinId111");
		emp.setEmailId("emailId@sss");
		emp.setName("ankur");
		emp.setPhoneNo(21221212);
		emp.setAddress("address 1");
		
	int empid=emp.hashCode()*Math.abs((int)System.currentTimeMillis());
	emp.setGymMemberId(empid);
		GymMemberService  service=new GymMemberService();
		System.out.println(service.addGymMember(emp,1,1,1));
		//System.out.println(emp);
		System.out.println(service.showGymMember(empid));

	}

}
