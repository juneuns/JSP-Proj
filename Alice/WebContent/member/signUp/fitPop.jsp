<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Alice/css/member/fitPop.css">
<link rel="stylesheet" href="/Alice/css/w3.css">
<script type="text/javascript" src="/Alice/js/jquery-3.5.0.min.js"></script>
<style>
</style>

</head>
<body>
<form method="POST" id="fitPopS">
	<input type="hidden" name="keyword" id="hfname">
</form>
<div class="pop-address-search" style="width: 100%;" >
	<div class="pop-address-search-inner" style="border: 0px;">
		<div style="height: 50px;" id="searchContentBox">
			<fieldset>
				<legend>시설명 검색</legend>		
				<span class="wrap">
					<input type="text" class="popSearchInput" style="font-size: 13px; font-weight: bold; ime-mode:active; " title="검색어를 입력하세요" name="keyword" id="keyword" placeholder="시설 이름으로 검색해주세요.." value=""  tabindex="1"/>
					<input type="button" id="searchFit" title="검색"  tabindex="2" style="margin-left:2px; cursor: pointer;"/>
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
		<c:forEach var="data" items="${LIST}" varStatus="st">
			<div class="w3-col w3-padding-16 w3-border-bottom content" id="${data.fno}">
				<form id="frm">
					<input  type="hidden" name="fitno" id="fitno" value="${data.fno}">
					<input type="hidden" name="fitname" id="fitname" value="${data.fname}">
				</form>
				<div class="w3-col s2" style="display: inline-block ;">
				<p>${st.index}</p>
				</div>
				<div class="w3-col s8 w3-center" style="display: inline-block ;">
					<p>${data.fname}</p>
					<p>${data.addr2}</p>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		$('#searchFit').click(function(){
			var key = $('#keyword').val();
			$('#hfname').val(key);
			$('#fitPopS').attr('action','/Alice/member/signUp/fitPopProc.do');
			$('#fitPopS').submit();
		});
		$('.content').click(function(){
			var fitnumber = $('.content').attr('id');
			var fitname = $('#fitname').val();
			alert('fitname :' + fitname);
			if(!fitnumber){
				alert('심각한 오류가 발생했습니다.');
				return;			
			}
			window.opener.fitInfo(fitnumber,fitname);
			window.close();
		});
		$('#closeBtn').click(function(){
			$(this).attr('href',popClose());
		});
	});
	function popClose(){
		window.close();
	}
</script>
</html>