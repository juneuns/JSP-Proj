<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필 보기</title>
	<link rel="stylesheet" href="../css/w3.css">
	<link rel="stylesheet" href="../css/user.css">
	<script type="text/javascript" src="../js/jquery-3.5.0.min.js"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=31b53901da50d253bfb310b02f1ebd01&libraries=services"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#profile').click(function(){
		
	});
	
});
</script>
<style>	
</style>

</head>
<body>
	<header>
		<jsp:include page="../frame/header.jsp"/>
	</header>
	<nav>
		<jsp:include page="../frame/sideBar.jsp"/>
	</nav>
	<div class="w3-main" style="margin-left:250px;">
		<div class="w3-hide-large" style="margin-top:83px;"></div>
		<div class="w3-center w3-border mxw">
			<h3>매칭 리스트</h3>			
			<div class="w3-col w3-margin-top">
			<c:forEach var="data" items="${SLIST}" varStatus="st">
			<img class="w3-left w3-margin-top w3-col m3"id="img1" src="../img/noimage.jpg" style="height: auto; width: 180px;">
				<div class="w3-col m8 w3-border">
					<div class="w3-col m9 pd-10">${data.name}</div>
					<div class="w3-col m9 pd-10">${data.addr2}</div>
					<div class="w3-col m9 pd-10">${data.body} </div>
					<div class="w3-col m9 pd-10">${data.goal}</div>
					<div class="w3-col m9 pd-10">${data.career}</div>
					<div class="w3-col m9 pd-10">${data.info}</div>
					<button class="w3-col m3 w3-light" type="submit" id="profile">요청</button>
				</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>