<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="/proj/css/sideBar.css">
<script type="text/javascript" src="/proj/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/proj/js/sideBar.js"></script>
<style>
</style>
<body class="w3-content" style="max-width: 1200px">
	<!-- Sidebar/menu -->
	<nav class="w3-sidebar w3-bar-block w3-white w3-collapse w3-top"
		style="z-index: 3; width: 250px" id="mySidebar">
		<div class="w3-container w3-display-container w3-padding-16">
			<i onclick="w3_close()"
				class="fa fa-remove w3-hide-large w3-button w3-display-topright"></i>
			<h3 class="w3-wide">
				<b>touch your hand javava</b>
			</h3>
		</div>
		<div class="w3-padding-64 w3-large w3-text-grey"
			style="font-weight: bold">
			<h6 class="w3-bar-item w3-button" id="fbtn">Free Board</h6>
			<h6 class="w3-bh6r-item w3-button" id="tbtn">Trainer Board</h6>
			<h6 class="w3-bh6r-item w3-button" id="cbtn">Fitness Center</h6>
			<h6 class="w3-bh6r-item w3-button" id="ubtn">Client Info</h6>
		</div>
		<a href="#footer" class="w3-bar-item w3-button w3-padding">Contact</a>
		<a href="javascript:void(0)" class="w3-bar-item w3-button w3-padding"
			onclick="document.getElementById('newsletter').style.display='block'">Newsletter</a>
		<a href="#footer" class="w3-bar-item w3-button w3-padding">Subscribe</a>
	</nav>
</body>
</html>