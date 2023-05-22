package com.review.cinema.biz;

import static com.review.cinema.util.DBUtil.*;

import java.sql.*;
import java.util.List;

import com.review.cinema.dao.UserDao;
import com.review.cinema.vo.MovieVo;
import com.review.cinema.vo.UserVo;

public class UserBiz {
	public UserVo getLogin(String id, String password) {
		Connection conn = getConnection();

		UserDao userDao = new UserDao(conn);
		UserVo user = userDao.getLogin(id, password);
		close(conn);

		return user;
	}

	public boolean getJoin(String id, String password, String name, String gender, String birth, String email,
			String phone_number) {
		boolean result = false;

		Connection conn = getConnection();
		UserDao userDao = new UserDao(conn);
		result = userDao.getJoin(id, password, name, gender, birth, email, phone_number);

		if (result) {
			commit(conn);
		} else {
			rollback(conn);
		}

		return result;
	}

	public boolean getIdCheck(String id) {
		boolean result = false;

		Connection conn = getConnection();
		UserDao userDao = new UserDao(conn);
		result = userDao.getIdCheck(id);
		close(conn);

		return result;
	}

	public List<MovieVo> getBookMarkList(String id) {
		Connection conn = getConnection();

		UserDao userDao = new UserDao(conn);
		List<MovieVo> bookMarkList = userDao.getBookMarklist(id);
		close(conn);

		return bookMarkList;
	}


	public boolean deleteBookMark(String id, String check) {
		boolean result = false;

		Connection conn = getConnection();

		UserDao userDao = new UserDao(conn);
		result = userDao.deleteBookMark(id, check);

		if (result) {
			commit(conn);
		} else {
			rollback(conn);
		}

		return result;
	}


	public boolean insertBookMark(String id, int no) {
		boolean result = false;

		Connection conn = getConnection();

		UserDao userDao = new UserDao(conn);
		result = userDao.insertBookMark(id, no);

		if (result) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public List<UserVo> getUsers() {
		Connection conn = getConnection();
		UserDao userDao = new UserDao(conn);
		List<UserVo> users = userDao.getUsers();
		close(conn);
		return users;
	}

	public boolean DeleteUser(String id) {
		boolean result = false;
		Connection conn = getConnection();
		UserDao userDao = new UserDao(conn);
		result = userDao.DeleteUser(id);
		if (result) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public UserVo getUser(String id) {
		System.out.println("11 => " +id);
		Connection conn = getConnection();
		UserDao userDao = new UserDao(conn);
		UserVo user = userDao.getUser(id);
		close(conn);
		return user;
	}

	public boolean update(String password, String name, String birth, String email, String phone_number, String id) {
		boolean result = false;
		Connection conn = getConnection();
		UserDao userDao = new UserDao(conn);
		result = userDao.updateUser(password, name, birth, email, phone_number, id);
		if (result) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public UserVo searchId(String name, String birth, String email) {
		Connection conn = getConnection();
		UserDao userDao = new UserDao(conn);
		UserVo user = userDao.searchId(name, birth, email);
		close(conn);
		return user;
	}

	public UserVo searchPw(String id, String email) {
		Connection conn = getConnection();
		UserDao userDao = new UserDao(conn);
		UserVo user = userDao.searchPw(id, email);
		close(conn);
		return user;
	}
}
