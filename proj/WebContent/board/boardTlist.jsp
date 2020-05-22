<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="/proj/css/board.css">
<script type="text/javascript" src="/proj/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#write').click(function(){
		$(location).attr('href','/proj/board/boardTwrite.do');
	});
	$('#home').click(function(){
		$(location).attr('href', '/proj/main.do');
	});	
	$('.list').click(function(){
		$(location).attr('href', '/proj/board/boardTDetail.do');
	});

});
</script>
<style>
</style>
</head>
<body class="w3-content mxw">
	<form method="post" id="frm">
		<input type="hidden">
	</form>
	<div class="w3-container w3-text-grey w3-margin-top">
		<div class="w3-col w3-border-bottom w3-center">
			<h2>Free board</h2>
		</div>
		<div class="w3-row">
				<div class="w3-button w3-left w3-hover-blue" id="home">
					<small>홈으로</small>
				</div>
			<%-- <c:if test="${not empty SID}"> --%>
				<div class="w3-button w3-right w3-hover-green" id="write">
					<small>작성하기</small>
				</div>
			<%-- </c:if> --%>
		</div>
	</div>
	<div class="w3-row w3-margin-top w3-grayscale">
		<div class="w3-col">
			<div class="w3-container">
				<div class="w3-col m1 w3-padding w3-center w3-border-bottom w3-border-right">게시글 번호</div>
				<div class="w3-col m6 w3-padding w3-center w3-border-bottom w3-border-right">게시글 제목</div>
				<div class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">작성자</div>
				<div class="w3-col m1 w3-padding w3-center w3-border-bottom w3-border-right">조회수</div>
				<div class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">등록일자</div>
			</div>
		</div>
		<div class="w3-col">
			<div class="w3-container">
				<!-- 데이터 받아서 리스트에 뿌려주기 -->
				<%-- <c:forEach var="data" items="${LIST}"> --%>
					<div class="w3-col m1 w3-padding w3-center w3-border-bottom w3-border-right list">
					<%-- ${st.count} --%>1</div>
					<div class="w3-col m6 w3-padding w3-center w3-border-bottom w3-border-right list">
					<%-- ${data.title} --%>찌찌갓</div>
					<div class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right list">
					<%-- ${data.name} --%>김경훈</div>
					<div class="w3-col m1 w3-padding w3-center w3-border-bottom w3-border-right list" id="click">
					<%-- ${data.vno} --%>1</div>
					<div class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right list">
					<%-- ${data.hiredate} --%>20200521</div>
				<%-- </c:forEach> --%>
			</div>
		</div>
		<div class="w3-center">
			<div class="w3-bar w3-border w3-round w3-margin-top">
			<!-- 페이지 유틸 처리페이지 -->
				<c:if test="${PAGE.start}">
					<span class="w3-bar-item w3-button w3-light-gray">PRE</span>
				</c:if>
					<span class="w3-bar-item w3-button">1</span>
					<span class="w3-bar-item w3-button">2</span>
					<span class="w3-bar-item w3-button">3</span>
				<c:if test="${PAGE.end}">
					<span class="w3-bar-item w3-button w3-light-gray">NEXT</span>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>