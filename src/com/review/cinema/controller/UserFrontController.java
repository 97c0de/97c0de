package com.review.cinema.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.cinema.action.Action;
import com.review.cinema.action.BookMarkDeleteAction;
import com.review.cinema.action.BookMarkInsertAction;
import com.review.cinema.action.BookMarkListAction;
import com.review.cinema.action.JoinAction;
import com.review.cinema.action.JoinIdCheckAction;
import com.review.cinema.action.LoginAction;
import com.review.cinema.action.LogoutAction;
import com.review.cinema.action.UserDelete;
import com.review.cinema.action.UserIdpwSearchAction;
import com.review.cinema.action.UserInfoDel;
import com.review.cinema.action.UserInformation;
import com.review.cinema.action.UserList;
import com.review.cinema.action.UserUpdate;
import com.review.cinema.vo.ActionForwardVo;

import com.review.cinema.action.*;

@WebServlet("*.user")
public class UserFrontController extends HttpServlet {
		
	private static final long serialVersionUID = 1L;

	public UserFrontController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request, response);
	}//doGet end
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request, response);
	}//doGet end
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		Action action = null;
		ActionForwardVo forward = null;
		
		if(command.equals("/login.user")) {
			action = new LoginAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/logout.user")) {
			action = new LogoutAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/join.user")) {
			action = new JoinAction();
			try {
				forward = action.execute(request, response);
				
				response.sendRedirect("/login.jsp?msg=welcome");
				 return;
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/join_idCheck.user")) {
			action = new JoinIdCheckAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/userList.user")) {
			action = new UserList();
			try {
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/userDelete.user")) {
			action = new UserDelete();
			try {
				forward = action.execute(request, response);
				response.sendRedirect("/userList.user");
				return;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/userinformation.user")) {
			action = new UserInformation();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/userUpdate.user")) {
			action = new UserUpdate();
			try {
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/UserInfoDel.user")) {
			action = new UserInfoDel();
			try {
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/bookMark_list.user")) {
			action = new BookMarkListAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/bookMark_delete.user")) {
			action = new BookMarkDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/bookMark_insert.user")) {
			action = new BookMarkInsertAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/idpwSearchForm.user")) {
			action = new UserIdpwSearchAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getUrl());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher
						(forward.getUrl());
				dispatcher.forward(request, response);
			}
		}
		
	}//doProcess end
}


