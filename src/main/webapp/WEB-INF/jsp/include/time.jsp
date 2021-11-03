<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-2">
	<div id="year" class="text-center"></div>
	<div id="date" class="text-center"></div>
	<div id="time" class="text-center"></div>
</div>
<script>
	function setClock() {
		var dateInfo = new Date();
		var hour = modifyNumber(dateInfo.getHours());
		var minute = modifyNumber(dateInfo.getMinutes());
		var second = modifyNumber(dateInfo.getSeconds());
		var year = dateInfo.getFullYear();
		var month = dateInfo.getMonth() + 1;	//monthIndex를 반환하기 때문에 1을 더해줌
		var date = dateInfo.getDate();
		
		document.getElementById("year").innerHTML = year + "년";
		document.getElementById("date").innerHTML = month + "월 " + date + "일";
		document.getElementById("time").innerHTML = hour + " : " + minute + " : " + second;
	}
	
	function modifyNumber(time) {
		if(parseInt(time) < 10) {
			return "0" + time;
		} else {
			return time;
		}
	}
	
	window.onload = function() {
		setClock();
		setInterval(setClock, 1000);
	}
</script>