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

import com.ims.actions.UserDetails;
import com.ims.actions.Users;
import com.ims.daoimpl.UserDaoImpl;
import com.ims.util.DBConnectionManager;

@Path("/UserLogin")               
public class UserServices extends Application {

	UserDaoImpl udi = new UserDaoImpl();
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/validateUser")
	public boolean validateUserLogin(Users u)
	{
		
		System.out.println(u);
		UserDaoImpl udi = new UserDaoImpl();
		
		if(udi.validateUser(u.getUsername(), u.getUser_password()))
		{
			return true;
		}
		else
			return false;
		
		
	}
	
	@Path("/allUsers")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Users> getAllUser() {
		List<Users> usersList = this.udi.getAllUsers();

		return usersList;
		
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/newUser")
	public Response addUser(UserDetails u){
		
		
		DBConnectionManager dbm = new DBConnectionManager();
		
		try {
			Connection connection = dbm.getConnection();
			ResultSet resultSet;
			String sql="select * from users where user_name='" + u.getUser().getUsername() + "' and user_password='" + u.getUser().getUser_password() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
			String checkUser=resultSet.getString(1);
		    String checkPass=resultSet.getString(2);
		    
		    if(checkUser.equals(u.getUser().getUsername()) && (checkPass.equals(u.getUser().getUser_password()))){
		    	
		    	System.out.println("Record already exists..!!");
		    	Response.status(406,"Record already exists. Try new username and password");
		    	return Response.status(Response.Status.NOT_ACCEPTABLE).entity(u).build();
		    }
		    else{
		    	udi.addUser(u);
		    	
		    }
			}
	}catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
		return Response.status(Response.Status.ACCEPTED).entity(u).build();
		
	}
	
}


	

