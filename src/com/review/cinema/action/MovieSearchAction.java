package com.review.cinema.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.review.cinema.biz.MovieBiz;
import com.review.cinema.vo.ActionForwardVo;
import com.review.cinema.vo.MovieVo;

/**  영화 검색 처리 */
public class MovieSearchAction implements Action {
	
	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		MovieBiz bbsBiz = new MovieBiz();
		
		String search_tag = request.getParameter("search_tag");
		String search_keyword= request.getParameter("search_keyword");
		
		if(search_tag != null && search_keyword != null) {
			session.setAttribute("search_tag", search_tag);
			session.setAttribute("search_keyword", search_keyword);
			
			if(request.getParameter("pageno") != null) {
				int pageno = Integer.parseInt(request.getParameter("pageno"));
				
				List<MovieVo> bbss = bbsBiz.searchMovie(pageno, search_tag, search_keyword);
				int search_total_count = bbsBiz.getSearchCount(search_tag, search_keyword);
				
				request.setAttribute("bbss", bbss);
				request.setAttribute("search_total_count", search_total_count);
				request.setAttribute("pageno", pageno);
				
			} else {
				int pageno = 1;
				
				List<MovieVo> bbss = bbsBiz.searchMovie(pageno, search_tag, search_keyword);
				int search_total_count = bbsBiz.getSearchCount(search_tag, search_keyword);
				
				request.setAttribute("bbss", bbss);
				request.setAttribute("search_total_count", search_total_count);
				request.setAttribute("pageno", pageno);
			}
		} else {
			search_tag = (String)session.getAttribute("search_tag");
			search_keyword = (String)session.getAttribute("search_keyword");
			
			if(request.getParameter("pageno") != null) {
				int pageno = Integer.parseInt(request.getParameter("pageno"));
				
				List<MovieVo> bbss = bbsBiz.searchMovie(pageno, search_tag, search_keyword);
				int search_total_count = bbsBiz.getSearchCount(search_tag, search_keyword);
				
				request.setAttribute("bbss", bbss);
				request.setAttribute("search_total_count", search_total_count);
				request.setAttribute("pageno", pageno);
				
			} else {
				int pageno = 1;
				
				List<MovieVo> bbss = bbsBiz.searchMovie(pageno, search_tag, search_keyword);
				int search_total_count = bbsBiz.getSearchCount(search_tag, search_keyword);
				
				request.setAttribute("bbss", bbss);
				request.setAttribute("search_total_count", search_total_count);
				request.setAttribute("pageno", pageno);
			}
		}
		
		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl(".\\main.jsp?page=movie_searchlist");
		return forward;
	}
}
