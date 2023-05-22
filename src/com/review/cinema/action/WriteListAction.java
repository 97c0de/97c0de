package com.review.cinema.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.cinema.biz.MovieBiz;
import com.review.cinema.vo.ActionForwardVo;
import com.review.cinema.vo.MovieVo;

/** 등록한글 목록  */
public class WriteListAction implements Action {
	
@Override
public ActionForwardVo execute(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
	
		String id=request.getParameter("id");
		
		MovieBiz bbsbiz = new MovieBiz();
		List<MovieVo> bbs = bbsbiz.getWriteList(id);
		request.setAttribute("bbs", bbs);
		
		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl("writelist.jsp");
		return forward;
}
}