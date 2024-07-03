package project;

import project.DatabaseUtil;

import java.sql.*;

public class CreateMeetRecWriteDAO {

	   public static void main(String[] args) {
		   CreateMeetRecWriteDAO cmrdao = new CreateMeetRecWriteDAO();
		   cmrdao.createMeetRecWrite(3, "우리 소모임에 초대합니당", null);
	   }

	    public void createMeetRecWrite(int meet_idx, String title, String url) {
	        DatabaseUtil d = new DatabaseUtil();
	        Connection conn = d.getConn();

	        String sql = 
	              "INSERT INTO MEET_REC_WRITE(meet_rec_write_idx, meet_idx, title, url) "
	              + "VALUES (seq_meet_rec_write.nextval, ?, ?, ?)";
	        PreparedStatement pstmt = d.getPstmt(conn, sql);
	        try {
		        pstmt.setInt(1, meet_idx);
		        pstmt.setString(2, title);
		        pstmt.setString(3, url);
		        
		        int result = pstmt.executeUpdate();
		        System.out.println(result + "행 성공적으로 업데이트됨");
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         d.close(conn, pstmt);
		      }
	    }
	}