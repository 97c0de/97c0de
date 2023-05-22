<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>회원가입</title>
<link href="resources/css/join_provision.css" rel="stylesheet" type="text/css" />
</head>

<body bgcolor="#F2F4F7">
	<script>
		
	</script>

	<!--wrap시작-->
	<div id="wrap">
		<!--헤더시작-->
		<div id="header">
			<p align="center">
				<a href="main.jsp"> <img src="image\logo2.png" border="0">
				</a>
			</p>
		</div>

		<!--헤더끝-->
		<!---콘텐츠시작-->
		<div id="section">
			<form action="jsp\result.jsp">
				<table id="tablekan" border="0" width="550px">
					<tr>
						<td>
							<p id="iyong">
								<strong>이용약관 동의</strong><span style="color: red">(필수)</span> <input type="checkbox" id="yakgwan" name="yak1">
							</p>
							<p>
								<textarea style="resize: none;" readonly cols="70" rows="5" name="ta" id="ta">
</textarea>
							</p>
							<p id="iyong">
								<strong>개인 정보 수집 동의</strong><span style="color: red">(필수)</span> <input type="checkbox" id="yakgwan" name="yak2">
							</p>
							<p>
								<textarea style="resize: none;" readonly cols="70" rows="5" name="ta" id="ta">
</textarea>
							</p>
							<p id="iyong">
								<strong>메일 및 이벤트 정보 수신 동의</strong><span style="color: green">(선택)</span> <input type="checkbox" id="yakgwan" name="yak3">
							</p>
						</td>
					</tr>
				</table>
				<p>
					<button type="button" onclick="location.href='join.jsp'" id="agreebutton">
						<table id="gaipbutton" border="0" width="200px" height="65px">
							<tr>
								<th><span style="color: white">동의하기</span></th>
							</tr>
						</table>
					</button>
				</p>
			</form>

		</div>
		<!--콘텐츠끝-->
		<!--풋터시작-->
		<div id="footer">
			<table class="yakk" border="0">
				<tr>
					<td align="center" width="150"><a href="www.yakgwan.com"><strong>이용약관</strong></a></td>
					<td align="center" width="150"><a href="www.yakgwan.com"><strong>개인정보이용방침</strong></a></td>
					<td align="center" width="150"><a href="help.jsp"><strong>고객센터</strong></a></td>
				</tr>
			</table>
		</div>
		<!--풋터끝-->
	</div>
	<!--wrap끝-->
</body>
</html>
