<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.w3-sidebar a {
	font-family: "Roboto", sans-serif
}

body, h1, h2, h3, h4, h5, h6, .w3-wide {
	font-family: "Montserrat", sans-serif;
}
</style>
<body class="w3-content" style="max-width: 1200px">
	<div class="w3-container w3-text-grey" id="jeans">
		<p>This Month Trainer</p>
	</div>

	<!-- Product grid -->
	<div class="w3-row w3-grayscale">
		<div class="w3-col l3 s6">
			<div class="w3-container">
				<img src="/w3images/jeans1.jpg" style="width: 100%">
				<p>
					UJISANG<br>
					<b>He is Strong</b></br>
					<b>PLACE: GURO</b>
				</p>
			</div>
			<div class="w3-container">
				<img src="/w3images/jeans2.jpg" style="width: 100%">
				<p>
					GWANGHO<br>
					<b>He is CUTE</b>
				</p>
			</div>
		</div>

		<div class="w3-col l3 s6">
			<div class="w3-container">
				<div class="w3-display-container">
					<img src="/w3images/jeans2.jpg" style="width: 100%">
				</div>
				<p>
					HONGJOO<br>
					<b>fx search</b><br>
					<b>MASTER</b>
				</p>
			</div>
			<div class="w3-container">
				<img src="/w3images/jeans3.jpg" style="width: 100%">
				<p>
					OWIN<br>
					<b>NO SMOKE</b>
				</p>
			</div>
		</div>

		<div class="w3-col l3 s6">
			<div class="w3-container">
				<img src="/w3images/jeans3.jpg" style="width: 100%">
				<p>
					JOOJAESUK<br>
					<b>NO DAP</b><br>
					<b>NO DAP</b>
				</p>
			</div>
			<div class="w3-container">
				<div class="w3-display-container">
					<img src="/w3images/jeans4.jpg" style="width: 100%">
				</div>
				<p>
					JOOJAESUK<br>
					<b>NO DAP</b><br>
					<b>NO DAP</b>
				</p>
			</div>
		</div>

		<div class="w3-col l3 s6">
			<div class="w3-container">
				<img src="/w3images/jeans4.jpg" style="width: 100%">
				<p>
					JOOJAESUK<br>
					<b>NO DAP</b><br>
					<b>NO DAP</b>
				</p>
			</div>
			<div class="w3-container">
				<img src="/w3images/jeans1.jpg" style="width: 100%">
				<p>
					JOOJAESUK<br>
					<b>NO DAP</b><br>
					<b>NO DAP</b>
				</p>
			</div>
		</div>
	</div>

	<!-- Subscribe section -->
	<div class="w3-container w3-black w3-padding-32">
		<h1>JOIN HEALTH?</h1>
		<p>To get special offers and VIP treatment:</p>
		<p>
			<input class="w3-input w3-border" type="text"
				placeholder="Enter e-mail" style="width: 100%">
		</p>
		<button type="button" class="w3-button w3-red w3-margin-bottom">Subscribe</button>
	</div>
</body>
</html>