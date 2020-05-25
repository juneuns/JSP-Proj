// 작성자 : 박광호
$(document).ready(function(){
	// 아이디 찾기 처리
	$('#findIdbtn').click(function(){
		let name = $('#tname').val();
		let mail = $('#tmail').val();

		if(!name || !mail){
			alert('채우지 않은 값을 채우세요..');
			return;
		}
		$('#name').val(name);
		$('#mail').val(mail);
		regField();
		let type = $('#tF').is(':checked');
		if(type){
			$('#type').val('F');
			$('#findIdFrm').attr('action','/Alice/member/findId/findIdFProc.do');
			$('#findIdFrm').submit();
			return ;
		}
		$('#findIdFrm').attr('action','/Alice/member/findId/findIdUProc.do');
		$('#findIdFrm').submit();
	});
	// 비밀번호 찾기 버튼 
	$('#findPWbtn').click(function(){
		var name=$('#tname').val();
		var id=$('#tid').val();
		var mail=$('#tmail').val();
		var type=$('#tType').val();
		
		regField();
		if(!name || !id || !mail){
			alert('채우지 않은 값을 채우세요..');
			return;
		}
		$('#name').val(name);
		$('#id').val(id);
		$('#mail').val(mail);
		if($('#tType').is(':checked')){
			$('#type').val(type);	
		}
		$('#frm').attr('action','/Alice/member/findPassProc.do');
		$('#frm').submit();
	});
	$('#moveMain').click(function(){
		location.href ='/Alice/main/main.do';
	});
	$('#moveFindId').click(function(){
		$(this).attr('href','/Alice/member/findId/findId.do');
	});
	$('#moveFindPW').click(function(){
		$(this).attr('href','/Alice/member/findPW/findPass.do');
	});
	
});
var regField = function(){
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
	
}