<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.w3-sidebar a {
	font-family: "Roboto", sans-serif
}

body, h1, h2, h3, h4, h5, h6, .w3-wide {
	font-family: "Montserrat", sans-serif;
}
</style>
<
<body class="w3-content" style="max-width: 774px">
	<div class="w3-container w3-text-grey w3-margin-top">
		<div class="w3-col w3-border-bottom w3-center">
			<h2>Free board</h2>
		</div>
		<div class="w3-row">
			<div class="w3-button w3-right w3-hover-green">
				<small>작성하기</small>
			</div>
		</div>
	</div>
	<!-- Product grid -->
	<div class="w3-row w3-margin-top w3-grayscale">
		<div class="w3-col">
			<div class="w3-container">
				<div class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">게시글 번호</div>
				<div class="w3-col m6 w3-padding w3-center w3-border-bottom w3-border-right">게시글 제목</div>
				<div class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">조회수</div>
				<div class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">등록일자</div>
			</div>
		</div>
		<div class="w3-col">
			<div class="w3-container">
				<div class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">1 ${DATA.bno}</div>
				<div class="w3-col m6 w3-padding w3-center w3-border-bottom w3-border-right">저의 운동일지 입니다.${DATA.title}</div>
				<div class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">1 ${DATA.vno}</div>
				<div class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">2020.05.18 ${DATA.hiredate}</div>
			</div>
		</div>
		<div class="w3-center">
			<div class="w3-bar w3-border w3-round w3-margin-top">
				<span class="w3-bar-item w3-button w3-light-gray">PRE</span>
				<span class="w3-bar-item w3-button">1</span>
				<span class="w3-bar-item w3-button">2</span>
				<span class="w3-bar-item w3-button">3</span>
				<span class="w3-bar-item w3-button w3-light-gray">NEXT</span>
			</div>
		</div>
	</div>
</body>
</html>