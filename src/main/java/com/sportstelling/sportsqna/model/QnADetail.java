package com.sportstelling.sportsqna.model;

import java.util.List;

import com.sportstelling.sportsqna.comment.model.QnAComment;

public class QnADetail {
	private QnA qna;
	private List<QnAComment> commentList;
	public QnA getQna() {
		return qna;
	}
	public void setQna(QnA qna) {
		this.qna = qna;
	}
	public List<QnAComment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<QnAComment> commentList) {
		this.commentList = commentList;
	}
}
