package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MybandDAO {
	public static void main(String[] args) {
		MybandDAO mbdao = new MybandDAO();
        ArrayList<MybandDTO> list = null;        
        try {
        	list = mbdao.selectMybandDTO(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (MybandDTO mybandDTO : list) {
        	System.out.println(mybandDTO);
        }
    }
    
    public ArrayList<MybandDTO> selectMybandDTO(int member_idx) throws SQLException {
        ArrayList<MybandDTO> list = new ArrayList<>();
        DatabaseUtil d = new DatabaseUtil();
        Connection conn = d.getConn();

        String sql = 
        		"SELECT e.name, e.url "
        		+ "FROM meet e, meet_member m "
        		+ "WHERE e.meet_idx = m.meet_idx "
        		+ "AND m.member_idx = ? "
        		+ "ORDER BY e.meet_idx";

        PreparedStatement pstmt = d.getPstmt(conn, sql);

        pstmt.setInt(1, member_idx);

        ResultSet rs = d.getRs(pstmt);
        try {
            while (rs.next()) {
            	String meet_name = rs.getString(1);
            	String url = rs.getString(2);
            	
    			MybandDTO mybandDTO = new MybandDTO(meet_name, url); // 저장한 값으로 SeatStatus 객체 생성
                list.add(mybandDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
			d.close(conn, pstmt, rs);
        }
        return list;
    }
}
