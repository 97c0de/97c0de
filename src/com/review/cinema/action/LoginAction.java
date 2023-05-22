package com.review.cinema.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.review.cinema.biz.UserBiz;
import com.review.cinema.vo.ActionForwardVo;
import com.review.cinema.vo.UserVo;

/** 로그인 처리 */
public class LoginAction implements Action {

	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		UserBiz userBiz = new UserBiz();
		UserVo user = userBiz.getLogin(id, password);

		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			ActionForwardVo forward = new ActionForwardVo();
			forward.setUrl("main.jsp");

			return forward;

		} else {
			ActionForwardVo forward = new ActionForwardVo();
			forward.setUrl("loginFail.jsp");

			return forward;
		}
	}
}
