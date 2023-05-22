package com.review.cinema.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.review.cinema.biz.UserBiz;
import com.review.cinema.vo.ActionForwardVo;
import com.review.cinema.vo.UserVo;

/** 북마크 등록 처리 */
public class BookMarkInsertAction implements Action {

	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		int no = Integer.parseInt(request.getParameter("no"));
		UserVo user = (UserVo) session.getAttribute("user");
		String id = user.getId();

		UserBiz userBiz = new UserBiz();

		userBiz.insertBookMark(id, no);

		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl("movie_view.bbs?no=" + no);
		return forward;
	}
}
