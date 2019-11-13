<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:import url="../layout/boot.jsp"/>
<link href="../css/reset.css" rel="stylesheet"/>
<link href="../css/layout.css" rel="stylesheet"/>
<body>
<c:import url="../layout/nav.jsp"/>
	<section>
		<h1 class="pad"><a href="./qnaList">QnA</a></h1>
		<br />
		<table class="t1">
			<tr class="head">
				<td class="sub" style="text-align: center;">SUBJECT</td>
				<td class="name" style="text-align: center;">NAME</td>
				<td class="date" style="text-align: center;">DATE</td>
				<td class="hit" style="text-align: center;">HIT</td>
			</tr>
			<tr>
				<td>${qnaVO.title}</td>
				<td>${qnaVO.writer}</td>
				<td>${qnaVO.reg_date}</td>
				<td>${qnaVO.hit}</td>
			</tr>
			<tr>
				<td colspan="4" class="contents">${qnaVO.contents}</td>
			</tr>
			<tr>
				<td colspan="5"><a href="./qnaUpdate?num=${qnaVO.num}"
					style="float: right; margin-right: 20px;">Update</a>
					<a href="./qnaReply?num=${qnaVO.num}"
					style="float: right; margin-right: 20px;">Reply</a> <a href="./qnaDelete?num=${qnaVO.num}"
					id="del" style="float: left; margin-left: 20px;">Delete</a></td>
			</tr>
		</table>
	</section>
</body>
</html>