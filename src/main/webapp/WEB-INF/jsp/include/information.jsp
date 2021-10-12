<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-2">
	<h4 class="text-center">유저 정보</h4>
	<a class="d-flex justify-content-center"><i class="bi bi-person-circle person-icon"></i></a>
	<div class="text-center mt-2">				
		<label><b>이름 : </b></label>
		<span>${user.name }</span> <br>
		<label><b>닉네임 : </b></label>
		<span>${user.nickName }</span> <br>
		<label><b>이메일</b></label> <br>
		<span>${user.email }</span>
	</div>
	<a href="#" id="userUpdateBtn" type="button" class="mt-3 btn btn-secondary text-light d-flex justify-content-center">정보 변경</a>
	<c:if test="${not empty userNickName }">
		<a href="/sign/out" id="signoutBtn" type="button" class="mt-3 btn btn-danger text-light d-flex justify-content-center">로그아웃</a>
	</c:if>
</div>