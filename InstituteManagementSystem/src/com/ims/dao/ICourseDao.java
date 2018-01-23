package com.ims.dao;

import java.util.List;

import com.ims.actions.CourseDetails;
import com.ims.actions.Courses;

public interface ICourseDao {
	List<Courses> readCoursesFromDb();
	List<Courses> getAllData();
	CourseDetails addCourse(CourseDetails c);
}
