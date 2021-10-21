package com.sportstelling.freepost.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sportstelling.freepost.model.Free;

@Repository
public interface FreeDAO {
	//게시물 작성
	public int insertFreepost(
			@Param("userId") int userId
			, @Param("userNickName") String userNickName
			, @Param("subject") String subject
			, @Param("imagePath") String imagePath
			, @Param("content") String content);
	//리스트
	public List<Free> selectFreepostList();
	//게시물 상세
	public Free selectFreepostByFreeId(@Param("id") int id);
	//수정 / 삭제 데이터 불러오기
	public Free selectFreepostByIdUserId(
			@Param("id") int id
			, @Param("userId") int userId);
	//게시물 수정
	public int updateFreepost(
			@Param("id") int id
			, @Param("userId") int userId
			, @Param("subject") String subject
			, @Param("content") String content);
}
