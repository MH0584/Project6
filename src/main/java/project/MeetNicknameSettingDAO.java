package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MeetNicknameSettingDAO {
	public static void main(String[] args) {
		MeetNicknameSettingDAO mnpdao = new MeetNicknameSettingDAO();
		   mnpdao.meetNicknameSetting("빵빵", 3, 3);
	   }

	    public void meetNicknameSetting(String nickname, int member_idx, int meet_idx) {
	        DatabaseUtil d = new DatabaseUtil();
	        Connection conn = d.getConn();
	        
	        String sql = 
	              "UPDATE meet_member "
	              + "SET nickname = ? "
	              + "WHERE member_idx = ? "
	              + "AND meet_idx = ?";
	        
	        PreparedStatement pstmt = d.getPstmt(conn, sql);
	        try {
		        pstmt.setString(1, nickname);
		        pstmt.setInt(2, member_idx);
		        pstmt.setInt(3, meet_idx);
		        
		        int result = pstmt.executeUpdate();
		        System.out.println(result + "행 성공적으로 업데이트됨");
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         d.close(conn, pstmt);
		      }
	    }
}
