package com.ims.util;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseUtil {
	public Connection getConnection() throws ClassNotFoundException, SQLException;
	public void closeConnection() throws SQLException;
	
}
