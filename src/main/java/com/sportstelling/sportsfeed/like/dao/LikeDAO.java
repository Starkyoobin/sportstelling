package com.sportstelling.sportsfeed.like.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeDAO {
	//피드 좋아요 관리
	public int insertLike(
			@Param("userId") int userId
			, @Param("postId") int postId
			, @Param("userNickName") String userNickName);
	//postId와 userId로 좋아요 여부 확인
	public int selectCountLikeByUserId(
			@Param("userId") int userId
			, @Param("postId") int postId);
	//피드 좋아요 취소
	public int deleteLike(
			@Param("userId") int userId
			, @Param("postId") int postId);
	//게시물 좋아요 개수 세기
	public int countLikeByPostId(@Param("postId") int postId);
}
