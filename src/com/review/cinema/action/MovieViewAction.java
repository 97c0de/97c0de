package com.review.cinema.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.review.cinema.biz.MovieBiz;
import com.review.cinema.vo.ActionForwardVo;
import com.review.cinema.vo.MovieVo;
import com.review.cinema.vo.UserVo;

/**  영화 상세보기 */
public class MovieViewAction implements Action {

	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		UserVo user = (UserVo) session.getAttribute("user");
		MovieBiz bbsBiz = new MovieBiz();

		int no = Integer.parseInt(request.getParameter("no"));

		MovieVo bbs = bbsBiz.getContent(no);

		request.setAttribute("bbs", bbs);

		List<MovieVo> movie_comment = bbsBiz.getMovieComment(no);
		request.setAttribute("movie_comment", movie_comment);

		if (user != null) {
			boolean like = bbsBiz.getBookMark(no, user.getId());
			request.setAttribute("like", like);

			String id = user.getId();
			String read_id = bbsBiz.checkReadId(no, id);

			if (read_id != null) {
			} else {

				bbsBiz.insertReadId(no, id);
				bbsBiz.updateReadCount(no);
			}
		}

		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl(".\\main.jsp?page=movie_view");
		return forward;
	}

}
