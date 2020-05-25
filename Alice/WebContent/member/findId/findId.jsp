<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/Alice/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Alice/js/info/findId.js"></script>
<link rel="stylesheet" href="/Alice/css/w3.css">
<link rel="stylesheet" href="/Alice/css/user.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-grey.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-colors-metro.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
</style>
<script src="https://kit.fontawesome.com/865b1e5df5.js" crossorigin="anonymous"></script>
<script type="text/javascript">

</script>
</head>
<body>
	<form action="" method="POST" id="frm">
		<input type="hidden" name="type" id="type"/>
		<input type="hidden" name="name" id="name"/>
		<input type="hidden" name="id" id="id"/>
		<input type="hidden" name="mail" id="mail"/>
	</form>
	<div class="w3-content  mxw">
		<h2 class="w3-col s5  w3-left-align w3-theme-l3 w3-card" style="padding-left:20px;"><i class="fas fa-key"></i> 아이디 찾기</h2>
		<div class="w3-col s8  w3-border w3-margin-top">
			<div class="w3-col w3-margin-top">
				<label for="tname" class="w3-padding w3-right-align w3-col m3">회원 유형 :</label>
				<input class="w3-col s6 w3-padding w3-border-bottom"  style="border: 0px;" type="checkbox" name="tname" id="tname"/>	
				<input class="w3-col s6 w3-padding w3-border-bottom"  style="border: 0px;" type="checkbox" name="tname" id="tname"/>	
			</div>
			<div class="w3-col w3-margin-top">
				<label for="tname" class="w3-padding w3-right-align w3-col m3">이름 :</label>
				<input class="w3-col s6 w3-padding w3-border-bottom"  style="border: 0px;" type="text" name="tname" id="tname"/>	
			</div>
			<div class="w3-col w3-margin-top w3-margin-bottom">
				<label for="tmail" class="w3-padding w3-right-align w3-col m3">이메일 :</label>
				<input class="w3-col s6 w3-padding w3-border-bottom"  style="border: 0px;" type="text" name="tmail" id="tmail"/>	
			</div>
		</div>
		<div class="w3-col s8 w3-margin-top" >
			<div class="w3-button w3-half w3-theme-l4" id="cbtn">cencel</div>
			<div class="w3-button w3-half w3-metro-blue" id="sbtn">submit</div>
		</div>
	</div>
</body>
</html>