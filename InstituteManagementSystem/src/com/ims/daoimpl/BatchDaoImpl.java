package com.ims.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.ims.actions.Batches;
import com.ims.dao.IBatchesDao;
import com.ims.util.DBConnectionManager;

public class BatchDaoImpl implements IBatchesDao {

	@Override
	public List<Batches> readDataFromDb() {
		List<Batches> batchList = new ArrayList<Batches>();
		DBConnectionManager dbm = new DBConnectionManager();
		
		try {
			Connection connection = dbm.getConnection();
			ResultSet resultSet;
			String query1 = "select * from batches";
			PreparedStatement preparedStatement = connection.prepareStatement(query1);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){	
				int batch_id = resultSet.getInt(1);
				String batch_timings = resultSet.getString(2);
				String batch_start_date = resultSet.getString(3);
				String batch_end_date = resultSet.getString(4);
				int course_id = resultSet.getInt(5);
				int org_id = resultSet.getInt(6);
				
		
				Batches batch = new Batches(batch_id, course_id, org_id, batch_timings, batch_start_date, batch_end_date);
				batchList.add(batch);
				
			}
			
				
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(batchList);
		return batchList;
		
	}

	@Override
	public List<Batches> getAllData() {
		
		return readDataFromDb();
	}

	@Override
	public Batches addBatch(Batches b) {
		
		DBConnectionManager dbm = new DBConnectionManager();
		
		try {
			
			Connection connection = dbm.getConnection();
			//System.out.println(user);
			String query = "insert into batches(batch_id,course_id,org_id,batch_timings,batch_start_date,batch_end_date) values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, b.getBatch_id());
			preparedStatement.setInt(2, b.getCourse_id());
			preparedStatement.setInt(3, b.getOrg_id());
			preparedStatement.setString(4, b.getBatch_timings());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date sdate = sdf.parse(b.getBatch_start_date());
			java.sql.Date sDate = new java.sql.Date(sdate.getTime());  
			preparedStatement.setDate(5,sDate);
			java.util.Date edate = sdf.parse(b.getBatch_end_date());
			java.sql.Date eDate = new java.sql.Date(edate.getTime());  
			preparedStatement.setDate(6, eDate);
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			
		} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
		} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
		
		System.out.println(b);
		return b;
	}
	
}
