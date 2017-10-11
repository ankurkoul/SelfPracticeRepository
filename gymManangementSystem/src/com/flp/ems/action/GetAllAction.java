package com.flp.ems.action;

import java.util.*;

import javax.servlet.ServletContext;

import com.flp.ems.domain.GymMember;
import com.flp.ems.listener.ServletCtxListener;
import com.flp.ems.service.GymMemberService;
import com.flp.ems.service.IGymMemberService;

public class GetAllAction {


public	GetAllAction(){
		super();
	}


	public List<GymMember> execute() throws Exception{
		System.out.println("in action.....");
		IGymMemberService  service=new GymMemberService();
		List<GymMember> list=service.getAllGymMember();
		System.out.println(list);
		return list;
		

	}

}
