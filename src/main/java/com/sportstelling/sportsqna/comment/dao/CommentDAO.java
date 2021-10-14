package com.sportstelling.sportsqna.comment.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDAO {
	//게시물 댓글 등록
	public int insertComment(
			@Param("qnaId") int qnaId
			, @Param("userId") int userId
			, @Param("userNickName") String userNickName
			, @Param("content") String content);
}
