$(document).ready(function(){
	//마이리스트 내부 메뉴
	$('#infoEdit').click(function(){
		location.href='/Alice/member/info/infoEdit.do';
	});
	$('#pwEdit').click(function(){
		location.href='/Alice/member/info/pwEdit.do';
	});
	$('#contactList').click(function(){
		location.href='/Alice/member/info/conTactList.do';
	});
	
	// 주소 검색 팝업 창 요청
	$('#addrbtn').click(function(){
		window.open('/Alice/member/addrPop.do','addr','width=500,height=400,resizealbe=yes');
	});
	// 시설 검색 팝업 창 요청
	$('#fitinfo').click(function(){
		window.open('/Alice/member/signUp/fitPop.jsp','fitPop','width=500,height=400,resizealbe=yes');
	});
	// 비밀번호 재설정의 비밀번호 확인 요청 
	$('#pwck').click(function(){
		var editck = $('#oldPw').val();
		$.ajax({
			url: '/Alice/...do',
			type:'POST',
			dataType:'json',
			data : {
				'pw':editck
			},
			success : function(obj){
				if(obj.result == 'ok'){
					$('#pwckMsg').text('비밀번호를 확인 했습니다.');
					$('#pwckMsg').css('color','green');
					$('#pwMsgBox').removeClass('w3-hide');
					$('tPw').removeAttr('readonly');
					$('tRepw').removeAttr('readonly');
				} else{
					$('#pwckMsg').text('비밀번호를 다시 확인하세요.');
					$('#pwckMsg').css('color','red');
					$('#pwMsgBox').removeClass('w3-hide');
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
	
	// 입력사항 유효성 검사 및 비밀번호 재설정
	$('#pwEditSubmit').click(function(){
		let tPw = $('#tPw').val();
		if(!tPw || tPw.length==0){
			alert('변경하실 비밀번호를 입력해주세요');
			return;
		}
		$('#pw').val(tPw);
		
		$('#pwEditFrm').attr('action','/Alice/../.do');
	})
});
// 주소 팝업창 데이터 가져오는 함수
function josoCallBack(roadAddrPart1,zipno){
	document.getElementById('roadAddrPart1').value=roadAddrPart1;
	document.getElementById('zipno').value=zipno;
	document.getElementById('addedAddr').removeAttribute('readonly');
}
// 시설 검색 팝업창 데이터 가져오는 함수 
function fitInfo(fitnumber, fitname){
	document.getElementById('fno').value = fitnumber;
	document.getElementById('fname').value = fitname;
}