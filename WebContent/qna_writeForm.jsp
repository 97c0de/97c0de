<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.review.cinema.vo.UserVo" %>
<!DOCTYPE html>
<html>
<head>
<link href="resources/css/qna_writeForm.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cinema Review |</title>
</head>
<body>
	<div class="container">
		<form action="qna_write.qna" method="post" name="qna_write_form" id="qna_write_form">
			<h2>1:1 문의</h2>
			<table class="qna_table">
				<tr>
					<th>제목</th>
					<td><input type="text" name="qna_title" id="qna_title" maxlength="30"/></td>
				</tr>
				<tr>
					<th>문의 내용</th>
					<td><textarea name="qna_content" id="qna_content"></textarea></td>
				</tr>
			</table>
			<div class="form_button">	
				<input type="submit" value="문의하기" id="qna_write_button"/>
				<script>
							document.getElementById("qna_write_button").onclick = function(){
								var qna_title = document.getElementById("qna_title").value;
								var qna_content = document.getElementById("qna_content").value;
								
								if(!qna_title){
									alert("제목을 입력해주세요.");
									return false;
								}
								
								if(qna_title.length < 5){
									alert("제목은 최소 5글자 이상이어야 합니다.");
									return false;
								}
								
								if(!qna_content){
									alert("문의 내용을 입력해주세요.");
									return false;
								}
								
								if(qna_content.length < 10){
									alert("문의 내용은 최소 10글자 이상이어야 작성가능합니다.");
									return false;
								}
							}
						</script>
						&nbsp;&nbsp;
						<a href="#"><button id="reset_button">다시작성</button></a>
						<script>
							document.getElementById("reset_button").onclick = function(){
								document.getElementById("qna_write_form").reset();
								return false;
							}
						</script>
			</div>
		</form>
	</div>
</body>
</html>