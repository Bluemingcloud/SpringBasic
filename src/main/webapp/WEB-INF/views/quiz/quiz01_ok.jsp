<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	.userInfo {
		width: 500px;
		height: 500px;
		border: 1px solid #777;
		margin: 0 auto;
		margin-top: 200px;
		padding: 20px;
	}
	

	
</style>
</head>
<body>

	
	
	<div class="userInfo">
		<h3>${info.name }(${info.id })님 환영합니다.</h3>
		<b>아이디</b>
		<p>${info.id }</p>
		<b>비밀번호</b>
		<p>${info.pw }</p>
		<b>이름</b>
		<p>${info.name }</p>
		<b>이메일</b>
		<p>${info.email }</p>
	</div>

</body>
</html>