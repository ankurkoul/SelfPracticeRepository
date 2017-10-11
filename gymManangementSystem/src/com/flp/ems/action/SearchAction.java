package com.flp.ems.action;

import java.util.List;

import com.flp.ems.domain.GymMember;
import com.flp.ems.service.GymMemberService;
import com.flp.ems.service.IGymMemberService;

public class SearchAction {

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
	
}
