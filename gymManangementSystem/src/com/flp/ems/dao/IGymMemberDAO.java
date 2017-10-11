package com.flp.ems.dao;
import java.util.ArrayList;
import java.util.List;
import com.flp.ems.domain.TrainingProgram;
import com.flp.ems.domain.GymMember;
import com.flp.ems.domain.TrainingSchemes;
import com.flp.ems.domain.Role;




public interface IGymMemberDAO {
	public int addGymMember(GymMember member)throws Exception;	
	public GymMember showGymMember(int memberId) throws Exception;
	public TrainingProgram showTrainingProgram(int trainingProgram)throws  Exception;
	public TrainingSchemes showTrainingSchemes(int trainingSchemeId)throws Exception;
	public Role showRole(int roleId)throws Exception;
	public List<GymMember> searchByName(String name) throws Exception;
	public List<GymMember> searchByKinId(String kin) throws Exception;
	public List<GymMember> searchByEmailId(String email) throws Exception;
	public List<GymMember> getAllGymMember() throws Exception;
	public boolean removeGymMember(GymMember member)throws Exception;
	public boolean removeGymMember(String name,String value)throws Exception;
	public boolean modifyGymMember(GymMember e,int memberId) throws Exception;
	public List<GymMember> search(String name,String value) throws Exception;
	public List<TrainingProgram> getAllTrainingProgramId() throws Exception;
	public List<Role> getAllRoleId() throws Exception;
	public List<TrainingSchemes> getAllTrainingSchemesId() throws Exception;

}
