package com.springbook.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDBCUtil
 * 
 * @author jin.junho(ジンジュンホ、800189)
 * @since 18/05/22
 * @version JDK 1.8
 */

public class JDBCUtil {
	
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println(":ドライバーローディングしました。");
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jazzjun","wnshwnsh888");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close() {
		try {
			if( conn != null ) {
				conn.close();
			}
			if( rs != null ) {
				rs.close();
			}
			if( pstmt != null ) {
				pstmt.close();
			}
			System.out.println("DB EXIT");
		}catch (SQLException e) {
			System.out.println("データベースからの切断エラー" + e);
		}
	}
}