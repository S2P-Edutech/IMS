package com.ims.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ims.actions.UserDetails;
import com.ims.actions.Users;
import com.ims.dao.IUserDao;
import com.ims.util.DBConnectionManager;


public class UserDaoImpl implements IUserDao {

	@Override
	public List<Users> readUsersFromDb() {
		List<Users> userList = new ArrayList<Users>();
		DBConnectionManager dbm = new DBConnectionManager();
		
		try {
			Connection connection = dbm.getConnection();
			ResultSet resultSet;
			String query1 = "select * from users";
			PreparedStatement preparedStatement = connection.prepareStatement(query1);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){	
				String name = resultSet.getString(1);
				String password = resultSet.getString(2);
				int userid = resultSet.getInt(4);
				
				Users u = new Users(name,password);
				u.setUser_id(userid);
				userList.add(u);
				
			}
			
				
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return userList;
		
	}

	@Override
	public boolean validateUser(String u, String p) {
		
		DBConnectionManager dbm = new DBConnectionManager();
		
		try {
			Connection connection = dbm.getConnection();
			ResultSet resultSet;
			String query2="select * from users where user_name='" + u + "' and user_password='" + p + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(query2);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){	
				String n = resultSet.getString(1);
				String pw = resultSet.getString(2);
				
				
				if(n.equals(u) && p.equals(pw))
					return true;
				return false;
			
			}
			
			
			
				
				
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Users> getAllUsers() {
		
		return readUsersFromDb();
		 
	}

	@Override
	public UserDetails addUser(UserDetails user) {
		DBConnectionManager dbm = new DBConnectionManager();
	
		try {
			
			Connection connection = dbm.getConnection();
			//System.out.println(user);
			String query = "insert into users(user_name,user_password,org_id,user_id) values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getUser().getUsername());
			preparedStatement.setString(2, user.getUser().getUser_password());
			preparedStatement.setInt(3, user.getUser().getOrg_id());
			preparedStatement.setInt(4, user.getUser().getUser_id());
			preparedStatement.executeUpdate();
			String query1 = "insert into user_details(user_details_id,user_contact, user_address, user_id,user_email_id) values (?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query1);
			ps.setInt(1,user.getUser_details_id());
			ps.setString(2,user.getUser_contact());
			ps.setString(3,user.getUser_address());
			ps.setInt(4,user.getUser().getUser_id());
			ps.setString(5, user.getUser_email_id());
			ps.executeUpdate();
			preparedStatement.close();
			ps.close();
			connection.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(user);
		return user;
		
	}

}
