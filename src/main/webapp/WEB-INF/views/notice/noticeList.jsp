<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../layout/boot.jsp"></c:import>
<link href="../css/layout.css" rel="stylesheet">
<link href="../css/reset.css" rel="stylesheet">
</head>
<body style="padding-bottom: 60px;">
<c:import url="../layout/nav.jsp"></c:import>
	<h1 class="pad">
		<a href="">NOTICE</a>
	</h1>
	<br />
	<div class="container">
		<table class="t1">
			<thead>
				<tr class="head">
					<th class=no style="text-align: center;">NO</th>
					<th class=sub style="text-align: center;">SUBJECT</th>
					<th class=name style="text-align: center;">WRITE</th>
					<th class=date style="text-align: center;">DATE</th>
					<th class=hit style="text-align: center;">HIT</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="noticeVO">
					<tr>
						<td>${noticeVO.num}</td>
						<td><a href="./noticeSelect?num=${noticeVO.num}">${noticeVO.title}</a></td>
						<td>${noticeVO.writer}</td>
						<td>${noticeVO.reg_date}</td>
						<td>${noticeVO.hit}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5">
				</tr>
			</tbody>
		</table>
		<div>
			<c:forEach begin="1" end="10" var="i">
				${i}
			</c:forEach>
		</div>
		<!-- session member, memberDTO -->
			<a href="./noticeWrite">Write</a>
	</div>

</body>
</html>