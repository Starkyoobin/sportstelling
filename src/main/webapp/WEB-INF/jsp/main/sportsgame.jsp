<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SportsTelling</title>
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		
		<c:import url="/WEB-INF/jsp/include/menu.jsp" />
		
		<section class="d-flex detail-box my-5">
			<c:import url="/WEB-INF/jsp/include/time.jsp" />
			
			<div class="col-lg-8">
				<h2 class="text-center my-3">경기결과</h2>
				<!-- 
				<nav>
					<ul class="nav nav-fill" id="sport-nav">
						<li class="nav-item"><a class="nav-link" href="#">ALL</a></li>
						<li class="nav-item"><a class="nav-link" href="#">축구</a></li>
						<li class="nav-item"><a class="nav-link" href="#">야구</a></li>
						<li class="nav-item"><a class="nav-link" href="#">농구</a></li>
						<li class="nav-item"><a class="nav-link" href="#">배구</a></li>
					</ul>
				</nav>
				-->
				<table class="table">
					<thead class="text-center">
						<tr>						
							<th class="col-4">홈팀</th>
							<th class="col-4">경기결과</th>
							<th class="col-4">원정팀</th>
						</tr>
					</thead>
					<tbody class="text-center">
						<c:forEach var="sport" items="${sports }">
							<tr>							
								<td class="col-4">${sport.hteamHanNm }</td>
								<td class="col-4">${sport.matchEnd }</td>
								<td class="col-4">${sport.ateamHanNm }</td>
							</tr>
						</c:forEach>						
					</tbody>
				</table>
			</div>
			
			<c:import url="/WEB-INF/jsp/include/information.jsp" />
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
</body>
</html>