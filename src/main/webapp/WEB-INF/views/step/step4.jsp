<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<button type="button" onclick="jsonDataSend()">JSON SEND</button>
</body>

<script type="text/javascript">
	function jsonDataSend() {
		var userInfo = [{"mail_id":"stevelee@steveleejava.com","pw":"1q2w3ezZ!!","use_yn":"y","phone_num":"01077778888","type":"admin","addr":"서울시강남구논현동","sn7":"9209301"}
						,{"mail_id":"stevelee@steveleejava.com","pw":"1q2w3ezZ!!","use_yn":"y","phone_num":"01077778888","type":"admin","addr":"서울시강남구논현동","sn7":"9209301"}
						,{"mail_id":"stevelee@steveleejava.com","pw":"1q2w3ezZ!!","use_yn":"y","phone_num":"01077778888","type":"admin","addr":"서울시강남구논현동","sn7":"9209301"}
						,{"mail_id":"stevelee@steveleejava.com","pw":"1q2w3ezZ!!","use_yn":"y","phone_num":"01077778888","type":"admin","addr":"서울시강남구논현동","sn7":"9209301"}
						]
		
		var jsonData = JSON.stringify(userInfo);
		
		$.ajax({
			type: "POST",
			url: "ajaxcall",
			data: jsonData,
			contentType: "application/json",
			success: function() {
				console.log('11111');
			}, error: function(e) {
				console.log(e);
			}
		})
	}
</script>
</html>