$(document).ready(function(){
	//아이디 찾기 버튼
	$('#sbtn').click(function(){
		var name=$('#tname').val();
		var id=$('#tid').val();
		var mail=$('#tmail').val();
		
		if(!name || !id || !mail){
			alert('채우지 않은 값을 채우세요..');
			return;
		}
		$('#name').val(name);
		$('#id').val(id);
		$('#mail').val(mail);
		
		$('#frm').attr('action','/Alice/member/findPassProc.do');
		$('#frm').submit();
	});
	$('#moveMain').click(function(){
		location.href ='/프로젝트명/main/main.cls';
	});
	$('#moveFindPW').click(function(){
		var findId = /* EL태그 사용해서 아이디 값 찍기 */
		$('#id').val(findId);
		
		$('#frm').attr('action','/프로젝트명/findPass.do');
		$('#frm').submit();
	});
});