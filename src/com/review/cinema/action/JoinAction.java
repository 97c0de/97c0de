package com.review.cinema.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.cinema.biz.UserBiz;
import com.review.cinema.vo.ActionForwardVo;

/** 회원가입 처리 */
public class JoinAction implements Action {

	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		String password = request.getParameter("password_1");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");

		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");

		String email_id = request.getParameter("email_id");
		String email_address = request.getParameter("email_address");
		String email = email_id + "@" + email_address;

		String phone_number1 = request.getParameter("phone_number1");
		String phone_number2 = request.getParameter("phone_number2");
		String phone_number3 = request.getParameter("phone_number3");
		String phone_number = phone_number1 + "-" + phone_number2 + "-" + phone_number3;

		int int_month = Integer.parseInt(month);
		int int_day = Integer.parseInt(day);

		if (int_month < 10) {
			if (month.charAt(0) != '0') {
				month = "0" + month;
			}
		}
		if (int_day < 10) {
			if (day.charAt(0) != '0') {
				day = "0" + day;
			}
		}
		String birth = year + "-" + month + "-" + day;

		UserBiz userBiz = new UserBiz();
		userBiz.getJoin(id, password, name, gender, birth, email, phone_number);

		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl(".\\main.jsp");

		return forward;
	}
}
