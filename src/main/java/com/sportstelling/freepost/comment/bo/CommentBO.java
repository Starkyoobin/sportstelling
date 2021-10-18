package com.sportstelling.freepost.comment.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportstelling.freepost.comment.dao.CommentDAO;

@Service
public class CommentBO {
	@Autowired
	private CommentDAO commentDAO;
	
	public int addComment(int freeId, int userId, String userNickName, String content) {
		return commentDAO.insertComment(freeId, userId, userNickName, content);
	}
}
