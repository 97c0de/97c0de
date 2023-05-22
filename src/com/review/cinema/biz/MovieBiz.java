package com.review.cinema.biz;

import static com.review.cinema.util.DBUtil.close;
import static com.review.cinema.util.DBUtil.commit;
import static com.review.cinema.util.DBUtil.getConnection;
import static com.review.cinema.util.DBUtil.rollback;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.review.cinema.dao.MovieDao;
import com.review.cinema.vo.MovieVo;

public class MovieBiz {

	public List<MovieVo> getMovieList(String category, int pageno) {
		Connection conn = getConnection();

		MovieDao bbsDao = new MovieDao(conn);
		List<MovieVo> bbsList = bbsDao.getMovieList(category, pageno);
		close(conn);

		return bbsList;
	}

	public boolean insertMovie(String id, String category, String genre, String actor,
			String trailer, int price, String director, String opening_year, String opening_month,
			String phone_number, String title, String content, String filename1) {
		Connection conn = getConnection();
		boolean result = false;

		MovieDao bbsDao = new MovieDao(conn);
		result = bbsDao.insertMovie(id, category, genre, actor, trailer, price, director,
				opening_year, opening_month, phone_number, title, content, filename1);

		if (result) {
			commit(conn);
		} else {
			rollback(conn);
		}

		return result;
	}

	public boolean updateMovie(String category, String genre, String actor, String trailer,
			int price, String director, String opening_year, String opening_month, String phone_number,
			String title, String content, String filename1, int no) {
		Connection conn = getConnection();
		boolean result = false;

		MovieDao bbsDao = new MovieDao(conn);
		result = bbsDao.updateMovie(category, genre, actor, trailer, price, director,
				opening_year, opening_month, phone_number, title, content, filename1, no);

		if (result) {
			commit(conn);
		} else {
			rollback(conn);
		}

		return result;
	}

	
	public List<MovieVo> getMainList(int pageno) {
		Connection conn = getConnection();

		MovieDao bbsDao = new MovieDao(conn);
		List<MovieVo> mainList = bbsDao.getMainList(pageno);
		close(conn);

		return mainList;
	}

	public int getTotalCount() {
		Connection conn = getConnection();

		int total_count = 0;

		MovieDao bbsDao = new MovieDao(conn);
		total_count = bbsDao.getTotalCount();
		close(conn);

		return total_count;
	}

	public int getCategoryListCount(String category) {
		Connection conn = getConnection();

		int getCategoryListCount = 0;

		MovieDao bbsDao = new MovieDao(conn);
		getCategoryListCount = bbsDao.getCategoryListCount(category);
		close(conn);

		return getCategoryListCount;
	}


	public MovieVo getContent(int no) {
		Connection conn = getConnection();

		MovieDao bbsDao = new MovieDao(conn);
		MovieVo bbs = bbsDao.getContent(no);
		close(conn);

		return bbs;
	}

	
	public boolean deleteContent(int no) {
		Connection conn = getConnection();
		boolean result = false;

		MovieDao bbsDao = new MovieDao(conn);
		result = bbsDao.deleteContent(no);

		if (result) {
			commit(conn);
		} else {
			rollback(conn);
		}

		return result;
	}

	public boolean insertComment(String id, int no, String comment_write) {
		boolean result = false;
		Connection conn = getConnection();

		MovieDao bbsDao = new MovieDao(conn);
		try {
			//conn.setAutoCommit(false);
			result = bbsDao.insertComment(id, no, comment_write);
			bbsDao.addCommentCount(no);
			//conn.commit();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (result) {
			commit(conn);
		} else {
			rollback(conn);
		}

		return result;
	}

	public List<MovieVo> getMovieComment(int no) {
		Connection conn = getConnection();

		MovieDao bbsDao = new MovieDao(conn);
		List<MovieVo> movie_comment = bbsDao.getMovieComment(no);
		close(conn);

		return movie_comment;
	}

	public boolean deleteComment(int no, int comment_no) {
		Connection conn = getConnection();

		boolean result = false;

		MovieDao bbsDao = new MovieDao(conn);
		result = bbsDao.deleteComment(comment_no);

		bbsDao.minusCommentCount(no);
		
		
		if (result) {
			commit(conn);
		} else {
			rollback(conn);
		}

		return result;
	}

	public boolean updateComment(int comment_no, String comment_update) {
		Connection conn = getConnection();

		boolean result = false;

		MovieDao bbsDao = new MovieDao(conn);
		result = bbsDao.updateComment(comment_no, comment_update);

		if (result) {
			commit(conn);
		} else {
			rollback(conn);
		}

		return result;
	}

	public List<MovieVo> searchMovie(int pageno, String search_tag, String search_keyword) {
		Connection conn = getConnection();

		MovieDao bbsDao = new MovieDao(conn);

		List<MovieVo> bbss = bbsDao.searchMovie(pageno, search_tag, search_keyword);
		close(conn);

		return bbss;
	}

	public int getSearchCount(String search_tag, String search_keyword) {
		Connection conn = getConnection();

		MovieDao bbsDao = new MovieDao(conn);
		int search_total_count = bbsDao.getSearchCount(search_tag, search_keyword);
		close(conn);

		return search_total_count;
	}

	public int getCommentCount(int no) {
		Connection conn = getConnection();

		MovieDao bbsDao = new MovieDao(conn);
		int comment_count = bbsDao.getCommentCount(no);
		close(conn);

		return comment_count;
	}

	public boolean addCommentCount(int no) {
		Connection conn = getConnection();

		MovieDao bbsDao = new MovieDao(conn);
		boolean result = bbsDao.addCommentCount(no);

		if (result) {
			commit(conn);
		} else {
			rollback(conn);
		}

		return result;
	}

	public boolean minusCommentCount(int no) {
		Connection conn = getConnection();

		MovieDao bbsDao = new MovieDao(conn);
		boolean result = bbsDao.minusCommentCount(no);

		if (result) {
			commit(conn);
		} else {
			rollback(conn);
		}

		return result;
	}
	
	public boolean insertReadId(int no, String id) {
		Connection conn = getConnection();

		MovieDao bbsDao = new MovieDao(conn);
		boolean result = bbsDao.insertReadId(no, id);

		if (result) {
			commit(conn);
		} else {
			rollback(conn);
		}

		return result;
	}

	public boolean updateReadCount(int no) {
		Connection conn = getConnection();

		MovieDao bbsDao = new MovieDao(conn);
		boolean result = bbsDao.updateReadcount(no);

		if (result) {
			commit(conn);
		} else {
			rollback(conn);
		}

		return result;
	}

	public String checkReadId(int no, String id) {
		Connection conn = getConnection();

		MovieDao bbsDao = new MovieDao(conn);
		String read_id = bbsDao.checkReadId(no, id);
		close(conn);

		return read_id;
	}

	public List<MovieVo> getWriteList(String id) {
		Connection conn = getConnection();

		MovieDao bbsDao = new MovieDao(conn);

		List<MovieVo> bbss = bbsDao.getWriteList(id);
		close(conn);

		return bbss;
	}

	public boolean insertSoldOut(int no) {
		Connection conn = getConnection();

		MovieDao bbsDao = new MovieDao(conn);
		boolean result = bbsDao.insertSoldOut(no);

		if (result) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public boolean deleteSoldOut(int no) {
		Connection conn = getConnection();

		MovieDao bbsDao = new MovieDao(conn);
		boolean result = bbsDao.deleteSoldOut(no);

		if (result) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public boolean getBookMark(int no, String id) {
		Connection conn = getConnection();

		MovieDao bbsDao = new MovieDao(conn);
		boolean result = bbsDao.getBookMark(no, id);
		close(conn);

		return result;
	}
}
