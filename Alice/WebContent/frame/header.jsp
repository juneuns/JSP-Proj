<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<link rel="stylesheet" href="/Alice/css/user.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-grey.css">
<script type="text/javascript" src="/Alice/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Alice/js/frame/header.js"></script>
<script src="https://kit.fontawesome.com/865b1e5df5.js" crossorigin="anonymous"></script>
<style>
.w3-sidebar a {font-family: "Roboto", sans-serif}
body,h1,h2,h3,h4,h5,h6 {font-family: "Montserrat", sans-serif; padding:0px;margin:0px; }
.cencel {
	position: relative;
    top: 9px;
    left: 1px;
}

</style>
<body class="w3-content" style="max-width:1200px">
	<!-- Overlay effect when opening sidebar on small screens -->
	<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>
	
	<!-- !PAGE CONTENT! -->
	<div class="w3-main" style="margin-left:250px">
	
	  <!-- Push down content on small screens -->
		<div class="w3-hide-large" style="margin-top:83px"></div>
	  
	  <!-- Top header -->
	  	<header class="w3-container w3-xlarge">
	    	<p class="w3-col m2 w3-left">GoGym</p>
		    <div class="w3-col w3-right m4">
		    	<c:if test="${empty SID}">
			    	<a class="w3-button w3-col s4 " id="login"><h6>Sign In</h6></a>
				    <a class="w3-button w3-col s4 w3-padding-left"><h6>Sign up</h6></a>
			    </c:if>
		    	<c:if test="${not empty SID}">
			    	<a class="w3-button w3-col s4 " id="login"><h6>My Page</h6></a>
				    <a class="w3-button w3-col s4 w3-padding-left" id="logout"><h6>Logout</h6></a>
			    </c:if>
			    <div class="w3-button w3-right">
					<i class="fas fa-concierge-bell"></i>
				</div>
			    <!-- 여기까지 -->
		    </div>
		    <div id="id01" class="w3-modal">
	  			<div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:500px">
					<form class="w3-container" action="" method="POST" id="frm">
						<input type="hidden" value="" name="fit" />
				        <div class="w3-section w3-center" id="ulogin" >
				        	<div>
					        	<label class="w3-text-gary" for="id"><h5 class="w3-center ">사용자 아이디</h5></label>			        	
				        	</div>
				        	<div class=" w3-center ">
						        <input class="w3-padding w3-border-gray w3-border-bottom" style="border: 0px;" type="text" placeholder="Enter Username" name="id" required>			        	
				        	</div>
				        	<div>
					        	<label for="id"><h5 class="w3-center w3-text-gary">비밀번호</h5></label>			        	
				        	</div>
					       	<div class=" w3-center " >
						       	<input class="w3-padding w3-border-gray w3-border-bottom" style="border: 0px;" type="password" placeholder="Enter Password" name="pw" required>				       	
					       	</div> 
						</div>				
				        <div class="w3-button w3-block w3-section w3-padding w3-theme-l4" id="lbtn">Login</div>
					    <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
					        <div id="cbtn" class="w3-col m3 w3-button w3-red cencel">Cancel</div>
					        <div class="w3-rest w3-right-align">
					        	<label for="fbtn">시설 관리자 로그인</label>
						        <input name="f" type="checkbox" id="fbtn" >		        			        
					        </div>
					        <span class="w3-right w3-hide-small">Forgot <a href="#">password?</a></span>
					    </div>
					</form>
				</div>
			</div>
	  </header>
	</div>
</body>
<script type="text/javascript">

</script>
</html>