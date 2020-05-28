$(function(){
	$('#fbtn').click(function(){
		$(location).attr('href', '/Alice/fboard/fboardFlist.do');
	});
	
	$('#tbtn').click(function(){
		$(location).attr('href', '/Alice/tboard/tboardList.do');
	});
	
	$('#writemap').click(function(){
		$(location).attr('href', '/Alice/tboard/tboardList.do');
	});
});