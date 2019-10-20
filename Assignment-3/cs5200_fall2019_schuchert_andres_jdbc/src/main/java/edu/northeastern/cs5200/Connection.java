package edu.northeastern.cs5200;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://cs5200-fall2019-schuchert.ckldewbxxzcn.us-east-1.rds.amazonaws.com/assignment_3";
	private static final String USER = "aschuchert";
	private static final String PASSWORD = "database2019";
	private static java.sql.Connection dbConnection = null;
	
	public static java.sql.Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		if(dbConnection == null) {
			dbConnection = DriverManager.getConnection(URL,USER,PASSWORD);
			return dbConnection;
		}
		else {
			return dbConnection;
		}
	}
	public static void closeConnection() {
		try {
			if(dbConnection != null) {
				dbConnection.close();
				dbConnection = null;
			}
		} catch (SQLException e) {
			//TODO AUTO-generated catch block
			e.printStackTrace();
		}
	}
}
