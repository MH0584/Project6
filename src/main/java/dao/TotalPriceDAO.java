package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.TotalPriceDTO;
import project.DatabaseUtil;

public class TotalPriceDAO {

    public static void main(String[] args) {
    	TotalPriceDAO tpdao = new TotalPriceDAO();
        ArrayList<TotalPriceDTO>  list = null;        
        try {
        	list = tpdao.selectTotalPrice(2, 34);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (TotalPriceDTO totalPriceDTO : list) {
        	System.out.println(totalPriceDTO);
        }
    }
    
    public ArrayList<TotalPriceDTO> selectTotalPrice(int member_idx, int payment_idx) throws SQLException {
        ArrayList<TotalPriceDTO> list = new ArrayList<>();
        DatabaseUtil d = new DatabaseUtil();
        Connection conn = d.getConn();
        
        String sql =
				"SELECT SUM(pr.ticket_price) " + 
				"FROM member m JOIN payment pm ON m.member_idx = pm.member_idx " + 
				"JOIN paymentseat ps ON ps.payment_idx = pm.payment_idx " + 
				"JOIN seat s ON s.seat_idx = ps.seat_idx " + 
				"JOIN playinfo pi ON pi.playinfo_idx = ps.playinfo_idx " + 
				"JOIN price pr ON pr.play_idx = pi.play_idx " + 
				"AND pr.seat_rank = s.rank " + 
				"WHERE m.member_idx = ? " + 
				"AND pm.payment_idx = ? ";

        PreparedStatement pstmt = d.getPstmt(conn, sql);

        pstmt.setInt(1, member_idx);
        pstmt.setInt(2, payment_idx);

        ResultSet rs = d.getRs(pstmt);
        try {
            while (rs.next()) {
                int price = rs.getInt(1);
                TotalPriceDTO totalPriceDTO = new TotalPriceDTO(price);
                list.add(totalPriceDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
			d.close(conn, pstmt, rs);
        }
        return list;
    }
}