<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색 테스트</title>
	<link rel="stylesheet" href="../css/w3.css">
	<link rel="stylesheet" href="../css/user.css">
	<script type="text/javascript" src="../js/jquery-3.5.0.min.js"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=31b53901da50d253bfb310b02f1ebd01&libraries=services"></script>
<style>
	h3{background:#ccc;}	
</style>

</head>
<body>
	<header>
		<jsp:include page="../frame/header.jsp"/>
	</header>
	<nav>
		<jsp:include page="../frame/sideBar.jsp"/>
	</nav>
	<div class="w3-main" style="margin-left:250px;">
		<div class="w3-hide-large" style="margin-top:83px;"></div>
		<div class="w3-center w3-border mxw">
			<form class="w3-col w3-margin-top" id="menu_wrap" name="">
				<input type='text' name='keyword' id="keyword" placeholder="키워드를 검색하세요." >
				<button type="submit" id="test01">검색하기</button>
			</form>
			<div class="w3-col w3-margin-top">			
			<h3>검색 리스트</h3>			
			</div>
			<div id="map" style="width:250px;height:250px;" class="w3-col m2 w3-margin-top w3-right"></div>	
			<c:forEach var="data" items="${SLIST}" varStatus="st">
			<div class="w3-col m7 w3-margin-top">
			<img class="w3-left w3-col m2 w3-border"id="img1" src="../img/noimage.jpg" style="height: auto; width: 180px;">
			<div class="w3-border w3-col m6">${data.name}</div>
			<div class="w3-border w3-col m6">${data.fname}</div>
			<div class="w3-border w3-col m6">${data.addr2}</div>
			<div class="w3-border w3-col m6">${data.body}</div>
			<div class="w3-border w3-col m6">${data.goal}</div>
			<div class="w3-border w3-col m6">${data.tel}</div>
			</div>	
			</c:forEach>
		</div>
	</div>
</body>
<script>

$('#test01').click(function(){ 
	 $('#menu_wrap').submit();
});
//마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
var infowindow = new kakao.maps.InfoWindow({zIndex:1});

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places(); 

// 키워드로 장소를 검색합니다
ps.keywordSearch('${KEYWORD}', placesSearchCB); 

// 키워드 검색 완료 시 호출되는 콜백함수 입니다
function placesSearchCB (data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        var bounds = new kakao.maps.LatLngBounds();

        for (var i=0; i<data.length; i++) {
            displayMarker(data[i]);    
            bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
        }       

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
        map.setBounds(bounds);
    } 
}

// 지도에 마커를 표시하는 함수입니다
function displayMarker(place) {
    
    // 마커를 생성하고 지도에 표시합니다
    var marker = new kakao.maps.Marker({
        map: map,
        position: new kakao.maps.LatLng(place.y, place.x) 
    });

    // 마커에 클릭이벤트를 등록합니다
    kakao.maps.event.addListener(marker, 'click', function() {
        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
        infowindow.open(map, marker);
    });
}
</script>
</html>