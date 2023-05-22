package com.review.cinema.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.review.cinema.biz.MovieBiz;
import com.review.cinema.vo.ActionForwardVo;
import com.review.cinema.vo.UserVo;

/** 댓글 등록 처리 */
public class CommentWriteAction implements Action {

	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		UserVo user = (UserVo) session.getAttribute("user");

		int no = Integer.parseInt(request.getParameter("no"));
		String comment_write = request.getParameter("comment_write");
		String id = user.getId();

		MovieBiz bbsBiz = new MovieBiz();

		bbsBiz.insertComment(id, no, comment_write);

		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl("movie_view.bbs?no=" + no);

		return forward;
	}
}
