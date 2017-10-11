package com.flp.ems.service;

import java.util.List;

import com.flp.ems.domain.TrainingProgram;
import com.flp.ems.domain.GymMember;
import com.flp.ems.domain.TrainingSchemes;
import com.flp.ems.domain.Role;

public interface IGymMemberService {

	public int addGymMember(GymMember member,int trainingProgramId,int roleId,int trainingSchemeId) throws Exception;
	public List<GymMember> searchByName(String name) throws Exception;
	public List<GymMember> searchByKinId(String kin) throws Exception;
	public List<GymMember> searchByEmailId(String email) throws Exception;
	public List<GymMember> getAllGymMember() throws Exception;
	public GymMember showGymMember(int memberid) throws Exception;
	//public boolean removeGymMember(String name,String value)throws Exception;
	public String modifyGymMember(GymMember member, int trainingProgramId, int roleId,int trainingSchemeId,int memberId) throws Exception;
	public List<TrainingProgram> getAllTrainingProgramId() throws Exception ;
	public List<Role> getAllRoleId() throws Exception;
	public List<TrainingSchemes> getAllTrainingSchemesId() throws Exception;
	public List<GymMember> search(String name,String value) throws Exception;
	public boolean removeGymMember(GymMember e)throws Exception;
}
