package com.review.cinema.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.review.cinema.biz.UserBiz;
import com.review.cinema.vo.ActionForwardVo;

/** 회원가입 : 아이디 체크 */
public class JoinIdCheckAction implements Action {
	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		boolean id_check;

		UserBiz userBiz = new UserBiz();
		id_check = userBiz.getIdCheck(id);

		if (id == "") {
			id_check = false;
		}

		session.setAttribute("id", id);
		session.setAttribute("id_check", id_check);

		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl("id_checkForm.jsp");

		return forward;
	}
}
