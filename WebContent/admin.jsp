<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.review.cinema.vo.UserVo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@page import="java.util.ArrayList"%>
<%
List<UserVo> users = (List<UserVo>) request.getAttribute("users");
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="include/head.jsp"%>
<title>회원관리</title>
<link href="resources/css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>


	<%@ include file="include/head_menu.jsp"%>


	<div class="container">
		<div id="login_div">

				<h2>회원목록 관리</h2>

			<table border="1">
				<%
				if (users != null)
				%>
				<tr>
					<td>ID</td>
					<td>생년월일</td>
					<td>핸드폰</td>

					<td>회원탈퇴</td>
				</tr>
				<%
				for (int i = 0; i < users.size(); i++) {
									UserVo getUser = users.get(i);
				%>
				<tr>
					<td><%=getUser.getId()%></td>
					<td><%=getUser.getBirth()%></td>
					<td><%=getUser.getPhone_number()%></td>

					<td><a href="userDelete.user?id=<%=getUser.getId()%>" id="drop_button_<%=i%>">탈퇴</a> 
					<script>
						document.getElementById("drop_button_<%=i%>
						").onclick = function() {
							var con = confirm("탈퇴시키시겠습니까?");
							if (!con) {
								return false;
							}
						}
					</script>
					</td>
				</tr>

				<%
				}
				%>


			</table>
		</div>
		
	</div>




	<%@ include file="include/footer.jsp"%>


</body>
</html>