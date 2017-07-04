package com.traders.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


@Entity
public class Sale {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="traderId", referencedColumnName="id")
	private Trader trader;
	
	/*	
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="sale_detail",
            joinColumns=
            @JoinColumn(name="sale_id", referencedColumnName="id"),
      inverseJoinColumns=
            @JoinColumn(name="prod_id", referencedColumnName="id")
    )
    private List<SaleItem> saleItems;
*/
	@OneToMany(
	        mappedBy = "sale", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true, fetch = FetchType.EAGER
	    )
	private List<SaleItem> saleItems;  
	
	protected Sale() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public List<SaleItem> getSaleItems() {
		return saleItems;
	}

	public void setSaleItems(List<SaleItem> saleItems) {
		this.saleItems = saleItems;
	}
}
