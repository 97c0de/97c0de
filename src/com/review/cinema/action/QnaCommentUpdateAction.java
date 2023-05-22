package com.review.cinema.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.cinema.biz.QnaBiz;
import com.review.cinema.vo.ActionForwardVo;

/** qna 답변 업데이트 처리 */
public class QnaCommentUpdateAction implements Action {
	
	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		request.setCharacterEncoding("utf-8");
		
		int qna_no = Integer.parseInt(request.getParameter("qna_no"));
		int qna_comment_no = Integer.parseInt(request.getParameter("qna_comment_no"));
		String comment_update_name = request.getParameter("comment_update_name");
		String comment_update = request.getParameter(comment_update_name);
		
		QnaBiz qnaBiz = new QnaBiz();
		qnaBiz.updateComment(qna_comment_no, comment_update);
		
		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl("qna_view.qna?qna_no="+qna_no);
		
		return forward;
	}
}
