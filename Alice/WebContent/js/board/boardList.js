/**
 * 해당 js는 목차에서 버튼을 통해 url을 이동하는 js입니다.
 * @author	주재석
 * @since	2020.05.27
 */
$(document).ready(function(){
	$('#write').click(function(){
		$(location).attr('href', '/Alice/tboard/tboardWrite.do');
	});

	$('#home').click(function(){
		$(location).attr('href', '/Alice/main/main.do');
	});	

	$('.pbtn').click(function(){
		var str = $(this).text();
		$('#nowPage').val(str);
		$('#form').attr('action', '/Alice/tboard/tboardList.do');
		$('#form').submit();
	});
	
	$('.w3-button').click(function(){
		var str = $(this).html();
		if(str == 'PRE') {
			pre = $('#pre').val()
			$('#nowPage').val(pre);
		} else if(str == 'NEXT') {
			next = $('#next').val();
			$('#nowPage').val(next);
		} else {
			return;
		}
		
		$('#form').attr('action', '/Alice/tboard/tboardList.do');
		$('#form').submit();
	});
	
	$('.content').click(function(){
		var sno = $(this).attr('id');
		$('#bno').val(sno);
		cPage = $('#cPage').val();
		$('#nowPage').val(cPage);
		$('#form').attr('action', '/Alice/tboard/tboardUpdClick.do');
		$('#form').submit();
	});
});