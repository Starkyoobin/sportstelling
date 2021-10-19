package com.sportstelling.freepost.comment.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportstelling.freepost.comment.dao.FreeCommentDAO;

@Service
public class FreeCommentBO {
	@Autowired
	private FreeCommentDAO commentDAO;
	
	public int addComment(int freeId, int userId, String userNickName, String content) {
		return commentDAO.insertComment(freeId, userId, userNickName, content);
	}
}
