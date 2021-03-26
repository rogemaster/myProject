<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div style="margin-left: 943px; margin-top: 10px">
		<a href="/my/insert"><button type="button">글쓰기</button></a>
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
				<td style="text-align: center;">${list.title }</td>
				<td style="text-align: center;">${list.writer }</td>
				<td style="text-align: center;"><fmt:formatDate pattern="yyyy.MM.dd" value="${list.reg_date }"/></td>
			</tr>
		</c:forEach>
	</table>
	
</body>

<script type="text/javascript">

</script>
</html>