package com.review.cinema.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.cinema.biz.QnaBiz;
import com.review.cinema.vo.ActionForwardVo;
import com.review.cinema.vo.QnaVo;

/** qna 상세보기 */
public class QnaViewAction implements Action {
	
	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		request.setCharacterEncoding("utf-8");
		
		int qna_no = Integer.parseInt(request.getParameter("qna_no"));
		
		QnaBiz qnaBiz = new QnaBiz();
		
		QnaVo qna = qnaBiz.getQNA(qna_no);
		List<QnaVo> qna_comment = qnaBiz.getQNAComment(qna_no);
		
		request.setAttribute("qna", qna);
		request.setAttribute("qna_comment", qna_comment);
		
		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl(".\\main.jsp?page=qna_view");
		return forward;
	}
}
