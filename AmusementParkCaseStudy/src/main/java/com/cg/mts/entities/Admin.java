package com.cg.mts.entities;

import javax.persistence.Entity;


@Entity
public class Admin extends AbstractUser{
	
	private int adminId;
	private String type="Admin";
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
}