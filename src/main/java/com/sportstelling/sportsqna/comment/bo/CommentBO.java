package com.sportstelling.sportsqna.comment.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportstelling.sportsqna.comment.dao.CommentDAO;

@Service
public class CommentBO {
	@Autowired
	private CommentDAO commentDAO;
	
	//게시물 댓글 등록
	public int addComment(int qnaId, int userId, String userNickName, String content) {
		return commentDAO.insertComment(qnaId, userId, userNickName, content);
	}
}
