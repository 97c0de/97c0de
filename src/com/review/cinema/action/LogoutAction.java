package com.review.cinema.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.review.cinema.vo.ActionForwardVo;


/** 로그아웃 처리 */
public class LogoutAction implements Action {
	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();

		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl("main.jsp");

		return forward;
	}
}
