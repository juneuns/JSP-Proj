$(document).ready(function(){
	$('#logo').click(function(){
		$(location).attr('href','/Alice/main/main.do');
	});
	// 로그인 버튼 활성화
	$('#login').click(function(){
		$('#id01').css('display','block');
	});
	// 로그인 창 비활성화
	$('#cbtn').click(function(){
		$('#id01').css('display','none');
	});
	// 로그인 처리 요청 
	$('#lbtn').click(function(){
		var fit = $('#fbtn').is(':checked');
		alert(fit);
		if(fit){
			$('#fit').val('f');	// 시설관리자일 경우 'f' 데이터 파라미터로 넘기는 작업
			$('#frm').attr('action','/Alice/member/signIn/signInFProc.do');
		} else{
			$('#frm').attr('action','/Alice/member/signIn/signInUProc.do');			
		}
		$('#frm').submit(); 
	});
	// 로그아웃 처리 요청
	$('#logout').click(function(){
		location.href = "/Alice/member/logout/logoutProc.do";
	})
	// 회원가입 동의 페이지 요청 
	$('#signup').click(function(){
		$(this).attr('href','/Alice/member/signUp/signUpAgree.do');
	});
	// 아이디/ 비밀번호 찾기 페이지 요청
	$('#findPWbtn').click(function(){
		$('#findPWbtn').attr('href','/Alice/member/findId/findId.do');
	});
	// 검색 페이지 요청
	$('#search').click(function(){
		$(this).attr('href','/Alice/map/search.do');
	});
	// 마이페이지 버튼 이벤트 처리 
	$('#moveMyPage').click(function(){
		$(location).attr('href','/Alice/member/info/infoHome.do');
	});
});