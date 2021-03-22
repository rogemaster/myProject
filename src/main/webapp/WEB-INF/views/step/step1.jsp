<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>Insert title here</title>
</head>
<%
	

%>
<body>

<button type="button" value="2" onclick="onGugudanClick(event)">2단</button>
<button type="button" value="3" onclick="onGugudanClick(event)">3단</button>
<button type="button" value="4" onclick="onGugudanClick(event)">4단</button>
<button type="button" value="5" onclick="onGugudanClick(event)">5단</button>
<button type="button" value="6" onclick="onGugudanClick(event)">6단</button>
<button type="button" value="7" onclick="onGugudanClick(event)">7단</button>
<button type="button" value="8" onclick="onGugudanClick(event)">8단</button>
<button type="button" value="9" onclick="onGugudanClick(event)">9단</button>

<button class="btn" type="button" value="9">9단</button>

<div>
	<p id="gugudan"></p>
</div>

</body>

<script type="text/javascript">

	/* $(".btn").on("click", function(event) {
		console.log($(this).val());
		console.log(event.target.value);
	}); */

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