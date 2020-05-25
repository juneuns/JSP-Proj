$(document).ready(function(){
	$('#sbtn').click(function(){
		var name=$('#tname').val();
		var id=$('#tid').val();
		var mail=$('#tmail').val();
		var type=$('#tType').val();
		
		
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
});