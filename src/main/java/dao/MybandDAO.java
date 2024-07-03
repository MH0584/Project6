package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.MybandDTO;
import project.DatabaseUtil;

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
        		"SELECT e.name, e.url, (SELECT COUNT(*) FROM meet_member WHERE meet_idx=m.meet_idx) "
        		+ "FROM meet_member m, meet e "
        		+ "WHERE m.meet_idx = e.meet_idx "
        		+ "AND m.member_idx = ? "
        		+ "AND leave_ok = 'N' "
        		+ "ORDER BY m.meet_idx";

        PreparedStatement pstmt = d.getPstmt(conn, sql);

        pstmt.setInt(1, member_idx);

        ResultSet rs = d.getRs(pstmt);
        try {
            while (rs.next()) {
            	String meet_name = rs.getString(1);
            	String url = rs.getString(2);
            	int meet_member_count = rs.getInt(3);
            	
    			MybandDTO mybandDTO = new MybandDTO(meet_name, url, meet_member_count); // 저장한 값으로 SeatStatus 객체 생성
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
