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
		
	<%-- <ul>
	<c:forEach var="vo" items="${list }">
		<li>이름:${vo.name }</li>
		<li>국어:${vo.kor }</li>
		<li>수학:${vo.math }</li>
		<li>영어:${vo.eng }</li>
	</c:forEach>
	</ul> --%> 
	
	<div id="list"></div>
	
	<a href="scoreRegist">점수등록</a>
	
	<script>
		
		var list = document.getElementById("list");
		window.onload = function() {
			
			fetch("getScoreList")
				.then(response => response.json())
				.then(data => {
					var html = "";
					data.forEach(item => {
						html += "<p>이름:" + item.name + "</p>";
						html += "<p>국어:" + item.kor + "</p>";
						html += "<p>수학:" + item.math + "</p>";
						html += "<p>영어:" + item.eng + "</p>";
					});
					list.innerHTML = html;
				});
			
		}
	
	
	</script>
</body>
</html>