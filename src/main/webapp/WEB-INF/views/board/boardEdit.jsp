<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>

	<section>
		<h2>게시글 수정</h2>
		<form action="boardEditForm" method="post">
	
			작성자:<input name="name" value="${boardDTO.name }"><br>
			제목:<input name="title" value="${boardDTO.title }"><br>
			내용:<textarea rows="3" name="content" >${boardDTO.content }</textarea><br>
			<input type="hidden" value="${boardDTO.num }" name="num">
			<input type="submit" value="수정">
			<input type="button" value="목록" onclick="location.href='boardList';">
		</form>
	</section>


</body>
</html>