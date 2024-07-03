package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.MeetInfoWriteDTO;
import dto.MeetIntroduceWriteDTO;
import project.DatabaseUtil;

public class MeetIntroduceWriteDAO {
	public static void main(String[] args) {
		MeetIntroduceWriteDAO mitwdao = new MeetIntroduceWriteDAO();
        try {
        	System.out.println(mitwdao.selectMeetIntroduceWriteDTO(1)); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public MeetIntroduceWriteDTO selectMeetIntroduceWriteDTO(int meet_idx) throws SQLException {
        DatabaseUtil d = new DatabaseUtil();
        Connection conn = d.getConn();

        String sql = 
        		"SELECT meet.name, meet.url, COUNT(m_m.meet_member_idx) "
        		+ "FROM meet meet, meet_member m_m  "
        		+ "WHERE meet.meet_idx = m_m.meet_idx "
        		+ "AND m_m.meet_idx = ? "
        		+ "GROUP BY meet.name, meet.url";
        
        PreparedStatement pstmt = d.getPstmt(conn, sql);
        pstmt.setInt(1, meet_idx);

        ResultSet rs = pstmt.executeQuery();
        
        MeetIntroduceWriteDTO meetIntroduceWriteDTO = null;
        
        if (rs.next()) {
        	String meet_name = rs.getString(1);
        	String url = rs.getString(2);
        	int meet_member_count = rs.getInt(3);
        	
        	meetIntroduceWriteDTO = new MeetIntroduceWriteDTO(meet_name, url, meet_member_count); // 저장한 값으로 SeatStatus 객체 생성
        }
            
        return meetIntroduceWriteDTO;
    }
}
