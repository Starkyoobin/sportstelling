package com.sportstelling.sportsqna.model;

import java.util.List;

import com.sportstelling.sportsqna.comment.model.Comment;

public class QnADetail {
	private QnA qna;
	private List<Comment> commentList;
	public QnA getQna() {
		return qna;
	}
	public void setQna(QnA qna) {
		this.qna = qna;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
}
