package com.review.cinema.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.cinema.biz.UserBiz;
import com.review.cinema.vo.ActionForwardVo;
import com.review.cinema.vo.UserVo;

/** 유저 비밀번호 검색  */
public class UserIdpwSearchAction implements Action {
	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String email = request.getParameter("email_id")+"@"+request.getParameter("email_address");
		String id = request.getParameter("id");
		String form = request.getParameter("form");
		
		UserBiz userBiz = new UserBiz();
	
	
		if(form.equals("idform")) {
			int int_month = Integer.parseInt(month);
			int int_day = Integer.parseInt(day);
			

			if(int_month < 10) {
				if(month.charAt(0) != '0') {
					month = "0" + month;
				}
			}
			if(int_day < 10) {
				if(day.charAt(0) != '0') {
					day = "0" + day;
				}
			}
			
			String birth=year+month+day;
			
			UserVo user = userBiz.searchId(name, birth, email);
			request.setAttribute("user", user);
			request.setAttribute("form", form);
		
		} else if(form.equals("pwform")) {
			UserVo user = userBiz.searchPw(id, email);
			request.setAttribute("user", user);
			request.setAttribute("form", form);
		}
		
		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl("idpw_searchForm.jsp");
		
		return forward;
	}
}
