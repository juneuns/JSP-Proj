<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>게시글 상세보기</title>
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
<body class="w3-content" style="max-width: 774px">
	<div class="w3-container w3-text-grey w3-margin-top">
		<div class="w3-col w3-border-bottom w3-center">
			<h2>Trainer board</h2>
		</div>
		<div class="w3-row">
			<div class="w3-button w3-right w3-hover-green">
				<small>수정하기</small>
			</div>
			<div class="w3-button w3-left w3-hover-green">
				<small>목차보기</small>
			</div>
			<div class="w3-button w3-left w3-hover-green">
				<small>홈으로</small>
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
				<div class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">2020.05.18 ${DATA.vno}</div>
				<div class="w3-col m2 w3-padding w3-center w3-border-bottom">2 ${DATA.hiredate}</div>
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
		<!-- 이미지 보여주기 -->
		<div class="w3-col w3-margin-top">
			<div class="w3-container">
				<div class="w3-col m2 w3-padding w3-center"><small>게시글 이미지</small></div>
				<div class="w3-rest w3-border-bottom">
					<div class="w3-dropdown-hover" style="background-color: white;">
						<img src="/proj/image/img_avatar1.png" alt="Monterosso" style="width:20%">
	    			</div>
	    			<div class="w3-dropdown-content" style="width:300px"><br>
		      			<img src="/proj/image/img_avatar1.png" alt="Norway" style="width:100%">
	  				</div>
				</div>
			</div>
		</div>
		<!-- 댓글 보여주기 -->
		<div class="w3-col w3-margin-top">
			<div class="w3-container">
<%-- 			<c:if test="${not empty SID }"> 아이디가 같으면 실행 --%>
				<div class="w3-col m2 w3-right w3-button w3-hover-green" style="padding: 0px;">
					<small>댓글작성하기</small>
				</div>
<%-- 			</c:if> --%>				
				<div class="w3-row">
					<div class="w3-col m2"><p></p></div>
					<%-- <c:forEach var="data" items="${LIST}"> --%>
						<div class="w3-col m10 w3-left w3-border-top" 
								style="height: 90px;
						 <%-- padding: "${st.step * 50} 왼쪽에 조금씩 패딩넣어서 대댓글 표--%>">
							<h6 class="w3-col w3-border-bottom" style="margin: 0px; height: 50px;"><small>첫 댓글 등록</small></h6>
							<div class="w3-col m9"><p></p></div>
							<%-- <c:if test="${not empty SID }"> 로그인되어있으면 --%>
								<div class="w3-col m1 w3-center w3-light-green w3-button" style="padding: 0px;">작성</div>
							<%-- </c:if> --%>
							<%-- <c:if test="${not empty SID}"> 아이디가 같으면 --%>
								<div class="w3-col m1 w3-center w3-amber w3-button" style="padding: 0px;">수정</div>
								<div class="w3-col m1 w3-center w3-deep-orange w3-button" style="padding: 0px;">삭제</div>
							<%-- </c:if> --%>
						</div>
					<%-- </c:forEach> --%>
				</div>
			</div>
		</div>
		<!-- 댓글 페이징처리 -->
		<div class="w3-center">
		<div class="w3-bar w3-border w3-round w3-margin-top">
			<%-- <c:if test="${PAGE}"> --%>
				<span class="w3-bar-item w3-button w3-light-gray">pre</span>
				<span class="w3-bar-item w3-button w3-light-gray">1 ${PAGE }</span>
				<span class="w3-bar-item w3-button w3-light-gray">next</span>
			<%-- </c:if> --%>
		</div>
	</div>
	</div>
	<!-- 캘린더 보기 및 수정 -->
	<form class="w3-container w3-margin-top" name="calendarFrm" id="calendarFrm" action="" method="post">
		<div class="w3-col w3-padding" id="content">
			<table width="100%" border="0" cellspacing="1" cellpadding="1"><!-- cellspacing 셀사이간격 cellpadding 셀 패딩. -->
				<tr>
					<td align="right"><input type="button"value="오늘" /></td>
				</tr>
			</table>
			<!--날짜 네비게이션  -->
			<table border="0" cellspacing="1" cellpadding="1" bgcolor="#FFFFFF">
				<thead>
					<tr bgcolor="#CECECE">
						<td width='100px'>
							<div align="center">
								<font color="red">일</font>
							</div>
						</td>
						<td width='100px'>
							<div align="center">월</div>
						</td>
						<td width='100px'>
							<div align="center">화</div>
						</td>
						<td width='100px'>
							<div align="center">수</div>
						</td>
						<td width='100px'>
							<div align="center">목</div>
						</td>
						<td width='100px'>
							<div align="center">금</div>
						</td>
						<td width='100px'>
							<div align="center">
								<font color="light-blue">토</font>
							</div>
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:forEach var="sblock" items="${SBLOCK}">
							<td>${sblock}</td>
						</c:forEach>
						<c:forEach var="date" items="${DATE}">
							<c:if test="${date lt 3}">
								<td>${date}</td>
							</c:if>
							<c:if test="${date eq 3}">
							    </tr>
							    <tr>
							</c:if>
							<c:if test="${(date ge 3) and (date lt 10) }">
								<td>${date}</td>
							</c:if>
							<c:if test="${date eq 9}">
								</tr>
							</c:if>
						</c:forEach>
						<c:forEach var="eblock" items="${EBLOCK}">
							<td>${eblock}</td>
						</c:forEach>
					</tr>
				</tbody>
			</table>
		</div>
	</form>
	<!-- 게시글 페이징처리 -->
	<div class="w3-center">
		<div class="w3-bar w3-border w3-round w3-margin-top">
			<span class="w3-bar-item w3-button w3-light-gray">이전글보기</span>
			<span class="w3-bar-item w3-button w3-light-gray">다음글보기</span>
		</div>
	</div>
</body>
</html>