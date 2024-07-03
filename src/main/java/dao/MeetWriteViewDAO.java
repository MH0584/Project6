package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.MeetWriteViewDTO;
import project.DatabaseUtil;

public class MeetWriteViewDAO {
	public static void main(String[] args) {
		MeetWriteViewDAO mwdao = new MeetWriteViewDAO();
        ArrayList<MeetWriteViewDTO> list = null;        
        try {
        	list = mwdao.selectMeetWriteViewDTO(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (MeetWriteViewDTO meetWriteViewDTO : list) {
        	System.out.println(meetWriteViewDTO);
        }
    }
    
    public ArrayList<MeetWriteViewDTO> selectMeetWriteViewDTO(int post_idx) throws SQLException {
        ArrayList<MeetWriteViewDTO> list = new ArrayList<>();
        DatabaseUtil d = new DatabaseUtil();
        Connection conn = d.getConn();

        String sql = 
        		"SELECT m.nickname, m_m.profile, p.views, p.reg_date, p.content, p.file_url "
        		+ "FROM member m, meet_member m_m, post p "
        		+ "WHERE m.member_idx = m_m.member_idx "
        		+ "AND p.meet_member_idx = m_m.meet_member_idx "
        		+ "AND p.post_idx = ?";
        
        PreparedStatement pstmt = d.getPstmt(conn, sql);
        
        pstmt.setInt(1, post_idx);

        ResultSet rs = d.getRs(pstmt);
        try {
            while (rs.next()) {
            	String nickname = rs.getString(1);
            	String profile = rs.getString(2);
            	int views = rs.getInt(3);
            	String reg_date = rs.getString(4);
            	String content = rs.getString(5);
            	String file_url = rs.getString(6);
            	
            	MeetWriteViewDTO meetWriteViewDTO = new MeetWriteViewDTO(nickname, profile, views, reg_date, content, file_url); // 저장한 값으로 SeatStatus 객체 생성
                list.add(meetWriteViewDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
			d.close(conn, pstmt, rs);
        }
        return list;
    }
}
