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
				<div class="d-flex justify-content-center mt-5">
					<div>
						<h2>스포츠피드</h2>
						<a href="/main/sportsfeed/create_view" id="writeBtn" type="button" class="form-control btn btn-success text-white">글쓰기</a>					
					</div>
				</div>
				<!-- 피드 -->
				<div>
					<c:forEach var="postDetail" items="${postList }">
						<div class="card border rounded mt-3">
							<!-- 타이틀 -->
							<div class="d-flex justify-content-between p-2 border-bottom">
								<div>
									<b>${postDetail.post.userNickName }</b>
								</div>
								<div class="more-icon">
									<a class="text-dark moreBtn" href="#" data-post-id="${postDetail.post.id }" data-toggle="modal" data-target="#deleteModal">
										<i class="bi bi-three-dots"></i>
									</a>
								</div>
							</div>
							<!-- 이미지 -->
							<div>
								<img src="${postDetail.post.imagePath }" alt="사용자가 등록한 이미지" class="w-100">
							</div>
							<!-- 좋아요 -->
							<div class="m-2">
								<c:choose>
									<c:when test="${postDetail.like }">
										<a href="#" class="likeBtn" data-post-id="${postDetail.post.id }" >
											<i class="bi bi-heart-fill heart-icon text-danger"></i>		
										</a>
									</c:when>
									<c:otherwise>
										<a href="#" class="likeBtn" data-post-id="${postDetail.post.id }" >
											<i class="bi bi-heart heart-icon text-dark"></i>		
										</a>
									</c:otherwise>
								</c:choose>
								<span class="middle-size ml-1">좋아요 ${postDetail.likeCount } 개</span>
							</div>					
						</div>
					</c:forEach>
				</div>
			</div>
			
			<c:import url="/WEB-INF/jsp/include/information.jsp" />
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	      
	      <div class="modal-body text-center">
	        <a href="#" id="deleteBtn">삭제하기</a>
	      </div>
	      
	    </div>
	  </div>
	</div>
	
	<script>
		$(document).ready(function() {
			$("#likeBtn").on("click", function(e) {
				e.preventDefault();
				
				var postId = $(this).data("post-id");
				
				$.ajax({
					type:"get",
					url:"/main/sportsfeed/like",
					data:{"postId":postId},
					success:function(data) {
						if(data.result == "success") {
							location.reload();
						} else {
							alert("좋아요 등록 실패");
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