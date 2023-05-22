<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.review.cinema.vo.UserVo" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cinema Review |</title>
<link href="resources/css/idpw_searchForm.css" rel="stylesheet" type="text/css" />

<script src="resources/js/jquery-3.2.1.min.js"></script>
<script>
	$(document).ready(function(){
		$("button#id_search").on("click",function(){
			$("button#id_search").removeClass("off");
			$("button#pw_search").removeClass("on");
			$("button#id_search").addClass("on");
			$("button#pw_search").addClass("off");
		});
		$("button#pw_search").on("click",function(){
			$("button#id_search").removeClass("on");
			$("button#pw_search").removeClass("off");	
			$("button#id_search").addClass("off");
			$("button#pw_search").addClass("on");
		});
	});
</script>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
	String form = (String)request.getAttribute("form");
	UserVo user = (UserVo)request.getAttribute("user");
%>
	<table>
		<tr>
			<td>
				<button type="button" name="id_search" class="on" id="id_search">아이디 찾기</button>
				<button type="button" name="pw_search" class="off" id="pw_search">비밀번호 찾기</button>
				<script>
					document.getElementById("id_search").onclick = function() {
						document.getElementById("pw_table").style.display = "none";
						document.getElementById("id_table").style.display = "";
						document.getElementById("result").style.display = "none";
						
						$("#pw-btn").hide();
						$("#id-btn").show();
						
					}
					document.getElementById("pw_search").onclick = function(){
						document.getElementById("id_table").style.display = "none";
						document.getElementById("pw_table").style.display = "";
						document.getElementById("result").style.display = "none";
						
						
						$("#id-btn").hide();
						$("#pw-btn").show();
						
					}
				</script>
			</td>
		</tr>
	</table>
	<form action="idpwSearchForm.user?form=idform" method="post" name="id_form" id="id_form" onsubmit="return check_idform();">
		<table id="id_table">
			<tr>
				<td>이름 </td>
				<td>
					<input type="text" name="name" maxlength="10"/>
				</td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td>
					<input type="text" name="year" maxlength="4"/>년
					<input type="text" name="month" maxlength="2"/>월
					<input type="text" name="day" maxlength="2"/>일
				</td>
			</tr>
			<tr>
				<td>이메일 주소</td>
				<td>
				<input type="text" name="email_id" maxlength="15"/>@	
				<input type="text" name="email_address" maxlength="35"/>
				</td>
			</tr>
		</table>
	</form>
	
	<form action="idpwSearchForm.user?form=pwform" method="post" name="pw_form" id="pw_form" onsubmit="return check_pwform();">
		<table style="display:none;" id="pw_table">
			<tr>
				<td width="100px">아이디</td>
				<td>
					<input type="text" name="id" maxlength="15"/>
				</td>
			</tr>
			<tr>
				<td width="100px">이메일 주소</td>
				<td>
				<input type="text" name="email_id" maxlength="15"/>@
				<input type="text" name="email_address" maxlength="35"/>
				</td>
			</tr>
		</table>
	</form>
	<div id="result">
	<% if(user != null){ %>
			<% if(user.getId() != null) {%>
				아이디 : <%= user.getId() %>
			<% } else if (form.equals("idform")) {%>
				일치하는 아이디가 없습니다.
			<% } %>
			<% if(user.getPassword() != null) { %>
				비밀번호 : <%= user.getPassword() %>
			<% } else if (form.equals("pwform")) {%>
				일치하는 비밀번호가 없습니다.
			<% } %>
	<% } %>
	</div>
	<div id="search_button">
			<input type="button" value="아이디 찾기"  id="id-btn"  onclick="check_idform()"/>
			
			<input type="button" value="비밀번호 찾기" id="pw-btn"   onclick="check_pwform()" style="display: none;"/>
	</div>
	<div id="close_button">
		<input type="button" value="취소" onclick="window.close()"/>
	</div>
<script>
	function check_idform(){
		var form = document.id_form;
		
		if(!form.name.value){
			alert("이름을 입력하세요.");
			return false;
		}
        if(!(isNaN(form.name.value))){
            alert("이름은 문자만 입력가능합니다.");
            return false;
        }
        if(!form.year.value){
            alert("년도를 입력하세요.");
            return false;
        }
        
        if(isNaN(form.year.value)){
            alert("년도는 숫자만 입력가능합니다.");
            return false;
        }

        if(!form.month.value){
            alert("월을 입력하세요.");
            return false;
        }
        
        if(form.month.value > 12 || form.month.value <= 0){
            alert("월을 다시 입력해주세요.");
            return false;
        }
        
        if(isNaN(form.month.value)){
            alert("월은 숫자만 입력가능합니다.");
            return false;
        }
        
        if(!form.day.value){
            alert("날짜를 입력하세요.");
            return false;
        }
        
        if(isNaN(form.day.value)){
            alert("날짜는 숫자만 입력가능합니다.");
            return false;
        }
        
        switch(form.month.value){
			case "1": case "01": case "03": case "05": case "07": case "08": case "3": case "5": case "7": case "8": case "10": case "12":
		        if((form.day.value > "31") || (form.day.value < "1")){
		        	alert("날짜를 다시 입력해주세요.");
		        	return false;
					break;
		        }
				break;
			case "4": case "6": case "9": case "11": case "04": case "06": case "09":
		        if((form.day.value > "30") || (form.day.value < "1")){
		        	alert("날짜를 다시 입력해주세요.");
		        	return false;
					break;
		        }
				break;
			case "2": case "02":
		        if((form.day.value > "29") || (form.day.value < "1")){
		        	alert("날짜를 다시 입력해주세요.");
		        	return false;
					break;
		        }
				break;
   		 }
        
        if(!form.email_id.value){
            alert("메일 아이디를 입력하세요.");
            return false;
        }
        
        if(!form.email_address.value){
            alert("메일 주소를 입력하세요.");
            return false;
        }
        
        alert("이메일 발송 처리 되었습니다.");
	}
	
	function check_pwform(){
		
		var form = document.pw_form;
		
		if(!form.id.value){
			alert("아이디를 입력해주세요.");
			return false;
		}
		
        if(!form.email_id.value){
            alert("메일 아이디를 입력하세요.");
            return false;
        }
        
        if(!form.email_address.value){
            alert("메일 주소를 입력하세요.");
            return false;
        }
        
        alert("이메일 발송 처리 되었습니다.");
	}
</script>
</body>
</html>