package com.review.cinema.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.review.cinema.biz.QnaBiz;
import com.review.cinema.vo.ActionForwardVo;
import com.review.cinema.vo.UserVo;

/** qna  답변 등록 처리 */
public class QnaCommentWriteAction implements Action {
	
	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		UserVo user = (UserVo)session.getAttribute("user");
		
		String id = user.getId();
		int qna_no = Integer.parseInt(request.getParameter("qna_no"));
		String comment_write = request.getParameter("comment_write");
		
		QnaBiz qnaBiz = new QnaBiz();

		qnaBiz.insertComment(id, qna_no, comment_write);
		
		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl("qna_view.qna?qna_no="+qna_no);
		
		return forward;
	}
}
