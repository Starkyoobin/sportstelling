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
	//스포츠Q&A 게시물 상세
	public QnA selectQnAByQnAId(@Param("id") int id);
	//스포츠Q&A 게시물 수정 삭제 데이터 불러오기
	public QnA selectQnAByIdUserId(
			@Param("id") int id
			, @Param("userId") int userId);
	//게시물 수정
	public int updateQnA(
			@Param("id") int id
			, @Param("userId") int userId
			, @Param("subject") String subject
			, @Param("content") String content);
	//게시물 삭제
	public int deleteQnA(
			@Param("id") int id
			, @Param("userId") int userId);
}
