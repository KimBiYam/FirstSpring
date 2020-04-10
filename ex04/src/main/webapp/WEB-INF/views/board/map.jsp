<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html lang="en">
<%@include file="includes/header.jsp"%>

<div id="layoutSidenav_content">
	<div class="container">
		<div class="row justify-content-center my-5">
			<div id="map" style="width: 800px; height: 800px;"></div>
		</div>
	</div>
</div>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f0d1e0ad6c3879f48f742476ea996d23&libraries=services,clusterer"></script>
<script type="text/javascript">
$(function(){
	map.setDraggable(false);
	map.setZoomable(false);
})
	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
	var options = { //지도를 생성할 때 필요한 기본 옵션
		center : new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
		level : 3
	//지도의 레벨(확대, 축소 정도)
	};
	var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
 
	
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new daum.maps.services.Geocoder();
		
	// 주소로 좌표를 검색합니다
	// addressSearch 함수에 주소정보를 입력해 줍니다. 
	geocoder.addressSearch('부산 부산진구 중앙대로 708', function(result, status) {
	    // 정상적으로 검색이 완료됐으면
	     if (status === daum.maps.services.Status.OK) {
	        var coords = new daum.maps.LatLng(result[0].y, result[0].x);
	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new daum.maps.Marker({
	            map: map,
	            position: coords
	        });
	        // 인포윈도우로 장소에 대한 설명을 표시합니다
	        var infowindow = new daum.maps.InfoWindow({                     
	            content: "<div style='width:150px;text-align:center;padding:6px 0;'><b>학원 위치</b><br>부산IT교육센터<br>부산 부산진구<br>중앙대로 708<?echo $my_shop_name;?></div>"
		            
	        });
	        infowindow.open(map, marker);
	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	    }
	});

</script>
</body>
</html>
