package com.sportstelling.freepost.model;

import java.util.List;

import com.sportstelling.freepost.comment.model.FreeComment;

public class FreeDetail {
	private Free free;
	private List<FreeComment> commentList;
	public Free getFree() {
		return free;
	}
	public void setFree(Free free) {
		this.free = free;
	}
	public List<FreeComment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<FreeComment> commentList) {
		this.commentList = commentList;
	}
}
