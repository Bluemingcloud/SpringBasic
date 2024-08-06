<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	*{padding: 0; margin: 0; box-sizing: border-box;}
	
	section{
		margin: 200px auto;
		width: 800px;
		padding: 50px;
		border: 1px solid #777;
	}
	
	section > h2 {
		padding: 10px;
		padding-left: 0;
		font-size: 24px;
	}
	
	section > table {
		border-collapse: collapse;
        border-spacing: 0;
		width: 100%;
		height: auto;
		overflow: hidden;
		text-align: center;
		margin: 20px 0 50px 0;
	}
	
	section > table > thead {
		font-size: 18px;
		font-weight: 600;
		line-height: 28px;
	}
	
	section > table > thead > tr > td,
	section > table > tbody > tr > td{
		margin-bottom: 10px;
		height: 50px;
		border: 1px solid #777;
	}
	
	a {
		apperance: none;
		text-decoration:none;
		color: black;
		display: inline-block;
		width: 100px;
		height: 30px;
		border: 1px solid #777;
		border-radius: 3px;
		text-align: center;
		line-height: 30px;
		cursor: pointer;
	}
	a:hover {
		color: white;
		background-color: #d3d3d3;
	}
	
	td > button {
		border: none;
		background-color: white;
		width: 100%;
		height: 100%;
		cursor: pointer;
		font-weight: bolder;
	}
	td > button:hover {
		background-color: #d3d3d3;
		color: white;
	}

</style>
</head>
<body>
	<%--다음 화면을 처리하는 메서드를 컨트롤러에 생성하세요 --%>
	<section>
	
		<h2>게시글 목록</h2>
		
		<table>
			<thead>
				<tr>
					<td>번호</td>
					<td>작성자</td>
					<td>제목</td>
					<td>비고</td>
				</tr>
			</thead>
			
			<tbody class="list">
				<%-- 
				<c:forEach var="dto" items="${list }">
					<tr>
						<td>${dto.num }</td>
						<td>${dto.name }</td>
						<td>${dto.title }</td>
						<td>${dto.content }</td>
						<td><button type="button" onclick="location.href='boardDelete?bno=${dto.num }';">삭제</button></td>
					</tr>		
				</c:forEach> 
				--%>
			</tbody>
	
				<!-- 
				1. boardDelete로 삭제 처리하세요. 
				2. 삭제 후엔 목록화면으로 리다이렉트 하세요.
				-->
		</table>
		
		<%--게시글 작성페이지로 이동시키세요. --%>
		<a href="boardRegister">게시글 작성</a>
	</section>
	
	<script>
		
		document.addEventListener('DOMContentLoaded', function() {
			
			var list = document.querySelector(".list");
			list.addEventListener('click', function() {
				event.preventDefault();
				if(event.target.tagName === 'BUTTON') {
					location.href='boardDelete?bno=' + event.target.dataset.bno;
				} else if(event.target.tagName === 'A') {
					location.href='boardContent?bno=' + event.target.dataset.bno;
				} else {
					return;
				}
				
			});
			
			fetch('boardListAjax')
			.then(response => response.json())
			.then(data => {
				var listHTML = '';
				data.forEach(item => {
					listHTML += '<tr>';
					listHTML += '<td>' + item.num + '</td>';
					listHTML += '<td>' + item.name + '</td>';
					listHTML += '<td><a href="#" data-bno="' + item.num + '">' + item.title + '</a></td>';
					listHTML += '<td><button type="button" data-bno="' + item.num + '">삭제</button></td>'
					listHTML += '</tr>';
				});
				list.innerHTML = listHTML;
			});
		});
	
	</script>
	
</body>
</html>




