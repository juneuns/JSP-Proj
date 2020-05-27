
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
	
	// 비밀번호 정규식      
	var pwReg = /(?=.*\d{1})(?=.*[~`!@#$%\^&*()-+=]{1})(?=.*[a-zA-Z]{2}).{8,15}$/;
	if(! pwReg.test($('#pw').val() )){
		alert("비밀번호 형식을 확인해주세요.");
		$('#pw').focus();
		return;
	}
};
$(document).ready(function(){
	$('#moveMainbtn').click(function(){
		$(location).attr('href','/Alice/main/main.do');
	});
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
	// 시설 찾기 전담함수 
	
	
	
	// 회원가입 동의 페이지 함수 
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
	// 회원 종류별 회원가입 처리 요청 전담 함수 
	
});
// 주소창 정보 담는 함수 
function josoCallBack(roadAddrPart1,zipno){
	document.getElementById('roadAddrPart1').value=roadAddrPart1;
	document.getElementById('zipno').value=zipno;
}
function fitInfo(fitnumber, fitname){
	$('#fno1').val(fitnumber);
	$('#fname1').val(fitname);
}
