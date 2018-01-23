package com.ims.actions;

public class Courses {

	public int course_id;
	public String course_name;
	public String course_duration;
	public double course_fees;
	
	
	
	public Courses() {
		
	}

	public Courses(int course_id, String course_name, String course_duration, double course_fees) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_duration = course_duration;
		this.course_fees = course_fees;
	}
	
	public int getCourse_id() {
		return course_id;
	}
	
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	
	public String getCourse_name() {
		return course_name;
	}
	
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	
	public String getCourse_duration() {
		return course_duration;
	}
	
	public void setCourse_duration(String course_duration) {
		this.course_duration = course_duration;
	}
	
	public double getCourse_fees() {
		return course_fees;
	}
	
	public void setCourse_fees(double course_fees) {
		this.course_fees = course_fees;
	}

	@Override
	public String toString() {
		return "Courses [course_id=" + course_id + ", course_name=" + course_name + ", course_duration="
				+ course_duration + ", course_fees=" + course_fees + "]";
	}
	
	
}
