<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>

<script type="text/javascript">

function onGugudanClick(event) {
	var dan = {"dan" : event.target.value};
	$('#gugudan').text('');
	
	$.get("gugudancalcul", dan, function(res) {
		
		console.log('ajax res :: ', res);
		gugudanView(res);
	})
}

function gugudanView(res) {
	for(var i = 0; i < res.gugudanList.length; i++) {
		$('#gugudan').append(res.gugudanList[i] + '<br>');
	}
}

</script>
</html>