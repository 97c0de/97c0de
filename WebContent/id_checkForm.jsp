<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "javax.servlet.http.*" %>
<%@ page import = "java.sql.*" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>중복확인창</title>
</head>
<% 
	boolean id_check = false;

	if(session.getAttribute("id_check") != null){
		id_check = (boolean)session.getAttribute("id_check");
	}

	String id = "";
	
	if(id != null){
		id = (String)session.getAttribute("id");
	}
%>
<body>
	<script>
	/*부모창에 있는 id값을 자식창의 id값으로 전송*/
	function setChildText(){
		var tf = opener.document.getElementById("pId").value;
		
		if(tf != null){
			document.getElementById("cId").value = tf;
		} else {
			document.getElementById("cId").value = "";
		}
	}
	
	/*윈도우 창이 켜질때 setChildText 함수 실행, 중복체크를 실행하지 않았으면, 부모창에서 값을 받아옴*/
	if(!(<%=id_check%>)){
		window.onload = setChildText;
	} 
	
	function setParentText(){
		opener.document.getElementById("pId").value = document.getElementById("cId2").value;
		opener.document.getElementById("id_check").value = "id_Checked";
	}
	
	function checkValue(){
		var id = document.getElementById("cId").value;
		
		if(id == null || id == "") {
		 	 alert("아이디를 입력하세요.");
		 	 return false;
		}
		
		for(var i=0; i<id.length; i++){
			var check = id.charAt(i);
			
			if( !((check >= "a") && (check <= "z")) && !((check >= "0") && (check <= "9")) && !((check >= "A") && (check <= "Z")) ){
				alert("아이디에는 한글이나, 특수문자는 사용할 수 없습니다");
				return false;
			}
		}
	}
	</script>
<form action="join_idCheck.user" method="post" name="id_checkForm" onsubmit="return checkValue();">
	<table align="center">
		<tr>
			<td>ID : <br><br></td>
			<td>
				<% if(id_check){ %>
				<input type="text" name="id2" id="cId2" value="<%= id %>" readonly/>
				<% } else { %>
				<input type="text" name="id" id="cId" value="<%= id %>"/>
				<% } %>
				&nbsp;&nbsp;
				<input type="submit" value="중복확인"/>
				<br><br>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="left">
				<% if(id != null){ %>
					<% if(id_check) { %>	
					사용할 수 있는 아이디입니다.
					<%} else {%>
					사용할 수 없는 아이디입니다.
					<% } %>	
				<% } else { %>
					중복확인을 눌러주세요.
				<% } %>
				<br><br><br><br><br><br>
			</td>
		</tr>

		<tr>
			<td colspan="2" align="center">	
				<% if(id_check){ %>
					<input type="button" value="사용하기" onclick="setParentText();window.close();"/>
				<% } %>
				&nbsp;&nbsp;
				<input type="button" value="창 닫기" onclick="window.close()"/>
			</td>
		</tr>
	</table>
</form>
<%
	session.invalidate();
%>
</body>
</html>