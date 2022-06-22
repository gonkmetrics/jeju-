<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>쓴날짜</th>
				<th>예약일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="reservation" items="${reservList }">
				<tr>
					<td>${reservation.rId }</td>
					<td>${reservation.name }</td>					
					<td>${reservation.regDate }</td>
					<td>${reservation.reservation }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>