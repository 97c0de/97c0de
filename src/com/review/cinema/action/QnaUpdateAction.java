package com.review.cinema.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.cinema.biz.QnaBiz;
import com.review.cinema.vo.ActionForwardVo;

/** qna 업데이트 */
public class QnaUpdateAction implements Action {
	
	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		request.setCharacterEncoding("utf-8");
		
		int qna_no = Integer.parseInt(request.getParameter("qna_no"));
		String qna_title = request.getParameter("qna_title");
		String qna_content = request.getParameter("qna_content");
		
		QnaBiz qnaBiz = new QnaBiz();
		qnaBiz.updateQNA(qna_no,qna_title,qna_content);
		
		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl("qna_view.qna?qna_no="+qna_no);
		
		return forward;
	}
}
