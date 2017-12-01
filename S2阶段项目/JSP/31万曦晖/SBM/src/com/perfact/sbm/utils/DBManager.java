package com.perfact.sbm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBManager {

	private static Connection con;
	private static final String DRIVERNAME ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL ="jdbc:sqlserver://localhost:1433;databaseName=db_SBM";
	private static final String USERNAME="sa";
	private static final String PASSWORD="123456";
	public static Connection getConnection() {
		try {
			Class.forName(DRIVERNAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con= DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void cloes(PreparedStatement ps, Connection con) {
		// TODO Auto-generated method stub
		
	}

}
