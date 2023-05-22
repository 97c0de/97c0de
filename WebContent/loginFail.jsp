<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cinema Review |</title>
<link href="resources/css/loginFail.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">
		<div class="login_again">
			<p>로그인에 실패했습니다.
			<br><span id="blue">아이디와 비밀번호</span>를 <span id="red">확인</span>하고 다시 로그인해주세요.</p>
		</div>
		<div id="login_div">
			<form action="login.user" method="post" name="login">
				<div>
					<h2><a href="main.jsp"><img src="resources/image/cinema-logo.png" width="110px"></a></h2>
				</div>
				<div>
					<input type="text" name="id" id="id" placeholder="아이디"/>
					<input type="password" name="password" id="password" placeholder="비밀번호"/>
				</div>
				<div>
					<button type="button" id="idpwSearch">아이디/비밀번호 찾기</button>
							<script>
								document.getElementById("idpwSearch").onclick = function openChild(){
									var openWin;
									window.name = "parentForm";
									
									var popUrl = "idpw_searchForm.jsp";
									var popOption = "width=550px, height=450px, resizable=no,top=100px, left=100px, directories=no";
									
									openWin = window.open(popUrl, "id/pw 찾기창", popOption);
								}
							</script>
				</div>
				<div>
					<input type="submit" class="a" value="로그인"/>
				</div>
			</form>
		</div>
	</div>
</body>
</html>