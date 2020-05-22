$(function(){
	$('#fbtn').click(function(){
		$(location).attr('href', '/proj/board/boardFlist.do');
	});
	
	$('#tbtn').click(function(){
		$(location).attr('href', '/proj/board/boardTlist.do');
	});
});