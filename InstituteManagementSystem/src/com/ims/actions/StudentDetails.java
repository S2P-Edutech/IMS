package com.ims.actions;

public class StudentDetails {

	public int student_details_id;
	public String student_address;
	public double student_ssc_score;
	public int student_ssc_passing_year;
	public double student_hsc_score;
	public int student_hsc_passing_year;
	public String student_degree_type;
	public boolean student_degree_status;
	public Student student;
	
	
	
	public StudentDetails() {
		
	}
	
	public StudentDetails(int student_details_id, String student_address, double student_ssc_score,
			int student_ssc_passing_year, double student_hsc_score, int student_hsc_passing_year,
			String student_degree_type, boolean student_degree_status, Student student) {
		super();
		this.student_details_id = student_details_id;
		this.student_address = student_address;
		this.student_ssc_score = student_ssc_score;
		this.student_ssc_passing_year = student_ssc_passing_year;
		this.student_hsc_score = student_hsc_score;
		this.student_hsc_passing_year = student_hsc_passing_year;
		this.student_degree_type = student_degree_type;
		this.student_degree_status = student_degree_status;
		this.student = student;
	}
	
	public int getStudent_details_id() {
		return student_details_id;
	}
	
	public void setStudent_details_id(int student_details_id) {
		this.student_details_id = student_details_id;
	}
	
	public String getStudent_address() {
		return student_address;
	}
	
	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}
	
	public double getStudent_ssc_score() {
		return student_ssc_score;
	}
	
	public void setStudent_ssc_score(double student_ssc_score) {
		this.student_ssc_score = student_ssc_score;
	}
	
	public int getStudent_ssc_passing_year() {
		return student_ssc_passing_year;
	}
	
	public void setStudent_ssc_passing_year(int student_ssc_passing_year) {
		this.student_ssc_passing_year = student_ssc_passing_year;
	}
	
	public double getStudent_hsc_score() {
		return student_hsc_score;
	}
	
	public void setStudent_hsc_score(double student_hsc_score) {
		this.student_hsc_score = student_hsc_score;
	}
	
	public int getStudent_hsc_passing_year() {
		return student_hsc_passing_year;
	}
	
	public void setStudent_hsc_passing_year(int student_hsc_passing_year) {
		this.student_hsc_passing_year = student_hsc_passing_year;
	}
	
	public String getStudent_degree_type() {
		return student_degree_type;
	}
	
	public void setStudent_degree_type(String student_degree_type) {
		this.student_degree_type = student_degree_type;
	}
	
	public boolean isStudent_degree_status() {
		return student_degree_status;
	}
	
	public void setStudent_degree_status(boolean student_degree_status) {
		this.student_degree_status = student_degree_status;
	}
	
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "StudentDetails [student_details_id=" + student_details_id + ", student_address=" + student_address
				+ ", student_ssc_score=" + student_ssc_score + ", student_ssc_passing_year=" + student_ssc_passing_year
				+ ", student_hsc_score=" + student_hsc_score + ", student_hsc_passing_year=" + student_hsc_passing_year
				+ ", student_degree_type=" + student_degree_type + ", student_degree_status=" + student_degree_status
				+ ", student=" + student + "]";
	}
	
	
	
	
	
}
