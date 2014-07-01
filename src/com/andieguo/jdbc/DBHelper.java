package com.andieguo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBHelper {

	public static void queryAllByStatement() {
		List<User> users = new ArrayList<User>();
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from user");
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getBoolean("gender"));
				user.setRegtime(rs.getDate("regtime"));
				System.out.println(user.toString());
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(stmt);
			DBConnection.closeConnection(conn);
		}
	}

	public static void queryAllByprepareStatement() {
		List<User> users = new ArrayList<User>();
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from user");
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getBoolean("gender"));
				user.setRegtime(rs.getDate("regtime"));
				System.out.println(user.toString());
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConnection(conn);
		}
	}

	public static void queryById(Integer id) {
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from user where id = " + id);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getBoolean("gender"));
				user.setRegtime(rs.getDate("regtime"));
				System.out.println(user.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(stmt);
			DBConnection.closeConnection(conn);
		}
	}

	public static void queryByUser(String username,String password) {
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from user where username = '" + username+"' and password='"+password+"'");
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getBoolean("gender"));
				user.setRegtime(rs.getDate("regtime"));
				System.out.println(user.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(stmt);
			DBConnection.closeConnection(conn);
		}
	}

	
	public static void queryPrepareById(Integer id) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from user where id = ?");
			ps.setInt(1, id);// 设置占位符参数
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getBoolean("gender"));
				user.setRegtime(rs.getDate("regtime"));
				System.out.println(user.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConnection(conn);
		}
	}

	public static void queryPrepareByUser(String username,String password) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from user where username = ? and password = ?");
			ps.setString(1,username);// 设置占位符参数
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getBoolean("gender"));
				user.setRegtime(rs.getDate("regtime"));
				System.out.println(user.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConnection(conn);
		}
	}
	
}
