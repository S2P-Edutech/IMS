package com.ims.actions;

public class Student {

	public int student_id;
	public String student_name;
	public String student_email_id;
	public String college;
	public String student_phone;
	public int org_id;
	
	
	public Student() {
	
	}
	
	public Student(int student_id, String student_name, String student_email_id, String college, String student_phone) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_email_id = student_email_id;
		this.college = college;
		this.student_phone = student_phone;
		
	}
	
	public int getStudent_id() {
		return student_id;
	}
	
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	
	public String getStudent_name() {
		return student_name;
	}
	
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	
	public String getStudent_email_id() {
		return student_email_id;
	}
	
	public void setStudent_email_id(String student_email_id) {
		this.student_email_id = student_email_id;
	}
	
	public String getCollege() {
		return college;
	}
	
	public void setCollege(String college) {
		this.college = college;
	}
	
	public String getStudent_phone() {
		return student_phone;
	}
	
	public void setStudent_phone(String student_phone) {
		this.student_phone = student_phone;
	}
	
	public int getOrg_id() {
		return org_id;
	}

	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", student_email_id="
				+ student_email_id + ", college=" + college + ", student_phone=" + student_phone + ", org_id=" + org_id
				+ "]";
	}

	
	
	
	
	
}
