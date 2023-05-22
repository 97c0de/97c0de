package com.review.cinema.biz;

import static com.review.cinema.util.DBUtil.*;

import java.sql.*;
import java.util.List;

import com.review.cinema.dao.QnaDao;
import com.review.cinema.vo.QnaVo;

public class QnaBiz {
	public boolean insertQNA(String id,String qna_title,String qna_content) {
		Connection conn = getConnection();
		
		QnaDao qnaDao = new QnaDao(conn);
		
		boolean result = qnaDao.insertQNA(id,qna_title,qna_content);
		
		if(result) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}
	
	public int getQNACount() {
		Connection conn = getConnection();
		
		QnaDao qnaDao = new QnaDao(conn);
		
		int qna_count = qnaDao.getQNACount();
		close(conn);
		
		return qna_count;
	}
	
	public List<QnaVo> getQNAList(int pageno){
		Connection conn = getConnection();
		
		QnaDao qnaDao = new QnaDao(conn);
		
		List<QnaVo> qnaList = qnaDao.getQNAList(pageno);
		close(conn);
				
		return qnaList;
	}
	
	public QnaVo getQNA(int qna_no) {
		Connection conn = getConnection();
		
		QnaDao qnaDao = new QnaDao(conn);
		
		QnaVo qna = qnaDao.getQNA(qna_no);
		close(conn);
		
		return qna;
	}
	
	public boolean deleteQNA(int qna_no) {
		Connection conn = getConnection();
		
		QnaDao qnaDao = new QnaDao(conn);
		
		boolean result = qnaDao.deleteQNA(qna_no);
		
		if(result) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}
	
	public boolean updateQNA(int qna_no,String qna_title,String qna_content) {
		Connection conn = getConnection();
		
		QnaDao qnaDao = new QnaDao(conn);
		
		boolean result = qnaDao.updateQNA(qna_no,qna_title,qna_content);
		
		if(result) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}
	

	public List<QnaVo> getQNAComment(int qna_no){
		Connection conn = getConnection();
		
		QnaDao qnaDao = new QnaDao(conn);
		
		List<QnaVo> qna_comment = qnaDao.getQNAComment(qna_no);
		close(conn);
		
		return qna_comment;
	}
	
	public boolean insertComment(String id,int qna_no,String comment_write) {
		Connection conn = getConnection();
		
		QnaDao qnaDao = new QnaDao(conn);
		
		boolean result = qnaDao.insertComment(id,qna_no,comment_write);
		
		if(result) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}
	

	public boolean deleteComment(int qna_comment_no) {
		Connection conn = getConnection();
		
		QnaDao qnaDao = new QnaDao(conn);
		
		boolean result = qnaDao.deleteComment(qna_comment_no);
		
		if(result) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}
	

	public boolean updateComment(int qna_comment_no,String comment_update) {
		Connection conn = getConnection();
		
		QnaDao qnaDao = new QnaDao(conn);
		
		boolean result = qnaDao.updateComment(qna_comment_no, comment_update);
		
		if(result) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}
}
