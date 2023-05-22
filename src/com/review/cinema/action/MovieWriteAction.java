package com.review.cinema.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.review.cinema.biz.MovieBiz;
import com.review.cinema.vo.ActionForwardVo;
import com.review.cinema.vo.UserVo;

import java.util.Enumeration;

/**  영화 등록  */
public class MovieWriteAction implements Action {
	@Override
	public ActionForwardVo execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
        try {

        int fileSize= 5*1024*1024;

        String realPath=request.getServletContext().getRealPath("/");
        
       // String uploadPath = "\\\\192.168.0.165\\upload\\Ateam_upload"; 
        String uploadPath = realPath+"upload";
        
        System.out.println("uploadPath : "+uploadPath);
  
        String encType = "utf-8";

        
        MultipartRequest multi = new MultipartRequest(request, uploadPath,
        		fileSize, encType, new DefaultFileRenamePolicy());
  
        //String fileName= (String)multi.getFileNames().nextElement(); 
       // String decodedFileName= new String (fileName.getBytes ("iso-8859-1"), "UTF-8");
        
        Enumeration<?> files = multi.getFileNames();
        
        String file1 = (String)files.nextElement();
       String filename1 = multi.getFilesystemName(file1);
       // String filename1=decodedFileName;
        
        UserVo user = (UserVo)session.getAttribute("user");
        
		String id = user.getId();
		String category = multi.getParameter("category");
		String genre = multi.getParameter("genre");
		String actor = multi.getParameter("actor");
		String trailer = multi.getParameter("trailer");
		int price = Integer.parseInt(multi.getParameter("price"));
		String director = multi.getParameter("director");
		String opening_year = multi.getParameter("opening_year");
		String opening_month = multi.getParameter("opening_month");
		String running_time = multi.getParameter("running_time");
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		
		MovieBiz bbsBiz = new MovieBiz();
		
		//System.out.println("업로드 정보 " + bbsBiz.toString()  + " title "  + title);
		
		bbsBiz.insertMovie(id, category, genre, actor, trailer,
				price, director, opening_year, opening_month, running_time,
				title, content, filename1);
		
        } catch(Exception e) {
        	e.printStackTrace();
        }
        
		ActionForwardVo forward = new ActionForwardVo();
		forward.setUrl(".\\main.jsp");
		return forward;
	}
}
