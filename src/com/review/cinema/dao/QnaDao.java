package com.review.cinema.dao;

import static com.review.cinema.util.DBUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.review.cinema.vo.QnaVo;

public class QnaDao {
	private Connection conn = null;
	
	public QnaDao(Connection conn) {
		super();
		this.conn = conn;
	}
	public boolean insertQNA(String id,String qna_title,String qna_content) {
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			String sql = "INSERT INTO TBL_QNA (ID, QNA_TITLE, QNA_CONTENT, QNA_UPLOAD_DATE) VALUES (?,?,?,sysdate())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, qna_title);
			pstmt.setString(3, qna_content);
			
			int tf = pstmt.executeUpdate();
			
			if(tf > 0) {
				result = true;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		return result;
	}
	
	public int getQNACount() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int qna_count = 0;
		
		try {
			String sql = "SELECT COUNT(*) QNA_COUNT FROM TBL_QNA";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			qna_count = rs.getInt("qna_count");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(rs);
		}
		return qna_count;
	}
	
	public List<QnaVo> getQNAList(int pageno){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<QnaVo> qnaList = null;
		
		int start = 0;
		int end = 0;
		
		end = pageno*10;
		start = end-9;
		
		try {
			String sql = "select * from (" + 
					"		select @rownum:= @rownum+1 as rnum, qna_no, id, qna_title, qna_content, qna_upload_date" + 
					"    	from (" + 
					"			select @rownum :=0, qna_no, id, qna_title, qna_content, qna_upload_date" + 
					"     	 	from TBL_QNA" + 
					"			)a order by qna_no desc" + 
					"				)b" + 
					"	where rnum >= "+ start +" and rnum<= "+ end +" order by qna_no desc";
			

			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			qnaList = new ArrayList<QnaVo>();
			QnaVo qna = null;
			
			while(rs.next()) {
				qna = new QnaVo();
				
				qna.setQna_no(rs.getInt("qna_no"));
				qna.setId(rs.getString("id"));
				qna.setQna_title(rs.getString("qna_title"));
				qna.setQna_update_date(rs.getString("qna_upload_date"));
				
				qnaList.add(qna);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(rs);
		}
		return qnaList;
	}
	
	public QnaVo getQNA(int qna_no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QnaVo qna = new QnaVo();
		
		try {
			String sql = "SELECT * FROM TBL_QNA WHERE QNA_NO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qna_no);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			qna.setId(rs.getString("id"));
			qna.setQna_title(rs.getString("qna_title"));
			qna.setQna_content(rs.getString("qna_content"));
			qna.setQna_no(rs.getInt("qna_no"));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(rs);
		}
		return qna;
	}
	
	public boolean deleteQNA(int qna_no) {
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			String sql = "DELETE FROM TBL_QNA WHERE QNA_NO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qna_no);
			
			int tf = pstmt.executeUpdate();
			
			if(tf > 0) {
				result = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		return result;
	}
	
	public boolean updateQNA(int qna_no,String qna_title,String qna_content) {
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			String sql = "UPDATE TBL_QNA SET qna_title=?, qna_content=? where qna_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qna_title);
			pstmt.setString(2, qna_content);
			pstmt.setInt(3, qna_no);
			
			int tf = pstmt.executeUpdate();
			
			if(tf > 0) {
				result = true;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		return result;
	}
	

	public List<QnaVo> getQNAComment(int qna_no){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<QnaVo> qna_comment = null;
		
		try {
			String sql = "select * from TBL_QNA_COMMENT where qna_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qna_no);
			
			rs = pstmt.executeQuery();
			
			qna_comment = new ArrayList<QnaVo>();
			QnaVo qna = null;
			
			while(rs.next()) {
				qna = new QnaVo();
				
				qna.setQna_no(rs.getInt("qna_no"));
				qna.setQna_comment_no(rs.getInt("qna_comment_no"));
				qna.setId(rs.getString("id"));
				qna.setQna_comment_content(rs.getString("qna_comment_content"));
				qna_comment.add(qna);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(rs);
		}
		return qna_comment;
	}
	

	public boolean insertComment(String id,int qna_no,String comment_write) {
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			String sql = "insert into TBL_QNA_COMMENT(id,qna_no,qna_comment_content) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, qna_no);
			pstmt.setString(3, comment_write);
			
			int tf = pstmt.executeUpdate();
			
			if(tf > 0) {
				result = true;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		return result;
	}
	

	public boolean deleteComment(int qna_comment_no) {
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			String sql = "DELETE FROM TBL_QNA_COMMENT WHERE QNA_COMMENT_NO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qna_comment_no);
			
			int tf = pstmt.executeUpdate();
			
			if(tf > 0) {
				result = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		return result;
	}
	

	public boolean updateComment(int qna_comment_no, String comment_update) {
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			String sql = "UPDATE TBL_QNA_COMMENT SET QNA_COMMENT_CONTENT=? WHERE QNA_COMMENT_NO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comment_update);
			pstmt.setInt(2, qna_comment_no);
			
			int tf = pstmt.executeUpdate();
			
			if(tf > 0) {
				result = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		return result;
	}
}