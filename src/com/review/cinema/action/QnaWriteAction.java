package com.review.cinema.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.review.cinema.biz.QnaBiz;
import com.review.cinema.vo.ActionForwardVo;
import com.review.cinema.vo.UserVo;

/** qna 등록  */
public class QnaWriteAction implements Action {
	
	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		UserVo user = (UserVo)session.getAttribute("user");
		
		String id = user.getId();
		String qna_title = request.getParameter("qna_title");
		String qna_content = request.getParameter("qna_content");
		
		QnaBiz qnaBiz = new QnaBiz();
		
		qnaBiz.insertQNA(id, qna_title, qna_content);
		
		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl("qna_list.qna");
		
		return forward;
	}
}
