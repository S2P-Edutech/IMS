package com.ims.actions;

public class OrganizationDetails {

	public int org_details_id;
	public String org_email_id;
	public String org_estd_date;
	public String org_details;
	public String org_owner;
	public String org_address;
	public String org_contact;
	public Organization org;
	
	public OrganizationDetails() {
		
	}

	public OrganizationDetails( int org_details_id, String org_email_id, String org_estd_date,
			String org_details, String org_owner, String org_address, String org_contact, Organization org) {
		super();
		this.org_details_id = org_details_id;
		this.org_email_id = org_email_id;
		this.org_estd_date = org_estd_date;
		this.org_details = org_details;
		this.org_owner = org_owner;
		this.org_address = org_address;
		this.org_contact = org_contact;
		this.org = org;
	}

	public int getOrg_details_id() {
		return org_details_id;
	}
	
	public void setOrg_details_id(int org_details_id) {
		this.org_details_id = org_details_id;
	}
	
	public String getOrg_email_id() {
		return org_email_id;
	}
	
	public void setOrg_email_id(String org_email_id) {
		this.org_email_id = org_email_id;
	}
	
	public String getOrg_estd_date() {
		return org_estd_date;
	}
	
	public void setOrg_estd_date(String org_estd_date) {
		this.org_estd_date = org_estd_date;
	}
	
	public String getOrg_details() {
		return org_details;
	}
	
	public void setOrg_details(String org_details) {
		this.org_details = org_details;
	}
	
	public String getOrg_owner() {
		return org_owner;
	}
	
	public void setOrg_owner(String org_owner) {
		this.org_owner = org_owner;
	}
	
	public String getOrg_address() {
		return org_address;
	}
	
	public void setOrg_address(String org_address) {
		this.org_address = org_address;
	}
	
	public String getOrg_contact() {
		return org_contact;
	}
	
	public void setOrg_contact(String org_contact) {
		this.org_contact = org_contact;
	}
	
	public Organization getOrg() {
		return org;
	}

	public void setOrg(Organization org) {
		this.org = org;
	}

	@Override
	public String toString() {
		return "OrganizationDetails [org_details_id=" + org_details_id + ", org_email_id=" + org_email_id
				+ ", org_estd_date=" + org_estd_date + ", org_details=" + org_details + ", org_owner=" + org_owner
				+ ", org_address=" + org_address + ", org_contact=" + org_contact + ", org=" + org + "]";
	}

	

	
	
	
	
	
}
