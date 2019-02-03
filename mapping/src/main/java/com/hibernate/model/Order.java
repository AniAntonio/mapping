package com.hibernate.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "orders")
public class Order { 
	private Integer id; 
	private String date;
	private float orderprice;;
	private Store store;
	private State state;
	private String message;
	private User client;
	private User employee;
	private Set<OrderProduct> orderProducts= new HashSet<OrderProduct>();
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}


	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getOrderprice() {
		return orderprice;
	}
	public void setOrderprice(float orderprice) {
		this.orderprice = orderprice;
	}
	@ManyToOne
	@JoinColumn(name = "idclient")
	public User getClient() {
		return client;
	}
	public void setClient(User client) {
		this.client = client;
	}
	@ManyToOne
	@JoinColumn(name = "idemployee")
	public User getEmployee() {
		return employee;
	}
	public void setEmployee(User employee) {
		this.employee = employee;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idstore")
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idstate")
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@OneToMany(mappedBy = "order",fetch = FetchType.LAZY)
	public Set<OrderProduct> getOrderProducts() {
		return orderProducts;
	}
	public void setOrderProducts(Set<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", date=" + date + ", orderprice=" + orderprice 
				 + ", store=" + store.getName() + ", state=" + state.getName() + ", message=" + message + "]";
	}

}
