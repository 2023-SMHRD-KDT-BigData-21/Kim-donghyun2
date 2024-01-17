package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	public int Balance() {

		int bal = 0;
		try {
			String sql = "SELECT U_BALANCE FROM USER_INFO WHERE U_ID = ?";
			Connection conn = DriverManager.getConnection(sql);
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, sql);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				bal = rs.getInt(5);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return bal;
	}

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	public void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1523:xe";
			String user = "seocho_21K_bigdata_mini_1";
			String db_pw = "smhrd1";

			conn = DriverManager.getConnection(url, user, db_pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getClose() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String login(UserVO user) {
		String name = null;
		getConn();
		try {
			String sql = "select name from USER_INFO where id=? and pw =?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, user.getId());
			psmt.setString(2, user.getPw());

			rs = psmt.executeQuery();
			if (rs.next()) {
				name = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			getClose();
		}
		return name;
	}

}
