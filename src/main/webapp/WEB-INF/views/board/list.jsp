<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.top-btn {
	margin-left: 868px;
	margin-top: 10px;
	margin-bottom: 5px;
}
.excel-btn {
	margin-left: 940px;
	margin-top: 5px;
}
</style>
<meta charset="UTF-8">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	
		<div class="top-btn">
			<c:if test="${!empty sessionScope.sessionUser }">
				<a href="/my/insert"><button type="button">글쓰기</button></a>
			</c:if>
			<button id="logout" type="button">로그아웃</button>
		</div>
	
	<table border="1px" width="1000px">
		<tr style="text-align: center;">
			<td>No</td>
			<td>제목</td>
			<td>작성자</td>
			<td>등록시간</td>
		</tr>
		<c:forEach items="${list }" var="list">
			<tr>
				<td style="text-align: center;"><fmt:formatNumber value="${list.no }" /></td>
				<td style="text-align: center;"><a href="/my/detail?no=${list.no }">${list.title }</a></td>
				<td style="text-align: center;">${list.writer }</td>
				<td style="text-align: center;"><fmt:formatDate pattern="yyyy.MM.dd" value="${list.reg_date }"/></td>
			</tr>
		</c:forEach>
	</table>
	
	<c:if test="${!empty sessionScope.sessionUser }">
		<form action="excelDown" method="post" >
			<button class="excel-btn" id="excelDown" type="submit">EXCEL</button>
		</form>
	</c:if>
	<%-- <c:if test="${!empty sessionScope.sessionUser }">
		<form id="excelUpForm" name="excelUpForm" enctype="multipart/form-data" method="post">
			<input type="file" id="excelFile" name="excelFile">
			<button type="button" onclick="onClickExcelUpload()">저장</button>
		</form>
	</c:if> --%>
	
</body>

<script type="text/javascript">

	$('#logout').on('click', function() {
		location.href = 'logout';
	});

	/* function onClickExcelUpload() {
		var form = new FormData(document.getElementById('excelUpForm'));
		console.log('form::', form);
		
		$.ajax({
			url: 'excelUpload',
			dataType: 'json',
			data: form,
			processData: false,
			contentType: false,
			type: 'POST',
			success: function(data) {
				console.log('success::', data);
			},
			error: function(xhr, status, error) {
				console.log('error', error);
			}
		});
	} */

	
</script>
</html>
