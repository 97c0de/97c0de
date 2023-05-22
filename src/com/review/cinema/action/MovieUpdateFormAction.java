package com.review.cinema.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.cinema.biz.MovieBiz;
import com.review.cinema.vo.ActionForwardVo;
import com.review.cinema.vo.MovieVo;


/**  영화 업데이트 폼 */
public class MovieUpdateFormAction implements Action {
	
	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		MovieBiz bbsBiz = new MovieBiz();
		
		MovieVo bbs = bbsBiz.getContent(no);
		request.setAttribute("bbs", bbs);
		
		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl(".\\main.jsp?page=movie_updateForm");
		return forward;
	}
}
