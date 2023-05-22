package com.review.cinema.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.cinema.action.Action;
import com.review.cinema.action.QnaCommentDeleteAction;
import com.review.cinema.action.QnaCommentUpdateAction;
import com.review.cinema.action.QnaCommentWriteAction;
import com.review.cinema.action.QnaDeleteAction;
import com.review.cinema.action.QnaListAction;
import com.review.cinema.action.QnaUpdateAction;
import com.review.cinema.action.QnaUpdateFormAction;
import com.review.cinema.action.QnaViewAction;
import com.review.cinema.action.QnaWriteAction;
import com.review.cinema.vo.ActionForwardVo;

import com.review.cinema.action.*;

@WebServlet("*.qna")

public class QnaFrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public QnaFrontController() {
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
		
		if(command.equals("/qna_write.qna")) {
			action = new QnaWriteAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/qna_list.qna")) {
			action = new QnaListAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/qna_view.qna")) {
			action = new QnaViewAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/qna_delete.qna")) {
			action = new QnaDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/qna_updateForm.qna")) {
			action = new QnaUpdateFormAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/qna_update.qna")) {
			action = new QnaUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/comment_write.qna")) {
			action = new QnaCommentWriteAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/comment_delete.qna")) {
			action = new QnaCommentDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/comment_update.qna")) {
			action = new QnaCommentUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

		/*�̵������ִ� ��*/
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


