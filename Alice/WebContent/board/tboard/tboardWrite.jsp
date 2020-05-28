<!-- 해당 jsp는 게시글 작성에 쓰이는 뷰입니다.
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
<title>Trainer Write</title>
<link rel="stylesheet" href="/Alice/css/w3.css">
<link rel="stylesheet" href="/Alice/css/board/board.css">
<script type="text/javascript" src="/Alice/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Alice/js/board/boardWrite.js"></script>
<style>
</style>
<script type="text/javascript">
</script>
</head>
<body>
	<header>
		<jsp:include page="../../frame/header.jsp" />
	</header>
	<nav>
		<jsp:include page="../../frame/sideBar.jsp" />
	</nav>
	<div class="w3-main mg250">
		<div class="w3-container w3-text-grey w3-margin-top">
				<div class="w3-col w3-border-bottom w3-center">
					<h2>Board Write</h2>
				</div>
			<div class="w3-row">
				<div class="w3-col m2 w3-button w3-left w3-hover-green" id="ltbtn">
					<small>목차보기</small>
				</div>
				<div class="w3-col m2 w3-button w3-left w3-hover-green" id="hbtn">
					<small>홈으로</small>
				</div>
				<c:if test="${empty DATA}">
					<div class="w3-col m2 w3-button w3-right w3-hover-green" id="bwbtn">
						<small>Submit</small>
					</div>
				</c:if>
				<c:if test="${not empty DATA}">
					<div class="w3-col m2 w3-button w3-right w3-hover-green" id="bebtn">
						<small>Edit</small>
					</div>
				</c:if>
<!-- 				<div class="w3-col m2 w3-button w3-right w3-hover-green">
					<small>Calendar Add</small>
				</div> -->
			</div>
		</div>
		<c:if test="${not empty DATA}">
		<form class="w3-row w3-margin-top w3-grayscale"
			encType="multipart/form-data" id="frme" name="frme" method="post">
			<input type="hidden" id="bno" name="bno" value="${BNO}">
				<div class="w3-col">
					<div class="w3-container">
						<div class="w3-col m2 w3-padding w3-center w3-border-bottom">게시글
							제목</div>
						<input class="w3-col m6 w3-center w3-border-bottom"
							style="padding: 7px 16px 7px 16px;" id="title" name="title" value="${DATA.title}">
						<div class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">작성자</div>
						<div class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">${SID}</div>
					</div>
				</div>
				<div class="w3-col">
					<div class="w3-container w3-border-bottom"
						style="padding-right: 0px;">
						<div class="w3-col m2 w3-padding w3-center">게시글 내용</div>
						<div class="w3-rest">
							<div class="w3-col mfile">
								<input class="w3-col w3-border-right file" type="file" name="file1">
							</div>
							<div class="w3-col">
								<textarea class="w3-col pdt" cols="50" rows="15" id="tcont" name="tcont" placeholder="내용을 입력하세요.">${DATA.bcontent}</textarea>
							</div>
						</div>
					</div>
				</div>
		</form>
		</c:if>
		<c:if test="${empty DATA}">
		<form class="w3-row w3-margin-top w3-grayscale"
			encType="multipart/form-data" id="frmw" name="frmw" method="post">
			<input type="hidden" id="bno" name="bno" value="${param.bno}">
				<div class="w3-col">
					<div class="w3-container">
						<div class="w3-col m2 w3-padding w3-center w3-border-bottom">게시글
							제목</div>
						<input class="w3-col m6 w3-center w3-border-bottom"
							style="padding: 7px 16px 7px 16px;" id="title" name="title">
						<div class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">작성자</div>
						<div class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">${SID}</div>
					</div>
				</div>
				<div class="w3-col">
					<div class="w3-container w3-border-bottom"
						style="padding-right: 0px;">
						<div class="w3-col m2 w3-padding w3-center">게시글 내용</div>
						<div class="w3-rest">
							<div class="w3-col mfile">
								<input class="w3-col w3-border-right file" type="file" name="file1">
							</div>
							<div class="w3-col">
								<textarea class="w3-col pdt" cols="50" rows="15" id="tcont" name="tcont" placeholder="내용을 입력하세요."></textarea>
							</div>
						</div>
					</div>
				</div>
		</form>
		</c:if>
	</div>
</body>
</html>