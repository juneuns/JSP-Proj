/*
 * 해당 js는 게시글 상세보기 뷰에서 기능을 처리하는 js입니다.
 * @author		주재석
 * @since		2020.05.27
 */
$(document).ready(function(){
	$('#hbtn').click(function(){
		$(location).attr('href','/Alice/main/main.do');
	});
	
	$('#libtn').click(function(){
		$('bno').val('');
		$('runo').val('');
		$('rcontent').val('');
		$('rupdate').val('');		
		$('#freply').attr('action','/Alice/tboard/tboardList.do');
		$('#freply').submit();
	});

	$('#ebtn').click(function(){
		$('runo').val('');
		$('rcontent').val('');
		$('rupdate').val('');
		$('#freply').attr('action', '/Alice/tboard/tboardEdit.do');
		$('#freply').submit();
	});
	
	$('#dbtn').click(function(){
		$('runo').val('');
		$('rcontent').val('');
		$('rupdate').val('');	
		$('#freply').attr('action','/Alice/tboard/tboardDelete.do');
		$('#freply').submit();
	});
	
	$('#rebtn').click(function(){
		$('#rebtn').css('display', 'none');
		$('.rcont').css('display', '');
		$('.rewr1').css('display', '');
	});
	
	$('.rewr1').click(function(){
		$('#freply').attr('action', '/Alice/tboard/replyWrite.do');
		$('#freply').submit();
	});
	
	$('.rewr2').click(function(){
		$('#freply').attr('action', '/Alice/tboard/replyEditProc.do');
		$('#freply').submit();
	});

	$('.writebtn').click(function(){
		var runo = $(this).parent().attr('id');
		$('#runo').val(runo);
		$('#rebtn').css('display', 'none');
		$('.rupdate').css('display', '');
		$('.rewr1').css('display', '');
	});
	
	$('.editbtn').click(function(){
		var runo = $(this).parent().attr('id');
		$('#runo').val(runo);
	});
	
	$('.editbtn').click(function(){
		// 할일
		// 어떤버튼이 클릭 됬는지 알아낸다.
		// 우리는 버튼마다 아이디 값을 다르게 설정했으므로 아이디 값을 읽어온다.
		var runo = $(this).parent().attr('id');
		$.ajax({
			url: '/Alice/tboard/replyEdit.do',
			type: 'post',
			dataType: 'json',
			data: {
				'runo':runo
			},
			success: function(obj){
				$('#rno').val(obj.rno);
				$('.rupdate').val(obj.rcontent);
			},
			error: function(){
				alert('통신에러');
			}
		});
		$('#rebtn').css('display', 'none');
		$('.rupdate').css('display', '');
		$('.rewr2').css('display', '');
	});
	
	$('.delbtn').click(function(){
		var rsno = $(this).parent().attr('id');
		$('#rno').val(rsno);
//		var bno = $('#bno').val()
//		$.ajax({
//			url: '/Alice/tboard/replyDelete.do',
//			type: 'post',
//			dataType: 'json',
//			data: {
//				'runo':runo,
//				'bno':bno
//			},
//			success: function(obj){
//				var bno = obj.bno
//				var view = obj.view
//				$('#bno').val(bno);
//				$('#freply').attr('action', view);
//				$('#freply').submit();
//			},
//			error: function(){
//				alert('통신에러');
//			}
//		});
		$('#freply').attr('action', '/Alice/tboard/replyDelete.do');
		$('#freply').submit();
	});
	
	$('.pbtn').click(function(){
		var pag = $(this).text();
		alert(pag);
		$('#rePage').val(pag);
		$('#freply').attr('action', '/Alice/tboard/tboardDetail.do');
		$('#freply').submit();
	});
	
	$('.w3-button').click(function(){
		var str = $(this).html();
		if(str == 'PRE') {
			pre = $('#pre').val()
			$('#rePage').val(pre);
		} else if(str == 'NEXT') {
			next = $('#next').val();
			$('#rePage').val(next);
		} else {
			return;
		}
		
		$('#freply').attr('action', '/Alice/tboard/tboardDetail.do');
		$('#freply').submit();
	});
});