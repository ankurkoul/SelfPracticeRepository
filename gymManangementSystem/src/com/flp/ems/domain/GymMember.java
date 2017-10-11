package com.flp.ems.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the gymMember database table.
 * 
 */
@Entity
public class GymMember implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int gymMemberId;

	private String address;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Temporal(TemporalType.DATE)
	private Date dateOfJoining;
	@Column(unique = true)
	private String emailId;
	@Column(unique = true)
	private String kinId;

	private String name;
	@Column(length=11)
	private long phoneNo;

	//bi-directional many-to-one association to Department-->trainingProgram
	@ManyToOne
	@JoinColumn(name="trainId")
	private TrainingProgram trainingProgram;

	//bi-directional many-to-one association to Project--->trainingSchemes
	@ManyToOne
	@JoinColumn(name="schemeId")
	private TrainingSchemes trainingSchemes;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="rolesId")
	private Role role;

	
	
	
	
/*
	
	//bi-directional many-to-one association to Department
		@ManyToOne
		@JoinColumn(name="deptId")
		private Department department;

		//bi-directional many-to-one association to Project
		@ManyToOne
		@JoinColumn(name="projectId")
		private Project project;

		//bi-directional many-to-one association to Role
		@ManyToOne
		@JoinColumn(name="rolesId")
		private Role role;

*/	
	
	public GymMember() {
	}

	public int getGymMemberId() {
		return this.gymMemberId;
	}

	public void setGymMemberId(int gymMemberId) {
		this.gymMemberId = gymMemberId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfJoining() {
		return this.dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getKinId() {
		return this.kinId;
	}

	public void setKinId(String kinId) {
		this.kinId = kinId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((kinId == null) ? 0 : kinId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GymMember other = (GymMember) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (kinId == null) {
			if (other.kinId != null)
				return false;
		} else if (!kinId.equals(other.kinId))
			return false;
		return true;
	}

	public TrainingProgram getTrainingProgram() {
		return trainingProgram;
	}

	public void setTrainingProgram(TrainingProgram trainingProgram) {
		this.trainingProgram = trainingProgram;
	}

	public TrainingSchemes getTrainingSchemes() {
		return trainingSchemes;
	}

	public void setTrainingSchemes(TrainingSchemes trainingSchemes) {
		this.trainingSchemes = trainingSchemes;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

/*	@Override
	public String toString() {
		return "GymMember [gymMemberId=" + gymMemberId + ", address=" + address + ", dateOfBirth=" + dateOfBirth
				+ ", dateOfJoining=" + dateOfJoining + ", emailId=" + emailId + ", kinId=" + kinId + ", name=" + name
				+ ", phoneNo=" + phoneNo + ", trainingProgram=" + trainingProgram + ", trainingSchemes="
				+ trainingSchemes + ", role=" + role + "]";
	}
*/	
	
	
	


}