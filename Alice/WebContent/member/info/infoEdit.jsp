<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Alice/css/infoEdit.css">
<link rel="stylesheet" href="/Alice/css/user.css">
<link rel="stylesheet" href="/Alice/css/w3.css">
<script type="text/javascript" src="/Alice/js/jquery-3.5.0.min.js"></script>
<script type="text/javascript" src="/Alice/js/member/info.js"></script>
<style>

</style>
<script type="text/javascript">

</script>
</head>
<body>
	<form method="POST" id="tfrm">
		<input type="hidden" name="mail" id="mail">	
		<input type="hidden" name="file" id="file">	
		<input type="hidden" name="addr1" id="addr1">	
		<input type="hidden" name="addr2" id="addr2">	
		<input type="hidden" name="addr3" id="addr3">	
		<!-- 일반회원일 경우 -->
		<input type="hidden" name="goal" id="goal">
		<input type="hidden" name="agree" id="agree">
		<input type="hidden" name="weight" id="weight">
		<input type="hidden" name="height" id="height">
		<input type="hidden" name="ptime" id="ptime">
		<!-- 트레이너 일 경우 -->
		<input type="hidden" name="career" id="career">
		<input type="hidden" name="info" id="info">
		<input type="hidden" name="fit" id="fit">
		<!-- 시설 회원의 경우 -->
		<input type="hidden" name="fname" id="fname"/>
		<input type="hidden" name="tel" id="tel"/>
	</form>
		<header>
		<jsp:include page="../../frame/header.jsp"/>
	</header>
	<nav>
		<jsp:include page="../../frame/sideBar.jsp"/>
	</nav>
	<div class="w3-main " style="margin-left:250px; height:70%;">
		<!-- 마이페이지 프로필 영역 -->
		<div class="w3-col s3 w3-padding w3-border-right" style="height:100% ">
			<div class="">
				<div class="w3-row w3-padding ">
					<!-- 회원 프로필 사진 -->
					<img class="w3-round-xlarge"src="/Alice/img/noimage.jpg" alt="회원 아아디" width="140" height="auto">
				</div>
				<div class="w3-row w3-center">
					<h6><!-- 회원이름 --><small>님</small><br><small><!-- 회원아이디 --></small></h6>			
				</div>			
			</div>				
		</div>
		<!-- 마이페이지 버튼 영역 -->
		<div class="w3-col s9 " >
			<ul class="w3-col s10 w3-center w3-border-bottom " id="movebtn"> 
				<li>
					<p class="w3-padding" id="infoEdit" ><small>회원 정보 수정</small></p>
				</li>
				<li>
					<p class="w3-padding" id="pwEdit" ><small>비밀번호 재설정</small></p>
				</li>
				<li>
					<p class="w3-padding" id="contactList" ><small>컨택 리스트</small></p>
				</li>
			</ul>
			<!-- 마이페이지 컨탠츠 영역 -->
			<div class="w3-margin-top w3-margin-left w3-row">
				<div class="w3-col s6 ">
					<div class="w3-col s2 w3-right-align">
						<label class="va-middle" for="tmail"><small>이메일 : </small></label>					
					</div>
					<div class="w3-col s8">
						<input class="w3-col  w3-margin-left w3-input " type="text" id="tmail"/>
					</div>
				</div>
				<div class="w3-col s6 pdtb1-10">
					<div class="w3-col s2 w3-right-align">
						<label class="av-middle"><small>프로필 : </small></label>					
					</div>
					<div class="w3-col s9">
						<img src="/Alice/img/noimage.jpg" alt="프로필" class="w3-margin-left profile">						
						<div class="w3-col s10 w3-margin-left">
							<input class="w3-col s10 w3-margin-left " type="file" value="" >
						</div>
					</div>
				</div>
				<div class="w3-col s6 pdtb-10 addrPosi">
					<div class="w3-col s2 w3-right-align">
						<label class="w3-col " for="abtn"><small>주소 : </small></label>					
					</div>
					<div class="w3-col s10">
						<input class="w3-col s5 w3-margin-left w3-input " type="text" id="zipno" readonly/>
						<div class="w3-button s7 w3-margin-left w3-red w3-round-xxlarge " id="addrbtn">주소 검색</div>
						<input class="w3-col s9 w3-margin-left w3-input " type="text"  id="roadAddrPart1"  readonly/>					
						<input class="w3-col s9 w3-margin-left w3-input " type="text"  id="addedAddr" readonly/>
					
					</div>
				</div>
				<!-- 일반 회원일 경우  -->
				<div class="w3-col s7 pdtb-10">
					<div class="w3-col s2 w3-right-align">
						<label class="w3-col " for="goal"><small>목 표 : </small></label>	
					</div>
					<div class="w3-col s8">
						<textarea class="w3-col w3-input w3-margin-left w3-border" rows="5" cols="39" id="tgoal" style="resize:none;"> </textarea>
					</div>
				</div>
				<div class="w3-col s4 pdtb-10">
					<div class="w3-col s5"> 
						<label class="w3-col w3-right-align " for="tagree"><small>P T 요청 여부 : </small></label>
						<label class="w3-col w3-right-align w3-margin-top " for="tbody"><small>체형 : </small><br><small>(kg),(cm)</small></label>
						<label class="w3-col w3-right-align w3-margin-top " for="ttime"><small>P T 희망 시간 : </small><br><small>(이후)</small></label>
					</div>
					<div class="w3-col s7">
						<input class="w3-col s7 w3-left-align w3-margin-left w3-check w3-margin-bottom" type="checkbox" value="Y" id="tagree">
						<input class="w3-col s4 w3-margin-left w3-input "type="text" id="tweight">
						<input class="w3-col s4 w3-margin-left w3-input w3-margin-bottom "type="text" id="theight">
						<input class="w3-margin-left w3-input w3-margin-top " type="time" id="ttime" >
					</div>
				</div>
				<!-- 트레이너일 경우 -->
				<div>
					<div class="w3-col s7 pdtb-10">
						<div class="w3-col s2">
							<label class="w3-col w3-right-align"><small>소 개 글 : </small></label>						
						</div>
						<div class="w3-col s7">
							<textarea class="w3-col w3-margin-left w3-border w3-input" rows="5" cols="37" id="tinfo" style="resize:none;"></textarea>
						</div>
					</div>
					<div class="w3-col s4 pdtb-10">
						<div class="w3-col s2">
							<label class="w3-col w3-right-align"><small>경력 : </small></label>						
						</div>
						<div class="w3-col s7">
							<textarea class="w3-col w3-margin-left w3-border w3-input" rows="5" cols="37" id="tcareer" style="resize:none;"></textarea>
						</div>
					</div>
					<div class="w3-col s6 pdtb-10" >
						<div class="w3-col s2">
							<label class="w3-col w3-right-align" for="fit" ><small class="w3-text-grey" >소속 시설 : </small></label>
						</div>
						<div class="w3-col s8 ">
							<input class="w3-col s4 w3-margin-left w3-input w3-boarder-bottom" type="text" readonly name="fname" style=" border: 0px; ">
							<div class="w3-button w3-red w3-round-xxlarge w3-gray w3-text-light-blue" id="fitinfo">시설 검색</div>					
							<input type="hidden" name="fno" id="fno" value="">
						</div>
					</div>
				</div>
					<!-- 시설 회원의 경우 -->
				<div>	
					<div class="w3-col s6 pdtb-10 ">
						<div class="w3-col s3">
							<label class="w3-col w3-right-align" for="fname"><small class="w3-text-grey">시설명 : </small></label>						
						</div>
						<div class="w3-col s7 ">
							<input class=" w3-input w3-margin-left" type="text" id="tfname" name="tfname" style="border: 0px;">			
						</div>
					</div>
					<div class="w3-col ">
						<label class="w3-col m3 w3-right-align" for="fname"><small class="w3-text-grey">시설 전화번호 : </small></label>
						<div class="w3-rest lblock w3-padding ">
							<input class="w3-padding w3-border-gray w3-border-bottom" id="ttel" name="ttel" style="border: 0px;">			
						</div>
					</div>
				</div>
			</div>
			<!-- 버튼 영역 -->
			<div class="w3-right-align">
				<div class="w3-button w3-theme-l2" id="" >저장하기</div>
				<div class="w3-button w3-red" id="" >탈퇴하기</div>
			</div>
		</div>
	</div>
	
</body>
</html>