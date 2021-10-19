package com.sportstelling.sportsqna.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sportstelling.sportsqna.comment.model.Comment;

@Repository
public interface QnACommentDAO {
	//게시물 댓글 등록
	public int insertComment(
			@Param("qnaId") int qnaId
			, @Param("userId") int userId
			, @Param("userNickName") String userNickName
			, @Param("content") String content);
	//등록된 댓글 보이기
	public List<Comment> selectCommentListByQnAId(@Param("qnaId") int qnaId);
	//게시물 삭제시 모든 댓글 삭제
	public int deleteCommentByQnAId(@Param("qnaId") int qnaId);
}
