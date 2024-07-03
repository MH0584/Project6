package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlayScheduleDAO {


    public static void main(String[] args) {
    	PlayScheduleDAO psdao = new PlayScheduleDAO();
        ArrayList<PlayScheduleDTO>  list = null;        
        try {
        	list = psdao.selectPlaySchedule(1, "2024년04월16일");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (PlayScheduleDTO playScheduleDAO : list) {
        	System.out.println(playScheduleDAO);
        }
    }
    
    public ArrayList<PlayScheduleDTO> selectPlaySchedule(int play_idx, String date) throws SQLException {
        ArrayList<PlayScheduleDTO> list = new ArrayList<>();
        DatabaseUtil d = new DatabaseUtil();
        Connection conn = d.getConn();

        String sql = 
        		"SELECT play_date, start_time, play_order " + 
        		"FROM playinfo " + 
        		"WHERE play_date = to_char(?) " + 
        		"AND play_idx  = ?";
        
        PreparedStatement pstmt = d.getPstmt(conn, sql);
        
        pstmt.setString(1, date);
        pstmt.setInt(2, play_idx);

        ResultSet rs = d.getRs(pstmt);
        try {
            while (rs.next()) {
            	String play_date = rs.getString(1);
            	String start_time = rs.getString(2);
            	int play_order = rs.getInt(3);
            	PlayScheduleDTO playScheduleDTO = new PlayScheduleDTO(play_date, start_time, play_order);
                list.add(playScheduleDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
			d.close(conn, pstmt, rs);
        }
        return list;
    }
}