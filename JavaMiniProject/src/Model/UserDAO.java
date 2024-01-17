package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	public int Balance() {
	      //open() 들어갈자리
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
	         //close들어갈자리
	      }
	      return bal;
	   }
}
