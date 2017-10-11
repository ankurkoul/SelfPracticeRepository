package com.flp.ems.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int roleId;

	private String description;

	private String name;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="role")
	private List<GymMember> members;

	public Role() {
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
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

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", description=" + description + ", name=" + name + ", members=" + members
				+ "]";
	}

		

}