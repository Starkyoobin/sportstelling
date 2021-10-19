package com.sportstelling.sportsqna.comment.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportstelling.sportsqna.comment.dao.QnACommentDAO;
import com.sportstelling.sportsqna.comment.model.Comment;

@Service
public class QnACommentBO {
	@Autowired
	private QnACommentDAO commentDAO;
	
	//게시물 댓글 등록
	public int addComment(int qnaId, int userId, String userNickName, String content) {
		return commentDAO.insertComment(qnaId, userId, userNickName, content);
	}
	//등록된 댓글 보이기
	public List<Comment> getCommentList(int qnaId) {
		return commentDAO.selectCommentListByQnAId(qnaId);
	}
	//게시물 삭제시 모든 댓글 삭제
	public int deleteByQnAId(int qnaId) {
		return commentDAO.deleteCommentByQnAId(qnaId);
	}
}
