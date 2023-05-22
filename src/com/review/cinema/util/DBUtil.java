package com.review.cinema.util;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}// static end

	public static Connection getConnection() {
		Connection conn = null;
//		try {
//
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspCinemaReview", "jspCinemaReview", "1234");
//			conn.setAutoCommit(false);
//
//		} catch (SQLException e) {
//			System.out.println("DBUtil Connection failed");
//			e.printStackTrace();
//		}
		
		Context initContext=null;
		try {
			initContext=new InitialContext();
			Context evContext =(Context)initContext.lookup("java:/comp/env");
			DataSource  ds =(DataSource)evContext.lookup("jdbc/mysql");
			
			conn=ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void close(Connection conn) {
		try {
			
			if(conn!=null)conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try {
			if(stmt!=null)stmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			if(rs!=null)rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void commit(Connection conn) {
		try {
			conn.commit();
			System.out.println("commit success");

		} catch (Exception e) {
			System.out.println("commit fail");
		}
	}

	public static void rollback(Connection conn) {
		try {
			conn.rollback();
			System.out.println("rollback success");

		} catch (Exception e) {
			System.out.println("rollback fail");
		}
	}
}// class end
