<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="top-btn">
		<c:if test="${!empty sessionScope.sessionUser }">
			<button id="update" type="button">수정</button>
			<button id="delete" type="button">삭제</button>
		</c:if>
	</div>
	<table border="1px" width="1000px" style="text-align: center;">
		<tr>
			<td>제목</td>
			<td>${boardDetail.title }</td>
		</tr>
		<tr style="height: auto;">
			<td>내용</td>
			<td>${boardDetail.contents }</td>
		</tr>
	</table>
	<a href="/my/list"><button id="boardlist">목록</button></a>

</body>
<script type="text/javascript">

	$('#update').on('click', function() {
		location.href = 'modify';
	});


</script>
</html>