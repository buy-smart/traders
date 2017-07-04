
package com.traders.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SaleItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
		
	private int quantity;
	
     
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "saleId")
	private Sale sale;

	
	@ManyToOne(optional=false)
	@JoinColumn(name="productId", referencedColumnName="id")
	private Product product;
	
	protected SaleItem() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
