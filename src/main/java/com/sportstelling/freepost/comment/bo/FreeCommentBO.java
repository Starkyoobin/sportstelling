package com.sportstelling.freepost.comment.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportstelling.freepost.comment.dao.FreeCommentDAO;
import com.sportstelling.freepost.comment.model.FreeComment;

@Service
public class FreeCommentBO {
	@Autowired
	private FreeCommentDAO commentDAO;
	//게시물 댓글 등록
	public int addComment(int freeId, int userId, String userNickName, String content) {
		return commentDAO.insertComment(freeId, userId, userNickName, content);
	}
	//등록된 댓글 보이기
	public List<FreeComment> getCommentList(int freeId) {
		return commentDAO.selectCommentListByFreeId(freeId);
	}
}
