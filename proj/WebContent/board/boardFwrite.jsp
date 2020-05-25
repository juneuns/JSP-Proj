<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 작성하기</title>
<link rel="stylesheet" href="/clsProj/css/w3.css">
<link rel="stylesheet" href="/clsProj/css/user.css">
<script type="text/javascript" src="/clsProj/js/jquery-3.5.0.min.js"></script>
<style>
</style>
<script type="text/javascript">

</script>
</head>
<body class="w3-content" style="max-width: 774px">
	<div class="w3-container w3-text-grey w3-margin-top">
		<div class="w3-col w3-border-bottom w3-center">
			<h2>Board Write</h2>
		</div>
		<div class="w3-col w3-border-bottom w3-center" style="display: none;">
			<h2>Board Edit</h2>
		</div>
		<div class="w3-row">
			<div class="w3-col m2 w3-button w3-right w3-hover-green">
				<small>Submit</small>
			</div>
			<div class="w3-col m2 w3-button w3-right w3-hover-green">
				<small>Calendar Add</small>
			</div>
			<div class="w3-col m2 w3-button w3-right w3-hover-green">
				<small>Edit</small>
			</div>
			<div class="w3-col m2 w3-button w3-right w3-hover-green">
				<small>Delete</small>
			</div>
		</div>
	</div>
	<!-- Product grid -->
	<div class="w3-row w3-margin-top w3-grayscale">
		<div class="w3-col">
			<div class="w3-container">
				<div class="w3-col m2 w3-padding w3-center w3-border-bottom">게시글 제목</div>
				<input class="w3-col m6 w3-center w3-border-bottom" style="padding: 7px 16px 7px 16px;">
				<div class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">작성자</div>
				<div class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">주재석</div>
			</div>
		</div>
		<div class="w3-col">
			<div class="w3-container">
				<div class="w3-col m2 w3-padding w3-center">게시글 내용</div>
				<div class="w3-rest">
					<input class="w3-col w3-border-right" type="file">
					<textarea class="w3-col" cols="50" rows="5" style="padding: 7px 16px 7px 16px;"></textarea>
				</div>
			</div>
		</div>
		<div class="w3-col">
			<div class="w3-container">
				<div class="w3-col w3-padding w3-border-top"></div>
				<div class="w3-col w3-padding w3-center w3-border-right">This Month Calendar</div>
			</div>
			<form class="w3-container w3-right" name="calendarFrm" id="calendarFrm" action="" method="post">
				<DIV class="w3-col" id="content">
					<table border="0" cellspacing="1" cellpadding="1" bgcolor="#FFFFFF">
						<THEAD>
							<TR bgcolor="#CECECE">
								<TD width='100px'>
									<DIV align="center">
										<font color="red">일</font>
									</DIV>
								</TD>
								<TD width='100px'>
									<DIV align="center">월</DIV>
								</TD>
								<TD width='100px'>
									<DIV align="center">화</DIV>
								</TD>
								<TD width='100px'>
									<DIV align="center">수</DIV>
								</TD>
								<TD width='100px'>
									<DIV align="center">목</DIV>
								</TD>
								<TD width='100px'>
									<DIV align="center">금</DIV>
								</TD>
								<TD width='100px'>
									<DIV align="center">
										<font color="#529dbc">토</font>
									</DIV>
								</TD>
							</TR>
						</THEAD>
						<TBODY>
							<TR>
							</TR>
						</TBODY>
					</TABLE>
				</DIV>
			</form>
		</div>
	</div>
</body>
</html>