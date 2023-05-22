<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "com.review.cinema.vo.UserVo" %>
<%@ page import = "java.util.List" %>
<%@ page import = "com.review.cinema.vo.QnaVo" %>
<!DOCTYPE html>
<html>
<head>
<link href="resources/css/qna_list.css" rel="stylesheet" type="text/css" />
<script src="resources/js/jquery-3.2.1.min.js"></script>
<script>
	$(document).ready(function() {
		$(".menuli").on("click", function(e) {
			e.preventDefault();
			$(this).find("ul").slideToggle();
			$(this).find("a").addClass("on");
			$(this).siblings().find("ul").slideUp();
			$(this).siblings().find("a").removeClass("on");
		});
	});
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Cinema Review |</title>
</head>
<body>
<%
UserVo user = (UserVo)session.getAttribute("user");
	List<QnaVo> qnaList = (List<QnaVo>)request.getAttribute("qnaList");
	int qna_count = (int)request.getAttribute("qna_count");
%>
<div class="container">
	<div class="notice">
		<h2>공지사항</h2>
		<div id="side">
			<ul>
				<li class="menuli">
					<a href="#"  onclick="retrun false;"> 첫 번째 공지사항</a>
					<ul>
						<li><a id="a" href="#">첫 번째 공지사항입니다.</a></li>
					</ul>
				</li>
				<li class="menuli">
					<a href="#"  onclick="retrun false;">두 번째 공지사항</a>
					<ul>
						<li><a id="a" href="#">두 번째 공지사항입니다.</a></li>
					</ul>
				</li>
				<li class="menuli">
					<a href="#"  onclick="retrun false;">세 번째 공지사항</a>
					<ul>
						<li><a id="a" href="#">세 번째 공지사항입니다.</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
	<div class="faq">
	<h2>Best FAQ</h2>
		<div id="side">
			<ul>
				<li class="menuli">
					<a href="#"  onclick="retrun false;">Q. 홈페이지는 잘 되나요?</a>
					<ul>
						<li><a id="a" href="#">A. 잘 됩니다.</a></li>
					</ul>
				</li>
				<li class="menuli">
					<a href="#"  onclick="retrun false;">Q. 홈페이지는 잘 되나요?</a>
					<ul>
						<li><a id="a" href="#">A. 잘 됩니다.</a></li>
					</ul>
				</li>
				<li class="menuli">
					<a href="#"  onclick="retrun false;">Q. 홈페이지는 잘 되나요?</a>
					<ul>
						<li><a id="a" href="#">A. 잘 됩니다.</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
	<div class="ptop" style="min-height: 500px;">
		<h2>1:1문의 게시판</h2>
		<%
		int count = 0;
			if(user != null){
				for(int j=0; j<qnaList.size(); j++){
					QnaVo qna = qnaList.get(j);
					if(qna.getId().equals(user.getId()) || user.getId().equals("admin")){
						count++;
					}
				}
				if(count == 0){
		%>
					<p>
						문의한 내용이 없습니다.
					</p>
					<p align="right">
						<a href="main.jsp?page=qna_writeForm">1:1 문의 등록</a>
					</p>
		<%
		} else {
		%>
		<table>
		 
		 	<tr>
				<th>글 번호</th>
				<th>제 목</th>
				<th>작성자</th>
				<th>작성일시</th>
			</tr>
		

		
			<%
							for(int i=0; i<qnaList.size(); i++){
															QnaVo qna = qnaList.get(i);
															if(qna.getId().equals(user.getId()) || user.getId().equals("admin")){
							%>
			<tr>
				<td><%=qna.getQna_no() %></td>
				<td><a href="qna_view.qna?qna_no=<%=qna.getQna_no()%>"><%=qna.getQna_title() %></a></td>
				<td><%=qna.getId() %></td>
				<td><%=qna.getQna_update_date() %></td>
			</tr>
			<%
					}
				}
			%>
			
		</table>
		<div class="page_num">
			<p align="center">
						<% if (qna_count%10 == 0){ 
							for(int i=1; i<=qna_count/10; i++){%>
								&nbsp;<a href="qna_list.qna?pageno=<%= i %>"><%= i %></a>&nbsp;
						<%	} 
							} else if(qna_count%10 > 0) {
								 for(int i=1; i<=qna_count/10+1; i++){%>
									&nbsp;<a href="qna_list.qna?pageno=<%= i %>"><%= i %></a>&nbsp;
						<% 		} 
							} 
						%>
			</p>
			<a href="main.jsp?page=qna_writeForm"><p id="write_qna">1:1 문의등록</p></a>
		</div>
		<%
				}
			} else {
		%>
			<h3>1:1 문의는 로그인한 회원만 가능합니다.</h3>
		<%
			}
		%>
	</div>
	</div>
</body>
</html>