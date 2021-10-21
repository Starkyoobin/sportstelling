package com.sportstelling.freepost.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sportstelling.freepost.comment.model.FreeComment;

@Repository
public interface FreeCommentDAO {
	//게시물 댓글 등록
	public int insertComment(
			@Param("freeId") int freeId
			, @Param("userId") int userId
			, @Param("userNickName") String userNickName
			, @Param("content") String content);
	//등록된 댓글 보이기
	public List<FreeComment> selectCommentListByFreeId(@Param("freeId") int freeId);
	//게시물 삭제시 모든 댓글 삭제
	public int deleteByFreeId(@Param("freeId") int freeId);
}
