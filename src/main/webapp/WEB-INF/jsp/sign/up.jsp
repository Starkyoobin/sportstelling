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
		
		<section class="login-section my-5">
			<div class="d-flex justify-content-center align-items-center">
				<div class="col-5">			
					<h2 class="text-center">회원가입</h2>
					<form id="signUpForm">
						<div class="d-flex mt-3">
							<input type="text" id="loginIdInput" class="form-control" placeholder="아이디">
							<span class="input-group-addon">							
								<button type="button" id="idIsDuplicateBtn" class="btn btn-primary btn-sm ml-2">중복체크</button>
							</span>								
						</div>
						<div id="idDuplicateDiv" class="d-none"><small class="text-danger">중복된 ID 입니다.</small></div>
						<div id="idNoneDuplicateDiv" class="d-none"><small class="text-success">사용 가능한 ID 입니다.</small></div>
						<input type="password" id="passwordInput" class="form-control mt-3" placeholder="비밀번호">
						<input type="password" id="passwordConfirmInput" class="form-control mt-3" placeholder="비밀번호 확인">
						
						<input type="text" id="nickNameInput" class="form-control mt-3" placeholder="이름">
						<div class="d-flex mt-3">
							<input type="text" id="nickNameInput" class="form-control" placeholder="닉네임">
							<span class="input-group-addon">							
								<button type="button" id="nickNameIsDuplicateBtn" class="btn btn-primary btn-sm ml-2">중복체크</button>
							</span>								
						</div>
						<div id="nickNameDuplicateDiv" class="d-none"><small class="text-danger">중복된 닉네임 입니다.</small></div>
						<div id="nickNameNoneDuplicateDiv" class="d-none"><small class="text-success">사용 가능한 닉네임 입니다.</small></div>
						
						<input type="text" id="emailInput" class="form-control mt-3" placeholder="이메일">						
						
						<button class="btn btn-success form-control mt-3" id="joinBtn">회원가입</button>
					</form>
					<div class="text-center mt-4">
						<a href="/sign/in_view">로그인으로 돌아가기</a>
					</div>
				</div>
			</div>
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	<script>
		$(document).ready(function() {
			var isIdCheck = false;
			var isDuplicateId =true;
			var isNickNameCheck = false;
			var isDuplicateNickName = true;
			//회원가입
			$("#signUpForm").on("submit", function(e) {
				e.preventDefault();
				
				var loginId = $("#loginIdInput").val();
				var password = $("#passwordInput").val();
				var passwordConfirm = $("#passwordConfirmInput").val();
				var name = $("#nameInput").val();
				var nickName = $("#nickNameInput").val();
				var email = $("#emailInput").val();
				
				//유효성 검사
				if(loginId == null || loginId == "") {
					alert("아이디를 입력해주세요");
					return;
				}
				
				if(password == null || password == "") {
					alert("비밀번호를 입력해주세요");
					return;
				}
				
				if(passwordConfirm == null || passwordConfirm == "") {
					alert("비밀번호 확인을 입력해주세요");
					return;
				}
				
				if(name == null || name == "") {
					alert("이름을 입력해주세요");
					return;
				}
				
				if(nickName == null || nickName == "") {
					alert("닉네임을 입력해주세요");
					return;
				}
				
				if(email == null || email == "") {
					alert("이메일을 입력해주세요");
					return;
				}
				
				//ID 중복체크 확인
				if(isIdCheck == false) {
					alert("아이디 중복체크를 진행해주세요");
					return;
				}
				//ID 중복인지 아닌지
				if(isDuplicateId == true) {
					alert("아이디가 중복되었습니다");
					return;
				}
				//닉네임 중복체크 확인
				if(isNickNameCheck == false) {
					alert("닉네임 중복체크를 진행해주세요");
					return;
				}
				//닉네임 중복인지 아닌지
				if(isDuplicateNickName == true) {
					alert("닉네임이 중복되었습니다");
					return;
				}
				
				$.ajax({
					type:"post",
					url:"/sign/up",
					data:{"loginId":loginId, "password":password, "name":name, "nickName":nickName, "email":email},
					success:function(data) {
						if(data.result == "success") {
							alert("회원가입 성공");
						} else {
							alert("회원가입 실패");
						}
					},
					error:function(e) {
						alert("error");
					}
				});
			});
			//ID 중복체크
			$("#idIsDuplicateBtn").on("click", function() {
				var loginId = $("#loginIdInput").val();
				
				if(loginId == null || loginId == "") {
					alert("아이디를 입력해주세요");
					return;
				}
				
				$.ajax({
					type:"get",
					url:"/sign/is_duplicate_id",
					data:{"loginId":loginId},
					success:function(data) {
						if(data.is_duplicate_id) {
							isDuplicateId = true;
							$("#idDuplicateDiv").removeClass("d-none");
							$("#idNoneDuplicateDiv").addClass("d-none");
						} else {
							isDuplicateId = false;
							$("#idDuplicateDiv").addClass("d-none");
							$("#idNoneDuplicateDiv").removeClass("d-none");
						}
					},
					error:function(e) {
						alert("error");
					}
				});
			});
			//닉네임 중복체크
			$("#nickNameIsDuplicateBtn").on("click", function() {
				var nickName = $("#nickNameInput").val();
				
				if(nickName == null || nickName == "") {
					alert("닉네임을 입력해주세요");
					return;
				}
				
				$.ajax({
					type:"get",
					url:"/sign/is_duplicate_nickname",
					data:{"nickName":nickName},
					success:function(data) {
						
					},
					error:function(e) {
						alert("error");
					}
				});
			});
		});
	</script>
</body>
</html>