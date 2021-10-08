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
		
		<section class="signin-section">
			<div class="d-flex my-5">			
				<div class="w-50">
					<h2 class="text-center">아이디 찾기</h2>
					<form>
						<input type="text" id="nameInput" class="form-control mt-2 col-6" placeholder="이름">
						<input type="text" id="idByEmailInput" class="form-control mt-2 col-6" placeholder="이메일">
						
						<button type="button" id="loginIdFindBtn" class="form-control btn btn-success mt-2 col-6">아이디 찾기</button>					
					</form>
				</div>
				
				<div class="w-50">				
					<h2 class="text-center">비밀번호 찾기</h2>
					<form>
						<input type="text" id="loginIdInput" class="form-control mt-2 col-6" placeholder="아이디">						
						<input type="text" id="pwByEmailInput" class="form-control mt-2 col-6" placeholder="이메일">
						
						<div class="col-6 border mt-2">
							<small class="text-secondary">
							가입시 등록한 이메일로 임시 비밀번호를 발급합니다. 발급후 로그인하여 정보 변경을 통하여 비밀번호를 변경해주세요.
							</small>
						</div>
						
						<button type="button" id="passwordFindBtn" class="form-control btn btn-success mt-2 col-6">비밀번호 찾기</button>					
					</form>
				</div>
			</div>
			<div class="text-center mt-4">
				<a href="/sign/in_view">로그인으로 돌아가기</a>
			</div>
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	<script>
		$(document).ready(function() {
			//아이디 찾기
			$("#loginIdFindBtn").on("click", function(e) {
				e.preventDefault();
				
				var name = $("#nameInput").val();
				var email = $("#idByEmailInput").val();
				
				if(name == null || name == "") {
					alert("이름을 입력해주세요");
					return;
				}
				
				if(email == null || email == "") {
					alert("이메일을 입력해주세요");
					return;
				}
				
				$.ajax({
					type:"post",
					url:"/sign/find_id",
					data:{"name":name, "email":email},
					success:function(data) {
						if(data.result == "success") {
							alert();
						} else {
							alert("회원정보 없음");
						}
					},
					error:function(e) {
						alert("error");
					}
				});
			});
			//비밀번호 찾기
			/*
			$("#passwordFindBtn").on("click", function(e) {
				e.preventDefault();
				
				var loginId = $("#loginIdInput").val();
				var email - $("#pwByEmailInput").val();
				
				if(loginId == null || loginId == "") {
					alert("아이디를 입력해주세요");
					return;
				}
				
				if(email == null || email == "") {
					alert("이메일을 입력해주세요");
					return;
				}
			});
			*/
		});
	</script>
</body>
</html>