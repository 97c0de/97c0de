<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.review.cinema.vo.UserVo"%>
<%
request.setCharacterEncoding("utf-8");
String pagefile = request.getParameter("page");
UserVo user = (UserVo)session.getAttribute("user");

if (pagefile == null) {
	pagefile = "main_call_default";
}
%>
<header style="padding-top: 0px;">
	<div class="container" style="padding-top: 28px;">
		<h1>
			<a href="main.jsp"><img src="resources/image/cinema-logo.png" width="85px"></a>
		</h1>
		<form action="movie_search.bbs" method="post" style="height: 45px; margin-top: 10px;">
			<select name="search_tag">
				<option value="title&content" ${search_tag eq 'title&content'? 'selected' :'' }>제목+내용</option>
				<option value="title" ${search_tag eq 'title'? 'selected' :'' }>제목</option>
				<option value="content" ${search_tag eq 'content'? 'selected' :'' }>내용</option>
				<%-- <option value="id" ${search_tag eq 'id'? 'selected' :'' }>작성자</option> --%>
			</select> <span> <input type="search" placeholder="검색" name="search_keyword" value="${search_keyword}" />
				<button type="submit" style="cursor: pointer">
					<img src="resources/image/search_icon.png">
				</button>
			</span>
		</form>

		<ul class="top_menu" style="padding-top: 25px;">
			<!-- 로그인 했으면 -->
			<%
			if (user != null) {
			%>
			<%
			if (user.getId().equals("admin")) {
			%>
			<li class="header_li" id="my_menu" style="position: relative;"><a href="userList.user"><span>관리자</span></a>
				<ul class="my_menu"
					style="position: absolute; z-index:99; top: 30px; left: -23px; width: 110px; height: auto; display: none; padding-left: 0; border: 1px solid #333; padding-top: 4px; background: #fff;">
					
					<li style="padding-left: 10px; padding-right: 10px; line-height: 30px; padding-bottom: 7px;"><a href="userList.user">회원목록관리</a></li>
					<li style="padding-left: 10px; padding-right: 10px; line-height: 30px; padding-bottom: 7px;"><a href="userinformation.user">회원정보관리</a></li>
					<li style="padding-left: 10px; padding-right: 10px; line-height: 32px;"><a href="WriteList.bbs?id=<%=user.getId()%>">내가쓴글보기</a></li>

				</ul>
			<li class="header_li"><a href="logout.user">로그아웃<img src="resources/image/logout_no.png" class="on"></a></li>
			<li class="header_li"><a href="bookMark_list.user">북마크</a></li>
			<%
			} else {
			%>
			<li class="header_li" id="my_menu" style="position: relative;"><a href="#"><span><%=user.getId()%>님</span></a>
				<ul class="my_menu"
					style="position: absolute; top: 30px; left: -23px; width: 110px; height: auto; display: none; padding-left: 0; border: 1px solid #333; padding-top: 4px; background: #fff;">
					<li style="padding-left: 10px; padding-right: 10px; line-height: 30px; padding-bottom: 7px;"><a href="userinformation.user">회원정보관리</a></li>
					<%-- <li style="padding-left: 10px; padding-right: 10px; line-height: 32px;"><a href="WriteList.bbs?id=<%=user.getId()%>">내가쓴글보기</a></li> --%>

				</ul></li>
			<li class="header_li"><a href="logout.user">로그아웃<img src="resources/image/logout_no.png" class="on"></a></li>
			<li class="header_li"><a href="bookMark_list.user">북마크</a></li>
			<!-- 로그인 안했으면 -->
			<%
			}
			} else {
			%>
			<li class="header_li"><a href="login.jsp">로그인<img src="resources/image/login_no.png" class="on"></a></li>
			<li class="header_li"><a href="join.jsp">회원가입<img src="resources/image/membership_no.png" class="on"></a></li>
			<%
			}
			%>
			<li class="header_li"><a href="qna_list.qna">고객센터</a></li>
			
		
	
		</ul>
	</div>
</header>

<nav>
	<div class="container">
		<ul>
			<li><a href="movie_list.bbs?category=movie">＋영화</a></li>
			<li><a href="movie_list.bbs?category=netflix">＋넥플릭스</a></li>
			<li><a href="movie_list.bbs?category=drama">＋드라마</a></li>
			<li><a href="movie_list.bbs?category=entertainment">＋예능</a></li>
			<li><a href="movie_list.bbs?category=popular_video">＋인기영상</a></li>
		</ul>
	</div>
</nav>


