<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>     
<%@ page import = "java.util.List" %>
<%@ page import = "java.text.*" %>
<%@ page import = "com.review.cinema.vo.MovieVo" %>
<%@ page import = "com.review.cinema.vo.UserVo" %>
<% 	
	int getCategoryListCount = (int)request.getAttribute("getCategoryListCount");
	String category = (String)request.getAttribute("category");
%>
<!DOCTYPE html>
<html>
<head>
	<title>Cinema Review |</title>
	<link href="resources/css/movie_list.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<div class="container">
	   <div id="movie_list_wrap">
		   <c:forEach items="${bbsList}" var="row">
	   	<div class="card" style="height: 500px">
		   	<c:choose>
		   		<c:when test="${not empty row.filename1}">
		   			<div class="img"><a href="movie_view.bbs?no=${row.no}"><img class="movie_image" src="upload/${row.filename1}" ></a></div>
		   		</c:when>
		   		<c:otherwise>
		   			<div class="img"><a href="movie_view.bbs?no=${row.no}"><img class="movie_image" src="image/noimg.gif"></a></div>
		   		</c:otherwise>
		   	</c:choose>
		   	  <div class="text">
		            <h4 style="font-size: 18px" title="${row.title}">
		           		<c:if test="${not empty row.screening_end }">
		           			<span class="text-red">[상영종료]</span> 
		           		</c:if>
		           		${row.title}
		           		<c:if test="${row.comment_count !=0 }">
		           			[${row.comment_count}] 
		           		</c:if>		       		
		            </h4>
		            <p class="f-15"><span class="text-yellow" title="주연:${row.actor}">[${row.getGenerKor(row.genre)}]</span> 주연:${row.actor} </p>
		            <div>
		            <p class="f-15" title="감독:${row.director}">감독:${row.director} </p>
		            </div>
		            <div class="d-flex" style="justify-content: space-around;">
			            <p  class="f-15" style="margin-right: 5px">
			            <i class="fa fa-eye" style="font-size: 15px;" data-toggle="tooltip" data-placement="bottom" title="조회수" data-original-title="조회수"></i> 
			             ${row.read_count}</p>
			            <p  class="f-15">개봉일:${row.opening_year}년 ${row.opening_month}월</p>	
		            </div>	            
		        </div>
		        </div>
		   </c:forEach>
	    
	   </div>
	   
	   
	 </div>
	  <h3 align="center">
		  	<span>
			<% if (getCategoryListCount%9 == 0){ 
				for(int i=1; i<=getCategoryListCount/9; i++){%>
					&nbsp;<a href="movie_list.bbs?category=<%=category%>&pageno=<%= i %>"><%= i %></a>&nbsp;
			<%	} 
				} else if(getCategoryListCount%9 > 0) {
					 for(int i=1; i<=getCategoryListCount/9+1; i++){%>
						&nbsp;<a href="movie_list.bbs?category=<%=category%>&pageno=<%= i %>"><%= i %></a>&nbsp;
			<% 		} 
				} %>
			</span>
	  </h3>
		<br>
	
	<%@ include file="include/movie_write_btn.jsp" %>
	
</body>
</html>