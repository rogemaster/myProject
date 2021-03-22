<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="resources/js/utility.js"></script>
<title>Insert title here</title>
</head>
<body>

	<form id="memberJoin" method="post">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" id="name" name="name" onkeyup="koreanChk()" required></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="text" id="birthday" id="birthday" onkeyup="numberChk()" maxlength="6" required></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" id="email" name="email" required></td>
			</tr>
			<tr>
				<td rowspan="2"><button type="button" onclick="accessNumberCall()">인증번호발송</button></td>
				<td><input type="text" id="access" name="accessNumber" required disabled></td>
			</tr>
			<tr>
				<td><button type="button" id="accessCheck" onclick="accessNumberCheck()" disabled>인증번호 확인</button></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="pw" name="pw" required placeholder="숫자, 특수문자 1개 이상 영문은 2자 이상 최소 8자 이상 입력"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" id="pw_chk" name="pw_chk" required></td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit" onclick="joinSubmit()">회원가입</button></td>
			</tr>
		</table>
	</form>

</body>
<script type="text/javascript">
	
	function koreanChk() {
		var param = $('#name').val();
		var res = langKorChkUtil(param);
		
		if(!res) {
			alert("한글만 입력 가능합니다.");
			$('#name').val('');
		}
	}
	
	function numberChk() {
		var param = $('#birthday').val();
		var res = numberChkUtil(param);
		console.log(numberChkUtil(param));
		
		if(!res) {
			alert('숫자만 입력 가능합니다.');
			$('#birthday').val('');
		}
	}
	
	function emailChk() {
		var param = $('#email').val();
		var res = emailChkUtil(param);
		
		if(!res) {
			alert('이메일 형식이 맞지 않습니다.');
			$('#email').val('');
		}
	}
	
	function passwordChk() {
		var param = $('#pw').val();
		var res = passwordChkUtil(param);
		
		if(!res) {
			alert('비밀번호 형식에 맞지 않습니다.');
			$('pw').val();
		}
	}
	
	function passwordReChk() {
		var rePw = $('#pw_chk').val();
		var pw = $('$pw').val();
		
		if(rePw !== pw) {
			alert('입력하시 비밀번호가 맞지 않습니다. 확인 하고 다시 입력 하시기 바랍니다.');
			$('pw_chk').val('');
		}
	}

	function accessNumberCall() {
		$('#access').attr('disabled', false);
		$('#accessCheck').attr('disabled', false);
	}
	
	function joinSubmit() {
		$('#memberJoin').attr('action', 'memberJoin');
	}

</script>
</html>