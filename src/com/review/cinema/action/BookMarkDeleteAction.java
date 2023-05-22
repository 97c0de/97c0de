package com.review.cinema.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.review.cinema.biz.UserBiz;
import com.review.cinema.vo.ActionForwardVo;
import com.review.cinema.vo.UserVo;

/** 북마크 삭제처리 */
public class BookMarkDeleteAction implements Action {

	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		UserVo user = (UserVo) session.getAttribute("user");
		String id = user.getId();
		String[] check = request.getParameterValues("check");

		UserBiz userBiz = new UserBiz();

		if (check != null) {
			for (int i = 0; i < check.length; i++) {
				userBiz.deleteBookMark(id, check[i]);
			}
		}

		if (request.getParameter("like") != null) {
			String no = request.getParameter("no");

			userBiz.deleteBookMark(id, no);

			ActionForwardVo forward = new ActionForwardVo();
			forward.setUrl("movie_view.bbs?no=" + no);
			return forward;
		}

		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl("bookMark_list.user");
		return forward;
	}
}
