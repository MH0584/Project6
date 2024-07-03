package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MeetNameProfileColorSettingDAO {
	public static void main(String[] args) {
		MeetNameProfileColorSettingDAO mnpdao = new MeetNameProfileColorSettingDAO();
		   mnpdao.meetNameProfileColorSetting("연극을 싫어할 수 없는 모임", "db/dataimagelist/meet05_photo03.png", 4, 1);
	   }

	    public void meetNameProfileColorSetting(String name, String url, int color, int meet_idx) {
	        DatabaseUtil d = new DatabaseUtil();
	        Connection conn = d.getConn();
	        
	        String sql = 
	              "UPDATE meet "
	              + "SET name = ?, url = ?, color = ? "
	              + "WHERE meet_idx = ?";
	        
	        PreparedStatement pstmt = d.getPstmt(conn, sql);
	        try {
		        pstmt.setString(1, name);
		        pstmt.setString(2, url);
		        pstmt.setInt(3, color);
		        pstmt.setInt(4, meet_idx);
		        
		        int result = pstmt.executeUpdate();
		        System.out.println(result + "행 성공적으로 업데이트됨");
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         d.close(conn, pstmt);
		      }
	    }
}
