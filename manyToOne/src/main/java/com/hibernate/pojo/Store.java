package com.hibernate.pojo;

import java.util.HashSet;
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
@Table(name = "store")
public class Store {
	private Integer id;
	private String name;
	private String address;
	private String mobile;
	private Set<User> employee = new HashSet<User>();
	private Set<StoreProduct> storeProducts = new HashSet<StoreProduct>();
	public Store() {
	}

	public Store(String name, String address, String mobile) {
		this.name = name;
		this.address = address;
		this.mobile = mobile;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@OneToMany(mappedBy = "store",fetch = FetchType.LAZY,cascade=CascadeType.ALL, orphanRemoval = true)	
	public Set<User> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<User> employee) {
		this.employee = employee;
	}

	@OneToMany(mappedBy = "store", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<StoreProduct> getStoreProduct() {
		return storeProducts;
	}

	public void setStoreProduct(Set<StoreProduct> storeProduct) {
		this.storeProducts = storeProduct;
	}

	public void addStoreProduct(StoreProduct storeProduct) {
		this.storeProducts.add(storeProduct);
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + ", address=" + address + ", mobile=" + mobile + "]";
	}

}
