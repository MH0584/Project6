package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import project.DatabaseUtil;

public class MeetChatMemberDeleteDAO {
	public static void main(String[] args) {
		MeetChatMemberDeleteDAO mcddao = new MeetChatMemberDeleteDAO();
		   mcddao.meetChatMemberDelete(13, 10);
	   }

	    public void meetChatMemberDelete(int unread_member_idx, int message_idx) {
	        DatabaseUtil d = new DatabaseUtil();
	        Connection conn = d.getConn();

	        String sql = 
	              "DELETE FROM read_ok "
	              + "WHERE unread_member_idx = ? "
	              + "AND message_idx = ?";
	        
	        PreparedStatement pstmt = d.getPstmt(conn, sql);
	        try {
		        pstmt.setInt(1, unread_member_idx);
		        pstmt.setInt(2, message_idx);
		        
		        int result = pstmt.executeUpdate();
		        System.out.println(result + "행 성공적으로 삭제됨");
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         d.close(conn, pstmt);
		      }
	    }
}
