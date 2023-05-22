<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.review.cinema.vo.MovieVo"%>
<%@ page import = "java.util.*" %>
<%@ page import = "java.text.*" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="resources/css/bookMaker.css" rel="stylesheet" type="text/css" />
</head>
<%
 
	List<MovieVo> bookMarkList = (List<MovieVo>)request.getAttribute("bookMarkList");
	String uploadPath = "upload/";
	DecimalFormat df = new DecimalFormat("#,##0");
	int bookMark_total_price = 0;
%>
<body>
	<div class="container">
		<form action="bookMark_delete.user" method="get" name="checkbox_form" id="checkbox_form">
			<div id="bookMark_top">
				<h2>북마크</h2>
				<a href="main.jsp"><p>메인화면</p></a>
			</div>
			<table class="bookMark_table">
				<tr>
					<th>선택</th>
					<th></th>
					<th class="text-center">영화</th>
					<th>감독</th>
					<th>배우</th>
				</tr>
				<%

											if(bookMarkList.size() > 0){
												for(int i=0; i<bookMarkList.size(); i++){
													MovieVo bookMark = bookMarkList.get(i);
													bookMark_total_price += bookMark.getPrice();
				%>
				<tr>
					<td>
		
						<input type="checkbox" name="check" value="<%=bookMark.getNo()%>"/>
		
					</td>
					<td>
					<% 
						if(bookMark.getFilename1() != null) { 
					%>
						<a href="movie_view.bbs?no=<%=bookMark.getNo()%>"><img class="movie_image" src="<%= uploadPath + bookMark.getFilename1() %>" width="150px"></a>
					<%
						} else {
					%>
						<a href="movie_view.bbs?no=<%=bookMark.getNo()%>"><img class="movie_image" src="image/noimg.gif" width="250px"></a>
					<%
						}
					%>
					</td>
					<td class="text-center"><%=bookMark.getTitle()%></td>
					<td class="text-center"><%=bookMark.getDirector()%></td>
					<td class="text-center"><%=bookMark.getActor() %> </td>
				</tr>
				
				<%
						}//for end
					} else {
				%>
				<tr>
					<td colspan="5">북마트 영화가 없습니다.</td>
				</tr>
				<%
					} //else end
				%>
				
				
			<c:if test="${not empty bookMarkList }">
				<tr>
					<td colspan="5" style="text-align: right;">
						<button id="checkbox_delete" type="button" class="btn-delete">삭제</button>
						<script>
							document.getElementById("checkbox_delete").onclick = function(){
								var con = confirm("삭제하시겠습니까?");
								if(con){
									document.getElementById("checkbox_form").submit();
								} else {
									return false;
								}
							}
						</script>
					</td>
				</tr>
			</c:if>	
				
			</table>
		</form>
	</div>
</body>
</html>