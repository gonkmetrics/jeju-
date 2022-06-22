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
				<th>수정날짜</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${producList }">
				<tr>
					<td>${product.pId }</td>
					<td>${product.name }</td>					
					<td>${product.regDate }</td>
					<td>${product.updateDate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>