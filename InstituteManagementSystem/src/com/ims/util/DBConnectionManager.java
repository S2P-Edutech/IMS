package com.ims.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager implements DatabaseUtil
{
	Connection connection;
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}

}
	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/imsdb", "root", "root");
		return connection;
	}
	@Override
	public void closeConnection() throws SQLException {
		connection.close();
	}
}