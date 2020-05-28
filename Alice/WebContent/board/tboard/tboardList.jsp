<!-- 해당 jsp는 게시글 목차를 보여주는 뷰 입니다.
@author		주재석
@since		2020.05.27
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trainer board</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/Alice/css/board/board.css">
<script type="text/javascript" src="/Alice/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Alice/js/board/boardList.js"></script>
<style>
</style>
</head>
<body>
	<header>
		<jsp:include page="../../frame/header.jsp" />
	</header>
	<nav>
		<jsp:include page="../../frame/sideBar.jsp" />
	</nav>
	
	<form method="post" id="form" name="form">
		<input type="hidden" id="nowPage" name="nowPage">
		<input type="hidden" id="cPage" name="cPage" value="${PAGE.nowPage}">
		<input type="hidden" id="pre" name="pre" value="${PAGE.startPage - 1}">
		<input type="hidden" id="next" name="next" value="${PAGE.endPage + 1}">
		<input type="hidden" id="bno" name="bno">
	</form>
	<div class="w3-content pd250 mxw980 mg0">
		<div class="w3-container w3-text-grey w3-margin-top">
			<div class="w3-col w3-border-bottom w3-center">
				<h2>Trainer board</h2>
			</div>
			<div class="w3-row">
				<div class="w3-button w3-left w3-hover-blue" id="home">
					<small>홈으로</small>
				</div>
				<c:if test="${not empty SID || TYPE eq 'T'}">
					<div class="w3-button w3-right w3-hover-green" id="write">
						<small>작성하기</small>
					</div>
				</c:if>
			</div>
		</div>
		<div class="w3-row w3-margin-top w3-grayscale">
			<div class="w3-col">
				<div class="w3-container">
					<div
						class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">Num</div>
					<div
						class="w3-col m4 w3-padding w3-center w3-border-bottom w3-border-right">Title</div>
					<div
						class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">Writer</div>
					<div
						class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">Onclick</div>
					<div
						class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">Hiredate</div>
				</div>
			</div>
			<div class="w3-col">
				<div class="w3-container">
					<c:forEach var="data" items="${LIST}" varStatus="st">
					<div class="content" id="${data.bno}">
						<div class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">
							${st.count}</div>
						<div
							class="w3-col m4 w3-padding w3-center w3-border-bottom w3-border-right">
							${data.title}</div>
						<div
							class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">
							${data.b_empno}</div>
						<div
							class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">
							${data.click}</div>
						<div
							class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">
							${data.sdate}</div>
					</div>
					</c:forEach>
				</div>
			</div>
			<div class="w3-center">
				<div class="w3-bar w3-border w3-round w3-margin-top">
					<!-- 페이지 유틸 처리페이지 -->
				  <c:if test="${PAGE.startPage lt (PAGE.pageGroup + 1)}">
					  <span class="w3-bar-item w3-light-gray">PRE</span>
				  </c:if>
				  <c:if test="${PAGE.startPage ge (PAGE.pageGroup + 1)}">
					  <span class="w3-bar-item w3-button w3-hover-blue pbtn">PRE</span>
				  </c:if>
				  <c:forEach var="pageNo" begin="${PAGE.startPage}" end="${PAGE.endPage}">
					  <c:if test="${pageNo eq PAGE.nowPage}">
						  <span class="w3-bar-item w3-button pbtn w3-blue">${pageNo}</span>
					  </c:if>
					  <c:if test="${pageNo ne PAGE.nowPage}">
						  <span class="w3-bar-item w3-button pbtn">${pageNo}</span>
					  </c:if>
				  </c:forEach>
				  <c:if test="${PAGE.endPage ne PAGE.totalPage}">
				  	<span class="w3-bar-item w3-button w3-hover-blue">NEXT</span>
				  </c:if>
				  <c:if test="${PAGE.endPage eq PAGE.totalPage}">
				  	<span class="w3-bar-item w3-light-gray">NEXT</span>
				  </c:if>
				</div>
			</div>
		</div>
	</div>
</body>
</html>