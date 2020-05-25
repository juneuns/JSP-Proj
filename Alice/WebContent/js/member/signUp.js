// 팝업창 닫는 함수 	
function popClose(){
		window.close();
}	
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
			if(!bodyWReg.test($('#weight').val())){
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