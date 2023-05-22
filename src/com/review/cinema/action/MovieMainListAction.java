package com.review.cinema.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.review.cinema.biz.MovieBiz;
import com.review.cinema.vo.ActionForwardVo;
import com.review.cinema.vo.MovieVo;


/** 메인페이지 영화 목록 처리 */
public class MovieMainListAction implements Action {
	
	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		request.setCharacterEncoding("utf-8");
		
		MovieBiz bbsBiz = new MovieBiz();
		
		if(request.getParameter("pageno") != null) {
			int pageno = Integer.parseInt(request.getParameter("pageno"));
			
			Integer  total_count= bbsBiz.getTotalCount();
			if(total_count!=0) {
				List<MovieVo> mainList = bbsBiz.getMainList(pageno);
				request.setAttribute("mainList", mainList);
				
				HttpSession session = request.getSession();
				session.setAttribute("pageno", pageno);
			}

			request.setAttribute("total_count", total_count);
			
		} else {

			int pageno = 1;
			Integer  total_count= bbsBiz.getTotalCount();
			if(total_count!=0) {
				HttpSession session = request.getSession();
				session.setAttribute("pageno", pageno);
				
				List<MovieVo> mainList = bbsBiz.getMainList(pageno);
				request.setAttribute("mainList", mainList);	
			}

			request.setAttribute("total_count", total_count);
		}
		
		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl(".\\main.jsp?page=main_default");
		return forward;
	}
}
