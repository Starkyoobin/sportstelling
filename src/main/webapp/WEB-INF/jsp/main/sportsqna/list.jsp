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
		
		<section class="d-flex my-5">
			<c:import url="/WEB-INF/jsp/include/time.jsp" />
			
			<div class="col-lg-8">
				<h2 class="text-center my-3">스포츠Q&A</h2>
				<form id="searchForm">				
					<div class="m-4 d-flex justify-content-center">
						<select>
							<option value="all">전체</option>
							<option value="nickName">닉네임</option>
							<option value="title">제목</option>
						</select>
						<input type="text" name="search" id="searchInput" class="form-control">
						<input type="submit" class="btn btn-info" id="searchBtn" value="검색">
					</div>
				</form>
				
				<c:choose>
					<c:when test="${not empty keyword }">
						<p>
							<strong>${keyword} </strong>키워드로 검색된
							<strong>${totalRow }</strong>개의 파일이 있습니다.
						</p>
					</c:when>
					<c:otherwise>
						<p><strong>${totalRow }</strong>개의 파일이 있습니다.</p>
					</c:otherwise>
				</c:choose>
				
				<table class="table">
					<thead class="text-center">
						<tr>
							<th class="col-3">닉네임</th>
							<th class="col-7">제목</th>
							<th class="col-2">작성날짜</th>
						</tr>
					</thead>
					<tbody class="text-center">
						<!-- <tr class="text-secondary text-center">
							<td></td>
							<td>게시물 없음</td>
							<td></td>
						</tr>	-->
						<c:forEach var="qna" items="${qnaList }">
							<tr>
								<td class="col-3">${qna.userNickName }</td>
								<td class="col-7"><a href="/main/sportsqna/detail_view?id=${qna.id }" class="text-dark">${qna.subject }</a></td>
								<td class="col-2">
									<fmt:formatDate var="createdAt" value="${qna.createdAt }" pattern="yyyy-MM-dd" />
									${createdAt }
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<div class="d-flex justify-content-between m-2">
					<button type="button" id="myPostView" class="btn btn-secondary">내 글 보기</button>
					<button type="button" id="allPostView" class="btn btn-secondary d-none">전체 보기</button>
					<a type="button" href="/main/sportsqna/create_view" class="btn btn-success">글쓰기</a>
				</div>
			</div>
			
			<c:import url="/WEB-INF/jsp/include/information.jsp" />
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	<script>
		$(document).ready(function() {
			/*
			$("#myPostView").on("click", function() {
				$("#myPostView").addClass("d-none");
				$("#allPostView").removeClass("d-none");
			});	*/
			
			$("#searchBtn").on("click", function(e) {
				var searchContent = $("#searchInput").val().trim();
				
				if(searchContent.)
			});
		});
	</script>
</body>
</html>