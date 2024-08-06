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
		
	<ul class="scoreList">

	<%-- 
	<c:forEach var="vo" items="${list }" varStatus="a"> <!-- varStatus : 각 배열의 값에 대한 정보(index, count 등) -->
		<li>번호:${a.index }</li>
		<li>이름:${vo.name }</li>
		<li>국어:${vo.kor }</li>
		<li>수학:${vo.math }</li>
		<li>영어:${vo.eng }</li>
		<li><button type="button" data-sno="${a.index }">삭제</button></li>
	</c:forEach> 
	--%>
	</ul> 
	
	<!-- <div id="list"></div> -->
	
	<a href="scoreRegist">점수등록</a>
	
	<script>
		
		document.addEventListener('DOMContentLoaded', function() { 
			
			var scoreList = document.querySelector('.scoreList');
			scoreList.addEventListener('click', function(e) {
				e.preventDefault();
				if(e.target.tagName != 'BUTTON') return;
				var index = e.target.dataset.sno;
				location.href = 'deleteScore?sno=' + index;
			});
			
			fetch("getScoreList")
				.then(response => response.json())
				.then(data => {
					var html = "";
					data.forEach(function(item, index) { // forEach 메서드의 매개변수를 두개 지정하여 index 값 사용 가능
						html += "<li>번호:" + (index + 1) + "</li>";
						html += "<li>이름:" + item.name + "</li>";
						html += "<li>국어:" + item.kor + "</li>";
						html += "<li>수학:" + item.math + "</li>";
						html += "<li>영어:" + item.eng + "</li>";
						html += '<li><button type="button" data-sno="' + item.sno + '">삭제</button></li>';
					});
					scoreList.innerHTML = html;
				});
		});
	
	
	</script>
</body>
</html>