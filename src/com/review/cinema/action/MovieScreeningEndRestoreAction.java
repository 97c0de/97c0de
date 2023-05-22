package com.review.cinema.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.cinema.biz.MovieBiz;
import com.review.cinema.vo.ActionForwardVo;


/**  영화 상영종료 처리 */
public class MovieScreeningEndRestoreAction implements Action {
	
	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		MovieBiz bbsBiz = new MovieBiz();
		bbsBiz.deleteSoldOut(no);
		
		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl("movie_view.bbs?no="+no);
		return forward;
	}
}
