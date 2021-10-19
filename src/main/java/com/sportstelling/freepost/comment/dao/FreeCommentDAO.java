package com.sportstelling.freepost.comment.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FreeCommentDAO {
	public int insertComment(
			@Param("freeId") int freeId
			, @Param("userId") int userId
			, @Param("userNickName") String userNickName
			, @Param("content") String content);
}
