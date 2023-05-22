package com.review.cinema.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.cinema.biz.MovieBiz;
import com.review.cinema.vo.ActionForwardVo;

/** 댓글 업데이트 처리 */
public class CommentUpdateAction implements Action {

	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		int no = Integer.parseInt(request.getParameter("no"));
		int comment_no = Integer.parseInt(request.getParameter("comment_no"));
		String comment_update_name = request.getParameter("comment_update_name");
		String comment_update = request.getParameter(comment_update_name);

		MovieBiz bbsBiz = new MovieBiz();
		bbsBiz.updateComment(comment_no, comment_update);

		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl("movie_view.bbs?no=" + no);

		return forward;
	}
}
