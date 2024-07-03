package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MeetAreaDAO {
	public static void main(String[] args) {
		MeetAreaDAO madao = new MeetAreaDAO();
        ArrayList<MeetAreaDTO> list = null;        
        try {
        	list = madao.selectMeetAreaDTO();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (MeetAreaDTO meetAreaDTO : list) {
        	System.out.println(meetAreaDTO);
        }
    }
    
    public ArrayList<MeetAreaDTO> selectMeetAreaDTO() throws SQLException {
        ArrayList<MeetAreaDTO> list = new ArrayList<>();
        DatabaseUtil d = new DatabaseUtil();
        Connection conn = d.getConn();

        String sql = 
        		"SELECT area "
        		+ "FROM meet "
        		+ "ORDER BY area";

        PreparedStatement pstmt = d.getPstmt(conn, sql);

        ResultSet rs = d.getRs(pstmt);
        try {
            while (rs.next()) {
            	String area = rs.getString(1);
            	
            	MeetAreaDTO meetAreaDTO = new MeetAreaDTO(area); // 저장한 값으로 SeatStatus 객체 생성
                list.add(meetAreaDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
			d.close(conn, pstmt, rs);
        }
        return list;
    }
}
