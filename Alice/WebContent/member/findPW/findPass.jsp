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
<style>
</style>
<script src="https://kit.fontawesome.com/865b1e5df5.js" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function(){
		let fmsg = ${FAILEDMSG};
		if(fmsg){
		alert(fmsg);
		}		
	})
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
		<form action="" method="POST" id="findPWfrm">
			<input type="hidden" name="f" id="type"/>
			<input type="hidden" name="name" id="name"/>
			<input type="hidden" name="id" id="id"/>
			<input type="hidden" name="mail" id="mail"/>
		</form>
		<div class="w3-container">
			<div class="w3-bar w3-black">
				<a href="" class="w3-bar-item w3-padding w3-btn" id="moveFindId">아이디 찾기</a>
				<a href="" class="w3-bar-item w3-padding w3-btn" id="moveFindPW">비밀번호 찾기</a>
			</div>
			<div class="w3-col ">
				<h2 class="w3-col s5 w3-margin-top w3-left-align w3-theme-l3 w3-card" style="padding-left:20px;"><i class="fas fa-key"></i> 비밀번호 찾기</h2>
				<div class="w3-col s8  w3-border w3-margin-top">
					<div class="w3-col ">
						<label for=tType class="w3-padding w3-right-align w3-col m3 w3-large">시설 회원 여부</label>
						<input class="w3-col s2 w3-left w3-left-margin w3-check w3-padding "  style="border: 0px;" type="checkbox" id="tF" value="F"/><small>시설 관리자 회원은 체크해주세요.</small>
					</div>
					<div class="w3-col w3-margin-top">
						<label for="tname" class="w3-padding w3-right-align w3-col m3 w3-large">이름 :</label>
						<input class="w3-col s6 w3-padding w3-border-bottom"  style="border: 0px;" type="text" id="tname"/>	
					</div>
					<div class="w3-col w3-margin-top">
						<label for="tid" class="w3-padding w3-right-align w3-col m3 w3-large">아이디 :</label>
						<input class="w3-col s6 w3-padding w3-border-bottom" style="border: 0px;"type="text"  id="tid"/>	
					</div>
					<div class="w3-col w3-margin-top w3-margin-bottom">
						<label for="tmail" class="w3-padding w3-right-align w3-col m3 w3-large">이메일 :</label>
						<input class="w3-col s6 w3-padding w3-border-bottom"  style="border: 0px;" type="text" id="tmail"/>	
					</div>
				</div>
				<div class="w3-col s8 w3-margin-top" >
					<div class="w3-button w3-half w3-theme-l4" id="reset">cancel</div>
					<div class="w3-button w3-half " id="findPWbtn">submit</div>
				</div>			
			</div>
		</div>
	</div>
</body>
</html>