package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.LikeCountDTO;
import project.DatabaseUtil;

public class LikeCountDAO {
	public static void main(String[] args) {
		LikeCountDAO lcdao = new LikeCountDAO();
        ArrayList<LikeCountDTO> list = null;        
        try {
        	list = lcdao.selectLikeCountDTO(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (LikeCountDTO likeCountDTO : list) {
        	System.out.println(likeCountDTO);
        }
    }
    
    public ArrayList<LikeCountDTO> selectLikeCountDTO(int post_idx) throws SQLException {
        ArrayList<LikeCountDTO> list = new ArrayList<>();
        DatabaseUtil d = new DatabaseUtil();
        Connection conn = d.getConn();

        String sql = 
        		"SELECT COUNT(g.post_idx) "
        		+ "FROM meet_member m_m, member m, post p, post_good g "
        		+ "WHERE m_m.member_idx = m.member_idx "
        		+ "AND p.meet_member_idx = m_m.meet_member_idx "
        		+ "AND g.post_idx = p.post_idx "
        		+ "AND p.post_idx = ?";
        
        PreparedStatement pstmt = d.getPstmt(conn, sql);
        
        pstmt.setInt(1, post_idx);

        ResultSet rs = d.getRs(pstmt);
        try {
            while (rs.next()) {
            	int like = rs.getInt(1);
            	
            	LikeCountDTO likeCountDTO = new LikeCountDTO(like); // 저장한 값으로 SeatStatus 객체 생성
                list.add(likeCountDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
			d.close(conn, pstmt, rs);
        }
        return list;
    }
}
