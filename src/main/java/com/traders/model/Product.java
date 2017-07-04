package com.traders.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	String description, hsn, name;
	
	
	protected Product() {
		super();
	}


	public Product(String hsn, String name, String description) {
		super();
		this.hsn = hsn;
		this.name = name;
		this.description = description;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getHsn() {
		return hsn;
	}


	public void setHsn(String hsn) {
		this.hsn = hsn;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
}
