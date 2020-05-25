<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/Alice/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Alice/js/member/find.js"></script>
<link rel="stylesheet" href="/Alice/css/w3.css">
<link rel="stylesheet" href="/Alice/css/user.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-grey.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-metro.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
</style>
<script src="https://kit.fontawesome.com/865b1e5df5.js" crossorigin="anonymous"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<form action="" method="POST" id="frm">
		<input type="hidden" name="name" id="name"/>
		<input type="hidden" name="id" id="id"/>
		<input type="hidden" name="mail" id="mail"/>
	</form>
	<header>
		<jsp:include page="../../frame/header.jsp"/>
	</header>
	
	<nav>
		<jsp:include page="../../frame/sideBar.jsp"/>
	</nav>
	<div class="w3-main" style="margin-left:250px;">
	<div class="w3-hide-large" style="margin-top:83px;"></div>
		
		<div class="w3-container">
			<div class="w3-bar w3-black">
				<a href="" class="w3-bar-item w3-padding w3-btn" id="moveFindId">아이디 찾기</a>
				<a href="" class="w3-bar-item w3-padding w3-btn" id="moveFindPW">비밀번호 찾기</a>
			</div>
			<h2 class="w3-col s5  w3-left-align w3-theme-l3 w3-card" style="padding-left:20px;"><i class="fas fa-key"></i> 아이디 찾기</h2>
			<div class="w3-col s8  w3-border w3-margin-top">
				<div class="w3-col w3-border-black w3-border-top" style="background-color: #fbfbfb;">
					<div class="w3-col w3-padding ">
						<div class="w3-col w3-center">
							<div class="w3-col w3-border-gray w3-border-bottom"><h4>이메일 본인 인증으로 아이디를 찾았습니다.</h4></div>
						</div>
					</div>
					<div class="w3-col">
						<div class="w3-col">
							<div class="w3-large w3-padding-large">${FINDID}</div>
						</div>
					</div>
				</div>
			</div>
			<div class="w3-col s8 w3-margin-top" >
				<div class="w3-button w3-center w3-theme-l4" id="moveMain">메인페이지로 이동</div>
			</div>
		</div>	
	</div>
</body>
</html>