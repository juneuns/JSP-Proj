<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 
	  작성자 : 안홍주 
	  작성일 : 2020/05/25
	 
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Alice/css/w3.css">
<script type="text/javascript" src="/Alice/js/jquery-3.5.0.min.js"></script>
<style>
</style>
<script type="text/javascript">

</script>
</head>
<body>
	<header>
		<jsp:include page="/frame/header.jsp"/>
	</header>
	<nav>
		<jsp:include page="/frame/sideBar.jsp"/>
	</nav>
	<div class="w3-main" style="margin-left: 250px">

		<!-- Push down content on small screens -->
		<div class="w3-hide-large" style="margin-top: 83px"></div>

		<!-- Top header -->
		<header class="w3-container w3-xlarge">
			<p class="w3-left">WelCome This Place!!!</p>
			<p class="w3-right">
				<i class="fa fa-shopping-cart w3-margin-right"></i> <i
					class="fa fa-search"></i>
			</p>
		</header>

		<!-- Image header -->
		<div class="w3-display-container w3-container">
			<div class="w3-display-topleft w3-text-white"
				style="padding: 24px 48px; display: none;">
				<h1 class="w3-jumbo w3-hide-small">New arrivals</h1>
				<h1 class="w3-hide-large w3-hide-medium">New arrivals</h1>
				<h1 class="w3-hide-small">COLLECTION 2016</h1>
				<p style="display:none;">
					<a href="#jeans"
						class="w3-button w3-black w3-padding-large w3-large">SHOP NOW</a>
				</p>
			</div>
		</div>

		<div class="w3-container w3-text-grey" id="jeans" style="background-color:#000; width: 100%;">
            <div style="width:50%; float: left;"><p style="color:#fff; display: block; font-weight:bold;">이달의 회원</p></div>
            <div style="width:50%; float: left;"><p style="text-align: right; font-size:13px; color:#fff; margin-top: 15px;"><a href="/main/main.do" target="_blank" style="text-decoration: none;">더보기 +</a></p></div>
		</div>

		<!-- Product grid -->
		<div class="w3-row w3-grayscale" style="padding-top:10px;">
			<div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						회원1<br>
						<b>He is Strong</b><br>
						<b>PLACE: GURO</b>
                    </p>
				</div>
			</div>

			<div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<div class="w3-display-container">
						<img src="http://placehold.it/205?text=sample" style="width: 100%">
					</div>
					<p>
						회원2<br>
						<b>fx search</b><br>
						<b>MASTER</b>
					</p>
				</div>
			</div>

			<div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						회원3<br>
						<b>NO DAP</b><br>
						<b>NO DAP</b>
					</p>
				</div>
			</div>

			<div class="w3-col l3 s6">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						회원4<br>
						<b>NO DAP</b><br>
						<b>NO DAP</b>
					</p>
				</div>	
            </div>
			</div>
			
			<div class="w3-container w3-text-grey" id="jeans" style="background-color:#000; width: 100%;">
            <div style="width:50%; float: left;"><p style="color:#fff; display: block; font-weight:bold;">이달의 트레이너</p></div>
            <div style="width:50%; float: left;"><p style="text-align: right; font-size:13px; color:#fff; margin-top: 15px;"><a href="trainer/trainer.html" target="_blank" style="text-decoration: none;">더보기 +</a></p></div>
		</div>
			
			<div class="w3-row w3-grayscale" style="padding-top:10px;">
			<div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						트레이너1<br>
						<b>He is Strong</b><br>
						<b>PLACE: GURO</b>
                    </p>
				</div>
			</div>

			<div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<div class="w3-display-container">
						<img src="http://placehold.it/205?text=sample" style="width: 100%">
					</div>
					<p>
						트레이너2<br>
						<b>fx search</b><br>
						<b>MASTER</b>
					</p>
				</div>
			</div>

			<div class="w3-col l3 s6" style="width:25%;">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						트레이너3<br>
						<b>NO DAP</b><br>
						<b>NO DAP</b>
					</p>
				</div>
			</div>

			<div class="w3-col l3 s6">
				<div class="w3-container">
					<img src="http://placehold.it/205?text=sample" style="width: 100%">
					<p>
						트레이너4<br>
						<b>NO DAP</b><br>
						<b>NO DAP</b>
					</p>
				</div>	
            </div>
			</div>
			
		</div>

		 <!-- Subscribe section -->
		<!--<div class="w3-container w3-black w3-padding-32" style="margin-top:20px;">
			<h1>JOIN HEALTH?</h1>
			<p>To get special offers and VIP treatment:</p>
			<p>
				<input class="w3-input w3-border" type="text"
					placeholder="Enter e-mail" style="width: 100%">
			</p>
			<button type="button" class="w3-button w3-red w3-margin-bottom">Subscribe</button>
		</div> -->
</body>
</html>