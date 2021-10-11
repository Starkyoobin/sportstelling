package com.sportstelling.sportsfeed.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDAO {
	//스포츠픠드 게시물 작성
	public int insertPost(
			@Param("userId") int userId
			, @Param("userNickName") String userNickName
			, @Param("imagePath") String imagePath
			, @Param("content") String content);
}
