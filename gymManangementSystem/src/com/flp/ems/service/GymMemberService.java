package com.flp.ems.service;

import java.util.ArrayList;
import java.util.List;

import com.flp.ems.dao.GymMemberDAOImplForList;
import com.flp.ems.dao.IGymMemberDAO;

import com.flp.ems.domain.TrainingProgram;
import com.flp.ems.domain.GymMember;
import com.flp.ems.domain.TrainingSchemes;
import com.flp.ems.domain.Role;


public class GymMemberService implements IGymMemberService{
	IGymMemberDAO ref= new GymMemberDAOImplForList();	

	public int  addGymMember(GymMember emp,int trainingProgramId,int roleId,int projectId) throws Exception
	{
		/*TrainingProgram trainingProgram=ref.showTrainingProgram(trainingProgramId);
		TrainingSchemes project=ref.showTrainingSchemes(projectId);
		*/
		
		TrainingProgram trainingProgram=ref.showTrainingProgram(trainingProgramId);
		
		TrainingSchemes project=ref.showTrainingSchemes(projectId);
		Role role=ref.showRole(roleId);
		emp.setTrainingSchemes(project);
		emp.setTrainingProgram(trainingProgram);
		emp.setRole(role);
		
			return ref.addGymMember(emp);
		
	}



	public GymMember showGymMember(int empid) throws Exception{
		return ref.showGymMember(empid);
	}
	
	public List<GymMember> search(String name,String value) throws Exception {
		return ref.search(name,value);
	}

	public List<GymMember> searchByName(String name) throws Exception {
		return ref.searchByName(name);
	}

	public List<GymMember> searchByKinId(String kinId) throws Exception {
		return ref.searchByKinId(kinId);
	}

	public List<GymMember> searchByEmailId(String email) throws Exception {
		return ref.searchByEmailId(email);
	}

	public List<GymMember> getAllGymMember() throws Exception{
		return ref.getAllGymMember();
	}
	
	public boolean removeGymMember(String name,String value)throws Exception{
		return ref.removeGymMember(name, value);
	}



	@Override
	public String modifyGymMember(GymMember emp, int trainingProgramId, int roleId,int projectId,int empId) throws Exception{

			TrainingProgram trainingProgram=ref.showTrainingProgram(trainingProgramId);
			TrainingSchemes project=ref.showTrainingSchemes(projectId);
			Role role=ref.showRole(roleId);
			emp.setTrainingSchemes(project);
			emp.setTrainingProgram(trainingProgram);
			emp.setRole(role);

			if(ref.modifyGymMember(emp,empId))
			{	
				return "success"; 
			}

			else
			{
				return "error";
			}

	}



	@Override
	public List<TrainingProgram> getAllTrainingProgramId() throws Exception {
		// TODO Auto-generated method stub
		return ref.getAllTrainingProgramId();
	}



	@Override
	public List<Role> getAllRoleId() throws Exception {
		// TODO Auto-generated method stub
		return ref.getAllRoleId();
	}



	@Override
	public List<TrainingSchemes> getAllTrainingSchemesId() throws Exception {
		// TODO Auto-generated method stub
		return ref.getAllTrainingSchemesId();
	}

	
	public boolean removeGymMember(GymMember e)throws Exception{
		return ref.removeGymMember(e);
	}

}


