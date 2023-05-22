package com.review.cinema.action;

import javax.servlet.http.*;


import com.review.cinema.biz.UserBiz;
import com.review.cinema.vo.ActionForwardVo;

/** 유저 업데이트   */
public class UserUpdate implements Action{
	@Override
	public ActionForwardVo execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");

		String phone_number1 = request.getParameter("phone_number1");
		String phone_number2 = request.getParameter("phone_number2");
		String phone_number3 = request.getParameter("phone_number3");	
		
		String id = request.getParameter("id");
		UserBiz userBiz = new UserBiz();
		
		String birth = year+"-"+month+"-"+day;
		String email = email1+"@"+email2;
		String phone_number = phone_number1+"-"+phone_number2+"-"+phone_number3;
		userBiz.update(password, name, birth, email, phone_number, id);
		
		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl("main.jsp");
		forward.setRedirect(true);
		return forward;
	}

}
