<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cinema Review | 로그인</title>
<link href="resources/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">
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

<%
	String msg=request.getParameter("msg");
	if(msg!=null && msg.equals("welcome")){
%>
	<script>
		history.replaceState({}, null, location.pathname);
		alert("회원 가입을 축하합니다.");
	</script>
<% 
	}
 %>	
	
</body>
</html>