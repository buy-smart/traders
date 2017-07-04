package com.traders.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	String email, name, phoneNumber;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="traderId", referencedColumnName="id", insertable=false, updatable=false)
	private Trader trader;
	
	protected Customer() {
		super();
	}


	public Customer(Trader trader, String email, String name, String phoneNumber) {
		super();
		this.trader= trader;
		this.email = email;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}


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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Trader getTrader() {
		return trader;
	}


	public void setTrader(Trader trader) {
		this.trader = trader;
	}
}
