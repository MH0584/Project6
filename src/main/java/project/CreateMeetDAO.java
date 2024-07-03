package project;

import project.DatabaseUtil;

import java.sql.*;

public class CreateMeetDAO {

	   public static void main(String[] args) {
		   CreateMeetDAO cmdao = new CreateMeetDAO();
		   cmdao.createMeet("영화 좋아하는 사람", "db/dataimagelist/meet05_photo02.png", "Y", "서울시 성동구", "무슨 장르를 좋아하시나요",
				   "Y", "Y", 3);
	   }

	    public void createMeet(String name, String url, String public_ok, String area, String sub_q, String join_ok, String sub_qok, int color) {
	        DatabaseUtil d = new DatabaseUtil();
	        Connection conn = d.getConn();

	        String sql = 
	              "INSERT INTO MEET (MEET_IDX, NAME, URL, PUBLIC_OK, AREA, SUB_Q, JOIN_OK, SUB_QOK, COLOR)  "
	              + "VALUES (seq_meet.nextval, ?, ?, ?, "
	              + "?, ?, ?, ?, ?)";
	        PreparedStatement pstmt = d.getPstmt(conn, sql);
	        try {
		        pstmt.setString(1, name);
		        pstmt.setString(2, url);
		        pstmt.setString(3, public_ok);
		        pstmt.setString(4, area);
		        pstmt.setString(5, sub_q);
		        pstmt.setString(6, join_ok);
		        pstmt.setString(7, sub_qok);
		        pstmt.setInt(8, color);
		        
		        int result = pstmt.executeUpdate();
		        System.out.println(result + "행 성공적으로 업데이트됨");
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         d.close(conn, pstmt);
		      }
	    }
	}
