package com.review.cinema.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.cinema.biz.UserBiz;
import com.review.cinema.vo.ActionForwardVo;

/** 유저 정보 삭제 */
public class UserInfoDel implements Action {
	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");

		UserBiz userBiz = new UserBiz();

		userBiz.DeleteUser(id);

		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl("main.jsp");
		forward.setRedirect(true);
		return forward;

	}
}
