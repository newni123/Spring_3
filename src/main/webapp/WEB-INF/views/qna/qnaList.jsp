<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>Striped Rows</h2>
		<p>The .table-striped class adds zebra-stripes to a table:</p>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>num</th>
					<th>title</th>
					<th>writer</th>
					<th>date</th>
					<th>hit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="qnaVO">
					<tr>
						<td>${qnaVO.num}</td>
						<td>${qnaVO.title}</td>
						<td>${qnaVO.writer}</td>
						<td>${qnaVO.reg_date}</td>
						<td>${qnaVO.hit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container">
		<ul class="pagination">
			<c:if test="${pager.curBlock > 1 }">
				<li><a href="./qnaList?CurPage=${pager.startNum - 1}">이전</a></li>
			</c:if>
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<li><a href="./qnaList?CurPage=${i}">${i}</a></li>
			</c:forEach>
			<c:if test="${pager.curBlock < pager.totalBlock }">
				<li><a href="./qnaList?CurPage=${pager.lastNum + 1}">다음</a></li>
			</c:if>
		</ul>
	</div>
</body>
</html>
