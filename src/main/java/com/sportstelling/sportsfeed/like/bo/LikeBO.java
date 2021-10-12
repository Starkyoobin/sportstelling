package com.sportstelling.sportsfeed.like.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportstelling.sportsfeed.like.dao.LikeDAO;

@Service
public class LikeBO {
	@Autowired
	private LikeDAO likeDAO;
	
	//피드 좋아요 관리
	public boolean addLike(int userId, int postId, String userNickName) {
		//좋아요 상태면 좋아요 취소
		if(this.checkLikeByUserIdPostId(userId, postId)) {
			int count = likeDAO.deleteLike(userId, postId);
			
			if(count == 0) {
				return false;
			} else {
				return true;
			}
		} else {	//좋아요 취소 상태면 좋아요 등록
			int count = likeDAO.insertLike(userId, postId, userNickName);
			
			if(count == 1) {
				return true;
			} else {
				return false;
			}
		}
	}
	//postId와 userId로 좋아요 여부 확인
	public boolean checkLikeByUserIdPostId(int userId, int postId) {
		int count = likeDAO.selectCountLikeByUserId(userId, postId);
		
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}
	//게시물 좋아요 개수 세기
	public int likeCount(int postId) {
		return likeDAO.countLikeByPostId(postId);
	}
}
