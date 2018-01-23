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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ims.actions.CourseDetails;
import com.ims.actions.Courses;
import com.ims.daoimpl.CourseDaoImpl;
import com.ims.util.DBConnectionManager;

@Path("/course")
public class CourseServices {

	CourseDaoImpl cdi = new CourseDaoImpl();
	
	@Path("/allCourses")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Courses> getAllData() {
		List<Courses> cList = this.cdi.getAllData();

		return cList;
	}	
	

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/newCourse")
	public Response addCourse(CourseDetails cr){
		
		DBConnectionManager dbm = new DBConnectionManager();
		
		try {
			Connection connection = dbm.getConnection();
			ResultSet resultSet;
			String sql="select * from courses where course_id='" + cr.getCourse().getCourse_id() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
			int checkId=resultSet.getInt(1);
		    
		    if(checkId==(cr.getCourse().getCourse_id())){
		    	
		    	System.out.println("Record already exists..!!");

		    	return Response.status(Response.Status.NOT_ACCEPTABLE).entity(cr).build();
		    }
		    
			}
	}catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
    	
		cdi.addCourse(cr);

		return Response.status(Response.Status.ACCEPTED).entity(cr).build();
		
	}
}
