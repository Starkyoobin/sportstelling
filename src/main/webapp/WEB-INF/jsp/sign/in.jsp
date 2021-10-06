<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SportsTelling</title>
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		
		<section class="signin-section my-5">
			<div class="d-flex justify-content-center align-items-center">
				<div class="col-5">			
					<h2 class="text-center">로그인</h2>
					<form id="signInForm">
						<input type="text" id="idInput" class="form-control mt-4" placeholder="아이디를 입력해주세요">
						<input type="password" id="passwordInput" class="form-control mt-4" placeholder="비밀번호를 입력해주세요">
						<input type="button" id="loginBtn" class="btn form-control btn-info mt-4" value="로그인">
					</form>
					<button class="btn btn-success form-control mt-4" id="joinBtn">회원가입</button>
					<div class="text-center mt-4">
						<a href="#">아이디 / 비밀번호 찾기</a>
					</div>
					<div class="text-center mt-4">
						<a href="#" id="non-member-login">비회원 로그인</a>
					</div>
				</div>
			</div>
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	<script>
		$(document).ready(function() {
			$("#joinBtn").on("click", function() {
				location.href="/sign/up_view";
			});
		});
	</script>
</body>
</html>