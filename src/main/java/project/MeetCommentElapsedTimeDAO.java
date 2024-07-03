package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MeetCommentElapsedTimeDAO {
	public static void main(String[] args) {
		MeetCommentElapsedTimeDAO mcedao = new MeetCommentElapsedTimeDAO();
        ArrayList<MeetCommentElapsedTimeDTO> list = null;        
        try {
        	list = mcedao.selectMeetCommentElapsedTimeDTO(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (MeetCommentElapsedTimeDTO meetCommentElapsedTimeDTO : list) {
        	System.out.println(meetCommentElapsedTimeDTO);
        }
    }
    
    public ArrayList<MeetCommentElapsedTimeDTO> selectMeetCommentElapsedTimeDTO(int comment_idx) throws SQLException {
        ArrayList<MeetCommentElapsedTimeDTO> list = new ArrayList<>();
        DatabaseUtil d = new DatabaseUtil();
        Connection conn = d.getConn();

        String sql = 
        		"SELECT TRUNC(sysdate - reg_date,0), "
        		+ "MOD(TRUNC((sysdate - reg_date )* 24 ,0),24), "
        		+ "MOD(TRUNC((sysdate - reg_date )* 24 * 60, 0),60) "
        		+ "FROM meet_comment "
        		+ "WHERE meet_comment_idx = ?";
        
        PreparedStatement pstmt = d.getPstmt(conn, sql);
        
        pstmt.setInt(1, comment_idx);

        ResultSet rs = d.getRs(pstmt);
        try {
            while (rs.next()) {
            	String day = rs.getString(1);
            	String time = rs.getString(2);
            	String minute = rs.getString(3);
            	
            	MeetCommentElapsedTimeDTO meetCommentElapsedTimeDTO = new MeetCommentElapsedTimeDTO(day, time, minute); // 저장한 값으로 SeatStatus 객체 생성
                list.add(meetCommentElapsedTimeDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
			d.close(conn, pstmt, rs);
        }
        return list;
    }
}
