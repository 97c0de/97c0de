<%@page import="com.mysql.jdbc.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.review.cinema.vo.MovieVo" %>
<%@ page import = "com.review.cinema.vo.UserVo" %>
<%@ page import = "java.util.*" %>
<%@ page import = "java.text.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Cinema Review |</title>
<link href="resources/css/movie_view.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%
MovieVo bbs = (MovieVo)request.getAttribute("bbs");
	UserVo user = (UserVo)session.getAttribute("user");
	List<MovieVo> movie_comment = (List<MovieVo>)request.getAttribute("movie_comment");
	
	boolean like = false;
	
	if(request.getAttribute("like") != null){
		like = (boolean)request.getAttribute("like");
	}
	
	DecimalFormat df = new DecimalFormat("#,##0");
	String uploadPath = "upload/";
%>
	<div class="container">
		<div class="product_img">
			<%
			if(bbs.getFilename1() != null) {
			%>
				<img src="<%=uploadPath + bbs.getFilename1()%>" width="550px">
			<%
			} else {
			%>
				<img src="resources/image/noimg.gif" width="550px"/>
			<%
			}
			%>
		</div>
		<table class="product_info">
			<tr>
				<th colspan="4"><%=bbs.getTitle()%></th>
			</tr>
			<tr>
				<th>카테고리  : </th>
				<td colspan="3">
				<%
				if(bbs.getCategory().equals("movie")){
				%>
					영화
				<%
				} else if(bbs.getCategory().equals("netflix")){
				%>
					넥플릭스
				<%
				} else if(bbs.getCategory().equals("drama")){
				%>
					드라마
				<%
				} else if(bbs.getCategory().equals("entertainment")){
				%>
					예능
				<%
				} else if(bbs.getCategory().equals("popular_video")){
				%>
					인기영상
				<%
				}
				%>
				</td>
			</tr>
			<tr>
				<th>영화구분  : </th>
				<td colspan="3">
				<%
				if(bbs.getGenre().equals("romance")){ out.print("로멘스");}
													else if(bbs.getGenre().equals("fantasy")){ out.print("공상");}
													else if(bbs.getGenre().equals("thriller")){ out.print("스릴러");}
													else if(bbs.getGenre().equals("comedy")){ out.print("코메디");}
													else if(bbs.getGenre().equals("sf")){ out.print("SF");}
													else if(bbs.getGenre().equals("fear")){ out.print("공포");}
													else if(bbs.getGenre().equals("mystery")){ out.print("미스테리");}
													else if(bbs.getGenre().equals("documentary")){ out.print("다큐멘터리");}
													else if(bbs.getGenre().equals("animatedmovie")){ out.print("애니메이션");}
													else if(bbs.getGenre().equals("etc")){ out.print("기타");}
				%>
				</td>
			</tr>
			<tr>
				<th>배우 : </th>
				<td colspan="3"><%=bbs.getActor()%></td>
			</tr>
			<tr>
				<th>개봉일 : </th>
				<td colspan="3"><%=bbs.getOpening_year() + "년 " + bbs.getOpening_month() + "월"%></td>
			</tr>
			<tr>
				<th>상영시간  : </th>
				<td><%=bbs.getRunning_time()%></td>
			</tr>

			
			<tr>
				<th>감독  : </th>
				<td colspan="3"><%=bbs.getDirector()%></td>
			</tr>
			
			<%
						if(bbs.getScreening_end()!=null){
						%>
			<tr>
				<th>상영여부  : </th>
				<td colspan="3">
					<span class='text-red' >상영종료 </span>
				</td>
			</tr>
			<%
			}
			%>
			
			<tr>
				<th>가격  : </th>
				<td colspan="3"><%=df.format(bbs.getPrice())%>원</td>
			</tr>
			</table>
			
			<div class="like">
			<%
			if(like){
			%>
					<p><a href="bookMark_delete.user?no=<%=bbs.getNo()%>&like=view" id="delete_bookMarkList"><img src="resources/image/liked.png">북마크하기</a></p>
			<%
			} else{
			%>
					<p><a href="bookMark_insert.user?no=<%=bbs.getNo()%>" id="add_bookMarkList"><img src="resources/image/like.png">북마크하기</a></p>
			<%
			}
			%>
			<%
			if(user == null){
			%>
				<script>
					document.getElementById("add_bookMarkList").onclick = function(){
						alert("로그인한 회원만 가능합니다.");
						return false;
					}
				</script>
			<%
			}
			%>
			</div>
			
			<div id="trailer" style="width: 100%; margin-top: 100px;">
			<h5 style="margin-bottom: 10px;">＋예고편</h5>
			 <%
			 String trailer="";
			 	 	 	 	if(!StringUtils.isNullOrEmpty(bbs.getTrailer())){
			 	 	 	 			trailer=bbs.getTrailer().replaceAll("https://youtu.be/", "");
			 	 	 	 	}
			 %>
			 <iframe width="100%" height="450" src="https://www.youtube.com/embed/<%=trailer%>?autoplay=1&mute=1" ></iframe>
			</div>
			
			
			<div class="product_content" style="margin-top: :20px;">
					<%=bbs.getContent().replace("\r\n","<br>")%>
			</div>
			
			<%
						if(user != null){
						%>
			
			<div class="product_option">
					<%
					if(user.getId().equals(bbs.getId()) || user.getId().equals("admin")){
																if(bbs.getScreening_end() != null){
					%>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="movie_screening_end_restore.bbs?no=<%=bbs.getNo()%>" id="screening_end_restore_button">상영종료 취소</a>
					<script>
						document.getElementById("screening_end_restore_button").onclick = function(){
							var con = confirm("상영종료를 취소하시겠습니까?");
							if(!con){ 
								return false;
							}
						}
					</script>
					<%
					} else{
					%>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="movie_screening_end.bbs?no=<%=bbs.getNo()%>" id="screening_end_button">상영종료</a>
					<script>
						document.getElementById("screening_end_button").onclick = function(){
							var con = confirm("상영종료로 변경하시겠습니까?");
							if(!con){
								return false;
							}
						}
					</script>
					<%
					}
					%>

					&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="movie_updateForm.bbs?no=<%=bbs.getNo()%>">수정하기</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="movie_delete.bbs?no=<%=bbs.getNo()%>&filename1=<%=bbs.getFilename1()%>" id="movie_delete_button">삭제하기</a>
					<script>
						document.getElementById("movie_delete_button").onclick = function(){
							var con = confirm("게시글을 삭제하시겠습니까?");
							if(!con){
								return false;
							}
						}
					</script>
					<%
					}
					%>
			</div>
			<%
			}
			%>
			
			
			
			<h5 style="margin-bottom: 20px;width: 100%;display: block; " id="movie-review">＋리뷰</h5>
			<%
			if(movie_comment.size() > 0){
								for(int i=0; i<movie_comment.size(); i++){
									MovieVo comment = movie_comment.get(i);
			%>
			
				
			<div class="reply_view">
			
				
				<p id="replyid"><%= comment.getId() %></p>
					<form action="comment_update.bbs?comment_no=<%=comment.getComment_no()%>&comment_update_name=<%=i%>&no=<%=comment.getNo()%>" method="post" name="comment_update_form">
						<span id="comment_content_<%=i%>">
						<% 
							if(comment.getComment_content()!=null){
								out.print(comment.getComment_content().replace("\r\n","<br>"));
							}
						
						%>
						</span>
		
					<%
						if(user != null){
							if(user.getId().equals(comment.getId()) || user.getId().equals("admin")){
					%>
					<div id="reply_option">
						<a href="#" id="button_<%=i%>" onclick="return false;">수정</a>
						<script>
							document.getElementById("button_<%=i%>").onclick = function(e){
								e.preventDefault();
								var org_value = document.getElementById("comment_content_<%=i%>").innerHTML;
								
								document.getElementById("button_<%=i%>").style.display = "none";
								document.getElementById("update_commit_<%=i%>").style.display = "inline";
								document.getElementById("comment_content_<%=i%>").innerHTML = "<textarea cols='130' rows='4' name='<%=i%>' id='<%=i%>'></textarea>";
								document.getElementById("<%=i%>").value = $.trim(org_value.replace(/(<br>|<br\/>|<br \/>)/g, '\r\n'));
							}
						</script>
						<a href="javascript:comment_update_form.submit()" id="update_commit_<%=i%>" style="display:none;"><button>완료</button></a>
						<a href="comment_delete.bbs?comment_no=<%=comment.getComment_no()%>&no=<%=comment.getNo()%>">삭제</a>
					</div>
					</form>
				<%
						}
					}
				%>
			</div>
			<%
					}
				} else {
			%>
			<div id="noreply">
				아직 댓글이 없습니다.
			</div>
			<%
				}
			%>
			<div class="reply">
					<form action="comment_write.bbs" method="post" id='comment_write_form'>
						<p id="text">댓글쓰기</p>
						
						<textarea name="comment_write" id="comment_write"></textarea>
						&nbsp;&nbsp;&nbsp;
						<p>
							<input type="button" value="등록" id="checkComment"/>
							<input type="hidden" name="no" value="<%=bbs.getNo()%>">
						</p>
						<%
							if(user != null){
						%>
						<script>
							document.getElementById("checkComment").onclick = function(){
								var value = document.getElementById("comment_write").value;
								
								if(!value){
									alert("댓글에 아무것도 입력하지 않았습니다.");
									return false;
								}
								
								document.getElementById('comment_write_form').submit();
							}
						</script>
						<%
							} else {
						%>
							<script>
								document.getElementById("checkComment").onclick = function(){
										alert("로그인한 회원만 댓글을 작성할 수 있습니다.");
										return false;
									}
							</script>
						<%
							}
						%>
					</form>
			</div>
	</div>
</body>
</html>