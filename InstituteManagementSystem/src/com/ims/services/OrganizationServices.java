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

import com.ims.actions.Organization;
import com.ims.actions.OrganizationDetails;
import com.ims.daoimpl.OrganizationDaoImpl;
import com.ims.util.DBConnectionManager;

@Path("/org")
public class OrganizationServices {

	OrganizationDaoImpl odi = new OrganizationDaoImpl();
	
	@Path("/allOrg")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Organization> getAllData() {
		List<Organization> orgList = this.odi.getAllData();

		return orgList;
	}	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/newOrg")
	public Response addOrganization(OrganizationDetails or){
		
		DBConnectionManager dbm = new DBConnectionManager();
		
		try {
			Connection connection = dbm.getConnection();
			ResultSet resultSet;
			String sql="select * from organization where org_id='" + or.getOrg().getOrg_id() + "' and org_name='" + or.getOrg().getOrg_name() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
			int checkId=resultSet.getInt(1);
		    String checkName=resultSet.getString(2);
		    
		    if(checkId==(or.getOrg().getOrg_id()) && (checkName.equals(or.getOrg().getOrg_name()))){
		    	
		    	System.out.println("Record already exists..!!");
		    	//Response.status(406,"Record already exists.");

		    	return Response.status(Response.Status.NOT_ACCEPTABLE).entity(or).build();
		    }
		    
			}
	}catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
    	
		odi.addOrganization(or);

		return Response.status(Response.Status.ACCEPTED).entity(or).build();
		
	}
}
