package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.MeetInfoWriteDTO;
import project.DatabaseUtil;

public class MeetInfoWriteDAO {
	public static void main(String[] args) {
		MeetInfoWriteDAO miwdao = new MeetInfoWriteDAO();
        try {
        	System.out.println(miwdao.selectMeetInfoWriteDTO(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public MeetInfoWriteDTO selectMeetInfoWriteDTO(int meet_idx) throws SQLException {
        DatabaseUtil d = new DatabaseUtil();
        Connection conn = d.getConn();

        String sql = 
        		"SELECT title, m.area "
        		+ "FROM meet_rec_write r, meet m "
        		+ "WHERE r.meet_idx = m.meet_idx "
        		+ "AND m.meet_idx = ?";

        PreparedStatement pstmt = d.getPstmt(conn, sql);
        
        pstmt.setInt(1, meet_idx);

        ResultSet rs = pstmt.executeQuery();
        MeetInfoWriteDTO meetInfoWriteDTO = null;
        
	    if (rs.next()) {
	    	String title = rs.getString(1); 
	    	String area = rs.getString(2); 
	    	
	    	meetInfoWriteDTO = new MeetInfoWriteDTO(title, area); // 저장한 값으로 SeatStatus 객체 생성
	    }
	    
	    return meetInfoWriteDTO;
    }
}
