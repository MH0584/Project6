package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.SeatStatusDTO;
import project.DatabaseUtil;

public class SeatStatusDAO {

    public static void main(String[] args) {
    	SeatStatusDAO sa = new SeatStatusDAO();
        ArrayList<SeatStatusDTO>  list = null;
        try {
        	list = sa.selectSeatStatus(1, 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (SeatStatusDTO seatStatusDTO : list) {
        	System.out.println(seatStatusDTO);
        }
    }

    public ArrayList<SeatStatusDTO> selectSeatStatus(int play_idx, int playinfo_idx) throws SQLException {
        ArrayList<SeatStatusDTO> list = new ArrayList<>();
        DatabaseUtil d = new DatabaseUtil();
        Connection conn = d.getConn();

        String sql =
                "SELECT s.rank, count(CASE WHEN p.play_idx = ? THEN 1 END) - count(CASE WHEN ps.playinfo_idx = ? THEN 1 END) " +
                "FROM play p JOIN playhall ph ON p.playhall_idx = ph.playhall_idx " +
                "JOIN seat s ON ph.playhall_idx = s.playhall_idx " +
                "LEFT JOIN paymentseat ps ON s.seat_idx = ps.seat_idx " +
                "GROUP BY s.rank";

        PreparedStatement pstmt = d.getPstmt(conn, sql);

        pstmt.setInt(1, play_idx);
        pstmt.setInt(2, playinfo_idx);

        ResultSet rs = d.getRs(pstmt);
        try {
            while (rs.next()) {
                String rank = rs.getString(1);
                int count = rs.getInt(2);
                SeatStatusDTO seatStatusDTO = new SeatStatusDTO(rank, count);
                list.add(seatStatusDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
			d.close(conn, pstmt, rs);
        }
        return list;
    }
}