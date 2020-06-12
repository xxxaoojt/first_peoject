package com.exam.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	
	private static final String DRIVER_CLASS="com.mysql.jdbc.Driver";
	private static final String DRIVER_URL="jdbc:mysql:///demo?useUnicode=true&characterEncoding=UTF-8";
	private static final String DRIVER_USER="root";
	private static final String DRIVER_PWD="123456";
	protected Connection conn ;
	protected PreparedStatement pstmt ;
	protected ResultSet rs ;
	static {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 数据连接工具类
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(DRIVER_URL, DRIVER_USER, DRIVER_PWD) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 通用的查询方法
	 * @param sql
	 * @param params
	 * @return
	 */
	public ResultSet commonQuery(String sql,Object...params) {
		try {
			conn = getConnection() ;
			pstmt = conn.prepareStatement(sql);
			setValues(pstmt,params);
			rs =  pstmt.executeQuery() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return rs ;
	}
	/**
	 * 通用的增删改
	 * @param sql
	 * @param params
	 * @return
	 */
	public int commonUpdate(String sql,Object...params) {
		try {
			conn = getConnection() ;
			pstmt = conn.prepareStatement(sql);
			setValues(pstmt,params);
			return pstmt.executeUpdate() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn,pstmt,rs);
		}
		return 0 ;
	}
	/**
	 * 通用的关闭方法
	 * @param conn
	 * @param pstmt
	 * @param rs
	 */
	public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close(); 
			}
			if(pstmt != null) {
				pstmt.close(); 
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 设置参数的方法
	 * @param pstmt2
	 * @param params
	 * @throws SQLException 
	 */
	private void setValues(PreparedStatement pstmt, Object... params) throws SQLException {
		if(params != null && params.length > 0) {
			for(int i = 0 ;i<params.length ;i++) {
				pstmt.setObject(i+1, params[i]);
			}
		}
	}
	public Connection getConn() {
		return conn;
	}
	public PreparedStatement getPstmt() {
		return pstmt;
	}
	
	
}
