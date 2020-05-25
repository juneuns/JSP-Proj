$(document).ready(function(){
	
	$('#idck').click(function(){
		// 할일
		// 1. 입력태그에 입력된 아이디를 가져오고
		var sid = $('#id').val();
		if(sid){
			$.ajax({
				url: '../id.check',
				type: 'post',
				dataType: 'json',
				data: {
					'id': sid
				},
				success: function(data){
					var result = data.result;
					var id = data.id;
					var name = data.Name;
					var tel = data.Tel;
					var mail = data.Mail;
					if(result == 'ok'){
						// 아이디를 사용가능한 경우
						$('#idmsg').text('*** 사용 가능한 아이디 입니다. ***');
						$('#idmsg').css('color', 'blue');
						$('#idmsg').css('display', '');
					} else {
						// 아이디가 사용불가능한 경우
						$('#idmsg').text('### 사용할 수 없는 아이디 입니다. ###');
						$('#idmsg').css('color', 'red');
						$('#idmsg').css('display', '');
						$('#id').val('');
						$('#id').focus();
						$('#idCont').css('display','');
						$('#getId').text(id);
						$('#getName').text(name);
						$('#getTel').text(tel);
						$('#getMail').text(mail);
					}
				},
				error: function(){
					alert('### 통신 실패 ###');
				}
			});
		} else {
			$('#id').focus();
			return;
		}
	});
});
	document.getElementById('repw').onkeyup = function() {
		var pw = document.getElementById('pw').value;
		var repw = this.value;

		if (repw == pw) {
			document.getElementById('gl2').innerHTML = '비밀번호가 일치합니다..';
			document.getElementById('gl1').classList.remove('w3-hide');
			document.getElementById('gl2').classList.remove('w3-hide');
			document.getElementById('gl2').style.color = 'green';
		} else {
			document.getElementById('gl2').innerHTML = '비밀번호가 일치하지 않습니다.';
			document.getElementById('gl1').classList.remove('w3-hide');
			document.getElementById('gl2').classList.remove('w3-hide');
			document.getElementById('gl2').style.color = 'red';

		}

	};
	// 사진파일 유효 검사
	document.getElementById('file').onchange = function(e) {

		var form = this.value;
		var check = form.slice(form.lastIndexOf('.') + 1);
		check = check.toLowerCase(check);

		if (check != 'png' && check != 'jpg' && check != 'jpeg' && check != 'gif') {
			alert('파일형식을 확인하세요..');
			document.getElementById('imgbox').classList.toggle('w3-hide');
			this.value = '';
			return;
		}
		var vfile = URL.createObjectURL(e.target.files[0]); // 배열로 저장하고 있다가 선택한 파일은
															// 0번째 이기때문
		document.getElementById('img1').setAttribute('src', vfile);
		document.getElementById('imgbox').classList.remove('w3-hide');

	};
	// 아바타 여자 구별
	document.getElementById('F').onchange = function() {
		var gen = this.value;
		document.getElementById('avtgenb').classList.add('w3-hide');
		document.getElementById('avtgenM').classList.add('w3-hide');
		document.getElementById('avtgenb').classList.remove('w3-hide');
		document.getElementById('avtgenF').classList.remove('w3-hide');
	};
	// 아바타 남자 구별
	document.getElementById('M').onchange = function() {
		var gen = this.value;

		document.getElementById('avtgenb').classList.add('w3-hide');
		document.getElementById('avtgenF').classList.add('w3-hide');
		document.getElementById('avtgenb').classList.remove('w3-hide');
		document.getElementById('avtgenM').classList.remove('w3-hide');
	};