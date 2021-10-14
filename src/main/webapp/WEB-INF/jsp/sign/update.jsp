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
		
		<section class="d-flex my-5">
			<c:import url="/WEB-INF/jsp/include/time.jsp" />
			
			<div class="col-lg-8">
				<h2 class="text-center my-3">정보 변경</h2>
				<form class="p-4">
					<div class="mt-3 d-flex form-group">
						<label class="col-sm-2 control-label d-flex align-items-center"><b>아이디 : </b></label>							
					</div>
					
					<div class="mt-3 d-flex form-group">
						<label class="col-sm-2 control-label d-flex align-items-center"><b>비밀번호 : </b></label>
						<input type="password" id="passwordInput" class="form-control" placeholder="비밀번호">
					</div>
					
					<div class="mt-3 d-flex form-group">
						<label class="col-sm-3 control-label d-flex align-items-center"><b>비밀번호 확인 : </b></label>
						<input type="password" id="passwordConfirmInput" class="form-control" placeholder="비밀번호 확인">
					</div>
					
					<div class="mt-3 d-flex form-group">					
						<label class="col-sm-2 control-label d-flex align-items-center"><b>이름 : </b></label>
					</div>
					
					<div class="mt-3 d-flex form-group">
						<label class="col-sm-2 control-label d-flex align-items-center"><b>닉네임 : </b></label>
					</div>
					
					<div class="mt-3 d-flex form-group">
						<label class="col-sm-2 control-label d-flex align-items-center"><b>이메일 : </b></label>					
						<input type="text" id="emailInput" class="form-control" placeholder="이메일">						
					</div>
					
					<button class="btn btn-success form-control mt-3" id="updateBtn">정보 수정</button>
				</form>
			</div>
			
			<c:import url="/WEB-INF/jsp/include/information.jsp" />
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
</body>
</html>