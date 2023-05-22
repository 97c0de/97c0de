package com.review.cinema.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.cinema.biz.QnaBiz;
import com.review.cinema.vo.ActionForwardVo;

/** qna 답변 삭제 처리 */
public class QnaCommentDeleteAction implements Action {
	
	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		request.setCharacterEncoding("utf-8");
		
		int qna_comment_no = Integer.parseInt(request.getParameter("qna_comment_no"));
		int qna_no = Integer.parseInt(request.getParameter("qna_no"));
		
		QnaBiz qnaBiz = new QnaBiz();
		
		qnaBiz.deleteComment(qna_comment_no);
		
		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl("qna_view.qna?qna_no="+qna_no);
		return forward;
	}
}
