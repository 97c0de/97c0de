package com.review.cinema.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.review.cinema.biz.MovieBiz;
import com.review.cinema.vo.ActionForwardVo;


/**  영화 업데이트 처리 */
public class MovieUpdateAction implements Action {

	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		int no = Integer.parseInt(request.getParameter("no"));

		try {

			int fileSize = 5 * 1024 * 1024;

			String realPath = request.getServletContext().getRealPath("/");

			// String uploadPath = "\\\\192.168.0.165\\upload\\Ateam_upload";
			String uploadPath = realPath + "upload";

			System.out.println("uploadPath : " + uploadPath);

			String encType = "utf-8";

			MultipartRequest multi = new MultipartRequest(request, uploadPath, fileSize, encType,
					new DefaultFileRenamePolicy());

			Enumeration<?> files = multi.getFileNames();

			String file1 = (String) files.nextElement();
			String filename1 = multi.getFilesystemName(file1);

			if (filename1 == null) {
				filename1 = multi.getParameter("org_filename");
			}

			String category = multi.getParameter("category");
			String genre = multi.getParameter("genre");
			String actor = multi.getParameter("actor");
			String trailer = multi.getParameter("trailer");
			int price = Integer.parseInt(multi.getParameter("price"));
			String director = multi.getParameter("director");
			String opening_year = multi.getParameter("opening_year");
			String opening_month = multi.getParameter("opening_month");
			String running_time = multi.getParameter("running_time");
			String title = multi.getParameter("title");
			String content = multi.getParameter("content");

			MovieBiz bbsBiz = new MovieBiz();
			bbsBiz.updateMovie(category, genre, actor, trailer, price, director, opening_year, opening_month,
					running_time, title, content, filename1, no);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl("movie_view.bbs?no=" + no);
		return forward;
	}
}
