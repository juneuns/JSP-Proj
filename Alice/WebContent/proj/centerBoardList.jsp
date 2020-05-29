<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/Alice/css/w3.css">
<script type="text/javascript" src="/Alice/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Alice/js/centerBoard/centerBoardList.js?v=<%=System.currentTimeMillis() %>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	.d-menu{
		width: 236.5px; 
		height: 100%;
		font-weight:bold;
		font-size:13pt;
		color:gray; 
		float:left;
		padding-top:15px;
		text-align:center; 
	}
	.d-menu:hover{
		background-color:white!important;
		color:black;
		border-bottom: 3px solid black;
	}
	.d-menubox{
		width:948px; 
		height: 48px;
		position:fixed; 
		background-color:white;
	}
</style>
</head>
<body>
	<div style="  width: 950px; margin-top:100px;">
		<div class="d-menubox" >
			<div style="width:950px;display:inline-block;background-color:#f1f1f1;">
				<div style="width:780px;margin-left:85px;margin-right:85px;display:inline-block;">
					<c:forEach var="cvo" items="${LIST}">
					<div>
						<div class="w3-button bbtn"style="width: 350px; display:inline-block;margin:20px; background-color:white;float:right">
							<h>시설이름 : ${cvo.fname}</h><br>
						</div>
						<form class="fnofrm"style="diplay:hidden" method="post" action="/Alice/centerBoardMain.do">
							<input type="hidden" name="fno" value="${cvo.fno}"/>
						</form>
					</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>