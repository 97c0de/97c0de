package com.review.cinema.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.cinema.biz.UserBiz;
import com.review.cinema.vo.ActionForwardVo;
import com.review.cinema.vo.UserVo;

public class UserInformation implements Action{
	@Override
	public ActionForwardVo execute(HttpServletRequest request,HttpServletResponse response) throws Exception {
	
		//String id = request.getParameter("id");
		UserVo sessionUser=(UserVo)request.getSession().getAttribute("user");
		//System.out.println(" sessionUser  : "+sessionUser.toString());
		
		
		UserBiz userBiz = new UserBiz();
		UserVo user = userBiz.getUser(sessionUser.getId());
		//System.out.println(" UserInformation : "+user.toString());
		request.setAttribute("userInfo", user);
		
		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl(".\\main.jsp?page=information");
		return forward;			
	}

}
