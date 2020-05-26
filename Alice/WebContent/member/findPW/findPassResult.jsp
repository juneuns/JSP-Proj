<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Alice/css/w3.css">
<link rel="stylesheet" href="/Alice/css/user.css">
<script type="text/javascript" src="/Alice/js/jquery-3.5.0.min.js"></script>
<style>
</style>
<script type="text/javascript">

</script>
</head>
<body>
	<header>
		<jsp:include page="../../frame/header.jsp"/>	
	</header>
	<nav>	
		<jsp:include page="../../frame/sideBar.jsp"/>
	</nav>
	<div class="w3-main" style="margin-left:250px">
		<div class="w3-hide-large" style="margin-top:84px;"></div>
		<div class="w3-container">
			<div class="w3-bar w3-black">
				<a href="" class="w3-bar-item w3-padding w3-btn" id="moveFindId">아이디 찾기</a>
				<a href="" class="w3-bar-item w3-padding w3-btn" id="moveFindPW">비밀번호 찾기</a>
			</div>
		</div>
		<div class="w3-col ">
			<div class="w3-col w3-padding w3-margin-top">
				<div class="w3-col w3-center  w3-border-gray w3-border-bottom">
					<div class="w3-large w3-center">입력하신 이메일로 임시 비밀번호를 보내드렸습니다.</div>
					<br>
					<div class="w3-large w3-center">임시 비밀번호를 이용해 로그인 해주세요</div>
					<br>
					<div class="w3-small w3-center w3-margin-bottom">임시 비밀번호는 보안에 취약하니 비밀번호를 변경해주세요</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>