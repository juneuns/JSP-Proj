<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 작성하기</title>
<link rel="stylesheet" href="/clsProj/css/w3.css">
<link rel="stylesheet" href="/clsProj/css/user.css">
<script type="text/javascript" src="/clsProj/js/jquery-3.5.0.min.js"></script>
<style>
.w3-sidebar a {
	font-family: "Roboto", sans-serif
}

body, h1, h2, h3, h4, h5, h6, .w3-wide {
	font-family: "Montserrat", sans-serif;
}s
</style>
<script type="text/javascript">
	$(document).ready(function(){
		
	});
</script>
</head>
<body class="w3-content" style="max-width: 774px">
	<div class="w3-container w3-text-grey w3-margin-top">
<%-- 		<c:if test="${not empty SID }"> --%>
			<div class="w3-col w3-border-bottom w3-center">
				<h2>Board Write</h2>
			</div>
<%-- 		</c:if> --%>
<%-- 		<c:if test="${empty SID }"> --%>
			<div class="w3-col w3-border-bottom w3-center" style="display: none;">
				<h2>Board Edit</h2>
			</div>
<%-- 		</c:if> --%>
		<div class="w3-row">
			<div class="w3-col m2 w3-button w3-left w3-hover-green">
				<small>목차보기</small>
			</div>
			<div class="w3-col m2 w3-button w3-left w3-hover-green">
				<small>홈으로</small>
			</div>
<%-- 			<c:if test="${not empty SID }"> --%>
			<div class="w3-col m2 w3-button w3-right w3-hover-green">
				<small>Submit</small>
			</div>
			<div class="w3-col m2 w3-button w3-right w3-hover-green">
				<small>Calendar Add</small>
			</div>
<%-- 			</c:if> --%>
<%-- 			<c:if test="${empty SID }"> --%>
			<div class="w3-col m2 w3-button w3-right w3-hover-green">
				<small>Edit</small>
			</div>
<%-- 			</c:if> --%>
<%-- 			<c:if test="${empty SID}"> --%>
				<div class="w3-col m2 w3-button w3-right w3-hover-green">
					<small>Delete</small>
				</div>
<%-- 			</c:if> --%>
		</div>
	</div>
	<form class="w3-row w3-margin-top w3-grayscale" encType="multipart/form-data" id="frm">
		<div class="w3-col">
			<div class="w3-container">
				<div class="w3-col m2 w3-padding w3-center w3-border-bottom">게시글 제목</div>
				<input class="w3-col m6 w3-center w3-border-bottom" style="padding: 7px 16px 7px 16px;">
				<div class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">작성자</div>
				<div class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">주재석${param.name}<</div>
			</div>
		</div>
		<div class="w3-col">
			<div class="w3-container w3-border-bottom" style="padding-right: 0px;">
				<div class="w3-col m2 w3-padding w3-center">게시글 내용</div>
				<div class="w3-rest">
					<input class="w3-col w3-border-right" type="file">
					<textarea class="w3-col" cols="50" rows="10" style="padding: 7px 16px 7px 16px;"></textarea>
				</div>
			</div>
		</div>
		<div class="w3-col">
			<div class="w3-container">
				<div class="w3-col m2 w3-padding w3-center"><small>이미지 미리보기</small></div>
				<div class="w3-dropdown-hover">
					<img src="/proj/image/img_avatar1.png" alt="Monterosso" style="width:20%">
    			</div>
    			<div class="w3-dropdown-content" style="width:300px"><br>
	      			<img src="/proj/image/img_avatar1.png" alt="Norway" style="width:100%">
  				</div>
			</div>
		</div>
	</form>
</body>
</html>