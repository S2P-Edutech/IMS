package com.ims.actions;

public class Users {
	public int user_id;
	public int org_id;
	public String username;
	public String user_password;
	
	public Users(){
		
	}
	
	public Users(String username, String user_password) {
		super();
		this.username = username;
		this.user_password = user_password;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public int getOrg_id() {
		return org_id;
	}

	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", username=" + username + ", user_password=" + user_password + "]";
	}

	
	
	
}
