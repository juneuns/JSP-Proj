<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>게시글 상세보기</title>
<meta charset="UTF-8">
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
<body class="w3-content" style="max-width: 774px">
	<div class="w3-container w3-text-grey w3-margin-top">
		<div class="w3-col w3-border w3-border-bottom w3-center">
			<h2>Trainer board</h2>
		</div>
		<div class="w3-row">
			<div class="w3-button w3-right w3-hover-green">
				<small>수정하기</small>
			</div>
		</div>
	</div>
	<!-- Product grid -->
	<div class="w3-row w3-margin-top w3-grayscale">
		<div class="w3-col">
			<div class="w3-container">
				<div class="w3-col m6 w3-padding w3-center w3-border-bottom w3-border-right">게시글 제목</div>
				<div class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">작성자</div>
				<div class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">등록일자</div>
				<div class="w3-col m2 w3-padding w3-center w3-border-bottom">조회수</div>
			</div>
		</div>
		<div class="w3-col">
			<div class="w3-container">
				<div class="w3-col m6 w3-padding w3-center w3-border-bottom w3-border-right">저의 운동일지 입니다. ${DATA.bno}</div>
				<div class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">주재석 ${DATA.title}</div>
				<div class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">1 ${DATA.vno}</div>
				<div class="w3-col m2 w3-padding w3-center w3-border-bottom">2020.05.18 ${DATA.hiredate}</div>
			</div>
		</div>
		<div class="w3-col w3-margin-top">
			<div class="w3-container">
				<div class="w3-col w3-padding w3-center w3-border-bottom">게시글 내용 ${DATA.bno}</div>
				<div class="w3-col w3-padding w3-border-bottom" style="height: 200px;">
				금일 유지상 회원님의 대한 감사의 글입니다. <br> 일을 하면서 느낀 크나큰 보람에 대해
				한자 적어볼까 합니다. <br> 어느때보다 열심히 운동해주고 절 믿고 따라와주셔서 드디어 B컵이 되셨습니다. ${DATA.title}
				</div>
			</div>
		</div>
	</div>
	<form class="w3-container w3-margin-top" name="calendarFrm" id="calendarFrm" action="" method="post">
		<DIV class="w3-col w3-padding" id="content">
			<table width="100%" border="0" cellspacing="1" cellpadding="1"><!-- cellspacing 셀사이간격 cellpadding 셀 패딩. -->
				<tr>
					<td align="right"><input type="button"
						onclick="javascript:location.href='<c:url value='/CalendarExam2.jsp' />'"
						value="오늘" /></td>
				</tr>
			</table>
			<!--날짜 네비게이션  -->
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
								<font color="light-blue">토</font>
							</DIV>
						</TD>
					</TR>
				</THEAD>
				<TBODY>
					<TR>
						<c:forEach var="data" items="${LIST}">
							<TD>${data}</TD>
						</c:forEach>
					</TR>
				</TBODY>
			</TABLE>
		</DIV>
	</form>
	<div class="w3-center">
		<div class="w3-bar w3-border w3-round w3-margin-top">
			<span class="w3-bar-item w3-button w3-light-gray w3-border-right">목차보기</span>
			<span class="w3-bar-item w3-button w3-light-gray">홈으로</span>
		</div>
	</div>
</body>
</html>