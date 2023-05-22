package com.review.cinema.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.review.cinema.biz.MovieBiz;
import com.review.cinema.vo.ActionForwardVo;
import com.review.cinema.vo.MovieVo;

/** 영화 목록 처리 */
public class MovieListAction implements Action {

	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		String category = request.getParameter("category");
		request.setAttribute("category", category);
		MovieBiz bbsBiz = new MovieBiz();

		if (request.getParameter("pageno") != null) {
			int pageno = Integer.parseInt(request.getParameter("pageno"));

			HttpSession session = request.getSession();
			session.setAttribute("pageno", pageno);

			request.setAttribute("getCategoryListCount", bbsBiz.getCategoryListCount(category));

			List<MovieVo> bbsList = bbsBiz.getMovieList(category, pageno);
			request.setAttribute("bbsList", bbsList);

		} else {
			int pageno = 1;

			HttpSession session = request.getSession();
			session.setAttribute("pageno", pageno);

			request.setAttribute("getCategoryListCount", bbsBiz.getCategoryListCount(category));

			List<MovieVo> bbsList = bbsBiz.getMovieList(category, pageno);
			request.setAttribute("bbsList", bbsList);
		}

		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl(".\\main.jsp?page=movie_list");
		return forward;
	}
}
