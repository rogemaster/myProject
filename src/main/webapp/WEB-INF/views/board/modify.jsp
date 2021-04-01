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
			<td><input type="text" id="title" style="width: 700px">${boardContents.title }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea id="contents" style="width: 700px; height: 700px">${boardContents.contents }</textarea></td>
		</tr>
		<tr>
			<td><button type="button" id="cancel" >취소</button></td>
			<td><button type="button" onclick="board_save()">등록</button></td>
		</tr>
	</table>

</body>
</html>