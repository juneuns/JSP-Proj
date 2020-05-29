
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/Alice/css/w3.css">
<script type="text/javascript" src="/Alice/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Alice/js/centerBoard/centerBoardNotice.js?v=<%=System.currentTimeMillis() %>"></script>
<title>Insert title here</title>
<style>
	.fnt1{
		font-weight:bold;
		color:gray;
	}
	.d-menu:hover{
		background-color:white!important;
		color:black;
		border-bottom: 3px solid black;
	}
	.d2:hover{
		background-color:white!important;
	}
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
	.d-menubox{
		width:948px; 
		height: 48px;
		position:fixed; 
		background-color:white;
	}
	textarea:focus {
  		outline: none;
	}
	.btn{
	}
	.btn:hover{
		background-color:white!important;
		border-right: 1px solid lightgray;
		border-bottom: 1px solid lightgray;
		padding-bottom: 7px;
		padding-right: 15px;
	}
	.ntxt{
		border-radius:20px; 
		border:0.5px solid lightgray;
		padding:10px;
		resize: none;
		width:908px; 
		min-height:80px;
		margin:10px;
		display:inline-block;
		overflow-y:hidden;
	}
	.rtxt{
		border-radius:20px; 
		padding:10px;
		resize: none;
		width:848px; 
		min-height:80px;
		margin:10px;
		margin-left:50px;
		display:inline-block;
		border:0.5px solid lightgray;
		overflow-y:hidden;
	}
	.rplbody{
		display:inlin-block;
		width:800px;
		margin-top:5px;
		float:left;
		border-radius:20px;
		background-color:#f1f1f5;
	}
</style>
<script type="text/javascript">

</script>
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
				<input type="hidden" id="fno" name="fno" value="${fno}">
			</form>
			<input type="hidden" id="sfno" name="sfno" value="${sfno}">
		</div>

		<div style="width:948px;display: inline-block; ">
			<div style="width: 948px;background-color: #f1f1f1; display: inline-block;  margin-top:50px;">
				<div class="d4"style="width:928px; margin: 10px; background-color:white;display:inline-block">
					<div style="width:350px; height:60px; display:inline-block">
						<div style="width:60px; height:60px; display:inline-block; object:fill; border-radius:100%; float:left">
							<img style=" margin:10px;width:40px;height:40px;object:fill;border-radius:100%"src="/Alice/img/ronnie_coleman2.jpg"/>
						</div>
						<div id=""class="d2 w3-button" style=" display:inline-block; padding-left:0px;margin-top:15px;float:left; line-height:100%">
							<h style="font-size:12pt;font-weight:bold;color:gray">지금 무슨 공지를 하고싶은가요?</h>							
						</div>
					</div>
				</div>
				<div class="d3"style="width:928px; margin: 10px; background-color:white;display:inline-block">
					<div style="width:240px; height:60px; display:inline-block">
						<div style="width:60px; height:60px; display:inline-block; object:fill; border-radius:100%; float:left">
							<img style=" margin:10px;width:40px;height:40px;object:fill;border-radius:100%"src="/Alice/img/ronnie_coleman2.jpg"/>
						</div>
						<div style=" display:inline-block;margin-top:20px; float:left; line-height:100%">
							<h style="font-size:12pt;font-weight:bold;">${cvo.fname} ${cvo.foname}관장님</h>							
						</div>
					</div>
					<form method="post" class="frm" action="/Alice/centerBoardNoticeWrite.do">
						<input type="hidden" id="" name="fno"value="${cvo.fno}">
						<textarea class="ntxt" id="" name="body"></textarea>
					</form>
					<div id=""class="cbtn w3-button w3-right btn" style="font-weight:bold;margin:10px;margin-top:0px;display:inline-block">취소</div>
					<div id=""class="wbtn w3-button w3-right btn" style="font-weight:bold;margin:10px;margin-top:0px;display:inline-block">게시</div>
				</div>
				
				<!-- notice div 시작 -->
				<c:forEach var="vo" items="${NLIST}">
				<div class="notice" style="width:928px; margin: 10px; background-color:white;display:inline-block">
						<div style="width:240px; height:60px; display:inline-block">
							<div style="width:60px; height:60px; display:inline-block; object:fill; border-radius:100%; float:left">
								<img style=" margin:10px;width:40px;height:40px;object:fill;border-radius:100%"src="/Alice/img/ronnie_coleman2.jpg"/>
							</div>
							<div style=" display:inline-block;margin-top:15px; float:left; line-height:100%">
								<h style="font-size:12pt;font-weight:bold;">${vo.fname} ${vo.foname}관장님
								</h><br>
								<h style="font-size:8pt; color:gray;margin-top:0px;">${vo.sDate} ${vo.edit}</h>
							</div>
						</div>
						<div class="nbody"style="width:900px;margin:15px;display:inline-block; font-size:12pt;">${vo.body}</div>
						<div id=""class="lbtn w3-button w3-left btn" style="margin-left:10px;margin-bottom:10px;font-size:9pt;font-weight:bold;display:inline-block">좋아요</div>
						<div id=""class="rbtn w3-button w3-left btn" style="margin-left:10px;margin-bottom:10px;font-size:9pt;font-weight:bold;display:inline-block">댓글 보기</div>
						<!-- delete form 시작 -->
						<div id="dbtn"class="w3-button w3-right btn dbtn" style="margin-right:10px;margin-bottom:10px;font-size:9pt;font-weight:bold;display:inline-block">삭제
							<form method="post" id="" class="del" action="/Alice/centerBoardNoticeDelete.do">
								<input type="hidden" class="bno" name="bno"value="${vo.bno}">
							</form>
						</div>
						<!-- delete form 끝 -->
						<div id=""class="esbtn w3-button w3-right btn" style="margin-right:10px;margin-bottom:10px;font-size:9pt;font-weight:bold;display:inline-block">수정</div>
						<div id=""class="ebtn w3-button w3-right btn" style="margin-right:10px;margin-bottom:10px;font-size:9pt;font-weight:bold;display:inline-block">수정</div>

						<!-- edit div 시작 -->
						<form method="post" id="" class="edtfrm ebody" action="/Alice/centerBoardNoticeEdit.do">
							<input type="hidden" id="" name="bno"value="${vo.bno}">
							<textarea class="ntxt"  name="ebody">${vo.body}</textarea>						
						</form>
						<!-- edit div 끝 -->
						<!-- reply box div 시작 -->
<%-- 						<c:forEach var="rvo" items="${RELIST}">
						</c:forEach>
 --%>					<div class="rbox"style="border-top: 1px dashed lightgray;width:898px; margin: 10px; background-color:white;display:inline-block">
							<div style="width:890px;display:inline-block">
								<div style="width:60px; height:60px; display:inline-block; object:fill; border-radius:100%; float:left">
									<img style=" margin:10px;width:40px;height:40px;object:fill;border-radius:100%"src="/Alice/img/ronnie_coleman2.jpg"/>
								</div>
								<div style="display:inline-block;margin-top:10px; float:left; line-height:100%;">
									<h style="font-size:12pt;font-weight:bold;">${vo.fname} ${vo.foname}</h>
									<h style="font-size:8pt; color:gray;">${rvo.sDate} ${rvo.edit}</h>			
								</div>
								<div class="rplbody"style="padding:10px;">${rvo.rebody}댓글 상자</div>
							</div>
						</div>
						<!-- reply box div 끝 -->
						<!-- rewrite div 시작 -->
						<div class="rwbox"style="border-top: 1px dashed lightgray;width:908px; margin: 10px; background-color:white;display:inline-block">
							<div style="width:240px; height:60px; display:inline-block">
								<div style="width:60px; height:60px; display:inline-block; object:fill; border-radius:100%; float:left">
									<img style=" margin:10px;width:40px;height:40px;object:fill;border-radius:100%"src="/Alice/img/ronnie_coleman2.jpg"/>
								</div>
								<div style=" display:inline-block;margin-top:20px; float:left; line-height:100%">
									<h style="font-size:12pt;font-weight:bold;">${vo.fname} ${vo.foname} </h>							
								</div>
							</div>
							<form method="post" id="" class="rplfrm rebody" action="/Alice/centerBoardReplyWrite.do">
								<input type="hidden" id="" name="rno" value="0">
								<input type="hidden" id="" name="fno" value="${vo.fno}">
								<input type="hidden" id="" name="bno" value="${vo.bno}">
								<textarea name="rebody" class="rtxt"></textarea>
							</form>
							<div id=""class="rcbtn w3-button w3-right btn" style="font-weight:bold;font-size:10pt;display:inline-block">취소</div>
							<div id=""class="rwbtn w3-button w3-right btn" style="font-weight:bold;font-size:10pt;display:inline-block">댓글달기</div>
						</div>
						<!-- rewrite div 끝 -->									
				</div>
				</c:forEach>
				<!-- notice div 끝 -->
			</div>
		</div>
	</div>
</body>
</html>