package com.andieguo.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 该类封装了连接和关闭数据库连接操作
 * 
 * @author andieguo
 * 
 */
public class DBConnection {

	public static Connection getConnection() {
		Properties props = new Properties();
		FileInputStream fis = null;
		Connection con = null;
		try {
			fis = new FileInputStream("db.properties");
			props.load(fis);
			// 加载驱动
			Class.forName(props.getProperty("DB_DRIVER_CLASS"));
			// 创建一个连接
			con = DriverManager.getConnection(props.getProperty("DB_URL"), props.getProperty("DB_USERNAME"), props.getProperty("DB_PASSWORD"));
		} catch (IOException | SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

	// 关闭ResultSet
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 关闭Statement
	public static void closeStatement(Statement stm) {
		if (stm != null) {
			try {
				stm.close();
				stm = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 关闭PreparedStatement
	public static void closePreparedStatement(PreparedStatement pstm) {
		if (pstm != null) {
			try {
				pstm.close();
				pstm = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 关闭Connection
	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			con = null;
		}
	}

}
