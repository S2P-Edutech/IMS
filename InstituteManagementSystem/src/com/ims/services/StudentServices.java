package com.ims.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ims.actions.Student;
import com.ims.actions.StudentDetails;
import com.ims.daoimpl.StudentDaoImpl;
import com.ims.util.DBConnectionManager;

@Path("/student")
public class StudentServices extends Application {

	StudentDaoImpl sdi = new StudentDaoImpl();
	
	@Path("/allStudents")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudents() {
		List<Student> studentList = this.sdi.getAllStudents();

		return studentList;
	}	
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/newStudent")
	public Response addStudents(StudentDetails s){
		
		DBConnectionManager dbm = new DBConnectionManager();
		
		try {
			Connection connection = dbm.getConnection();
			ResultSet resultSet;
			String sql="select * from student where student_id='" + s.getStudent().getStudent_id() + "' and student_name='" + s.getStudent().getStudent_name() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
			int checkId=resultSet.getInt(1);
		    String checkName=resultSet.getString(2);
		    
		    if(checkId==(s.getStudent().getStudent_id()) && (checkName.equals(s.getStudent().getStudent_name()))){
		    	
		    	System.out.println("Record already exists..!!");
		    	Response.status(406,"Record already exists.");

		    	return Response.status(Response.Status.NOT_ACCEPTABLE).entity(s).build();
		    }
		    
			}
	}catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
    	
		sdi.addStudent(s);

		return Response.status(Response.Status.ACCEPTED).entity(s).build();
		
	}
}
