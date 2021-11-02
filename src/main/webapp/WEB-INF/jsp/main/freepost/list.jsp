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
				<h2 class="text-center my-3">자유게시판</h2>
				<div class="m-4 d-flex justify-content-center">
					<select>
						<option value="all">전체</option>
						<option value="nickName">닉네임</option>
						<option value="title">제목</option>
					</select>
					<input type="text" id="searchInput" class="form-control">
					<button class="btn btn-info" id="searchBtn">검색</button>
				</div>
				
				<table class="table">
					<thead class="text-center">
						<tr>
							<th class="col-3">닉네임</th>
							<th class="col-7">제목</th>
							<th class="col-2">작성날짜</th>
						</tr>
					</thead>
					<tbody class="text-center">
						<c:forEach var="freepost" items="${myFreePostList }">
							<tr>
								<td class="col-3">${freepost.userNickName }</td>
								<td class="col-7"><a href="/main/freepost/detail_view?id=${freepost.id }" class="text-dark">${freepost.subject }</a></td>
								<td class="col-2">
									<fmt:formatDate var="createdAt" value="${freepost.createdAt }" pattern="yyyy-MM-dd" />
									${createdAt }
								</td>
							</tr>
						</c:forEach>
						<c:forEach var="freepost" items="${freepostList }">
							<tr>
								<td class="col-3">${freepost.userNickName }</td>
								<td class="col-7"><a href="/main/freepost/detail_view?id=${freepost.id }" class="text-dark">${freepost.subject }</a></td>
								<td class="col-2">
									<fmt:formatDate var="createdAt" value="${freepost.createdAt }" pattern="yyyy-MM-dd" />
									${createdAt }
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<div class="d-flex justify-content-between m-2">
					<!-- 현재 페이지 주소의 jsp주소 -->
					<c:set var="URI" value="${pageContext.request.requestURI}" />
					<!-- 현재 페이지 주소값 -->
					<c:set var="URL" value="${requestScope['javax.servlet.forward.request_uri']}" />
					
					<c:choose>
						<c:when test="${URL eq '/main/freepost/list_view' }">
							<button type="button" id="myPostView" class="btn btn-secondary">내 글 보기</button>						
						</c:when>
						<c:otherwise>						
							<button type="button" id="allPostView" class="btn btn-secondary">전체 보기</button>
						</c:otherwise>
					</c:choose>
					
					<a type="button" href="/main/freepost/create_view" class="btn btn-success">글쓰기</a>
				</div>
			</div>
			
			<c:import url="/WEB-INF/jsp/include/information.jsp" />
		</section>
		
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	
	<script>
		$(document).ready(function() {
			$("#myPostView").on("click", function() {
				$("#myPostView").addClass("d-none");
				$("#allPostView").removeClass("d-none");
				
				location.href = "/main/freepost/myfreepost_view";
			});
			
			$("#allPostView").on("click", function() {
				$("#myPostView").removeClass("d-none");
				$("#allPostView").addClass("d-none");
				
				location.href = "/main/freepost/list_view";
			});
		});
	</script>
</body>
</html>