<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Alice/css/w3.css">
<link rel="stylesheet" href="/Alice/css/user.css">
<script type="text/javascript" src="/Alice/js/jquery-3.5.0.min.js"></script>
<style>
</style>
<script type="text/javascript">
	$(document).ready(function(){
		var url = $(location).attr('href');
		var confmKey = '${CONFMKEY}';
		var resultType = 4;
		var inputYn ='${INPUTYN}';
		if(inputYn !='Y'){
			$('#confmKey').val(confmKey);
			$('#returnUrl').val(url);
			$('#resultType').val(resultType);
			$('#form').attr('action','http://www.juso.go.kr/addrlink/addrLinkUrl.do');
			$('#form').submit();
		}else{
			opener.josoCallBack('${ROADADDRPART1}','${ZIPNO}');
			window.close();
		}
	});
</script>
</head>
<body>
	<form method="POST" name="form"id="form" >
		<input type="hidden" id="confmKey" name="confmKey" value="">
		<input type="hidden" id="returnUrl" name="returnUrl" value="">
		<input type="hidden" id="resultType" name="resultType" value="">
	</form>
</body>
</html>