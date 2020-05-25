$(document).ready(function(){
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
	$('#logout').click(function(){
		location.href = "/Alice/member/logout/logoutProc.do";
	})
});