<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Cinema Review |</title>
<link href="resources/css/movie_writeForm.css" rel="stylesheet" type="text/css" />
<script src="//cdn.ckeditor.com/4.21.0/full/ckeditor.js"></script>
</head>
<body>
<div class="container" style="min-height: 1250px;">
	<div id="movie_writeForm_table">
		<h2>영화등록</h2>
		<form action="movie_write.bbs" method="post" name="movie_write_form" id="movie_write_form" enctype="multipart/form-data">
			<table>
				<tr>
					<th>카테고리</th>
					<td>
						<select name="category" id="category">
							<option value="0">---선택---</option>
							<option value="movie">영화</option>
							<option value="netflix">넥플릭스</option>
							<option value="drama">드라마</option>
							<option value="entertainment">예능</option>
							<option value="popular_video">인기영상</option>
						</select>
					</td>
					<th>장르</th>
					<td>
						<select name="genre" id="genre">						
						          	<option value="romance">로맨스</option>
						          	<option value="fantasy">공상</option>
						          	<option value="thriller">스릴러</option>
						          	<option value="comedy">코메디</option>
						          	<option value="sf">SF</option>
						          	<option value="fear">공포</option>
						          	<option value="mystery">미스테리</option>
						          	<option value="documentary">다큐멘터리</option>
						          	<option value="animatedmovie">애니메이션</option>
						          	<option value="etc">기타</option>     
						</select>
					</td>
				</tr>
				
				<tr>
					<th>배우</th>
					<td>
						<input id="actor" type="text" name="actor" placeholder="배우" required  style="width:300px"/>
				
					</td>
					<th>가격</th>
					<td>
						<input id="price" type="text" name="price"  oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"  required/>원
					</td>
				</tr>
				<tr>
					<th>감독</th>
					<td>			
						<input id="director" type="text" name="director" required/>
					</td>
					<th>개봉일</th>
					<td colspan="3">
						<input id="opening_year" type="text" name="opening_year"  maxlength="4" requireds style="width: 100px"	  oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />년&nbsp;&nbsp;
						<input id="opening_month" type="text" name="opening_month" maxlength="2" required style="width: 100px"  oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />월
					</td>
				</tr>
				<tr>
					<th>상영시간</th>
					<td>
						<input type="text" id="running_time" name="running_time" required>
					</td>
					<th>예고편</th>
					<td colspan="3">
						<input type="text" id="trailer" name="trailer" style="width: 80%" placeholder="유튜브 주소">
					</td>
				</tr>
	
		
				
				<tr>
					<th>제목</th>
					<td colspan="3">					
						<input id="title" type="text" name="title" size="170px" required/>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3">					
						<textarea name="content" cols="80px" rows="30px"   id="content" required></textarea>
					</td>
				</tr>
				<tr>
					<th>사진첨부</th>
					<td colspan="3">
						<input type="file" name="filename" required style="width: 200px"/>
					</td>
				</tr>
			</table>
			<div class="write_option">
				<a href="#" id="reset"><p>다시작성</p></a>
				&nbsp;&nbsp;&nbsp;
				<button type="submit" id="register" style="cursor:pointer;"><p>영화등록</p></button>
				<script>
					document.getElementById("register").onclick = function(){
						var category = document.getElementById("category").value;
						var genre = document.getElementById("genre").value;
						var actor = document.getElementById("actor").value;
						var trailer = document.getElementById("trailer").value;
						var price = document.getElementById("price").value;
						var director = document.getElementById("director").value;
						var opening_year = document.getElementById("opening_year").value;
						var opening_month = document.getElementById("opening_month").value;
						var running_time = document.getElementById("running_time").value;
						var phone_number2 = document.getElementById("phone_number2").value;
						var phone_number3 = document.getElementById("phone_number3").value;
						
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
						
						if(!trailer){
							alert("배우을 입력해주세요.");
							return false;
						}
						
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
						
						if(!phone_number2){
							alert("전화번호를 입력해주세요.");
							return false;
						}
						
						if(isNaN(phone_number2)){
							alert("전화번호는 숫자만 입력 가능합니다.");
							return false;
						}
						if(!phone_number3){
							alert("전화번호를 입력해주세요.");
							return false;
						}
						
						if(isNaN(phone_number3)){
							alert("전화번호는 숫자만 입력 가능합니다.");
							return false;
						}
	
					}
					
					document.getElementById("reset").onclick = function() {
						var con = confirm("다시 작성하시겠습니까?")
						if(con){
							document.getElementById("movie_write_form").reset();
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