$(document).ready(function(){
	$('#write').click(function(){
		$(location).attr('href','/proj/board/boardTwrite.do');
	});
	$('#home').click(function(){
		$(location).attr('href', '/proj/main.do');
	});	
	$('.list').click(function(){
		$(location).attr('href', '/proj/board/boardTDetail.do');
	});

});