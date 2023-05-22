package com.review.cinema.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.cinema.biz.UserBiz;
import com.review.cinema.vo.ActionForwardVo;
import com.review.cinema.vo.UserVo;


/** 유저 목록  */
public class UserList implements Action{
	@Override
	public ActionForwardVo execute(HttpServletRequest request,HttpServletResponse response) throws Exception {

		UserBiz userBiz = new UserBiz();
		List<UserVo> users = userBiz.getUsers();
		request.setAttribute("users", users);
		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl("admin.jsp");
		
		return forward;
	}
}
