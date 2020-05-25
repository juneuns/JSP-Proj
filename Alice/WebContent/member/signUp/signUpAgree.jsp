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
<link rel="stylesheet" href="/Alice/css/member/signUp.css">
<script type="text/javascript" src="/Alice/js/jquery-3.5.0.min.js"></script>
<style>

</style>
</head>
<body>
	<form action="" method="POST" id="frm">
		<input type="hidden" name="type" id="type" value="">
	</form>
	<div class="w3-content mxw min-heignt " >
		<div class="w3-col w3-border-bottom w3-border-gray">
			<h4 class="w3-margin-left" > 회원가입</h4>
		</div>
		<div class="w3-col w3-margin-top member_agree ">
			<ul>
				<li>				
					<img alt="약관동의" src="/Alice/img/step1_on.png">
				</li>
				<li>
					<img alt="약관동의" src="/Alice/img/step2.png">
				</li>
				<li>
					<img alt="약관동의" src="/Alice/img/step3.png">
				</li>
			</ul>
		</div>
		<div class="agree">
			<img alt="회원 약관 동의" src="/Alice/img/member_agree.png">
		</div>
		<h5 class="page-agree">
		[ JoGym 홈페이지 회원가입 이용 약관 ]
		</h5>
		<pre class="content-agree">
			아야야야야
		</pre>
		<div class="w3-right-align">
			<label class="">
				<input type="checkbox" id="agreeck1" value="Y" />
				이용약관에 동의합니다.
			</label>
		</div>
		<div class="w3-row">
				<div class="iblock">
					<h4 class=" page-agree">회원 유형 체크</h4>
				</div>
				<div class="w3-row w3-center">
					<label class="margin w3-text-gray" for="worker">일반</label>
					<label class="margin w3-text-gray" for="trainer">트레이너</label>
					<label class="margin w3-text-gray" for="fit">시설</label>
				</div>				
				<div class="w3-row w3-center height80">
					<input class="w3-radio margin2 ck" type="radio" name="type" id="worker" > 
					<input class="w3-radio margin2 ck" type="radio" name="type" id="trainer"  >
					<input class="w3-radio margin2 ck" type="radio" name="type" id="fit" >
				</div>
			</div>
		<!-- 버튼 영역 -->
		<div class="right-align w3-margin-top">
			<div class="w3-button w3-orange" id="agbtn">동의 합니다.</div>
			<div class="w3-margin-left w3-button w3-blue-grey" id="disbtn">동의하지 않습니다.</div>
		</div>
		
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		$('.ck').change(function(){
			var type = $(this).attr('id');
			alert(type);
			$('#type').val(type);
		});
		$('#agbtn').click(function(){
			if(!$('#agreeck1').is(':checked')) {
				alert("홈페이지 이용약관에 동의해 주세요.");
				return;
			}
			$('#frm').attr('action','/Alice/member/signUp/signUpForm.do');
			$('#frm').submit();
		});
	});	
</script>
</html>