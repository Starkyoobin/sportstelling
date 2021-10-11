package com.sportstelling.sportsfeed.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sportstelling.sportsfeed.model.Post;

@Repository
public interface PostDAO {
	//스포츠픠드 게시물 작성
	public int insertPost(
			@Param("userId") int userId
			, @Param("userNickName") String userNickName
			, @Param("imagePath") String imagePath
			, @Param("content") String content);
	//스포츠피드 게시물 리스트
	public List<Post> selectPostList();
}
