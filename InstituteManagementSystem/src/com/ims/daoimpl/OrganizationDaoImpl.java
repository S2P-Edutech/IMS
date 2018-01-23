package com.ims.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.ims.actions.Organization;
import com.ims.actions.OrganizationDetails;
import com.ims.dao.IOrganizationDao;
import com.ims.util.DBConnectionManager;

public class OrganizationDaoImpl implements IOrganizationDao{

	@Override
	public List<Organization> readDataFromDb() {
		List<Organization> orgList = new ArrayList<Organization>();
		DBConnectionManager dbm = new DBConnectionManager();
		
		try {
			Connection connection = dbm.getConnection();
			ResultSet resultSet;
			String query1 = "select * from organization";
			PreparedStatement preparedStatement = connection.prepareStatement(query1);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){	
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
		
				Organization o = new Organization(id,name);
				orgList.add(o);
				
			}
			
				
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(orgList);
		
		return orgList;
		
	}

	@Override
	public List<Organization> getAllData() {
		return readDataFromDb();
	}

	@Override
	public OrganizationDetails addOrganization(OrganizationDetails org) {
		
		DBConnectionManager dbm = new DBConnectionManager();
		
		try {
			
			Connection connection = dbm.getConnection();
			//System.out.println(user);
			String query = "insert into organization(org_id,org_name) values(?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, org.getOrg().getOrg_id());
			preparedStatement.setString(2, org.getOrg().getOrg_name());
			preparedStatement.executeUpdate();
			String query1 = "insert into organization_details(org_id,org_estd_date,org_description,org_owner,org_address,org_contact,org_details_id,org_email_id) values (?,?,?,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query1);
			ps.setInt(1, org.getOrg().getOrg_id());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = sdf.parse(org.getOrg_estd_date());
			java.sql.Date estDate = new java.sql.Date(date.getTime());  
			ps.setDate(2, estDate );
			ps.setString(3, org.getOrg_details());
			ps.setString(4, org.getOrg_owner());
			ps.setString(5, org.getOrg_address());
			ps.setString(6, org.getOrg_contact());
			ps.setInt(7, org.getOrg_details_id());
			ps.setString(8, org.getOrg_email_id());
			ps.executeUpdate();
			preparedStatement.close();
			ps.close();
			connection.close();
	} catch (ClassNotFoundException | SQLException e) {
	
	e.printStackTrace();
	}  catch (ParseException e) {
		e.printStackTrace();
	}
		
		
		System.out.println(org);
		return org;
	}
}