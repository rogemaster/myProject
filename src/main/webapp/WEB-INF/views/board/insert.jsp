<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<table border="1px" style="margin-left: 20px">
		<tr>
			<td>제목</td>
			<td><input type="text" id="title" style="width: 700px"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea id="contents" style="width: 700px; height: 700px"></textarea></td>
		</tr>
		<tr>
			<td><button type="button" id="cancel" >취소</button></td>
			<td><button type="button" onclick="board_save()">등록</button></td>
		</tr>
	</table>

</body>

<script type="text/javascript">

	$('#cancel').on("click", function() {
		location.href = 'list';
	});
	
	function board_save() {
		var data = {
				"title" : $('#title').val(),
				"contents" : $('#contents').val()
		}

		$.post('save', data, function(res) {
			console.log(res);
			saveCallAction(res);
		});
	}

	function saveCallAction(res) {
		console.log('action::', res);

		switch(res) {
			case 1:
				var ans = confirm('작성글이 저장되었습니다.');
				if(ans === true) {
					location.href = 'list';
				}
			break;
			case 2:
				alert('작성글 등록에 실패 하였습니다.');
			break;
		}
		
	}
	

</script>
</html>