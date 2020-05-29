<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="/Alice/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Alice/js/centerBoard/header.js?v=<%=System.currentTimeMillis() %>"></script>
<style>
.w3-sidebar a {font-family: "Roboto", sans-serif}
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}
</style>
<body class="w3-content w3-topbar w3-white" style="max-width:1200px; position:fixed; ">
	<!-- Overlay effect when opening sidebar on small screens -->
	<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>
	
	<!-- !PAGE CONTENT! -->
	   <div class="w3-main" style="margin-left:250px">
	  <!-- Push down content on small screens -->
	  <div class="w3-hide-large" style="margin-top:83px"></div>
	  
	  <!-- Top header -->
	  <header class="w3-container w3-xlarge w3-white" style="width:950px; height:100px;position:absolute; position:fixed; top: 0px">
	  	<div style="height:10px"></div>
	    <p class="w3-col m2 w3-left" id="logo">JoJim</p>
	  </header>
	
	  <!-- Image header -->
<!-- 	  <div class="w3-display-container w3-container">
	    <div class="w3-display-topleft w3-text-white" style="padding:24px 48px">
	      <h1 class="w3-jumbo w3-hide-small">New arrivals</h1>
	      <h1 class="w3-hide-large w3-hide-medium">New arrivals</h1>
	      <h1 class="w3-hide-small">COLLECTION 2016</h1>
	    </div>
	  </div> -->
</body>
</html>