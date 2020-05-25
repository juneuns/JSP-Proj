// 팝업창 닫는 함수 	
function popClose(){
		window.close();
}	
$(document).ready(function(){
	// 시설 찾기 전담함수 
	$('#closeBtn').click(function(){
		$(this).attr('href',popClose());
	});
	$('.content').click(function(){
		var fitnumber = $(this).attr('id');
		var fitname = $('#fitname').val();
		if(!fitnumber){
			alert('심각한 오류가 발생했습니다.');
			return;			
		}
		opener.fitInfo(fitnumber,fitname);
		window.close();
	});
	
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
	
});