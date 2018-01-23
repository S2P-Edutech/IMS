package com.ims.actions;

public class Organization {

	public int org_id;
	public String org_name;
	
	
	
	public Organization() {
		
	}

	public Organization(int org_id, String org_name) {
		super();
		this.org_id = org_id;
		this.org_name = org_name;
	}

	public int getOrg_id() {
		return org_id;
	}
	
	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}
	
	public String getOrg_name() {
		return org_name;
	}
	
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}

	@Override
	public String toString() {
		return "Organization [org_id=" + org_id + ", org_name=" + org_name + "]";
	}
	
	
	
}
