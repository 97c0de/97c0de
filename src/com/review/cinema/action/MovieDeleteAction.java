package com.review.cinema.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.cinema.biz.MovieBiz;
import com.review.cinema.vo.ActionForwardVo;

/** 영화삭제 처리 */
public class MovieDeleteAction implements Action {

	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		int no = Integer.parseInt(request.getParameter("no"));
		String filename1 = request.getParameter("filename1");

		String realPath = request.getServletContext().getRealPath("/");
		// String uploadPath = "\\\\192.168.0.165\\upload\\Ateam_upload";
		String uploadPath = realPath + "upload";

		File file = new File(uploadPath + "//" + filename1);

		MovieBiz bbsBiz = new MovieBiz();

		bbsBiz.deleteContent(no);

		if (file.exists()) {
			if (file.delete()) {
				System.out.println("file delete");
			} else {
				System.out.println("file delete failed");
			}
		} else {
			System.out.println("not found file");
		}

		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl("main.jsp");
		return forward;
	}
}
