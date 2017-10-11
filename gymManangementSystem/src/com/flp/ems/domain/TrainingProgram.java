package com.flp.ems.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the department database table.
 * 
 */
@Entity
public class TrainingProgram implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private int trainId;

	private String description;

	private String name;
	/*

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="department")
	private List<Employee> employees;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="department")
	private List<Project> projects;
 
	 */
	
	

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="trainingProgram")
	private List<GymMember> members;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="trainingProgram")
	private List<TrainingSchemes> schemes;

	public TrainingProgram() {
	}

	

	public int getTrainId() {
		return trainId;
	}



	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public List<GymMember> getMembers() {
		return members;
	}



	public void setMembers(List<GymMember> members) {
		this.members = members;
	}



	public List<TrainingSchemes> getSchemes() {
		return schemes;
	}



	public void setSchemes(List<TrainingSchemes> schemes) {
		this.schemes = schemes;
	}



	@Override
	public String toString() {
		return "TrainingProgram [trainId=" + trainId + ", description=" + description + ", name=" + name + ", members="
				+ members + ", schemes=" + schemes + "]";
	}

	

	
}