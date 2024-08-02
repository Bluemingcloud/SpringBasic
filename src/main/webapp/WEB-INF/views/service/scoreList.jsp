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
	
	<h3>목록 페이지</h3>
	<ul>
	<c:forEach var="vo" items="${list }">
		<li>이름:${vo.name }</li>
		<li>국어:${vo.kor }</li>
		<li>수학:${vo.math }</li>
		<li>영어:${vo.eng }</li>
	</c:forEach>
	</ul>
	
	<a href="scoreRegist">점수등록</a>
</body>
</html>