package com.ims.actions;

public class CourseDetails {

		public int course_details_id;
		public String course_contents;
		public String course_description;
		public Courses course;
		
		public CourseDetails() {
			
		}
		public CourseDetails(int course_details_id, String course_contents, String course_description, Courses course) {
			super();
			this.course_details_id = course_details_id;
			this.course_contents = course_contents;
			this.course_description = course_description;
			this.course = course;
		}
		
		public int getCourse_details_id() {
			return course_details_id;
		}
		
		public void setCourse_details_id(int course_details_id) {
			this.course_details_id = course_details_id;
		}
		
		public String getCourse_contents() {
			return course_contents;
		}
		
		public void setCourse_contents(String course_contents) {
			this.course_contents = course_contents;
		}
		
		public String getCourse_description() {
			return course_description;
		}
		
		public void setCourse_description(String course_description) {
			this.course_description = course_description;
		}
		
		public Courses getCourse() {
			return course;
		}
		
		public void setCourse(Courses course) {
			this.course = course;
		}
		@Override
		public String toString() {
			return "CourseDetails [course_details_id=" + course_details_id + ", course_contents=" + course_contents
					+ ", course_description=" + course_description + ", course=" + course + "]";
		}
		
		
		
}
