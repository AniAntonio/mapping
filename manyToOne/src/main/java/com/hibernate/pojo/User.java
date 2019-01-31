package com.hibernate.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	private Integer id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String address;
	private String email;
	private String mobile;
	private Store store;
	private Role role;
	public User() {
	}

	public User(String username, String password, String firstname, String lastname, String address,
			String email, String mobile) {
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.email = email;
		this.mobile = mobile;

	}
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "idstore")
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "idrole")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + username + " ]";
	}

}
