package com.foodkhana.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Component
@Entity
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true, nullable = false)
	private String email;
	private String password;
	@Column(name = "uname")
	private String userName;
	private String role;
	@OneToMany
	private List<Address> addressList=new ArrayList<>();
	@ElementCollection
	private List<String> phoneNo=new ArrayList<>();
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



	public List<String> getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(List<String> phoneNo) {
		this.phoneNo = phoneNo;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}

/*
 * @OneToMany(mappedBy="user")
 * 
 * private List<UserOrder> userOrdersList=new ArrayList<>();
 * 
 * @OneToMany(mappedBy="user") private List<UserPayment> userPaymentsList=new
 * ArrayList<>();
 */

/*
 * //bi-directional many-to-one association to Userpayment
 * 
 * @ManyToOne private UserPayment userpayment;
 * 
 * //bi-directional many-to-one association to Userorder
 * 
 * @ManyToOne private UserOrder userorder;
 */
// bi-directional many-to-one association to Userorder
/*
 * @OneToMany(mappedBy="user") private Set<UserOrder> userOrdersList;
 * 
 * //bi-directional many-to-one association to Userpayment
 * 
 * @OneToMany(mappedBy="user") private Set<UserPayment> userPaymentsList;
 */

/*
 * public Set<UserOrder> getUserOrdersList() { return userOrdersList; }
 * 
 * public void setUserOrdersList(Set<UserOrder> userOrdersList) {
 * this.userOrdersList = userOrdersList; }
 * 
 * public Set<UserPayment> getUserPaymentsList() { return userPaymentsList; }
 * 
 * public void setUserPaymentsList(Set<UserPayment> userPaymentsList) {
 * this.userPaymentsList = userPaymentsList; }
 */