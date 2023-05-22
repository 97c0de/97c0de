package com.review.cinema.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.cinema.biz.QnaBiz;
import com.review.cinema.vo.ActionForwardVo;
import com.review.cinema.vo.QnaVo;

/** qna 업데이트 폼 */
public class QnaUpdateFormAction implements Action {
	
	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		request.setCharacterEncoding("utf-8");
		
		int qna_no = Integer.parseInt(request.getParameter("qna_no"));
		
		QnaBiz qnaBiz = new QnaBiz();
		QnaVo qna = qnaBiz.getQNA(qna_no);
		
		request.setAttribute("qna", qna);
		
		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl(".\\main.jsp?page=qna_updateForm");
		return forward;
	}
}
