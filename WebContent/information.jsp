<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<%@ page import = "javax.servlet.http.*" %>
<%@page import="com.review.cinema.vo.UserVo" %>    
    
<%
        UserVo user = (UserVo)request.getAttribute("userInfo");
                	String[] birth = user.getBirth().split("-");
                	String[] email = user.getEmail().split("@");
                	String[] phone = user.getPhone_number().split("-");
        %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cinema Review |</title>
<link href="resources/css/information.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">
		<form action="userUpdate.user" method="post" name="join" id="join">
			<h2>회원정보</h2>
			<div id="id_area">
				<p>아이디</p>
				<input type="text" name="id" id="id" value="<%=user.getId() %>" readonly  class="readonly">
			</div>
			<div id="pw_area">
				<p id="pw1">변경할 비밀번호</p>
				<input type="password" name="password_1" id="password_1"> 			
			</div>
			<div id="pw_area">
				<p id="pw2">비밀번호 확인</p>
				<input type="password" name="password" id="password_2" >
			</div>	
				
			<div id="pri_area">
				<div id="name_area">
					<p>이름</p>
					<input type="text" name="name" id="name" value="<%=user.getName() %>">
				</div>
			</div>
			<div id="pri_area">
			 <div id="birth_area">
					<p>생년월일</p>
					<input type="text" name="year" id="birth" size="4px"  maxlength="4" value="<%=birth[0]%>">년 <span></span>
					<input type="text" name="month" id="month" size="4px"  maxlength="2" value="<%=birth[1]%>">월 <span></span>
					<input type="text" name="day" id="day" size="4px"  maxlength="2" value="<%=birth[2]%>"> 일
			</div>
			</div>
			
			
			<div id="email_area">
				<p>이메일</p>
				<input type="text" name="email1" id="email_id"  value="<%=email[0]%>"/>
				@
				<input type="text" name="email2" id="email_address"  value="<%=email[1]%>"/>
			</div>
			<div id="phonenum_area">
				<p>휴대폰번호</p>
				<input type="text" name="phone_number1" id="num1" maxlength="3" value="<%=phone[0] %>"/>
				-<input type="text" name="phone_number2" id="num2" maxlength="4" value="<%=phone[1] %>"/>
				-<input type="text" name="phone_number3" id="num3" maxlength="4" value="<%=phone[2] %>"/>
			</div>
			<div id="button_area">
				<input type="submit" value="수정하기" id="update_button"/>
				<a href="UserInfoDel.user?id=<%=user.getId()%>" id="drop_button"><p>탈퇴</p></a>
				<script>
					document.getElementById("update_button").onclick = function(){
						var password_1 = document.getElementById("password_1").value;
						var password_2 = document.getElementById("password_2").value;
						
						if(!password_1){
							alert("비밀번호를 입력하세요.");
							return false;
						}
						
						if(password_1 == password_2){
							alert("수정이 완료되었습니다.");
						} else {
							alert("비밀번호가 틀립니다.");
							return false;
						}
					}
					document.getElementById("drop_button").onclick = function(){
						var password_1 = document.getElementById("password_1").value;
						var password = document.getElementById("password_2").value;
						if(password!=password_1) {
							alert("비밀번호가 틀립니다.");
							
							return false;
						}
					}
				
				</script>
			</div>
		</form>
	</div>
</body>
</html>