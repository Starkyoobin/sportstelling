package com.sportstelling.sportsqna.comment.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportstelling.sportsqna.comment.dao.CommentDAO;
import com.sportstelling.sportsqna.comment.model.Comment;

@Service
public class CommentBO {
	@Autowired
	private CommentDAO commentDAO;
	
	//게시물 댓글 등록
	public int addComment(int qnaId, int userId, String userNickName, String content) {
		return commentDAO.insertComment(qnaId, userId, userNickName, content);
	}
	//등록된 댓글 보이기
	public List<Comment> getCommentList(int qnaId) {
		return commentDAO.selectCommentListByQnAId(qnaId);
	}
}
