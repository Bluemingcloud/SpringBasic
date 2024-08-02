<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>req_ex02</h3>
	
	<form action="param" method="post">
		아이디:<input type="text" name="id"><br>
		비밀번호:<input type="password" name="pw"><br>
		<input type="checkbox" name="inter" value="a">Java
		<input type="checkbox" name="inter" value="b">JSP
		<input type="checkbox" name="inter" value="c">Spring
		
		<input type="submit" value="확인">
	</form>

</body>
</html>