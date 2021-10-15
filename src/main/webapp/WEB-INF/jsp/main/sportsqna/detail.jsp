<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
				<h2 class="text-center my-3">스포츠Q&A</h2>
				<div class="d-flex form-group m-4">
					<label class="col-sm-2 control-label d-flex align-items-center"><b>제목</b></label>				
					<span>${qnaDetail.qna.subject }</span>
				</div>
				<div class="d-flex justify-content-end">				
					<c:if test="${qnaDetail.qna.userId eq userId }">
						<a type="button" href="#" class="btn btn-secondary"><small>수정하기</small></a>
					</c:if>
				</div>
				<!-- 이미지 -->
				<div class="d-flex justify-content-center">
					<c:if test="${not empty qnaDetail.qna.imagePath }">
						<img src="${qnaDetail.qna.imagePath }" alt="업로드한 이미지">
					</c:if>
				</div>
				<!-- 내용 -->
				<div class="m-3 d-flex">
					<h5>${qnaDetail.qna.userNickName }</h5>
					<span class="ml-5">${qnaDetail.qna.content }</span>
				</div>
				<hr>
				<!-- 댓글 작성 -->
				<div class="d-flex form-group">
					<label class="col-sm-1 control-label d-flex align-items-center"><b>댓글</b></label>
					<input type="text" id="commentInput" class="form-control">
					<button class="btn btn-success" id="commentBtn" data-qna-id="${qnaDetail.qna.id }">게시</button>
				</div>
				<!-- 댓글 목록 -->
				<c:forEach var="comment" items="${qnaDetail.commentList }">
					<div class="m-3 d-flex">
						<b>${comment.userNickName }</b>
						<span class="ml-4">${comment.content }</span>
					</div>
				</c:forEach>
				
				
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
			$("#commentBtn").on("click", function() {
				var qnaId = $(this).data("qna-id");
				var content = $("#commentInput").val();
				
				if(content == null || content == "") {
					alert("댓글을 입력하세요");
					return;
				}
				
				$.ajax({
					type:"post",
					url:"/main/sportsqna/comment/create",
					data:{"qnaId":qnaId, "content":content},
					success:function(data) {
						if(data.result == "success") {
							location.reload();
						} else {
							alert("댓글 등록 실패");
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