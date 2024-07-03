package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.CommentListViewDTO;
import project.DatabaseUtil;

public class CommentListViewDAO {
	public static void main(String[] args) {
		CommentListViewDAO clvdao = new CommentListViewDAO();
        ArrayList<CommentListViewDTO> list = null;        
        try {
        	list = clvdao.selectCommentListViewDTO(3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (CommentListViewDTO commentListViewDTO : list) {
        	System.out.println(commentListViewDTO);
        }
    }
    
    public ArrayList<CommentListViewDTO> selectCommentListViewDTO(int post_idx) throws SQLException {
        ArrayList<CommentListViewDTO> list = new ArrayList<>();
        DatabaseUtil d = new DatabaseUtil();
        Connection conn = d.getConn();

        String sql = 
        		"SELECT m.nickname, m_m.profile, c.content "
        		+ "FROM member m, meet_member m_m, meet_comment c, post p "
        		+ "WHERE m.member_idx = m_m.member_idx "
        		+ "AND c.meet_member_idx = m_m.meet_member_idx "
        		+ "AND p.post_idx = c.post_idx "
        		+ "AND p.post_idx = ?";
        
        PreparedStatement pstmt = d.getPstmt(conn, sql);
        
        pstmt.setInt(1, post_idx);

        ResultSet rs = d.getRs(pstmt);
        try {
            while (rs.next()) {
            	String nickname = rs.getString(1);
            	String profile = rs.getString(2);
            	String content = rs.getString(3);
            	
            	CommentListViewDTO commentListViewDTO = new CommentListViewDTO(nickname, profile, content); // 저장한 값으로 SeatStatus 객체 생성
                list.add(commentListViewDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
			d.close(conn, pstmt, rs);
        }
        return list;
    }
}
