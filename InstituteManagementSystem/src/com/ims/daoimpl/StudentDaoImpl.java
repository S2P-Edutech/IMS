package com.ims.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ims.actions.Student;
import com.ims.actions.StudentDetails;
import com.ims.dao.IStudentDao;
import com.ims.util.DBConnectionManager;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public List<Student> readStudentFromDb() {
		List<Student> studentList = new ArrayList<Student>();
		DBConnectionManager dbm = new DBConnectionManager();
		
		try {
			Connection connection = dbm.getConnection();
			ResultSet resultSet;
			String query1 = "select * from student";
			PreparedStatement preparedStatement = connection.prepareStatement(query1);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){	
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String email = resultSet.getString(3);
				String college = resultSet.getString(4);
				String phone = resultSet.getString(5);
				
				Student s = new Student(id,name,email,college,phone);
				studentList.add(s);
				
			}
			
				
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(studentList);
		return studentList;
		
	}

	@Override
	public List<Student> getAllStudents() {
		
		return readStudentFromDb();
	}

	@Override
	public StudentDetails addStudent(StudentDetails student) {
		DBConnectionManager dbm = new DBConnectionManager();
		
		try {
			
			Connection connection = dbm.getConnection();
			//System.out.println(user);
			String query = "insert into student(student_id,student_name,student_email,student_college,student_phone,org_id) values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,student.getStudent().getStudent_id());
			preparedStatement.setString(2,student.getStudent().getStudent_name());
			preparedStatement.setString(3, student.getStudent().getStudent_email_id());
			preparedStatement.setString(4,student.getStudent().getCollege());
			preparedStatement.setString(5,student.getStudent().getStudent_phone());
			preparedStatement.setInt(6, student.getStudent().getOrg_id());
			preparedStatement.executeUpdate();
			
			String query1 = "insert into student_details(student_details_id, student_address, student_ssc_score, student_ssc_passing_year,"
					+ "student_hsc_score,student_hsc_passing_year,student_degree,student_degree_status,student_id) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query1);
			ps.setInt(1, student.getStudent_details_id());
			ps.setString(2, student.getStudent_address());
			ps.setDouble(3, student.getStudent_ssc_score());
			ps.setInt(4,student.getStudent_ssc_passing_year());
			ps.setDouble(5, student.getStudent_hsc_score());
			ps.setInt(6, student.getStudent_hsc_passing_year());
			ps.setString(7, student.getStudent_degree_type());
			ps.setBoolean(8, student.isStudent_degree_status());
			ps.setInt(9, student.getStudent().getStudent_id());
			ps.executeUpdate();
			preparedStatement.close();
			ps.close();
			connection.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(student);
		return student;
		
	
	}

	
}
