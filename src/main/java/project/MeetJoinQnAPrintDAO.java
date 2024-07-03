package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MeetJoinQnAPrintDAO {
	public static void main(String[] args) {
		MeetJoinQnAPrintDAO mjqnadao = new MeetJoinQnAPrintDAO();
        ArrayList<MeetJoinQnAPrintDTO> list = null;        
        try {
        	list = mjqnadao.selectMeetJoinQnAPrintDTO(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (MeetJoinQnAPrintDTO meetJoinQnAPrintDTO : list) {
        	System.out.println(meetJoinQnAPrintDTO);
        }
    }
    
    public ArrayList<MeetJoinQnAPrintDTO> selectMeetJoinQnAPrintDTO(int meet_idx) throws SQLException {
        ArrayList<MeetJoinQnAPrintDTO> list = new ArrayList<>();
        DatabaseUtil d = new DatabaseUtil();
        Connection conn = d.getConn();

        String sql = 
        		"SELECT  m.name, m.sub_q "
        		+ "FROM meet m, meet_rec_write r "
        		+ "WHERE m.meet_idx = r.meet_idx "
        		+ "AND m.meet_idx = ?";

        PreparedStatement pstmt = d.getPstmt(conn, sql);
        
        pstmt.setInt(1, meet_idx);

        ResultSet rs = d.getRs(pstmt);
        try {
            while (rs.next()) {
            	String name = rs.getString(1);
            	String sub_q = rs.getString(2);
            	
            	MeetJoinQnAPrintDTO meetJoinQnAPrintDTO = new MeetJoinQnAPrintDTO(name, sub_q); // 저장한 값으로 SeatStatus 객체 생성
                list.add(meetJoinQnAPrintDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
			d.close(conn, pstmt, rs);
        }
        return list;
    }
}
