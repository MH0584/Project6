package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.SeatReservationDTO;
import project.DatabaseUtil;

public class SeatReservationDAO {
	
    public static void main(String[] args) {
    	SeatReservationDAO srvdao = new SeatReservationDAO();
        ArrayList<SeatReservationDTO>  list = null;
        try {
        	list = srvdao.selectSeatReservation(1,1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (SeatReservationDTO seatReservationDTO : list) {
        	System.out.println(seatReservationDTO);
        }
    }
    
    public ArrayList<SeatReservationDTO> selectSeatReservation(int member_idx, int payment_idx) throws SQLException {
        ArrayList<SeatReservationDTO> list = new ArrayList<>();
        DatabaseUtil d = new DatabaseUtil();
        Connection conn = d.getConn();

        String sql =
				"SELECT p.name, p.poster_url, s.rank, s.seat_chart, " + 
				"TO_CHAR(pm.time_limit + 5/1440, 'YYYY-MM-DD HH24:MI:SS') " + 
				"FROM playinfo pi " + 
				"JOIN payment pm ON pi.playinfo_idx = pm.playinfo_idx " + 
				"JOIN play p ON p.play_idx = pi.play_idx " + 
				"JOIN paymentseat ps ON ps.payment_idx = pm.payment_idx " + 
				"JOIN seat s ON ps.seat_idx = s.seat_idx " + 
				"JOIN price pr ON pr.seat_rank = s.rank " + 
				"AND pr.play_idx = p.play_idx " + 
				"JOIN member m ON pm.member_idx = m.member_idx " + 
				"WHERE m.member_idx = ? " + 
				"AND pm.payment_idx = ? ";
        
        PreparedStatement pstmt = d.getPstmt(conn, sql);
        
        pstmt.setInt(1, member_idx);
        pstmt.setInt(2, payment_idx);

        ResultSet rs = d.getRs(pstmt);
        try {
            while (rs.next()) {
                String playName = rs.getString(1);
                String poster_url = rs.getString(2);
                String rank = rs.getString(3);
                String seat_chart = rs.getString(4);
                String time_limit = rs.getString(5);
                SeatReservationDTO seatReservationDTO = new SeatReservationDTO(playName, poster_url, rank, seat_chart,time_limit); // 저장한 값으로 SeatPrice 객체 생성
                list.add(seatReservationDTO); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
			d.close(conn, pstmt, rs);
        }
        return list;
    }
}