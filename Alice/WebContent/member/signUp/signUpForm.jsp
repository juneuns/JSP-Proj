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
body {
	font-family: "Montserrat", sans-serif;
}
.min-heignt {
	min-height:1000px;
}
.member_agree ul li {
    display: block;
    float: left;
    width: 115px;
    height: 87px;
    margin-right: 12px;
}
.iblock{
	display:inline-block;
}
.hidden-msg{
	font-size : 8pt;
}
.height80 {
	height: 80px;
}
</style>
<script type="text/javascript">
	// 기본 정보 유효성 검사 처리 전담 함수 
	var validCk = function(){
		if ($('#id').val()==""){
			alert("아이디를 입력해 주세요.");
			$('#id').focus();
			return;
		}
		if ($('#pw').val()==""){
			alert("비밀번호를 입력해 주세요.");
			$('#pw').focus();
			return;
		}
		if ($('#repw').val()==""){
			alert("비밀번호 재입력을 입력해 주세요.");
			$('#repw').focus();
			return;
		}
		if ($('#name').val()==""){
			alert("이름을 입력해 주세요.");
			$('#name').focus();
			return;
		}
		if ($('#mail').val()==""){
			alert("이메일을 입력해 주세요.");
			$('#mail').focus();
			return;
		}
		if ($('#zipno').val()==""){
			alert("주소를 입력해 주세요.");
			$('#zipno').focus();
			return;
		}
	}
	// 전화번호 정규식 
	var telCK = function(){
		var telReg = /^[0-9]{0,18}$/;
		if( !telReg.test($('#tel').val())){
			alert('전화번호 형식을 확인하세요. ');
			$('#tel').val('');
			$('#tel').focus();
			return ; 
		}
	}
	var regCK = function(){
		var idReg = /^.[A-za-z0-9]{8,13}/g;
		if( !idReg.test( $("#id").val() ) ) {
            alert("아이디는 영문자로 시작하는 8~13자 영문자 또는 숫자이어야 합니다.");
            $("#id").focus()
            return;
        }
		// 이름 정규식 
		var nameReg = /^[가-힣]{1,5}$/;
		if( !nameReg.test( $("#name").val() ) ) {
            alert("이름는 5글자의 한글이여야 합니다.");
            $("#name").focus()
            return;
        }
		// 이메일 정규식
		var mailReg =  /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;
		if( !mailReg.test( $("#mail").val() ) ) {
            alert("이메일 형식을 확인해주세요.");
            $("#mail").focus();
            return;
        }
	};
	$(document).ready(function(){
		// 주소 팝업 창 요청 
		$('#abtn').click(function(){
			window.open('/Alice/member/addrPop.do','addr','width=500,height=400,resizealbe=yes');
		});
		// 시설 검색 팝업 창 요청
		$('#fitinfo').click(function(){
			window.open('/Alice/member/signUp/fitPop.jsp','fitPop','width=500,height=400,resizealbe=yes');
		});
		// 회원 종류가 일반일 때 입력 창 제공
		$('#addinfo').click(function(){
			var vailed = $('.type').attr('id');
			alert(vailed);
			if(!vailed){
				return ;
			}
			$('#worker').toggleClass('w3-hide');
			
		});
		
		// 회원 종류별 회원가입 처리 요청 전담 함수 
		$('#next').click(function(){
			var type = '${param.type}';
			
			// 입력란 유효성 검사
			validCk();
			// 정규식 
			regCK();
			
			if(type == 'worker'){
				var bodyHReg = /^[0-9]$/;
				if(!bodyHReg.test($('#height').val())){
					alert('숫자만 입력해주세요..');
					$('#height').focus();
					return
				}
				var bodyWReg = /^[0-9]$/;
				if(!bodyHReg.test($('#weight').val())){
					alert('숫자만 입력해주세요..');
					$('#weight').focus();
					return
				}
				$('#frm').attr('action','/Alice/...');
				$('#frm').submit();
				return ;
			}
			
			if(type == 'trainer'){
				// 파일 업로드 형식 정규식
				$('#file').change(function(e) {
					var form = $(this).val();
					var check = form.slice(form.lastIndexOf('.') + 1);
					check = check.toLowerCase(check);
	
					if (check != 'png' && check != 'jpg' && check != 'jpeg' && check != 'gif') {
						alert('파일형식을 확인하세요..');
						$(this).val('');
						return;
					}
					var vfile = URL.createObjectURL(e.target.files[0]); // 배열로 저장하고 있다가 선택한 파일은
																		// 0번째 이기때문
				});
				
				telCK();
				$('#frm').attr('action','/Alice/...');
				$('#frm').submit();
				return ;
			}
			if(type == 'fit'){
				
				telCK();
				$('#frm').attr('action','/Alice/...');
				$('#frm').submit();
				return ;
			}
		});
		
	
		
	});
	
	
	// 주소창 정보 담는 함수 
	function josoCallBack(roadAddrPart1,zipno){
		document.getElementById('roadAddrPart1').value=roadAddrPart1;
		document.getElementById('zipno').value=zipno;
	}
	function fitInfo(fitnumber, fitname){
		document.getElementById('fno').value = fitnumber;
		document.getElementById('fname').value = fitname;
	}
</script>
</head>
<body>
	<div class="w3-content mxw min-heignt ">
		<div class="w3-col w3-border-bottom w3-border-gray">
			<h4 class="w3-margin-left"> 회원가입</h4>
		</div>
		<div class="w3-col w3-margin-top member_agree ">
			<ul>
				<li>				
					<img alt="약관동의" src="/Alice/img/step1.png">
				</li>
				<li>
					<img alt="약관동의" src="/Alice/img/step2_on.png">
				</li>
				<li>
					<img alt="약관동의" src="/Alice/img/step3.png">
				</li>
			</ul>
		</div>
		<div class="w3-col">
			<h4 class="w3-left-align w3-row w3-text-grey" style="display:inline-block; position:relative;left:130px;">정보입력</h4>
		</div>
		<form class="w3-col w3-margin-top w3-padding" method="POST" >
			<input type="hidden" name="type" id="rtype" value="">
			<div class="w3-row">
				<label class="w3-col m3 w3-right-align" for= "id" ><h4 class="w3-text-grey" >아이디 : </h4></label>
				<div class="w3-rest w3-padding iblock">
					<input class="w3-padding w3-border-gray w3-border-bottom "style="height:30px; border:0px;"type="text" name="id" id="id" />
					<div class="w3-button w3-red w3-round-xxlarge" >중복 확인</div>
					<div class="w3-block hidden-msg">영문자 숫자 조합의 8 ~ 13자리</div>
					<div class="w3-block hidden-msg w3-margin-top" id="idck">사용 가능한 아이디 입니다.</div>
				</div>
			</div>
			<div class="w3-row">
				<label class="w3-col m3 w3-right-align" for= "pw" ><h4 class="w3-text-grey" >비밀번호 : </h4></label>
				<div class="w3-rest w3-padding iblock">
					<input class="w3-padding w3-border-gray w3-border-bottom " type="password" style="height:30px; border:0px;" name="pw" id="pw" value=""/>
					<div class="w3-block hidden-msg " id="idck">8 ~ 20 자리의 영문 대소문자 조합과 최소 1개의 숫자 혹은 특수 문자를 포함 </div>
				</div>
			</div>
			<div class="w3-row">
				<label class="w3-col m3 w3-right-align" for="repw" ><h4 class="w3-text-grey" >비밀번호 재입력 : </h4></label>
				<div class="w3-rest w3-padding iblock">
					<input class="w3-padding w3-border-gray w3-border-bottom " type="password" style="height:30px; border:0px;" name="repw" id="repw" value=""/>
					<div class="w3-block hidden-msg " id="idck">비밀번호가 일치합니다.</div>
				</div>
			</div>
			<div class="w3-row">
				<label class="w3-col m3 w3-right-align" for="name" ><h4 class="w3-text-grey" >이 름 : </h4></label>
				<div class="w3-rest w3-padding iblock">
					<input class="w3-padding w3-border-gray w3-border-bottom "style="height:30px; border:0px;"type="text"  name="name" id="name" value=""/>
				</div>
			</div>
			<div class="w3-row">
				<label class="w3-col m3 w3-right-align" for="mail" ><h4 class="w3-text-grey" >이메일 : </h4></label>
				<div class="w3-rest w3-padding iblock">
					<input class="w3-padding w3-border-gray w3-border-bottom "style="height:30px; border:0px;"type="text"  name="mail" id="mail" value=""/>
				</div>
			</div>
			<div class="w3-row">
				<label class="w3-col m3 w3-right-align" for="mail" ><h4 class="w3-text-grey" >주소 : </h4></label>
				<div class="w3-rest w3-padding iblock">
					<input class="w3-padding w3-border-gray w3-border-bottom" type="text" name="addr1" id="zipno" value="" readonly style="height:30px; border:0px;"  />
					<div class="w3-button w3-red w3-round-xxlarge " id="addrbtn">주소 검색</div>					
					<input class="w3-padding w3-border-gray w3-border-bottom w3-block" type="text" name="addr2"id="roadAddrPart1" readonly value="" style="height:30px; border:0px;"   />
					<input class="w3-padding w3-border-gray w3-border-bottom w3-block" type="text" name="addr3"id="" readonly value="" style="height:30px; border:0px;"   />
				</div>
			</div>
			<c:if test="${param.type eq 'worker'}">
				<h4 class=" w3-text-gray w3-button" id="addinfo">부가 정보</h4>
			</c:if>
			<c:if test="${param.type eq 'worker'}">
				<div class="w3-row w3-card type w3-hide" id="${param.type}" >
					<div class="iblock w3-border">
					</div>
					<div class="w3-row">
						<div class="w3-row w3-margin-0">
							<label class="w3-col m3 w3-right-align"><h4 class="w3-text-gray iblock">체 형 : </h4></label>
							<div class="w3-rest w3-padding iblock">
								<input class="w3-padding w3-border-gray w3-border-bottom" type="text" name="height" id="height" style="width:60px; height:30px; border:0px;"> kg
								<input class="w3-padding w3-border-gray w3-border-bottom" type="text" name="weight" id="weight" style="width:60px; height:30px; border:0px;"> cm
							</div>				
						</div>
					</div>
					<div class="w3-row">
						<div class="w3-row w3-margin-0">
							<label class="w3-col m3 w3-right-align"><h4 class="w3-text-gray iblock">목 표 : </h4></label>
							<div class="w3-rest w3-padding iblock">
								<textarea class="w3-padding w3-border-gray w3-border-bottom" rows="10" cols="36" name="goal" id="goal" style="resize:none;"></textarea>
							</div>				
						</div>
					</div>
					<div class="w3-row">
						<div class="w3-row w3-margin-0">
							<label class="w3-col m3 w3-right-align"><h4 class="w3-text-gray iblock">P T 요청 여부 : </h4></label>
							<div class="w3-rest w3-padding iblock">
								<input class="w3-padding w3-border-gray w3-border-bottom" type="checkbox" style="width:60px; height:30px; border:0px;">
							</div>				
						</div>
					</div>
					<div class="w3-row">
						<div class="w3-row w3-margin-0">
							<label class="w3-col m3 w3-right-align"><h4 class="w3-text-gray iblock">P T 가능 시간 : </h4></label>
							<div class="w3-rest w3-padding iblock">
								<input class="w3-padding w3-border-gray w3-border-bottom" type="time" style="height:30px; border:0px;">
							</div>				
						</div>
					</div>
				</div>
			</c:if>
		<c:if test="${param.type eq 'trainer'}">
			<div class="w3-row" >
				<label class="w3-col m3 w3-right-align" for="career" ><h4 class="w3-text-grey" >경 력 : </h4></label>
				<div class="w3-rest w3-padding iblock">
					<textarea class="w3-padding w3-border-gray w3-border-bottom" name="career" rows="3" cols="36"  style=" border: 0px; resize:none;"></textarea>
				</div>
			</div>
			<div class="w3-row" >
				<label class="w3-col m3 w3-right-align" for="info" ><h4 class="w3-text-grey" >소개글 : </h4></label>
				<div class="w3-rest w3-padding iblock">
					<textarea class="w3-padding w3-border-gray w3-border-bottom" name="info" rows="7" cols="36"  style=" border: 0px; resize:none;" placeholder="간단히 자신을 소개하세요.."></textarea>
				</div>
			</div>			
			<div class="w3-row" >
				<label class="w3-col m3 w3-right-align" for="file" ><h4 class="w3-text-grey" >프 로 필 : </h4></label>
				<div class="w3-rest w3-padding iblock">
					<input class="w3-padding w3-border-gray w3-border-bottom" type="file" name="file" style=" border: 0px; ">
				</div>
			</div>
			<div class="w3-row" >
				<label class="w3-col m3 w3-right-align" for="file" ><h4 class="w3-text-grey" >전화번호 : </h4></label>
				<div class="w3-rest w3-padding iblock">
					<input class="w3-padding w3-border-gray w3-border-bottom" type="tel" name="tel" style=" border: 0px; " placeholder="'-'를빼고 입력해주세요. ">
				</div>
			</div>
			<div class="w3-row" >
				<label class="w3-col m3 w3-right-align" for="fit" ><h4 class="w3-text-grey" >소속 시설 : </h4></label>
				<div class="w3-rest w3-padding iblock">
					<input class="w3-padding w3-border-gray w3-border-bottom" type="text" readonly name="fname" style=" border: 0px; ">
					<div class="w3-button w3-red w3-round-xxlarge w3-gray w3-text-light-blue" id="fitinfo">시설 검색</div>					
					<input type="hidden" name="fno" id="fno" value="">
				</div>
			</div>
		</c:if>
		<c:if test="${param.type eq 'fit'}">
			<div class="w3-row">
				<label class="w3-col m3 w3-right-align" for="fname"><h4 class="w3-text-grey">시설명 : </h4></label>
				<div class="w3-rest lblock w3-padding ">
					<input class="w3-padding w3-border-gray w3-border-bottom" id="fname" name="fname" style="border: 0px;">			
				</div>
			</div>
			<div class="w3-row">
				<label class="w3-col m3 w3-right-align" for="fname"><h4 class="w3-text-grey">시설 전화번호 : </h4></label>
				<div class="w3-rest lblock w3-padding ">
					<input class="w3-padding w3-border-gray w3-border-bottom" id="tel" name="tel" style="border: 0px;">			
				</div>
			</div>
		</c:if>
		</form>
		<div class="w3-right-align">
			<div class="w3-button w3-gray">뒤로가기</div>
			<div class="w3-button w3-orange" id="next">다음단계</div>
		</div>
	</div>
</body>
</html>