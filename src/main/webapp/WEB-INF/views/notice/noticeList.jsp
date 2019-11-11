<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../layout/boot.jsp" />
</head>
<link href="../css/reset.css" rel="stylesheet">
<link href="../css/layout.css" rel="stylesheet">
<c:import url="../layout/nav.jsp" />
<h1 class="pad">
	<a href="">NOTICE</a>
</h1>
<br />
<div class="container">
	 <table class="table table-hover">
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
					<td style="text-align: center;">${noticeVO.num}</td>
					<td style="text-align: center;"><a href="./noticeSelect?num=${noticeVO.num}">${noticeVO.title}</a></td>
					<td style="text-align: center;">${noticeVO.writer}</td>
					<td style="text-align: center;">${noticeVO.reg_date}</td>
					<td style="text-align: center;">${noticeVO.hit}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<ul class="pagination" >
			<c:forEach begin="1" end="${totalPage}" var="i">
				<li><a href="./noticeList?curPage=${i}">${i}</a></li>
			</c:forEach>
		</ul>
	</div>
	<!-- session member, memberDTO -->
	<a href="./noticeWrite">Write</a>
</div>

</body>
</html>