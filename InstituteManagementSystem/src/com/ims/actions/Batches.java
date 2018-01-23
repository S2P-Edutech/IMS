package com.ims.actions;

public class Batches {

	public int batch_id;
	public int course_id;
	public int org_id;
	public String batch_timings;
	public String batch_start_date;
	public String batch_end_date;
	
	public Batches() {
	
	}
	public Batches(int batch_id, int course_id, int org_id, String batch_timings, String batch_start_date,
			String batch_end_date) {
		super();
		this.batch_id = batch_id;
		this.course_id = course_id;
		this.org_id = org_id;
		this.batch_timings = batch_timings;
		this.batch_start_date = batch_start_date;
		this.batch_end_date = batch_end_date;
	}
	public int getBatch_id() {
		return batch_id;
	}
	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
	}
	
	public int getCourse_id() {
		return course_id;
	}
	
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	
	public int getOrg_id() {
		return org_id;
	}
	
	public void setOrg_id(int org_id) {
		this.org_id = org_id;
	}
	
	public String getBatch_timings() {
		return batch_timings;
	}
	
	public void setBatch_timings(String batch_timings) {
		this.batch_timings = batch_timings;
	}
	
	public String getBatch_start_date() {
		return batch_start_date;
	}
	
	public void setBatch_start_date(String batch_start_date) {
		this.batch_start_date = batch_start_date;
	}
	
	public String getBatch_end_date() {
		return batch_end_date;
	}
	
	public void setBatch_end_date(String batch_end_date) {
		this.batch_end_date = batch_end_date;
	}
	
	
	@Override
	public String toString() {
		return "Batches [batch_id=" + batch_id + ", course_id=" + course_id + ", org_id=" + org_id + ", batch_timings="
				+ batch_timings + ", batch_start_date=" + batch_start_date + ", batch_end_date=" + batch_end_date + "]";
	}
	
	
	
	
	
}
