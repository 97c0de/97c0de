package com.review.cinema.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.cinema.action.Action;
import com.review.cinema.action.CommentDeleteAction;
import com.review.cinema.action.CommentUpdateAction;
import com.review.cinema.action.CommentWriteAction;
import com.review.cinema.action.MovieDeleteAction;
import com.review.cinema.action.MovieListAction;
import com.review.cinema.action.MovieMainListAction;
import com.review.cinema.action.MovieScreeningEndAction;
import com.review.cinema.action.MovieScreeningEndRestoreAction;
import com.review.cinema.action.MovieSearchAction;
import com.review.cinema.action.MovieUpdateAction;
import com.review.cinema.action.MovieUpdateFormAction;
import com.review.cinema.action.MovieViewAction;
import com.review.cinema.action.MovieWriteAction;
import com.review.cinema.action.WriteListAction;
import com.review.cinema.vo.ActionForwardVo;

import com.review.cinema.action.*;

@WebServlet("*.bbs")
public class MovieFrontController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public MovieFrontController() {
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
		
		if(command.equals("/main_default.bbs")) {
			action = new MovieMainListAction();
			request.setAttribute("banner", "on");
			
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(command.equals("/movie_list.bbs")) {
			action = new MovieListAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/movie_write.bbs")) {
			action = new MovieWriteAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/movie_view.bbs")) {
			action = new MovieViewAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/movie_update.bbs")) {
			action = new MovieUpdateAction();
			try {
				forward = action.execute(request, response);
				
				response.sendRedirect("movie_view.bbs?no="+request.getParameter("no"));
				return;
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/movie_delete.bbs")) {
			action = new MovieDeleteAction();
			try {
				forward = action.execute(request, response);
				
				response.sendRedirect("/");
				return;
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/movie_updateForm.bbs")) {
			action = new MovieUpdateFormAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/comment_write.bbs")) {

			
			action = new CommentWriteAction();
			try {
				forward = action.execute(request, response);
				response.sendRedirect("movie_view.bbs?no="+request.getParameter("no")+"#movie-review");
			
				
				return;
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/comment_delete.bbs")) {
			action = new CommentDeleteAction();
			try {
				forward = action.execute(request, response);
				response.sendRedirect("movie_view.bbs?no="+request.getParameter("no")+"#movie-review");
				return ;
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/comment_update.bbs")) {
			action = new CommentUpdateAction();
			try {
				forward = action.execute(request, response);
				response.sendRedirect("movie_view.bbs?no="+request.getParameter("no")+"#movie-review");
				return ;
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/movie_search.bbs")) {
			action = new MovieSearchAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/WriteList.bbs")) {
			action = new WriteListAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/movie_screening_end.bbs")) {
			action = new MovieScreeningEndAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(command.equals("/movie_screening_end_restore.bbs")) {
			action = new MovieScreeningEndRestoreAction();
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


