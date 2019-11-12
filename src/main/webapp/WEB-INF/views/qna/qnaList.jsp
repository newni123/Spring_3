<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
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
		<div>
			<form action="qnaList" method="GET" id="frm">
				<input type="hidden" id="curPage" value="1" name="curPage">
				<select name="kind">
					<option id="kindTitle" value="kindTitle">title</option>
					<option id="kindContents" value="kindContents">contents</option>
					<option id="kindWriter" value="kindWriter">writer</option>
				</select> <input type="text" name="search" value="${pager.search}">
				<button>검색</button>
			</form>
		</div>
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
						<td><a href="./qnaSelect?num=${qnaVO.num}">${qnaVO.title}</a></td>
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
				<li><span id="${pager.startNum - 1}" class="list">이전</span></li>
			</c:if>
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<li><span id="${i}" class="list">${i}</span></li>
			</c:forEach>
			<c:if test="${pager.curBlock < pager.totalBlock}">
				<li><span id="${pager.lastNum + 1}" class="list">다음</span></li>
			</c:if>
		</ul>
		<script type="text/javascript">
			var kind = '${pager.kind}'
			if (kind == '') {
				kind = "kindTitle"
			}
			$("#" + kind).prop("selected", true);
			$(".list").click(function() {
				$("#curPage").val($(this).attr("id"));
				$("#frm").submit();
			});
		</script>
	</div>
</body>
</html>
