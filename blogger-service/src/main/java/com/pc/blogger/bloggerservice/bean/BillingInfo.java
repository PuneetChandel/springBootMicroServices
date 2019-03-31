package com.pc.blogger.bloggerservice.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BillingInfo {

	
	
	@Id
	private Long id;

	private String tier;
	
	public BillingInfo(Long id, String tier, int amount) {
		super();
		this.id = id;
		this.tier = tier;
		this.amount = amount;
	}
	
	public BillingInfo() {
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	private int amount;
	
	
		
	
}
