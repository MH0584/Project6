package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MeetInfoWriteDAO {
	public static void main(String[] args) {
		MeetInfoWriteDAO miwdao = new MeetInfoWriteDAO();
        ArrayList<MeetInfoWriteDTO> list = null;        
        try {
        	list = miwdao.selectMeetInfoWriteDTO(10);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (MeetInfoWriteDTO meetInfoWriteDTO : list) {
        	System.out.println(meetInfoWriteDTO);
        }
    }
    
    public ArrayList<MeetInfoWriteDTO> selectMeetInfoWriteDTO(int meet_idx) throws SQLException {
        ArrayList<MeetInfoWriteDTO> list = new ArrayList<>();
        DatabaseUtil d = new DatabaseUtil();
        Connection conn = d.getConn();

        String sql = 
        		"SELECT r.title, r.url, m.area,m.name "
        		+ "FROM meet m, meet_rec_write r "
        		+ "WHERE m.meet_idx = r.meet_idx "
        		+ "AND m.meet_idx = ?";

        PreparedStatement pstmt = d.getPstmt(conn, sql);
        
        pstmt.setInt(1, meet_idx);

        ResultSet rs = d.getRs(pstmt);
        try {
            while (rs.next()) {
            	String title = rs.getString(1);
            	String url = rs.getString(2); 
            	String area = rs.getString(3); 
            	String name = rs.getString(4); 
            	
            	MeetInfoWriteDTO meetInfoWriteDTO = new MeetInfoWriteDTO(title, url, area, name); // 저장한 값으로 SeatStatus 객체 생성
                list.add(meetInfoWriteDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
			d.close(conn, pstmt, rs);
        }
        return list;
    }
}
