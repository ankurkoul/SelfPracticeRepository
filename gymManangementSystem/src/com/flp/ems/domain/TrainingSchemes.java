package com.flp.ems.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the project database table.
 * 
 */
@Entity
public class TrainingSchemes implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int schemeId;

	private String description;

	private String name;

	//bi-directional many-to-one association to member
	@OneToMany(mappedBy="trainingSchemes")
	private List<GymMember> members;

	//bi-directional many-to-one association to department Trainingprogram
	@ManyToOne
	@JoinColumn(name="trainId")
	private TrainingProgram trainingProgram;

	public TrainingSchemes() {
	}

	
	
	public int getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(int schemeId) {
		this.schemeId = schemeId;
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



	public TrainingProgram getTrainingProgram() {
		return trainingProgram;
	}



	public void setTrainingProgram(TrainingProgram trainingProgram) {
		this.trainingProgram = trainingProgram;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "TrainingSchemes [schemeId=" + schemeId + ", description=" + description + ", name=" + name
				+ ", members=" + members + ", trainingProgram=" + trainingProgram + "]";
	}

	
		

}