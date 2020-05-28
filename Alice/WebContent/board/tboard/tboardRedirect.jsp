<!-- 해당 jsp는 redirect시 사라지는 게시글의 번호를 전달하기 위한 뷰 이다.
@author		주재석
@since		2020.05.27
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Relay</title>
<script type="text/javascript" src="/Alice/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Alice/js/board/boardRedirect.js"></script>
<script type="text/javascript">
</script>
<style>
</style>
</head>
<body>
	<form method="post" action="/Alice/tboard/tboardDetail.do" id="frm">
		<input type="hidden" name="bno" value="${BNO}">
		<input type="hidden" name="rno" value="${RNO}">
		<input type="hidden" name="sid" value="${SID}">
		<input type="hidden" name="nowPage" value="${nowPage}">
	</form>
</body>
</html>