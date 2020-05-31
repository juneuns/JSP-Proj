/**
 * 해당 js는 게시글 작성뷰 에서 url전환 및 함수를 기술한 js입니다.
 * @author		주재석
 * @since		2020.05.27
 */
$(document).ready(function(){
	$('#hbtn').click(function(){
		$(location).attr('href','/Alice/main/main.do');
	});
	
	$('#ltbtn').click(function(){
		$(location).attr('href','/Alice/tboard/tboardList.do');
	});
	
	$('#bwbtn').click(function(){
		$('#frmw').attr('action', '/Alice/tboard/tboardWriteProc.do');
		$('#frmw').submit();
	});
	
	$('#bebtn').click(function(){
		$('#frme').attr('action', '/Alice/tboard/tboardEditProc.do');
		$('#frme').submit();
	});
	
	var cnt = 2;
	
	function setNum(cnt) {
		cnt = cnt + 1;
	}
	
	var tag1 = '<input class="w3-col w3-border-right" type="file" name="file' + cnt + '">';
	
	function addBtn(){
		cnt = setNum(cnt);
		$('.mfile').append(tag1);
		setNum();
		$('.mfile > input').last().change(function(){
			addBtn();
		});
	}
	
	$('.file').change(function(){
		addBtn();
	});
	
	$('.cald').click(function(){
		var cal = $(this).children().text();
		$('#caldate').val(cal);
		$('#wCalendar').css('display', 'block');
	});
	
	$('#calSub').click(function(){
		$('#calfrm').submit();
	});
});
