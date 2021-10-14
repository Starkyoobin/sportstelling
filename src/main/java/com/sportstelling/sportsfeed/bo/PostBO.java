package com.sportstelling.sportsfeed.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sportstelling.common.FileManagerService;
import com.sportstelling.sportsfeed.dao.PostDAO;
import com.sportstelling.sportsfeed.like.bo.LikeBO;
import com.sportstelling.sportsfeed.model.Post;
import com.sportstelling.sportsfeed.model.PostDetail;

@Service
public class PostBO {
	@Autowired
	private PostDAO postDAO;
	@Autowired
	private LikeBO likeBO;
	
	//스포츠피드 게시물 작성
	public int addPost(int userId, String userNickName, MultipartFile file, String content) {
		String filePath = null;
		
		if(file != null) {
			filePath = FileManagerService.saveFile(userId, file);
		}
		
		return postDAO.insertPost(userId, userNickName, filePath, content);
	}
	//스포츠피드 게시물
	public List<PostDetail> getPostList(int userId) {
		List<Post> postList = postDAO.selectPostList();
		List<PostDetail> postDetailList = new ArrayList<>();
		
		for(Post post : postList) {
			//해당 게시물을 현재 로그인한 사용자가 좋아요 했는지 확인
			boolean isLike = likeBO.checkLikeByUserIdPostId(userId, post.getId());
			//해당 게시물 좋아요 수
			int likeCount = likeBO.likeCount(post.getId());
			//post와 좋아요
			PostDetail postDetail = new PostDetail();
			postDetail.setLike(isLike);
			postDetail.setLikeCount(likeCount);
			postDetail.setPost(post);
			
			postDetailList.add(postDetail);
		}
		return postDetailList;
	}
	//스포츠피드 게시물 삭제
	public boolean removePost(int userId, int postId) {
		Post post = postDAO.selectPost(postId);
		
		int count = postDAO.deletePost(userId, postId);
		
		if(count != 1) {
			return false;
		}
		
		FileManagerService fileManagerService = new FileManagerService();
		fileManagerService.deleteFile(post.getImagePath());
		//좋아요 삭제
		likeBO.removeByPostId(postId);
		
		return true;
	}
}
