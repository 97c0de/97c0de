package com.review.cinema.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.cinema.biz.QnaBiz;
import com.review.cinema.vo.ActionForwardVo;

/** qna 답변 등록 처리 */
public class QnaDeleteAction implements Action {
	
	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		request.setCharacterEncoding("utf-8");
		
		int qna_no = Integer.parseInt(request.getParameter("qna_no"));
		
		QnaBiz qnaBiz = new QnaBiz();
		
		qnaBiz.deleteQNA(qna_no);
		
		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl("qna_list.qna");
		return forward;
	}
}
