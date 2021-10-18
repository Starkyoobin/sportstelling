package com.sportstelling.freepost.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sportstelling.freepost.model.Free;

@Repository
public interface FreeDAO {
	//자유게시판 게시물 작성
	public int insertFreepost(
			@Param("userId") int userId
			, @Param("userNickName") String userNickName
			, @Param("subject") String subject
			, @Param("imagePath") String imagePath
			, @Param("content") String content);
	//자유게시판 리스트
	public List<Free> selectFreepostList();
	//자유게시판 게시물 상세
	public Free selectFreepostByFreeId(@Param("id") int id);
}
