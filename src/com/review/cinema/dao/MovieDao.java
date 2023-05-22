package com.review.cinema.dao;

import static com.review.cinema.util.DBUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.StringUtils;
import com.review.cinema.vo.MovieVo;

public class MovieDao{
	private Connection conn = null;
	
	public MovieDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public List<MovieVo> getMainList(int pageno){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MovieVo> mainList = null;
		
		int start = 0;
		int end = 0;
		
		end = pageno*25;
		start = end-24;
		
		try {
			String sql = "select * from (" + 
					"		select @rownum:= @rownum+1 as rnum, category, genre, actor, trailer,price,director,opening_year,opening_month,running_time,filename1, no, title, id, content, upload_date, read_count, comment_count, screening_end" + 
					"    	from (" + 
					"			select @rownum :=0, category, genre, actor, trailer,price,director,opening_year,opening_month,running_time,filename1, no, title, id, content, upload_date, read_count, comment_count, screening_end" + 
					"     	 	from TBL_MOVIE" + 
					"			)a order by no desc" + 
					"				)b" + 
					"	where rnum >= "+ start +" and rnum<= "+ end +" order by no desc";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			mainList = new ArrayList<MovieVo>();
			MovieVo bbs = null;
			
			while(rs.next()) {
				bbs = new MovieVo();
				
				bbs.setId(rs.getString("id"));
				bbs.setCategory(rs.getString("category"));
				bbs.setNo(rs.getInt("no"));
				bbs.setGenre(rs.getString("genre"));
				bbs.setActor(rs.getString("actor"));
				bbs.setTrailer(rs.getString("trailer"));
				bbs.setPrice(rs.getInt("price"));
				bbs.setDirector(rs.getString("director"));
				bbs.setOpening_year(rs.getString("opening_year"));
				bbs.setOpening_month(rs.getString("opening_month"));
				bbs.setRunning_time(rs.getString("running_time"));
				bbs.setTitle(rs.getString("title"));
				bbs.setContent(rs.getString("content"));
				bbs.setFilename1(rs.getString("filename1"));
				bbs.setUpload_date(rs.getString("upload_date"));
				bbs.setRead_count(rs.getInt("read_count"));
				bbs.setComment_count(rs.getInt("comment_count"));
				bbs.setScreening_end(rs.getString("screening_end"));
				mainList.add(bbs);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(rs);
			close(conn);
		}
		return mainList;
	}
	
	public List<MovieVo> getMovieList(String category, int pageno){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MovieVo> bbsList = null;
		
		int start = 0;
		int end = 0;
		
		end = pageno*9;
		start = end-8;
		
		try {
			String sql = "select * from (" + 
					"		select @rownum:= @rownum+1 as rnum, category, genre, actor, trailer,price,director,opening_year,opening_month,running_time,filename1, no, title, id, content, upload_date, read_count, comment_count, screening_end" + 
					"    	from (" + 
					"			select @rownum :=0, category, genre, actor, trailer,price,director,opening_year,opening_month,running_time,filename1, no, title, id, content, upload_date, read_count, comment_count, screening_end" + 
					"     	 	from TBL_MOVIE" + 
					"			)a where category=? order by no desc" + 
					"				)b" + 
					"	where rnum >= "+ start +" and rnum<= "+ end +" order by no desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			
			rs = pstmt.executeQuery();
			
			bbsList = new ArrayList<MovieVo>();
			MovieVo bbs = null;
			
			while(rs.next()) {
				bbs = new MovieVo();
				
				bbs.setId(rs.getString("id"));
				bbs.setCategory(rs.getString("category"));
				bbs.setNo(rs.getInt("no"));
				bbs.setGenre(rs.getString("genre"));
				bbs.setActor(rs.getString("actor"));
				bbs.setTrailer(rs.getString("trailer"));
				bbs.setPrice(rs.getInt("price"));
				bbs.setDirector(rs.getString("director"));
				bbs.setOpening_year(rs.getString("opening_year"));
				bbs.setOpening_month(rs.getString("opening_month"));
				bbs.setRunning_time(rs.getString("running_time"));
				bbs.setTitle(rs.getString("title"));
				bbs.setContent(rs.getString("content"));
				bbs.setFilename1(rs.getString("filename1"));
				bbs.setUpload_date(rs.getString("upload_date"));
				bbs.setRead_count(rs.getInt("read_count"));
				bbs.setComment_count(rs.getInt("comment_count"));
				bbs.setScreening_end(rs.getString("screening_end"));
				bbsList.add(bbs);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(rs);
			close(conn);
		}
		return bbsList;
	}//List<Movie> end
	

	public boolean insertMovie(String id, String category, String genre,
			String actor, String trailer, int price, String director,
			String opening_year, String opening_month,
			String running_time, String title, String content, String filename1) {
		PreparedStatement pstmt = null;
		
		boolean result = false;
		
		try {
			String sql = "insert into TBL_MOVIE(id, category, genre, actor, trailer," + 
					"				price, director, opening_year, opening_month, running_time," + 
					"				title, content, filename1, upload_date)" +
					"		values(?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, category);
			pstmt.setString(3, genre);
			pstmt.setString(4, actor);
			if(StringUtils.isNullOrEmpty(trailer))	trailer="";
			pstmt.setString(5, trailer);
			pstmt.setInt(6, price);
			pstmt.setString(7, director);
			pstmt.setString(8, opening_year);
			pstmt.setString(9, opening_month);
			pstmt.setString(10, running_time);
			pstmt.setString(11, title);
			pstmt.setString(12, content);
			pstmt.setString(13, filename1);
			
			int tf = pstmt.executeUpdate();
			
			if(tf > 0) {
				result = true;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(conn);
		}
		return result;
	}
	
	public boolean updateMovie(String category, String genre,
			String actor, String trailer, int price, String director,
			String opening_year, String opening_month,
			String running_time, String title, String content, String filename1, int no) {
		boolean result = false;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update TBL_MOVIE set category=?, genre=?, actor=?, trailer=?,"
					+ "price=?, director=?, opening_year=?, opening_month=?, running_time=?,"
					+ "title=?, content=?, filename1=? where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			pstmt.setString(2, genre);
			pstmt.setString(3, actor);
			if(StringUtils.isNullOrEmpty(trailer))	trailer="";
			pstmt.setString(4, trailer);
			pstmt.setInt(5, price);
			pstmt.setString(6, director);
			pstmt.setString(7, opening_year);
			pstmt.setString(8, opening_month);
			pstmt.setString(9, running_time);
			pstmt.setString(10, title);
			pstmt.setString(11, content);
			pstmt.setString(12, filename1);
			pstmt.setInt(13, no);
			
			int tf = pstmt.executeUpdate();
			
			if(tf > 0) {
				result = true;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
		return result;
		
		
	}
	
	public int getTotalCount() {
		int total_count = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select count(*) total_count from TBL_MOVIE";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			
			total_count = rs.getInt("total_count");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(rs);
			close(conn);
		}
		return total_count;
	}
	
	public int getCategoryListCount(String category) {
		int getCategoryListCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select count(*) getCategoryListCount from TBL_MOVIE where category=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			
			rs = pstmt.executeQuery();
			rs.next();
			
			getCategoryListCount = rs.getInt("getCategoryListCount");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(rs);
			close(conn);
		}
		return getCategoryListCount;
	}
	
	
	public int getCommentCount(int no) {
		int comment_count=0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT COUNT(*) COMMENT_COUNT FROM TBL_MOVIE_COMMENT WHERE NO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs =  pstmt.executeQuery();
			
			if(rs.next()) {
				comment_count = rs.getInt("comment_count");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(rs);
			close(conn);
		}
		return comment_count;
	}
	

	public boolean addCommentCount(int no) {
		boolean result = false;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update TBL_MOVIE set comment_count=comment_count+1 where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			int tf = pstmt.executeUpdate();
			
			if(tf > 0) {
				result = true;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(conn);
		}
		return result;
	}
	
	
	public boolean minusCommentCount(int no) {
		boolean result = false;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update TBL_MOVIE set comment_count=comment_count-1 where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			int tf = pstmt.executeUpdate();
			
			if(tf > 0) {
				result = true;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(conn);
		}
		return result;
	}
	
	
	public MovieVo getContent(int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MovieVo bbs = null;
		bbs = new MovieVo();
		
		try {
			String sql = "select * from TBL_MOVIE where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();
			
			rs.next();
			
			bbs.setId(rs.getString("id"));
			bbs.setCategory(rs.getString("category"));
			bbs.setNo(rs.getInt("no"));
			bbs.setGenre(rs.getString("genre"));
			bbs.setActor(rs.getString("actor"));
			bbs.setTrailer(rs.getString("trailer"));
			bbs.setPrice(rs.getInt("price"));
			bbs.setDirector(rs.getString("director"));
			bbs.setOpening_year(rs.getString("opening_year"));
			bbs.setOpening_month(rs.getString("opening_month"));
			bbs.setRunning_time(rs.getString("running_time"));
			bbs.setTitle(rs.getString("title"));
			bbs.setContent(rs.getString("content"));
			bbs.setFilename1(rs.getString("filename1"));
			bbs.setUpload_date(rs.getString("upload_date"));
			bbs.setRead_count(rs.getInt("read_count"));
			bbs.setComment_count(rs.getInt("comment_count"));
			bbs.setScreening_end(rs.getString("screening_end"));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(rs);
			close(conn);
		}
		return bbs;
	}
	

	public boolean deleteContent(int no) {
		boolean result = false;
		
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		try {
			String sql = "delete from TBL_MOVIE where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			int tf = pstmt.executeUpdate();
			
			if(tf > 0) {
				String sql2 = "delete from TBL_MOVIE_COMMENT where no=?";
				pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setInt(1, no);
				
				pstmt2.executeUpdate();
				
				result = true;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(pstmt2);
			close(conn);
		}
		return result;
	}
	
	public boolean insertComment(String id, int no, String comment_write) {
		boolean result = false;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into TBL_MOVIE_COMMENT(id, no, comment_content) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, no);
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
			close(conn);
		}
		return result;
	}
	
	public List<MovieVo> getMovieComment(int no){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MovieVo> movie_comment = null;
		
		try {
			String sql = "select * from TBL_MOVIE_COMMENT where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			movie_comment = new ArrayList<MovieVo>();
			MovieVo bbs = null;
			
			while(rs.next()) {
				bbs = new MovieVo();

				bbs.setNo(rs.getInt("no"));
				bbs.setId(rs.getString("id"));
				bbs.setComment_content(rs.getString("comment_content"));
				bbs.setComment_no(rs.getInt("comment_no"));
				movie_comment.add(bbs);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(rs);
			close(conn);
		}
		return movie_comment;
	}
	

	public boolean deleteComment(int comment_no) {
		boolean result = false;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from TBL_MOVIE_COMMENT where comment_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comment_no);
			
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
	

	public boolean updateComment(int comment_no, String comment_update) {
		boolean result = false;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update TBL_MOVIE_COMMENT set comment_content=? where comment_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comment_update);
			pstmt.setInt(2, comment_no);
			
			int tf = pstmt.executeUpdate();
			
			if(tf > 0) {
				result = true;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(conn);
		}
		return result;
	}
	
	public List<MovieVo> searchMovie(int pageno, String search_tag, String search_keyword){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MovieVo> bbss = null;
		
		int start = 0;
		int end = 0;
		
		end = pageno*9;
		start = end-8;
		
		try {
			
			if(!search_tag.equals("title&content")) {
				String sql = "select * from (" + 
						"		select @rownum:= @rownum+1 as rnum, category, genre, actor, trailer,price,director,opening_year,opening_month,running_time,filename1, no, title, id, content, upload_date, read_count, comment_count, screening_end" + 
						"    	from (" + 
						"			select @rownum :=0, category, genre, actor, trailer,price,director,opening_year,opening_month,running_time,filename1, no, title, id, content, upload_date, read_count, comment_count, screening_end" + 
						"     	 	from TBL_MOVIE" + 
						"			)a where "+ search_tag +" like ? order by no desc" + 
						"				)b" + 
						"	where rnum >= "+ start +" and rnum<= "+ end +" order by no desc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+search_keyword+"%");
				rs = pstmt.executeQuery();
				
				bbss = new ArrayList<MovieVo>();
				MovieVo bbs = null;
				
				while(rs.next()) {
					bbs = new MovieVo();
					
					bbs.setId(rs.getString("id"));
					bbs.setCategory(rs.getString("category"));
					bbs.setNo(rs.getInt("no"));
					bbs.setGenre(rs.getString("genre"));
					bbs.setActor(rs.getString("actor"));
					bbs.setTrailer(rs.getString("trailer"));
					bbs.setPrice(rs.getInt("price"));
					bbs.setDirector(rs.getString("director"));
					bbs.setOpening_year(rs.getString("opening_year"));
					bbs.setOpening_month(rs.getString("opening_month"));
					bbs.setRunning_time(rs.getString("running_time"));
					bbs.setTitle(rs.getString("title"));
					bbs.setContent(rs.getString("content"));
					bbs.setFilename1(rs.getString("filename1"));
					bbs.setUpload_date(rs.getString("upload_date"));
					bbs.setRead_count(rs.getInt("read_count"));
					bbs.setComment_count(rs.getInt("comment_count"));
					bbs.setScreening_end(rs.getString("screening_end"));
					bbss.add(bbs);
				}
			/*����+���� �˻�*/
			} else {
				String sql = "select * from (" + 
						"		select @rownum:= @rownum+1 as rnum, category, genre, actor, trailer,price,director,opening_year,opening_month,running_time,filename1, no, title, id, content, upload_date, read_count, comment_count, screening_end" + 
						"    	from (" + 
						"			select @rownum :=0, category, genre, actor, trailer,price,director,opening_year,opening_month,running_time,filename1, no, title, id, content, upload_date, read_count, comment_count, screening_end" + 
						"     	 	from TBL_MOVIE" + 
						"			)a where title like ? or content like ? order by no desc" + 
						"				)b" + 
						"	where rnum >= "+ start +" and rnum<= "+ end +" order by no desc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+search_keyword+"%");
				pstmt.setString(2, "%"+search_keyword+"%");
				rs = pstmt.executeQuery();
				
				bbss = new ArrayList<MovieVo>();
				MovieVo bbs = null;
				
				while(rs.next()) {
					bbs = new MovieVo();
					
					bbs.setId(rs.getString("id"));
					bbs.setCategory(rs.getString("category"));
					bbs.setNo(rs.getInt("no"));
					bbs.setGenre(rs.getString("genre"));
					bbs.setActor(rs.getString("actor"));
					bbs.setTrailer(rs.getString("trailer"));
					bbs.setPrice(rs.getInt("price"));
					bbs.setDirector(rs.getString("director"));
					bbs.setOpening_year(rs.getString("opening_year"));
					bbs.setOpening_month(rs.getString("opening_month"));
					bbs.setRunning_time(rs.getString("running_time"));
					bbs.setTitle(rs.getString("title"));
					bbs.setContent(rs.getString("content"));
					bbs.setFilename1(rs.getString("filename1"));
					bbs.setUpload_date(rs.getString("upload_date"));
					bbs.setRead_count(rs.getInt("read_count"));
					bbs.setComment_count(rs.getInt("comment_count"));
					bbs.setScreening_end(rs.getString("screening_end"));
					bbss.add(bbs);
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(rs);
			close(conn);
		}
		return bbss;
	}
	
	public int getSearchCount(String search_tag, String search_keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int search_total_count = 0;
		
		try {
			if(!search_tag.equals("title&content")) {
				String sql = "select count(*) search_total_count "
						   + "from TBL_MOVIE where "+ search_tag +" like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+search_keyword+"%");
				
				rs = pstmt.executeQuery();
				rs.next();
				
				search_total_count = rs.getInt("search_total_count");
			} else {
				String sql = "select count(*) search_total_count "
						   + "from TBL_MOVIE where title like ? or content like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+search_keyword+"%");
				pstmt.setString(2, "%"+search_keyword+"%");
				
				rs = pstmt.executeQuery();
				rs.next();
				
				search_total_count = rs.getInt("search_total_count");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(rs);
			close(conn);
		}
		return search_total_count;
	}
	
	public boolean insertReadId(int no, String id) {
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			String sql = "insert into TBL_MOVIE_READ values (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, id);
			
			int tf = pstmt.executeUpdate();
			
			if(tf > 0) {
				result = true;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(conn);
		}
		return result;
	}
	
	/*��ȸ�� ����*/
	public boolean updateReadcount(int no) {
		PreparedStatement pstmt = null;
		
		boolean result = false;
		
		try {
			String sql = "update TBL_MOVIE set read_count=read_count+1 where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			int tf = pstmt.executeUpdate();
			
			if(tf > 0) {
				result = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(conn);
		}
		return result;
	}
	
	public String checkReadId(int no, String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String read_id = null;
		
		try {
			String sql = "select * from TBL_MOVIE_READ where read_no=? and read_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				read_id = rs.getString("read_id");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
			close(conn);
		}
		return read_id;
	}

	public List<MovieVo> getWriteList(String id){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<MovieVo> bbs = null;
		
		try {
			String sql="select * from TBL_MOVIE where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			bbs=new ArrayList<MovieVo>();
			MovieVo bbs1= null;
			while(rs.next()) {
				bbs1=new MovieVo();
				bbs1.setId(rs.getString("id"));
				bbs1.setTitle(rs.getString("title"));
				bbs1.setUpload_date(rs.getString("Upload_date"));
				bbs1.setRead_count(rs.getInt("read_count"));
				bbs1.setNo(rs.getInt("no"));
				bbs.add(bbs1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(rs);
			close(conn);
		}
		return bbs;
	}
	
	public boolean insertSoldOut(int no) {
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			String sql = "update TBL_MOVIE set screening_end='screening_end' where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			int tf = pstmt.executeUpdate();
			
			if(tf > 0) {
				result = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(conn);
		}
		return result;
	}
	
	public boolean deleteSoldOut(int no) {
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			String sql = "update TBL_MOVIE set screening_end=null where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			int tf = pstmt.executeUpdate();
			
			if(tf > 0) {
				result = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(conn);
		}
		return result;
	}
	
	public boolean getBookMark(int no,String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;
		
		try {
			String sql = "select *,count(*) count from TBL_USER_BOOKMARK where no=? and id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, id);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			if(rs.getInt("count") <= 0) {
				result = false;
			} else {
				result = true;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(rs);
			close(conn);
		}
		return result;
	}
}