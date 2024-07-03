package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDAO {


    public static void main(String[] args) {
    	PaymentDAO pmdao = new PaymentDAO();
       pmdao.insertPayment(13, 2,163);
//       pmdao.updatePayment1();
//    	pmdao.updatePayment2("카카오페이", , 13);//type, payment_idx, member_idx
    }
    
    public void insertPayment(int member_idx, int playinfo_idx, int seat_idx) {
        DatabaseUtil d = new DatabaseUtil();
        Connection conn = d.getConn();
        try {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO payment (PAYMENT_IDX, MEMBER_IDX, TIME_LIMIT, STATUS,PLAYINFO_IDX) " +
                    "VALUES (seq_payment.nextval, ?,SYSDATE,'N',?)";
            PreparedStatement pstmt = d.getPstmt(conn, sql);
            pstmt.setInt(1, member_idx);
            pstmt.setInt(2, playinfo_idx);
            int result = pstmt.executeUpdate();
            System.out.println(result + "행 성공적으로 삽입됨");
            pstmt.close();

            sql = "SELECT seq_payment.currval FROM dual";
            pstmt = d.getPstmt(conn, sql);
            ResultSet rs = pstmt.executeQuery();
            int payment_idx = 0;
            if (rs.next()) {
                payment_idx = rs.getInt(1);
            }
            pstmt.close();
            sql = "INSERT INTO PAYMENTSEAT(PAYMENT_IDX,SEAT_IDX,PLAYINFO_IDX) " +
                    "VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, payment_idx);
            pstmt.setInt(2, seat_idx);
            pstmt.setInt(3, playinfo_idx);
            result = pstmt.executeUpdate();
            System.out.println(result + "행 성공적으로 삽입됨");
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            d.close(conn, null);
        }
    }
        
    public void updatePayment1(int payment_idx) {
        DatabaseUtil d = new DatabaseUtil();
        Connection conn = d.getConn();

        String sql = 
        		"UPDATE payment SET agree1 = 'Y', agree2 = 'Y', agree3 = 'Y' " + 
        		"WHERE payment_idx = ?";
        
        PreparedStatement pstmt = d.getPstmt(conn, sql);
        try {
			pstmt.setInt(1, payment_idx);
			int result = pstmt.executeUpdate();
			System.out.println(result + "행 성공적으로 업데이트됨");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			d.close(conn, pstmt);
		}
    }
  
    public void updatePayment2(String type, int payment_idx, int member_idx) {
        DatabaseUtil d = new DatabaseUtil();
        Connection conn = d.getConn();

        String sql = 
        		"UPDATE payment SET total_amount = ?, " +
        		"type = ?, " + 
        		"pay_date = sysdate, " + 
        		"status = 'Y' " + 
        		"WHERE payment_idx = ?";
        
       	TotalPriceDAO tpdao = new TotalPriceDAO();
        PreparedStatement pstmt = d.getPstmt(conn, sql);
        
        try {
        	pstmt.setInt(1, tpdao.selectTotalPrice(member_idx, payment_idx).get(0).getPrice());
			pstmt.setString(2, type);
			pstmt.setInt(3, payment_idx);
			int result = pstmt.executeUpdate();
			System.out.println(result + "행 성공적으로 업데이트됨");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			d.close(conn, pstmt);
		}
    }
}