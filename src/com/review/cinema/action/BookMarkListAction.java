package com.review.cinema.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.review.cinema.biz.UserBiz;
import com.review.cinema.vo.ActionForwardVo;
import com.review.cinema.vo.MovieVo;
import com.review.cinema.vo.UserVo;

/** 북마크 목록 처리 */
public class BookMarkListAction implements Action {

	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		UserVo user = (UserVo) session.getAttribute("user");
		String id = user.getId();

		UserBiz userBiz = new UserBiz();

		List<MovieVo> bookMarkList = userBiz.getBookMarkList(id);
		request.setAttribute("bookMarkList", bookMarkList);

		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl(".\\main.jsp?page=bookMark");
		return forward;
	}
}
