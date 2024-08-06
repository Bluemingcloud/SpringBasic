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
		<h2>게시글 내용</h2>

		<p>작성자: ${boardDTO.name }</p>
		<p>제목: ${boardDTO.title }</p>
		<p>내용: ${boardDTO.content }</p>
		
		<button type="button" onclick="location.href='boardEdit?bno=${boardDTO.num}';">수정</button>
		<button type="button" onclick="location.href='boardList';">목록</button>
		
	</section>

</body>
</html>