<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Alice/css/fitPop.css">
<link rel="stylesheet" href="/Alice/css/w3.css">
<script type="text/javascript" src="/Alice/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Alice/js/member/signUp.js"></script>
<style>
</style>
<script type="text/javascript">

</script>
</head>
<body>
<div class="pop-address-search" style="width: 100%;" >
	<div class="pop-address-search-inner" style="border: 0px;">
		<div style="height: 50px;" id="searchContentBox">
			<fieldset>
				<legend>시설명 검색</legend>		
				<span class="wrap">
					<input type="text" class="popSearchInput" style="font-size: 13px; font-weight: bold; ime-mode:active; " title="검색어를 입력하세요" name="keyword" id="keyword" placeholder="시설 이름으로 검색해주세요.." value=""  tabindex="1"/>
					<input type="button" title="검색"  tabindex="2" style="margin-left:2px; cursor: pointer;"/>
				</span>
				<a class="close" id="closeBtn" title="창닫기" tabindex="3"></a>
			</fieldset>
		</div>
	</div>
	<div class="w3-col w3-center" style="max-width: 400px; position: relative; left: 45px; top: -28px; ">
		<div class="w3-col w3-margin-top w3-padding w3-border-bottom w3-border-top " >
			<div class="w3-col s1" style="display: inline-block ;">
				no
			</div>
			<div class="w3-col s10 w3-center" style="display: inline-block ;">
				이름 및 주소				
			</div>
		</div>
	</div>
	<div class="w3-col w3-center" style="max-width: 400px; position: relative; left: 45px; top: -28px; ">
		<!-- forEach문 사용해주세요 -->
		<div class="w3-col w3-padding-16 w3-border-bottom content" id="">
			<form id="frm">
				<!-- el태그 사용해주세요 -->
				<input type="hidden" name="" id="fitno" value="">
				<input type="hidden" name="" id="fitname" value="">
			</form>
			<div class="w3-col s2" style="display: inline-block ;">
				1
			</div>
			<div class="w3-col s8 w3-center" style="display: inline-block ;">
				빡빡이 아저씨			
			</div>
		</div>
		<!-- 여기 까지-->
	</div>
</div>
</body>
</html>