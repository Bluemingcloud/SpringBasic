<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	* {
		padding: 0;
		margin: 0;
		box-sizing: border-box;
	}
	
	input {
		border: none;
	}
	
	form {
		width: 800px;
		height: 500px;
		margin: 0 auto;
		margin-top: 200px;
		padding: 50px;
		border: 1px solid #777;
		overflow: hidden;
	}
	
	form > label {
		display: block;
		font-size: 18px;
		font-weight: 600;
		width: 80%;
		margin-left: 10%;
	}
	
	form > input[type=text],
	form > input[type=number] {
		display: block;
		width:80%;
		height: 30px;
		padding: 5px;
		margin: 10px auto;
		border-bottom: 1px solid #e3e3e3;
		transition: 0.3s ease;
		font-size: 16px;
	}
	
	form > input:focus {
		outline:none;
		border-bottom: 1px solid #777;
	}
	
	form > input[type=submit] {
		float: right;
		margin-right: 10%;
		margin-top: 10px;
		padding: 10px;
	}

</style>
</head>
<body>

	<form action="scoreForm" method="post">
		<label for="name">이름:</label>
		<input type="text" name="name" id="name">
		<label for="kor">국어:</label>
		<input type="number" name="kor" id="kor">
		<label for="math">수학:</label>
		<input type="number" name="math" id="math">
		<label for="eng">영어:</label>
		<input type="number" name="eng" id="eng">
		<input type="submit" value="점수등록">
	</form>

</body>
</html>