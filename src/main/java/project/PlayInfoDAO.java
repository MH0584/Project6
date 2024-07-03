package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlayInfoDAO {

	public static void main(String[] args) {
    	PlayInfoDAO pidao = new PlayInfoDAO();
        ArrayList<PlayInfoDTO>  list = null;        
        try {
        	list = pidao.selectPlayInfoDTO(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (PlayInfoDTO playInfoDTO : list) {
        	System.out.println(playInfoDTO);
        }
    }
    
    public ArrayList<PlayInfoDTO> selectPlayInfoDTO(int play_idx) throws SQLException {
        ArrayList<PlayInfoDTO> list = new ArrayList<>();
        DatabaseUtil d = new DatabaseUtil();
        Connection conn = d.getConn();

        String sql = 
        		"SELECT DISTINCT p.name, ph.name, p.time, p.start_date, " + 
        		"p.end_date, p.poster_url, pi.view_class " + 
        		"FROM play p " + 
        		"JOIN playhall ph ON p.playhall_idx = ph.playhall_idx " + 
        		"JOIN playinfo pi ON pi.play_idx = p.play_idx " + 
        		"WHERE p.play_idx = ?";

        PreparedStatement pstmt = d.getPstmt(conn, sql);

        pstmt.setInt(1, play_idx);

        ResultSet rs = d.getRs(pstmt);
        try {
            while (rs.next()) {
            	String playName = rs.getString(1);
            	String playhallName = rs.getString(1);
            	int playtime = rs.getInt(3);
            	String start_date = rs.getString(4);
            	String end_date = rs.getString(5);
    			String poster_url = rs.getString(6);
    			String view_class = rs.getString(7);
    			PlayInfoDTO playInfoDTO = new PlayInfoDTO(playName, playhallName, playtime, start_date, end_date, poster_url, view_class); // 저장한 값으로 SeatStatus 객체 생성
                list.add(playInfoDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
			d.close(conn, pstmt, rs);
        }
        return list;
    }
}