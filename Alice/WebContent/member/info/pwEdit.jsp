<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="/Alice/css/member/infoEdit.css"> -->
<link rel="stylesheet" href="/Alice/css/user.css">
<link rel="stylesheet" href="/Alice/css/w3.css">
<script type="text/javascript" src="/Alice/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Alice/js/member/info.js"></script>
<script src="https://kit.fontawesome.com/865b1e5df5.js" crossorigin="anonymous"></script>

<style>
	.pwMsg {
		position: relative;
    	width: 160%;
    	right: 79px;
   		margin-top: 17px;
	}
</style>
<script type="text/javascript">

</script>
</head>
<body>
	<form method="POST" id="pwEditFrm">
		<input type="hidden" name="pw" id="pw">
		<input type="hidden" name="f" id="f">
	</form>
	
	<header>
		<jsp:include page="../../frame/header.jsp"/>
	</header>
	<nav>
		<jsp:include page="../../frame/sideBar.jsp"/>
	</nav>
	
	<div class="w3-main " style="margin-left:250px; height:70%;">
		<!-- 마이페이지 프로필 영역 -->
		<div class="w3-hide-large" style="margin-top:83px;"></div>
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
			<div class="w3-margin-top w3-margin-left w3-row"">
				<div class="w3-col s4">
					<h4 class="w3-center w3-theme-l4"><i class="far fa-edit w3-margin-right"></i>비밀번호 수정</h4>			
				</div>
				<div class="w3-col s9 w3-padding w3-margin-top w3-margin-bottom w3-theme-l4 ">
					<div class="w3-col  w3-container w3-card w3-white">
						<div class="w3-col ">
							<label for=tType class=" w3-col s3 w3-small">시설 회원 여부</label>
							<input class="w3-col s2 w3-left w3-left-margin w3-check w3-padding "  style="border: 0px;" type="checkbox" id="tF" value="F"/><small>시설 관리자 회원은 체크해주세요.</small>
						</div>
						<div class="w3-col s8 w3-border-bottom">
							<div class="w3-col w3-margin-top">
								<small class="w3-col s4 va-middle">기존 비밀번호 </small>
								<div class="w3-col s3 w3-medium w3-button w3-theme-l3 w3-round-xxlarge" id="ck">확인</div>  						
							</div>
							<div class="w3-col s6 w3-margin-bottom">
								<input class="w3-col w3-input" type="password" id="oldPw" >
							</div>
						</div>
						<div class="w3-col s4 w3-hide" id="pwMsgBox">
							<div class="w3-small pwMsg" ><small id="pwckMsg"></small><br><br><div>변경하실 비밀번호를 아래에 입력해주세요..</div></div>
						</div>
						<div class="w3-col w3-margin-top">
							<small>새 비밀번호</small>
						</div>
						<div class="w3-col s6">
							<input class="w3-input w3-col" type="password" id="tPw" readonly>
						</div>
						<div class="w3-col w3-margin-top">
							<small>비밀번호 재입력</small>
						</div>
						<div class="w3-col" id="pwEditMsgBox">
							<small id="pwEditMsg"></small>
						</div>
						<div class="w3-col s6 w3-margin-bottom">
							<input class="w3-input w3-col" type="password" id="tRepw" readonly>
						</div>
					</div>	
				</div>	
			</div>
			<!-- 버튼 영역 -->
			<div class="w3-col s9 w3-right-align">
				<div class="w3-button w3-round-xxlarge w3-theme-l2" id="pwEditSubmit" >암호 재설정</div>
			</div>
		</div>
	</div>
</body>
</html>