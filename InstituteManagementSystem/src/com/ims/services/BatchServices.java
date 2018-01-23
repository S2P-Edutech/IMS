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

import com.ims.actions.Batches;
import com.ims.daoimpl.BatchDaoImpl;
import com.ims.util.DBConnectionManager;

@Path("/batch")
public class BatchServices {

	BatchDaoImpl bdi =  new BatchDaoImpl();
	
	 
	@Path("/allBatches")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Batches> getAllData() {
		List<Batches> bList = this.bdi.getAllData();

		return bList;
	}	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/newBatch")
	public Response addBatch(Batches b){
		
		DBConnectionManager dbm = new DBConnectionManager();
		
		try {
			Connection connection = dbm.getConnection();
			ResultSet resultSet;
			String sql="select * from batches where org_id='" + b.getOrg_id() + "' and batch_id'" + b.getBatch_id() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
			int checkOid=resultSet.getInt(1);
		    int checkBid=resultSet.getInt(2);
		    
		    if((checkBid==(b.getBatch_id())) && (checkOid ==(b.getOrg_id()))){
		    	
		    	System.out.println("Record already exists..!!");
		    	//Response.status(406,"Record already exists.");

		    	return Response.status(Response.Status.NOT_ACCEPTABLE).entity(b).build();
		    }
		    
			}
	}catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
    	
		bdi.addBatch(b);

		return Response.status(Response.Status.ACCEPTED).entity(b).build();
		
	}
	

}
