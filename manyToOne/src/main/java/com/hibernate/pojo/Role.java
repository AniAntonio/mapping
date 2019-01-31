package com.hibernate.pojo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {


	private Integer id;
	private String name;
	private String description;
	private Set<User> users = new HashSet<User>();

	public Role() {
	}
	public Role (String name,String description) {
		this.name=name;
		this.description=description;
	}
	@Id
	@Column(name = "id")
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
    public void addUser( User user) {
        users.add(user);
        user.setRole (this);
    }
	@OneToMany(mappedBy = "role",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public void removeUser( User user) {
        users.remove(user);
        user.setRole (null);
    }

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}

}
