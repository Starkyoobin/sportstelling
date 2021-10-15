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
		
		<section class="d-flex update-content my-5">
			<c:import url="/WEB-INF/jsp/include/time.jsp" />
			
			<div class="col-lg-8">
				<h2 class="text-center my-3">스포츠Q&A 게시글 수정 / 삭제</h2>
				<!-- 제목 -->
				<div class="d-flex form-group m-4">
					<label class="col-sm-2 control-label d-flex align-items-center"><b>제목</b></label>				
					<input type="text" id="titleInput" class="form-control" value="${qna.subject }">
				</div>
				<!-- 이미지 -->
				<div class="d-flex justify-content-center">
					<c:if test="${not empty qna.imagePath }">
						<img src="${qna.imagePath }" alt="업로드한 이미지">
					</c:if>
				</div>
				<!-- 내용 -->
				<div class="my-3">
					<textarea class="form-control w-100 non-resize" rows="10" id="contentInput">${qna.content }</textarea>
				</div>
				
				<div class="d-flex justify-content-between m-3">
					<a href="#" id="imageUploadBtn"><i class="bi bi-image image-upload-icon"></i></a>
					<input type="file" id="fileInput" class="d-none" multiple>
					
					<button type="button" id="uploadBtn" class="btn btn-success">수정하기</button>
				</div>
				
				<div class="d-flex justify-content-center align-items-center">
					<a href="/main/sportsqna/list_view" class="form-control btn btn-info">목록으로</a>
				</div>
			</div>
			
			<c:import url="/WEB-INF/jsp/include/information.jsp" />
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	<script>
		$(document).ready(function() {
			$("#imageUploadBtn").on("click", function() {
				$("#fileInput").click();
			});
		});
	</script>
</body>
</html>