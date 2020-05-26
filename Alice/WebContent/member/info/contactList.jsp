<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Alice/css/member/infoEdit.css">
<link rel="stylesheet" href="/Alice/css/user.css">
<link rel="stylesheet" href="/Alice/css/w3.css">
<script type="text/javascript" src="/Alice/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Alice/js/member/info.js"></script>
<script src="https://kit.fontawesome.com/865b1e5df5.js" crossorigin="anonymous"></script>

<style>
	
</style>
<script type="text/javascript">

</script>
</head>
<body>
	<form method="POST" id="pwEditFrm">
		<input name="pw" id="pw">
	</form>
	
	<header>
		<jsp:include page="../../frame/header.jsp"/>
	</header>
	<nav>
		<jsp:include page="../../frame/sideBar.jsp"/>
	</nav>
	<div class="w3-main" style="margin-left:250px; ">
		<div class="w3-hide-large" style="margin-top:83px;"></div>
		<!-- 마이페이지 프로필 영역 -->
		<div class="w3-col s3 w3-padding w3-border-right" style="height:100% ">
			<div class="">
				<div class="w3-row w3-padding ">
					<!-- 회원 프로필 사진 -->
					<img class="w3-round-xlarge"src="/Alice/img/noimage.jpg" alt="회원 아아디" width="140" height="auto">
				</div>
				<div class="w3-row w3-center">
					<h6><!-- 회원이름 --><small>님</small><br><small><!-- 회원아이디 --></small></h6>			
				</div>			
			</div>				
		</div>
		<!-- 마이페이지 버튼 영역 -->
		<div class="w3-col s9 " >
			<div class=" w3-bar w3-border-bottom w3-black" id="movebtn"> 
				<a class="w3-bar-item w3-padding " id="infoEdit" ><small>회원 정보 수정</small></a>
				<a class="w3-bar-item w3-padding" id="pwEdit" ><small>비밀번호 재설정</small></a>
				<a class="w3-bar-item w3-padding" id="contactList" ><small>컨택 리스트</small></a>
			</div>
			<!-- 마이페이지 컨탠츠 영역 -->
			
			<!-- 버튼 영역 -->
			
		</div>
	</div>
</body>
</html>