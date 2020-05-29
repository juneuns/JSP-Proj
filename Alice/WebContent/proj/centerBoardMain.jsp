<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/Alice/css/w3.css">
<script type="text/javascript" src="/Alice/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Alice/js/centerBoard/centerBoardMain.js?v=<%=System.currentTimeMillis() %>"></script>
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
	.btn{
	}
	.btn:hover{
		background-color:rgba(255,255,255,0)!important;
	}
	.hidden{
	display:none;
	}
</style>
</head>
<body>
	<div style="  width: 950px; margin-top:100px;">
		<div class="d-menubox" >

			<div id="cent"class="w3-button d-menu">
				시설 소개
			</div>
			<div id="ntc"class="w3-button d-menu">
				공지사항
			</div>
			<div id="song"class="w3-button d-menu">
				신청곡
			</div>
			<div id="train"class="w3-button d-menu">
				트레이너 소개
			</div>
			<form style="display:none" method="post" class="fnofrm">
				<input type="hidden" name="fno" value="${fno}">
			</form>
			<div style="width:950px;display:inline-block">
				<div class="dbox" name="div1" style="background-size:cover;background-image:url('/Alice/img/${ivo1.savename}'); object:fill; width:650px; height:650px;border: 1px solid lightgray;display:inline-block;float:left;text-align:center">
					<div class="w3-button btn dbtn" style="width:648px; height:648px;display:inline-block;">
						<h style="text-align:center; font-size:15pt; color:lightgray;;position:relative; top:48%">JoJim. corporation.</h>
					</div>
					<form class="w3-row w3-margin-top w3-grayscale hidden imgfrm"
							encType="multipart/form-data" id="frmw" name="frmw" method="post" action="/Alice/centerBoardMainWrite.do">
						<input type="hidden" class="divno" name="divno" value="1"/>
						<input type="hidden" class="fno"name="fno" value="${fno}"/>
						<input type="file" class="file hidden" name="file"/>
					</form>
				</div>
				<div class="dbox" name="div2" style="background-size:cover;background-image:url('/Alice/img/${ivo2.savename}'); object:fill; width:296px; height:325px;border: 1px solid lightgray;display:inline-block;float:left;text-align:center">
					<div class="w3-button btn dbtn" style="width:294px; height:323px;display:inline-block;">
						<h style="text-align:center; font-size:12t; color:lightgray;;position:relative; top:48%">JoJim. corporation.</h>
					</div>
					<form class="w3-row w3-margin-top w3-grayscale hidden imgfrm"
							encType="multipart/form-data" id="frmw" name="frmw" method="post" action="/Alice/centerBoardMainWrite.do">
						<input type="hidden" class="divno" name="divno" value="2"/>
						<input type="hidden" class="fno"name="fno" value="${fno}"/>
						<input type="file" class="file hidden" name="file"/>
					</form>
				</div>
				<div class="dbox" name="div3" style="background-size:cover;background-image:url('/Alice/img/${ivo3.savename}'); object:fill;width:296px; height:325px;border: 1px solid lightgray;display:inline-block;float:left;text-align:center">
					<div class="w3-button btn dbtn" style="width:294px; height:323px;display:inline-block;">
						<h style="text-align:center; font-size:12pt; color:lightgray;;position:relative; top:48%">JoJim. corporation.</h>
					</div>
					<form class="w3-row w3-margin-top w3-grayscale hidden imgfrm"
							encType="multipart/form-data" id="frmw" name="frmw" method="post" action="/Alice/centerBoardMainWrite.do">
						<input type="hidden" class="divno" name="divno" value="3"/>
						<input type="hidden" class="fno"name="fno" value="${fno}"/>
						<input type="file" class="file hidden" name="file"/>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>