package com.sportstelling.sportsqna.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sportstelling.sportsqna.model.QnA;

@Repository
public interface QnADAO {
	//스포츠Q&A 게시물 등록
	public int insertQnA(
			@Param("userId") int userId
			, @Param("userNickName") String userNickName
			, @Param("subject") String subject
			, @Param("imagePath") String imagePath
			, @Param("content") String content);
	//스포츠Q&A 게시물 리스트
	public List<QnA> selectQnAList();
}
