package com.flp.ems.action;

import java.util.List;

import com.flp.ems.domain.GymMember;
import com.flp.ems.service.GymMemberService;
import com.flp.ems.service.IGymMemberService;

public class RemoveAction {

	public String execute(String name,String value){
		IGymMemberService service=new GymMemberService();
		List<GymMember> list = null;
		System.out.println("......................."+name);
		System.out.println("......................."+value);
		switch (name) {
		case "kinID":
			try {
				System.out.println("...................kinId....");
				
				list=service.searchByKinId(value);
				System.out.println("list----kinId------->"+list);
				break;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		case "emailID":
			try {

				System.out.println("...................email....");
				list= service.searchByEmailId(value);

				System.out.println("list----email------->"+list);
				break;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		case "name":
			try {

				System.out.println("...................name....");
				list= service.searchByName(value);

				System.out.println("list----name------->"+list);
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		default:
			break;
		}
		for(GymMember l:list){
			try {
				if(service.removeGymMember(l))
					return "record has been removed";

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return "record can't be removed";


	}
}
