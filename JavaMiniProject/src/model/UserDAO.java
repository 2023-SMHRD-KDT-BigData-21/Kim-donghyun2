package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	int row = 0;

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

	public int join(UserVO member) {
		// DB연결 호출
		getConn();
		try {
			String sql = "insert into user_info values(?,?,?,?,?)";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPw());
			psmt.setString(3, member.getName());
			psmt.setInt(4, member.getAge());
			psmt.setDouble(5, member.getBalance());

			row = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return row;
	}

	public String login(UserVO member) {
		String name = null;
		getConn();
		try {
			String sql = "select U_NAME from USER_INFO where U_ID =? and U_PW =?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPw());

			rs = psmt.executeQuery();
			if (rs.next()) {
				name = rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return name;
	}

}
