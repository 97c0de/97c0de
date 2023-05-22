<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
body {
	    background: #18181b;
	    color: #fff;
}
#pw_area , #pri_area , #phonenum_area{
	background: #fff;
	color: #000;
}

</style>
<title>Cinema Review | 회원가입</title>
<script>
	var openWin;
	function openChild(){
		window.name = "parentForm";
		
		var popUrl = "id_checkForm.jsp";
		var popOption = "width=370px, height=370px, resizable=no,top=100px, left=100px, directories=no";
		
		openWin = window.open(popUrl, "중복확인창", popOption);
	}
	
	function checkValue(){
		var form = document.join;
		
		if(!form.pId.value || form.pId.value == ""){
			alert("아이디를 입력하세요.");
			return false;
		}
		
		if(form.id_check.value != "id_Checked"){
			alert("아이디 중복확인을 해주세요.");
			return false;
		}
		
		if(!form.password_1.value){
            alert("비밀번호를 입력하세요.");
            return false;
        }
		
		if(!form.password_2.value){
            alert("비밀번호 확인란을 입력하세요.");
            return false;
        }
	
        if(form.password_check.value != "pw_Checked"){
            alert("비밀번호를 동일하게 입력하세요.");
            return false;
        }    
		
        if(!form.name.value){
     		alert("이름을 입력하세요.");
          	return false;
        }
        
        if(!isNaN(form.name.value)){
           	alert("이름은 문자만 입력할 수 있습니다.");
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
/*         
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
   		 } */
        
        if(!form.email_id.value){
            alert("메일 아이디를 입력하세요.");
            return false;
        }
        
        if(!form.email_address.value){
            alert("메일 주소를 입력하세요.");
            return false;
        }
        
        if(!form.phone_number.value){
            alert("전화번호를 입력하세요.");
            return false;
        }
        
        if(isNaN(form.phone_number.value)){
            alert("전화번호는 - 제외한 숫자만 입력해주세요.");
            return false;
        }
        
        
	}
	
	function pw_check(){
		var pw = document.getElementById("password_1").value;
		var pw_check = document.getElementById("password_2").value;
		
		if(pw.length < 4 || pw_check.length > 12){
			window.alert("비밀번호는 4글자 이상, 12글자 이하만 이용 가능합니다.");
			document.getElementById("password_1").value = "";
			document.getElementById("password_2").value = "";
		}
		
		if(pw != "" || pw_check != ""){
			if(document.getElementById("password_1").value == document.getElementById("password_2").value){
				document.getElementById("pw_checkText").innerHTML = "비밀번호가 일치합니다.";
				document.getElementById("password_check").value = "pw_Checked";
			} else {
				document.getElementById("pw_checkText").innerHTML = "비밀번호가 일치하지 않습니다.";
				document.getElementById("password_check").value = "pw_UnChecked";
			}
		}
	}
	
	function id_check(){
		document.getElementById("id_check").value = "id_UnCheck";
	}
</script>
<link href="resources/css/join.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">
		<h2><a href="main.jsp"><img src="resources/image/cinema-logo.png" width="120px"></a></h2> 
		<!---콘텐츠시작-->
			<form action="join.user" method="post" name="join" id="join" onsubmit="return checkValue();">
				<h3>회원가입</h3>
				<div id="id_area">
					<input type="text" name="id" id="pId" placeholder="아이디"/>
					<script>
						document.getElementById("pId").onkeyup = id_check;
					</script>
					<!-- 중복확인 클릭 시 아이디 중복확인 창을 띄운다. -->
					<button type="button" id="check_button">중복확인</button>
					<script>
						document.getElementById("check_button").onclick = openChild;
					</script>
					<!-- 아이디 중복체크를 했는지 판단하기 위한 부분, value가 UnCheck이면 아직 중복체크를 하지 않은 것 -->
					<input type="hidden" name="id_check" id="id_check" value="id_UnCheck"/>
				</div>
				<div id="pw_area">
					<input type="password" name="password_1" id="password_1" placeholder="비밀번호"/>
					<input type="password" name="password_2" id="password_2" placeholder="비밀번호 확인"/>
						<script>
							document.getElementById("password_2").onkeyup = pw_check;
						</script>
						<span id="pw_checkText"></span>
					<input type="hidden" name="password_check" id="password_check" value="pw_UnCheck"/>
				</div>
				<div id="pri_area">
					<input type="text" name="name" id="name" placeholder="이름"/>
					<div id="gender_area">
						<p>성별</p> 
						<input type="radio" name="gender" id="gender" value="Man" checked/>남
						<input type="radio" name="gender" id="gender" value="Woman"/>여
					</div>
					
										
					<div id="birth_area">
							<p>생년월일</p> 
							<input type="number" name="year" id="year" size="4px" 
							 placeholder="년도(4자)" maxlength="4"/>년 <span></span>
							<input type="number" name="month" id="month" size="2px" maxlength="2"/>월 <span></span>
							<input type="number" name="day" id="day" size="2px" maxlength="2"/>일
					</div>
				</div>

				
				<div id="email_area">
					<input type="text" name="email_id" id="email_id" placeholder="이메일"/>
						@
					<input type="text" name="email_address" id="email_address" placeholder="ex)test.com" required/>
				</div>
				<div id="phonenum_area">
					<input type="number" name="phone_number1" id="num1" maxlength="3" placeholder="휴대폰번호" required style="width: 140px"/>
					- <input type="number" name="phone_number2" id="num2" maxlength="4" placeholder="" required/>
					- <input type="number" name="phone_number3" id="num3" maxlength="4" placeholder="" required/>
				</div>
				<div id="button_area">
					<p style="background: #fff; color: #eee"><a href="javascript:join.reset()" id="join_button" >다시 작성</a></p>
					<input type="submit" value="가입하기"/>
				</div>
			</form>
		<!--콘텐츠끝-->
	</div>
</body>
</html>
