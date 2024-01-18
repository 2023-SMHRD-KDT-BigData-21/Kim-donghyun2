package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class UserDAO {
	public int Balance() {
	     
	      int bal = 0;
	      try {
	         String sql = "SELECT U_BALANCE FROM USER_INFO WHERE U_ID = ?";
	         Connection conn = DriverManager.getConnection(sql);
	         PreparedStatement psmt = conn.prepareStatement(sql);
	         psmt.setString(1, sql);
	         ResultSet rs =   psmt.executeQuery();
	         if(rs.next()) {
	            bal = rs.getInt(5);
	         }
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         
	      }
	      return bal;
	   }
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	public void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "service";
			String db_pw = "12345";
			
			conn = DriverManager.getConnection(url, user, db_pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void getClose() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
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

}
