package com.cg.mts.entities;

import javax.persistence.*;


@Entity
public class Customer extends AbstractUser{
	
	private int customerId;
	private String type="Customer";
   

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}