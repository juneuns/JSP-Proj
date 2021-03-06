<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.w3-sidebar a {font-family: "Roboto", sans-serif}
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}
</style>
<body class="w3-content" style="max-width:774px">
	  <div class="w3-container w3-text-grey" id="jeans">
			<div class="w3-col w3-blue w3-card-4 w3-center">
				<h2>Trainer Board</h2>
			</div>
			<div class="w3-row">
				<div class="w3-button w3-right w3-green"><small>WRITE</small></div>
			</div>	
	  </div>
	  <!-- Product grid -->
	  <div class="w3-row w3-margin-top w3-grayscale">
	    <div class="w3-col">
	      <div class="w3-container">
	        <div class="w3-col m2 w3-border_bottom">NUMBER</div>
	        <div class="w3-col m7 w3-border_bottom">TEXT</div>
	        <div class="w3-col m1 w3-border_bottom">VIEW</div>
	        <div class="w3-col m2 w3-border_bottom">HIREDATE</div>
	      </div>
	  </div>
	  <c:forEach var="DATA" items="${LIST}">
		  <div class="w3-row w3-margin-top w3-grayscale w3-border">
		    <div class="w3-col">
		      <div class="w3-container">
		        <div class="w3-col m2 w3-border_bottom">${DATA.bno}</div>
		        <div class="w3-col m7 w3-border_bottom">${DATA.title}</div>
		        <div class="w3-col m1 w3-border_bottom">${DATA.vno}</div>
		        <div class="w3-col m2 w3-border_bottom">${DATA.hiredate}</div>
		      </div>
		  </div>
	  </c:forEach>
	
	  <!-- Subscribe section -->
<!-- 	  <div class="w3-container w3-black w3-padding-32">
	    <h1>JOIN HEALTH?</h1>
	    <p>To get special offers and VIP treatment:</p>
	    <p><input class="w3-input w3-border" type="text" placeholder="Enter e-mail" style="width:100%"></p>
	    <button type="button" class="w3-button w3-red w3-margin-bottom">Subscribe</button>
	  </div> -->
</body>
</html>