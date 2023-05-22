package com.review.cinema.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.review.cinema.biz.QnaBiz;
import com.review.cinema.vo.ActionForwardVo;
import com.review.cinema.vo.QnaVo;

/** qna 목록 */
public class QnaListAction implements Action {
	
	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		request.setCharacterEncoding("utf-8");
		
		QnaBiz qnaBiz = new QnaBiz();
		

		if(request.getParameter("pageno") != null) {
			int pageno = Integer.parseInt(request.getParameter("pageno"));
			
			request.setAttribute("qna_count", qnaBiz.getQNACount());
			
			List<QnaVo> qnaList = qnaBiz.getQNAList(pageno);
			request.setAttribute("qnaList", qnaList);
			
			HttpSession session = request.getSession();
			session.setAttribute("pageno", pageno);
			
		} else {

			int pageno = 1;
			
			HttpSession session = request.getSession();
			session.setAttribute("pageno", pageno);
			
			request.setAttribute("qna_count", qnaBiz.getQNACount());
			
			List<QnaVo> qnaList = qnaBiz.getQNAList(pageno);
			request.setAttribute("qnaList", qnaList);
		}
		
		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl(".\\main.jsp?page=qna_list");
		
		return forward;
	}
}
