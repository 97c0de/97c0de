package com.review.cinema.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.cinema.biz.MovieBiz;
import com.review.cinema.vo.ActionForwardVo;

/** 댓글 삭제 처리 */
public class CommentDeleteAction implements Action {

	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		int comment_no = Integer.parseInt(request.getParameter("comment_no"));
		int no = Integer.parseInt(request.getParameter("no"));

		MovieBiz bbsBiz = new MovieBiz();

		bbsBiz.deleteComment(no, comment_no);

		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl("movie_view.bbs?no=" + no);
		return forward;
	}
}
