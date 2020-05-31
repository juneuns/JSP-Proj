<!-- 해당 jsp는 게시글 작성에 쓰이는 뷰입니다.
@author		주재석
@since		2020.05.27
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trainer Write</title>
<link rel="stylesheet" href="/Alice/css/w3.css">
<link rel="stylesheet" href="/Alice/css/board/board.css">
<script type="text/javascript" src="/Alice/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Alice/js/board/boardWrite.js"></script>
<style>
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
	<header>
		<jsp:include page="../../frame/header.jsp" />
	</header>
	<nav>
		<jsp:include page="../../frame/sideBar.jsp" />
	</nav>
	<div class="w3-main mg250">
		<div class="w3-container w3-text-grey w3-margin-top">
			<div class="w3-col w3-border-bottom w3-center">
				<h2>Board Write</h2>
			</div>
			<div class="w3-row">
				<div class="w3-col m2 w3-button w3-left w3-hover-green" id="ltbtn">
					<small>목차보기</small>
				</div>
				<div class="w3-col m2 w3-button w3-left w3-hover-green" id="hbtn">
					<small>홈으로</small>
				</div>
				<c:if test="${empty DATA}">
					<div class="w3-col m2 w3-button w3-right w3-hover-green" id="bwbtn">
						<small>Submit</small>
					</div>
				</c:if>
				<c:if test="${not empty DATA}">
					<div class="w3-col m2 w3-button w3-right w3-hover-green" id="bebtn">
						<small>Edit</small>
					</div>
				</c:if>
				<!-- 				<div class="w3-col m2 w3-button w3-right w3-hover-green">
					<small>Calendar Add</small>
				</div> -->
			</div>
		</div>
		<c:if test="${not empty DATA}">
			<form class="w3-row w3-margin-top w3-grayscale"
				encType="multipart/form-data" id="frme" name="frme" method="post">
				<input type="hidden" id="bno" name="bno" value="${BNO}">
				<div class="w3-col">
					<div class="w3-container">
						<div class="w3-col m2 w3-padding w3-center w3-border-bottom">게시글
							제목</div>
						<input class="w3-col m6 w3-center w3-border-bottom"
							style="padding: 7px 16px 7px 16px;" id="title" name="title"
							value="${DATA.title}">
						<div
							class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">작성자</div>
						<div
							class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">${SID}</div>
					</div>
				</div>
				<div class="w3-col">
					<div class="w3-container w3-border-bottom"
						style="padding-right: 0px;">
						<div class="w3-col m2 w3-padding w3-center">게시글 내용</div>
						<div class="w3-rest">
							<div class="w3-col mfile">
								<input class="w3-col w3-border-right file" type="file"
									name="file1">
							</div>
							<div class="w3-col">
								<textarea class="w3-col pdt" cols="50" rows="15" id="tcont"
									name="tcont" placeholder="내용을 입력하세요.">${DATA.bcontent}</textarea>
							</div>
						</div>
					</div>
				</div>
			</form>
		</c:if>
		<c:if test="${empty DATA}">
			<form class="w3-row w3-margin-top w3-grayscale"
				encType="multipart/form-data" id="frmw" name="frmw" method="post">
				<input type="hidden" id="bno" name="bno" value="${param.bno}">
				<div class="w3-col">
					<div class="w3-container">
						<div class="w3-col m2 w3-padding w3-center w3-border-bottom">게시글
							제목</div>
						<input class="w3-col m6 w3-center w3-border-bottom"
							style="padding: 7px 16px 7px 16px;" id="title" name="title">
						<div
							class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">작성자</div>
						<div
							class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">${SID}</div>
					</div>
				</div>
				<div class="w3-col">
					<div class="w3-container w3-border-bottom"
						style="padding-right: 0px;">
						<div class="w3-col m2 w3-padding w3-center">게시글 내용</div>
						<div class="w3-rest">
							<div class="w3-col mfile">
								<input class="w3-col w3-border-right file" type="file"
									name="file1">
							</div>
							<div class="w3-col">
								<textarea class="w3-col pdt" cols="50" rows="15" id="tcont"
									name="tcont" placeholder="내용을 입력하세요."></textarea>
							</div>
						</div>
					</div>
				</div>
			</form>
		</c:if>
		<div class="w3-col w3-margin-top">
			<div class="w3-container">
				<div id="wCalendar" class="w3-modal">
					<div class="w3-modal-content">
						<div class="w3-container">
							<span
								onclick="document.getElementById('wCalendar').style.display='none'"
								class="w3-button w3-display-topright">&times;</span>
							<div class="w3-container w3-padding w3-center">Write Calendar</div>
								<form method="post" action="/Alice/tboard/CalendarWrite.do" class="w3-col" id="calfrm">
									<div class="w3-col">
										<div class="w3-col m2 w3-center">운동일 : </div>
										<input class="w3-col m10" id="caldate" name="caldate">
									</div>
									<div class="w3-col">
										<div class="w3-col m2 w3-center">운동명 : </div>
										<input class="w3-col m10" id="calhtn" name="calhtn">
									</div>
									<div class="w3-col">
										<div class="w3-col m2 w3-center">운동부위 : </div>
										<input class="w3-col m10" id="calhtb" name="calhtb">
									</div>
									<div class="w3-col">
										<div class="w3-col m2 w3-center">식단 : </div>
										<input class="w3-col m10" id="caleat" name="caleat">
									</div>
									<div class="w3-col">
										<div class="w3-col m2 w3-button w3-right w3-black" id="calSub">submit</div>
									</div>
								</form>
						</div>
					</div>
				</div>
			</div>
			</div>
			<div class="w3-container w3-center w3-border">
				<div class="w3-col m1 w3-border-right">
					<small>일</small>
				</div>
				<div class="w3-col m2 w3-border-right">
					<small>월</small>
				</div>
				<div class="w3-col m2 w3-border-right">
					<small>화</small>
				</div>
				<div class="w3-col m2 w3-border-right">
					<small>수</small>
				</div>
				<div class="w3-col m2 w3-border-right">
					<small>목</small>
				</div>
				<div class="w3-col m2 w3-border-right">
					<small>금</small>
				</div>
				<div class="w3-col m1">
					<small>토</small>
				</div>
			</div>
			<div
				class="w3-container w3-center w3-border-bottom w3-border-left w3-border-right">
				<c:forEach var="sblock" items="${SBLOCK}" varStatus="st">
					<c:if test="${st.index eq 0}">
						<div class="w3-col m1">${sblock}</div>
					</c:if>
					<c:if test="${st.index gt 0 }">
						<div class="w3-col m2">${sblock}</div>
					</c:if>
				</c:forEach>
				<c:forEach var="date" items="${DATE}" varStatus="st">
					<c:if test="${st.index eq 0}">
						<div class="w3-col w3-button cald m1" id="dt${st.index}">
							<small>${date}</small>
						</div>
					</c:if>
					<c:if test="${st.index eq 1}" >
						<div class="w3-col w3-button cald m1" id="dt${st.index}"><small>${date}</small></div>
					</c:if>
					<c:if test="${st.index gt 1 && st.index lt 7}" >
						<div class="w3-col w3-button cald m2" id="dt${st.index}">
							<small>${date}</small>
						</div>
					</c:if>
					<c:if test="${st.index eq 7}" >
						<div class="w3-col w3-button cald m1" id="dt${st.index}">
							<small>${date}</small>
						</div>
					</c:if>
					<c:if test="${st.index eq 8}" >
						<div class="w3-col w3-button cald m1" id="dt${st.index}">
							<small>${date}</small>
						</div>
					</c:if>
					<c:if test="${st.index gt 8 && st.index lt 14}">
						<div class="w3-col w3-button cald m2" id="dt${st.index}">
							<small>${date}</small>
						</div>
					</c:if>
					<c:if test="${st.index eq 14}">
						<div class="w3-col w3-button cald m1" id="dt${st.index}">
							<small>${date}</small>
						</div>
					</c:if>
					<c:if test="${st.index eq 15}">
						<div class="w3-col w3-button cald m1" id="dt${st.index}">
							<small>${date}</small>
						</div>
					</c:if>
					<c:if test="${st.index gt 15 && st.index lt 21}">
						<div class="w3-col w3-button cald m2" id="dt${st.index}">
							<small>${date}</small>
						</div>
					</c:if>
					<c:if test="${st.index eq 21}">
						<div class="w3-col w3-button cald m1" id="dt${st.index}">
							<small>${date}</small>
						</div>
					</c:if>
					<c:if test="${st.index eq 22}">
						<div class="w3-col w3-button cald m1" id="dt${st.index}">
							<small>${date}</small>
						</div>
					</c:if>
					<c:if test="${st.index gt 22 && st.index lt 28}">
						<div class="w3-col w3-button cald m2" id="dt${st.index}">
							<small>${date}</small>
						</div>
					</c:if>
					<c:if test="${st.index eq 28}">
						<div class="w3-col w3-button cald m1" id="dt${st.index}">
							<small>${date}</small>
						</div>
					</c:if>
					<c:if test="${st.index eq 29}">
						<div class="w3-col w3-button cald m1" id="dt${st.index}">
							<small>${date}</small>
						</div>
					</c:if>
					<c:if test="${st.index gt 29}">
						<div class="w3-col w3-button cald m2" id="dt${st.index}">
							<small>${date}</small>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
</body>
</html>