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
				<h2 class="text-center my-3">회원정보 변경</h2>
				<form class="p-4">
					<div class="mt-3 input-group">
						<div class="input-group-prepend">						
							<div class="input-group-text"><b>아이디</b></div>
						</div>
						<input type="text" class="form-control" value="${user.loginId }" disabled>
					</div>
					
					<div class="mt-3 input-group">
						<div class="input-group-prepend">						
							<div class="input-group-text"><b>비밀번호</b></div>
						</div>
						<input type="password" id="passwordInput" class="form-control" placeholder="비밀번호">
					</div>
					
					<div class="mt-3 input-group">
						<div class="input-group-prepend">						
							<div class="input-group-text"><b>비밀번호 확인</b></div>
						</div>
						<input type="password" id="passwordConfirmInput" class="form-control" placeholder="비밀번호 확인">
					</div>
					
					<div class="mt-3 input-group">
						<div class="input-group-prepend">						
							<div class="input-group-text"><b>이름</b></div>
						</div>
						<input type="text" class="form-control" placeholder="${user.name }" disabled>
					</div>
					
					<div class="mt-3 input-group">
						<div class="input-group-prepend">						
							<div class="input-group-text"><b>닉네임</b></div>
						</div>
						<input type="text" class="form-control" placeholder="${user.nickName }" disabled>
					</div>
					
					<div class="mt-3 input-group">
						<div class="input-group-prepend">						
							<div class="input-group-text"><b>이메일</b></div>
						</div>					
						<input type="text" id="emailInput" class="form-control" value="${user.email }">						
					</div>
					
					<button type="button" class="btn btn-success form-control mt-3" id="updateBtn">정보 수정</button>
					<button type="button" class="btn btn-danger form-control mt-3"  data-toggle="modal" data-target="#deleteModal">회원 탈퇴</button>
				</form>
			</div>
			
			<c:import url="/WEB-INF/jsp/include/information.jsp" />
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">회원 탈퇴 여부 확인</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	      	<span>회원탈퇴를 하시게 되면 다시 회원가입을 하여 사용하실수있습니다. 회원탈퇴를 진행하시겠습니까?</span>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary mr-3" data-dismiss="modal">닫기</button>
	        <button type="button" class="btn btn-danger" id="deleteBtn">회원탈퇴</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<script>
		$(document).ready(function() {
			$("#updateBtn").on("click", function() {
				var password = $("#passwordInput").val();
				var passwordConfirm = $("#passwordConfirmInput").val();
				var email = $("#emailInput").val();
				
				if(password != passwordConfirm) {
					alert("비밀번호가 일치하지 않습니다");
					return;
				}
				
				$.ajax({
					type:"post",
					url:"/sign/update",
					data:{"password":password, "email":email},
					success:function(data) {
						if(data.result == "success") {
							alert("회원정보 변경에 성공했습니다");
							history.go(-1);
						} else {
							alert("회원정보 변경 실패");
						}
					},
					error:function(e) {
						alert("error");
					}
				});
			});
			
			$("#deleteBtn").on("click", function() {
				$.ajax({
					type:"get",
					url:"/sign/delete",
					data:{},
					success:function(data) {
						if(data.result == "success") {
							location.href = "/sign/in_view";
						} else {
							alert("회원 탈퇴 실패");
						}
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