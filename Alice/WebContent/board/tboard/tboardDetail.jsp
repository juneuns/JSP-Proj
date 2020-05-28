<!-- 해당 jsp는 게시글의 상세보기를 보여주는 뷰 이다.
@author		주재석
@since		2020.05.27
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>게시글 상세보기</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/Alice/css/w3.css">
<link rel="stylesheet" href="/Alice/css/board/board.css">
<script type="text/javascript" src="/Alice/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Alice/js/board/boardDetail.js"></script>
<style>
</style>
<body>
	<header>
		<jsp:include page="../../frame/header.jsp" />
	</header>
	<nav>
		<jsp:include page="../../frame/sideBar.jsp" />
	</nav>
	<div class="content mxw980 mg250">
		<div class="w3-container w3-text-grey w3-margin-top">
			<div class="w3-col w3-border-bottom w3-center">
				<h2>Trainer board</h2>
			</div>
			<div class="w3-row">
				<c:if test="${UNO eq DATA.b_uno}">
				<div class="w3-button w3-right w3-hover-green" id="ebtn">
					<small>수정하기</small>
				</div>
				<div class="w3-button w3-right w3-hover-red" id="dbtn">
					<small>삭제하기</small>
				</div>
				<</c:if>
				<div class="w3-button w3-left w3-hover-green" id="libtn">
					<small>목차보기</small>
				</div>
				<div class="w3-button w3-left w3-hover-green" id="hbtn">
					<small>홈으로</small>
				</div>
			</div>
		</div>
		<!-- Product grid -->
		<div class="w3-row w3-margin-top w3-grayscale">
			<div class="w3-col">
				<div class="w3-container">
					<div
						class="w3-col m6 w3-padding w3-center w3-border-bottom w3-border-right">게시글
						제목</div>
					<div
						class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">작성자</div>
					<div
						class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">등록일자</div>
					<div class="w3-col m2 w3-padding w3-center w3-border-bottom">조회수</div>
				</div>
			</div>
			<div class="w3-col">
				<div class="w3-container">
					<div
						class="w3-col m6 w3-padding w3-center w3-border-bottom w3-border-right">${DATA.title}</div>
					<div
						class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">${DATA.b_empno}</div>
					<div
						class="w3-col m2 w3-padding w3-center w3-border-bottom w3-border-right">${DATA.sdate}</div>
					<div class="w3-col m2 w3-padding w3-center w3-border-bottom">${DATA.click}</div>
				</div>
			</div>
			<div class="w3-col w3-margin-top">
				<div class="w3-container">
					<div class="w3-col w3-padding w3-border-bottom"
						style="height: 200px;">${DATA.bcontent}</div>
				</div>
			</div>
			<!-- 이미지 보여주기 -->
			<div class="w3-col w3-margin-top">
				<div class="w3-container">
					<div class="w3-col m2 w3-padding w3-center">
						<small>게시글 이미지</small>
					</div>
					<div class="w3-rest w3-border-bottom">
						<c:forEach var="image" items="${LIST}">
							<img class="dtline" src="/Alice/img/${image.savename}"
								style="display: inline-block; width: 20%;">
						</c:forEach>
					</div>
				</div>
			</div>
			<!-- 댓글 보여주기 -->
			<div class="w3-col w3-margin-top">
				<div class="w3-container">
					<div
						class="w3-col m2 w3-right w3-button w3-margin-bottom w3-border-bottom w3-border-right pd"
						id="rebtn" style="padding: 0px;">
						<small>댓글작성하기</small>
					</div>
					<div class="w3-col w3-margin-bottom">
						<form class="w3-col" id="freply" method="post">
							<input type="hidden" id="bno" name="bno" value="${param.bno}">
							<input type="hidden" id="rno" name="rno">
							<input type="hidden" id="runo" name="runo">
							<input type="hidden" id="nowPage" name="nowPage" value="${param.nowPage}">
							<input type="hidden" id="rePage" name="rePage">
							<input type="hidden" id="cPage" name="cPage" value="${PAGE.nowPage}">
							<input type="hidden" id="pre" name="pre" value="${PAGE.startPage - 1}">
							<input type="hidden" id="next" name="next" value="${PAGE.endPage + 1}">
							<textarea class="w3-col rcont" placeholder="댓글을 입력하세요." cols="30"
								rows="3" id="rcontent" name="rcontent" style="display: none;"></textarea>
							<textarea class="w3-col rupdate" placeholder="댓글을 입력하세요."
								cols="30" rows="3" id="rupdate" name="rupdate"
								style="display: none;"></textarea>
						</form>
						<div
							class="w3-col m1 w3-button w3-right w3-border-bottom w3-border-right rewr1"
							style="display: none;">
							<small>작성</small>
						</div>
						<div
							class="w3-col m1 w3-button w3-right w3-border-bottom w3-border-right rewr2"
							style="display: none;">
							<small>수정</small>
						</div>
					</div>
					<div class="w3-row">
						<c:forEach var="reply" items="${REPLY}" varStatus="st">
							<div class="w3-col m2">
								<p></p>
							</div>
							<div class="w3-col m10 w3-left tdmgh h90" id="${reply.rno}"
								style="margin: 0px; height: 90px;">
								<div class="w3-col m10"
									style="padding-left: ${reply.step * 50}px;">
									<div class="w3-border-top">
										<small>${reply.rcontent}</small>
									</div>
								</div>
								<div class="w3-col m1 w3-border-top">
									<small>ID : </small>
								</div>
								<div class="w3-col m1">
									<div class="w3-border-top">
										<small>${reply.r_empno}</small>
									</div>
								</div>
								<div class="w3-col m9">
									<p></p>
								</div>
								<%-- <c:if test="${not empty UNO}"> --%>
								<div
									class="w3-col m1 w3-center w3-light-green w3-button writebtn"
									style="padding: 0px;">작성</div>
								<%-- </c:if> --%>
								<%-- <c:if test="${reply.r_empno eq UNO}"> --%>
								<div class="w3-col m1 w3-center w3-amber w3-button editbtn"
									style="padding: 0px;">수정</div>
								<div class="w3-col m1 w3-center w3-deep-orange w3-button delbtn"
									style="padding: 0px;">삭제</div>
								<%-- </c:if> --%>
							</div>
						</c:forEach>
						<!-- 댓글 페이징처리 -->
						<div class="w3-center">
							<div class="w3-bar w3-border w3-round w3-margin-top">
									<!-- 페이지 유틸 처리페이지 -->
								  <c:if test="${PAGE.startPage lt (PAGE.pageGroup + 1)}">
									  <span class="w3-bar-item w3-light-gray">PRE</span>
								  </c:if>
								  <c:if test="${PAGE.startPage ge (PAGE.pageGroup + 1)}">
									  <span class="w3-bar-item w3-button w3-hover-blue pbtn">PRE</span>
								  </c:if>
								  <c:forEach var="pageNo" begin="${PAGE.startPage}" end="${PAGE.endPage}">
									  <c:if test="${pageNo eq PAGE.nowPage}">
										  <span class="w3-bar-item w3-button pbtn w3-blue">${pageNo}</span>
									  </c:if>
									  <c:if test="${pageNo ne PAGE.nowPage}">
										  <span class="w3-bar-item w3-button pbtn">${pageNo}</span>
									  </c:if>
								  </c:forEach>
								  <c:if test="${PAGE.endPage ne PAGE.totalPage}">
								  	<span class="w3-bar-item w3-button w3-hover-blue">NEXT</span>
								  </c:if>
								  <c:if test="${PAGE.endPage eq PAGE.totalPage}">
								  	<span class="w3-bar-item w3-light-gray">NEXT</span>
								  </c:if>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>