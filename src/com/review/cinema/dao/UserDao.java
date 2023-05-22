package com.review.cinema.dao;

import static com.review.cinema.util.DBUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.review.cinema.vo.MovieVo;
import com.review.cinema.vo.UserVo;

public class UserDao {
	private Connection conn = null;
	
	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	
	public UserVo getLogin(String id, String password) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVo user = null;
		
		try {
			String sql = "select * from TBL_USER where id=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				user = new UserVo();
				
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setGender(rs.getString("gender"));
				user.setBirth(rs.getString("birth"));
				user.setPhone_number(rs.getString("phone_number"));
				user.setJoindate(rs.getString("joindate"));
				user.setEmail(rs.getString("email"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(rs);
		}
		return user;
	}
	
	
	public boolean getJoin(
			String id, String password,
			String name, String gender,String birth,
			String email, String phone_number) {
		boolean result = false;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into TBL_USER"
					+ "(id, password, name, gender, birth, email, phone_number, joindate)"
					+ "values (?,?,?,?,?,?,?,sysdate())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setString(4, gender);
			pstmt.setString(5, birth);
			pstmt.setString(6, email);
			pstmt.setString(7, phone_number);
			
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


	public boolean getIdCheck(String id) {
		boolean result = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int id_check;
		
		try {
			String sql = "select count(*) id_check from TBL_USER where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			rs.next();
			
			id_check = rs.getInt("id_check");
			
			if(id_check == 0) {
				String sql2 = "select count(*) id_check2 from TBL_DELETE_USER where deleteId=?";
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setString(1, id);
				ResultSet rs2 = pstmt2.executeQuery();
				rs2.next();
				
				int id_check2 = rs2.getInt("id_check2");
				
				if(id_check2 == 0) {
					result = true;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}
	public List<UserVo> getUsers() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserVo> users=null;
		
		try {
			String sql = "select * from TBL_USER";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			users = new ArrayList<UserVo>();
			UserVo user = null;
			while(rs.next()) {
				user = new UserVo();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setGender(rs.getString("gender"));
				user.setBirth(rs.getString("birth"));
				user.setPhone_number(rs.getString("phone_number"));
				user.setJoindate(rs.getString("joindate"));
				users.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(rs);
		}
		return users;
	}
	public boolean DeleteUser(String id) {
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			String sql="delete from TBL_USER where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			int tf = pstmt.executeUpdate();
			
			if(tf > 0) {
				result = true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public UserVo getUser(String id) {
	 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVo user = null;
		
		try {
		 String sql="select * from TBL_USER where id=?";
		 pstmt = conn.prepareStatement(sql);
		 pstmt.setString(1, id);
		 rs=pstmt.executeQuery();
		 
		
		 if(rs.next()) {
			 
	
			 user = new UserVo();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setGender(rs.getString("gender"));
				user.setEmail(rs.getString("email"));
				user.setBirth(rs.getString("birth"));
				user.setPhone_number(rs.getString("phone_number"));
				user.setJoindate(rs.getString("joindate"));
				
		 }		 
		}catch(Exception e) {
			
		}finally {
			close(pstmt);
			close(rs);
		}
		return user;
	}
	public boolean updateUser(String password,String name,String birth,String email,String phone_number,String id) {
		PreparedStatement pstmt = null;
		boolean result= false;
		
		try {
			String sql="update TBL_USER set password=?, name=?,birth=?,email=?,phone_number=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, name);
			pstmt.setString(3, birth);
			pstmt.setString(4, email);
			pstmt.setString(5, phone_number);
			pstmt.setString(6, id);
			
			int tf = pstmt.executeUpdate();
			
			if(tf > 0) {
				result = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			
		}return result;
	}
	
	
	
	public List<MovieVo> getBookMarklist(String id){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MovieVo> bookMarkList = null;
		
		try {
			String sql = "select * from TBL_MOVIE as a where a.no in (select no from TBL_USER_BOOKMARK where id=?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			bookMarkList = new ArrayList<MovieVo>();
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
				bbs.setFilename1(rs.getString("filename1"));
				bookMarkList.add(bbs);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(rs);
		}
		return bookMarkList;
	}
	
	
	public boolean deleteBookMark(String id, String check) {
		boolean result = false;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "DELETE FROM TBL_USER_BOOKMARK WHERE ID=? AND NO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, check);
			
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
	

	
	public boolean insertBookMark(String id, int no) {
		boolean result = false;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO TBL_USER_BOOKMARK VALUES (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, no);
			
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

	
	public UserVo searchId(String name,String birth,String  email) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVo user = null;
		user = new UserVo();
		
		try {
			String sql = "select * from TBL_USER where name=? and birth=? and email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, birth);
			pstmt.setString(3, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user.setId(rs.getString("id"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(rs);
		}
		return user;
	}
	

	public UserVo searchPw(String id,String email) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVo user = null;
		user = new UserVo();
		
		try {
			String sql = "SELECT * FROM TBL_USER WHERE ID=? AND EMAIL=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user.setPassword(rs.getString("password"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(rs);
		}
		return user;
	}

}