// 작성자 : 박광호
$(document).ready(function(){
	
	
	// 아이디 찾기 처리
	$('#findIdbtn').click(function(){
		let name = $('#tname').val();
		let mail = $('#tmail').val();
		let F = $('#tF').val();
		if(!name || !mail){
			alert('채우지 않은 값을 채우세요..');
			return;
		}
		$('#name').val(name);
		$('#mail').val(mail);
		regField();
		let type = $('#tF').is(':checked');
		if(type){
			$('#type').val(F);
			$('#findIdFrm').attr('action','/Alice/member/findId/findIdFProc.do');
			$('#findIdFrm').submit();
			return ;
		}
		$('#findIdFrm').attr('action','/Alice/member/findId/findIdUProc.do');
		$('#findIdFrm').submit();
	});
	// 비밀번호 찾기 버튼 
	$('#findPWbtn').click(function(){
		let name=$('#tname').val();
		let id=$('#tid').val();
		let mail=$('#tmail').val();
		let F = $('#tF').val();
		$('#name').val(name);
		$('#id').val(id);
		$('#mail').val(mail);
		if(!name || !id || !mail){
			alert('채우지 않은 값을 채우세요..');
			return;
		}
		
		regField();
		
		let idReg = /^.[A-za-z0-9]{8,13}/g;
		if( !idReg.test( $("#id").val() ) ) {
	        alert("아이디는 영문자로 시작하는 8~13자 영문자 또는 숫자이어야 합니다.");
	        $("#id").focus()
	        return;
	    }
		let type = $('#tF').is(':checked');
		if(type){
			$('#type').val(F);
			$('#findPWFrm').attr('action','/Alice/member/findPW/findPassFProc.do');
			$('#findPWFrm').submit();
			return ;
		}
		$('#findPWFrm').attr('action','/Alice/member/findPW/findPassUProc.do');
		$('#findPWFrm').submit();
	});
	// 메인 이동 버튼 이벤트 처리
	$('#moveMain').click(function(){
		location.href ='/Alice/main/main.do';
	});
	// 상단 메뉴(아이디 찾기) 이동 버튼 이벤트 처리
	$('#moveFindId').click(function(){
		$(this).attr('href','/Alice/member/findId/findId.do');
	});
	// 상단 메뉴(비밀번호 찾기) 이동 버튼 이벤트 처리 
	$('#moveFindPW').click(function(){
		$(this).attr('href','/Alice/member/findPW/findPass.do');
	});
	// 취소 버튼 이벤트 처리
	$('#reset').click(function(){
		$('#tname').val(' ');
		$('#tmail').val(' ');
		$('#tid').val(' ');
	});
});
var regField = function(){
// 이름 정규식 
	var nameReg = /^[가-힣]{1,20}|[a-zA-Z]{1,10}\s[a-zA-Z]{1,10}$/;
	if( !nameReg.test( $("#name").val() ) ) {
		alert('이름은 영문 한글 20자까지 입력가능합니다.');
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