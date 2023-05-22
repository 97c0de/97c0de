<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.review.cinema.vo.MovieVo" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cinema Review |</title>
<link href="resources/css/movie_updateForm.css" rel="stylesheet" type="text/css" />
<script src="//cdn.ckeditor.com/4.21.0/full/ckeditor.js"></script>
</head>
<body>
	<div class="container">
		<%
		MovieVo bbs = (MovieVo)request.getAttribute("bbs");
			String runningTime = bbs.getRunning_time();
		%>
			<div id="movie_writeForm_table">
				<h2 style="color: #fff;">영화수정</h2>
				<form action="movie_update.bbs?no=<%= bbs.getNo() %>" method="post" name="movie_update_form" id="movie_update_form" enctype="multipart/form-data">
					<table>
						<tr>
							<th>카테고리</th>
							<td>
								<select name="category" id="category">
									<option value="0">---선택---</option>
									<option value="movie" <%if(bbs.getCategory().equals("movie")){%>selected<%}%>>영화</option>
									<option value="netflix" <%if(bbs.getCategory().equals("netflix")){%>selected<%}%>>넥플릭스</option>
									<option value="drama" <%if(bbs.getCategory().equals("drama")){%>selected<%}%>>드라마</option>
									<option value="entertainment" <%if(bbs.getCategory().equals("entertainment")){%>selected<%}%>>예능</option>
									<option value="popular_video" <%if(bbs.getCategory().equals("popular_video")){%>selected<%}%>>인기영상</option>
								</select>
							</td>
							<th>영화구분</th>
							<td>
								<select name="genre" id="genre">					
						          	<option value="romance" <%if(bbs.getGenre().equals("romance")){%>selected<%}%>>로맨스</option>
						          	<option value="fantasy" <%if(bbs.getGenre().equals("fantasy")){%>selected<%}%>>공상</option>
						          	<option value="thriller" <%if(bbs.getGenre().equals("thriller")){%>selected<%}%>>스릴러</option>
						          	<option value="comedy" <%if(bbs.getGenre().equals("comedy")){%>selected<%}%>>코메디</option>
						          	<option value="sf" <%if(bbs.getGenre().equals("sf")){%>selected<%}%>>SF</option>
						          	<option value="fear" <%if(bbs.getGenre().equals("fear")){%>selected<%}%>>공포</option>
						          	<option value="mystery" <%if(bbs.getGenre().equals("mystery")){%>selected<%}%>>미스테리</option>
						          	<option value="documentary" <%if(bbs.getGenre().equals("documentary")){%>selected<%}%>>다큐멘터리</option>
						          	<option value="animatedmovie" <%if(bbs.getGenre().equals("animatedmovie")){%>selected<%}%>>애니메이션</option>
						          	<option value="etc" <%if(bbs.getGenre().equals("etc")){%>selected<%}%>>기타</option>
								</select>
							</td>
						</tr>
						

						
						<tr>
							<th>배우</th>
							<td>
								<input id="actor" type="text" name="actor" placeholder="배우" style="width:300px"    value="<%=bbs.getActor()%>"/>
								
							</td>
							<th>가격</th>
							<td>
								<input id="price" type="text" name="price"  oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"  value="<%=bbs.getPrice()%>"/>원
							</td>
						</tr>
						<tr>
							<th>감독</th>
							<td>			
								<input id="director" type="text" name="director" value="<%=bbs.getDirector()%>"/>
							</td>
							<th>개봉일</th>
							<td colspan="3">
								<input id="opening_year" type="text" name="opening_year"  oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" maxlength="4" value="<%=bbs.getOpening_year()%>"/>년&nbsp;
								<input id="opening_month" type="text" name="opening_month"  oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" maxlength="2" value="<%=bbs.getOpening_month()%>"/>월
							</td>
						</tr>
						<tr>
							<th>상영시간</th>
							<td>
							    <input type="text" id="running_time" name="running_time" maxlength="15" value="<%=runningTime%>" required>
							</td>
							<th>예고편</th>
							<td colspan="3">
								<input type="text" id="trailer" name="trailer" style="width: 80%" 	value="<%=bbs.getTrailer()%>" 	placeholder="유튜브 주소">
							</td>
						</tr>
						<tr>
							<th>제목</th>
							<td colspan="3">					
								<input id="title" type="text" name="title" value="<%=bbs.getTitle()%>"/>
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="3">					
								<textarea name="content" cols="60px" id="content" rows="30px"><%=bbs.getContent().replace("<br>","\r\n")%></textarea>
							</td>
						</tr>
						<tr>
							<th>사진첨부</th>
							<td colspan="3">
								<input type="file" name="filename" style="width: 200px"/>
								<input type="hidden" name="org_filename" value="<%=bbs.getFilename1()%>"   style="width: 200px"  />
							</td>
						</tr>
					</table>
					<div class="write_option">
						<button type="submit" id="fixed" style="cursor:pointer;"><p>수정완료</p></button>
						<a id="before_fix" href="javascript:movie_update_form.reset()"><p>수정전으로</p></a>
				<script>
					document.getElementById("fixed").onclick = function(){
						var category = document.getElementById("category").value;
						var genre = document.getElementById("genre").value;
						var actor = document.getElementById("actor").value;
						var trailer = document.getElementById("trailer").value;
						var price = document.getElementById("price").value;
						var director = document.getElementById("director").value;
						var opening_year = document.getElementById("opening_year").value;
						var opening_month = document.getElementById("opening_month").value;
						var running_time = document.getElementById("running_time").value;

						
						if(category == "0"){
							alert("카테고리를 선택해주세요.");
							return false;
						}
						
						if(genre == "0"){
							alert("영화구분을 선택해주세요.");
							return false;
						}

						if(!actor){
							alert("배우을 입력해주세요.");
							return false;
						}
						
				/* 		if(!trailer){
							alert("예고편을 입력해주세요.");
							return false;
						} */
						
						if(!price){
							alert("가격을 입력해주세요.");
							return false;
						}
						
						if(isNaN(price)){
							alert("가격은 숫자만 입력 가능합니다.");
							return false;
						}
						
						if(!director){
							alert("감독을 입력해주세요.");
							return false;
						}
						
				
						
						if(!opening_year){
							alert("구매 날짜[년도]를 입력해주세요.");
							return false;
						}
						
						if(isNaN(opening_year)){
							alert("구매날짜는 숫자만 입력 가능합니다.");
							return false;
						}
						
						if(!opening_month){
							alert("구매 날짜[월]를 입력해주세요.");
							return false;
						}
						
						if(isNaN(opening_month)){
							alert("구매날짜는 숫자만 입력 가능합니다.");
							return false;
						}
						
						if(opening_month > 12 || opening_month <= 0){
							alert("구매날짜를 다시 입력해주세요.");
							return false;
						}
						
	
	
					}
					
					document.getElementById("before_fix").onclick = function() {
						var con = confirm("다시 작성하시겠습니까?")
						if(con){
							document.getElementById("movie_update_form").reset();
						} else {
							return false;
						}
					}
					
					
					
					
					$(function(){
						LoadPage();
					});
					function LoadPage() {
					    CKEDITOR.replace('content', {
					    	height:'600px',
					    	allowedContent:true,
					    	toolbarCanCollapse : true
					    });
					}

					function FormSubmit(f) {
					    CKEDITOR.instances.contents.updateElement();
					    if(f.contents.value == "") {
					        alert("Please enter your details.");
					        return false;
					    }
					    alert(f.contents.value);
					    return false;
					}
				</script>
					</div>
				</form>
			</div>
	</div>
</body>
</html>