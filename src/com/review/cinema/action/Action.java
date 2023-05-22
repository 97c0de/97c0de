package com.review.cinema.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.cinema.vo.ActionForwardVo;

public interface Action {
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
