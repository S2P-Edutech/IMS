package com.ims.dao;

import java.util.List;
import com.ims.actions.Student;
import com.ims.actions.StudentDetails;

public interface IStudentDao {

	List<Student> readStudentFromDb();
	List<Student> getAllStudents();
	StudentDetails addStudent(StudentDetails student);
}
