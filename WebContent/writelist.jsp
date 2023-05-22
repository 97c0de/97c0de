<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@page import="java.util.ArrayList"%>
    <%@page import="java.util.*" %>
    <%@page import="java.util.List"%>
    <%@page import="java.sql.*"%>
	<%@page import="javax.servlet.http.*"%>
    <%@page import="com.review.cinema.vo.MovieVo" %>
    <%@page import="com.review.cinema.dao.MovieDao" %> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<%@ include file="include/head.jsp" %>

<link href="resources/css/writelist.css" rel="stylesheet" type="text/css" />
</head>
<body>




	<%

		List<MovieVo> bbss = (List<MovieVo>) request.getAttribute("bbs");
	%>

		<%@ include file="include/head_menu.jsp" %>
	
	
	
	
	
	
	
	
		<div class="container" style="margin-top: 50px;">

		<h2>내가 쓴 글</h2>
		<table>
			<tr>
			<td>ID</td>
			<td>작성글</td>
			<td>날짜</td>
			<td>조회수</td>
			</tr>
			 <%
			
			 	 	  
			 	 	 		   	for(int i=0; i<bbss.size(); i++){ 
			 	 	 		   		MovieVo bbs = bbss.get(i);
			 %>
				<tr>
				<td><%= bbs.getId() %></td>
				<td><a href="movie_view.bbs?no=<%=bbs.getNo()%>"><%= bbs.getTitle() %></a></td>
				<td><%= bbs.getUpload_date() %></td>
				<td><%= bbs.getRead_count() %></td>
				</tr>
			<% } %>
			
			<c:if test="${bbss.size()==0 }">
				 <tr>
				 	<td colspan="4">게시글이 없습니다.</td>
				 </tr>
			</c:if>
		</table>
	
	</div>
	
	
	
			
	<%@ include file="include/footer.jsp" %>
	
	
	
</body>
</html>