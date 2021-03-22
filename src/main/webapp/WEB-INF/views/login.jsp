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

	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input id="id" type="text"></td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td><input id="pw" type="password"></td>
		</tr>
		<tr>
			<td><button id="join" type="button">회원가입</button></td>
			<td><button type="button" onclick="fn_loginAction()">로그인</button></td>
		</tr>
	</table>
</body>

<script type="text/javascript">
	
	$('#join').on("click", function() {
		location.href = 'join';
	});
	
	function fn_loginAction() {
		console.log(test1()); // js 파일 테스트 확인
		var param = {
				"id" : $('#id').val(),
				"pw" : $('#pw').val()
		}
		
		$.post("loginAccess", param, function(res) {
			console.log(res.result);
			fn_loginCallAction(res);
		});
	}
	
	function fn_loginCallAction(res) {
		switch (res.result) {
		case "error":
			alert("회원정보가 없습니다. 회원가입을 하고 로그인 하시기 바랍니다.");
			break;
		case "pwError":
			alert("아이디 또는 비밀번호가 다릅니다. 확인하시고 재로그인 하시기 바랍니다.");
			break;
		case "ok":
			location.href = "main";
			break;
		}
	}
	
	
	

</script>
</html>