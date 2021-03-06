$(document).ready(function(){
	//마이리스트 내부 메뉴
	$('#infoEdit').click(function(){
		location.href='/Alice/member/info/infoEdit.do';
	});
	$('#pwEdit').click(function(){
		location.href='/Alice/member/info/pwEdit.do';
	});
	$('#contactList').click(function(){
		location.href='/Alice/member/info/contactList.do';
	});
	
	// 탈퇴하기 방법 
	$('#getAway').click(function(){
		var str = prompt('탈퇴를 원하시면 "탈퇴하겠습니다." 를 입력해주세요.');
		
		if(str == '탈퇴하겠습니다.'){
			$(location).attr('href','/Alice/member/info/getAway.do');
		}
		
	});
	
	// 시설 검색 팝업 창 요청
	$('#fitinfo').click(function(){
		window.open('/Alice/member/signUp/fitPop.jsp','fitPop','width=500,height=400,resizealbe=yes');
	});
	// 비밀번호 재설정의 비밀번호 확인 요청 
	$('#ck').click(function(){
		var editck = $('#oldPw').val();
		var type = $('#tF').is(':checked');
		var f = null;
		if(type) {
			f = $('#tF').val();
			$('#f').val(f);
		}
		var pwReg = /(?=.*\d{1})(?=.*[~`!@#$%\^&*()-+=]{1})(?=.*[a-zA-Z]{2}).{8,15}$/;
		if(! pwReg.test(editck)){
			alert("비밀번호 형식을 확인해주세요.");
			$('#oldPw').focus();
			return;
		}
		
		$.ajax({
			url: '/Alice/ajax/pwCheck.do',
			type:'POST',
			dataType:'json',
			data : {
				'pw':editck,
				'type':f
			},
			success : function(obj){
				if(obj.result == 'ok'){
					$('#pwckMsg').text('비밀번호를 확인 했습니다.');
					$('#pwckMsg').css('color','green');
					$('#pwMsgBox').removeClass('w3-hide');
					$('#tPw').removeAttr('readonly');
					$('#tRepw').removeAttr('readonly');
				} else{
					$('#pwckMsg').text('비밀번호를 다시 확인하세요.');
					$('#pwckMsg').css('color','red');
					$('#pwMsgBox').removeClass('w3-hide');
					$('#tPw').prop('readonly');
					$('#tRepw').prop('readonly');
				}
			},error : function(){
				alert('통신애러');
			}
		})
		
	});
	// 비밀번호 재확인 
	$('#tRepw').keyup(function(){
		let tPw = $('#tPw').val();
		let tRepw = $('#tRepw').val();
		
		if(tRepw == tPw) {
			$('#pwEditMsg').text('비밀번호가 일치 합니다.')
			$('#pwEditMsg').css('color','green');
			$('#pwEditMsgBox').show('fast');
		} else {
			$('#pwEditMsg').text('비밀번호가 일치하지 않습니다.');
			$('#pwEditMsg').css('color','red');
			$('#pwEditMsgBox').show('fast');
		}
	});
	
	$('#pwEditSubmit').click(function(){
		let tPw = $('#tPw').val();
		if(!tPw || tPw.length==0){
			alert('변경하실 비밀번호를 입력해주세요');
			return;
		}
		var pwReg = /(?=.*\d{1})(?=.*[~`!@#$%\^&*()-+=]{1})(?=.*[a-zA-Z]{2}).{8,15}$/;
		if(! pwReg.test(editck)){
			alert("비밀번호 형식을 확인해주세요.");
			$('#oldPw').focus();
			return;
		}
		$('#pw').val(tPw);
		$('#pwEditFrm').attr('action','/Alice/member/info/pwEditProc.do');
		$('#pwEditFrm').submit();
	})
});

// 시설 검색 팝업창 데이터 가져오는 함수 
function fitInfo(fitnumber, fitname){
	document.getElementById('fno').value = fitnumber;
	document.getElementById('fname').value = fitname;
}