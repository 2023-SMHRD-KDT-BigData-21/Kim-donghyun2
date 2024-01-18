package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class UserDAO {
	int row = 0;

	

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

	public ArrayList<UserVO> getRankingList() {
		ArrayList<UserVO> list=new ArrayList();
		getConn();

		try {

			
			String sqlQuery = "SELECT u_id,u_balance from user_info where rownum<=10 order by u_balance desc;";

			psmt = conn.prepareStatement(sqlQuery);

			rs = psmt.executeQuery();


			while (rs.next()) {

				String id = rs.getString(1);
				int balance = rs.getInt(2);

				list.add(new UserVO(id, balance));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
			
		}
		return list;

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
	
	//balance 불러오기
	public int Balance(UserVO member) {
		getConn();
		int bal = 0;
		try {
			String sql = "SELECT U_BALANCE FROM USER_INFO WHERE U_ID = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getId());
			rs = psmt.executeQuery();
			while (rs.next()) {
				bal = rs.getInt(1);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return bal;

	}

}
