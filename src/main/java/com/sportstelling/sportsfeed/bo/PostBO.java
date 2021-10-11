package com.sportstelling.sportsfeed.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sportstelling.common.FileManagerService;
import com.sportstelling.sportsfeed.dao.PostDAO;
import com.sportstelling.sportsfeed.model.Post;

@Service
public class PostBO {
	@Autowired
	private PostDAO postDAO;
	
	//스포츠피드 게시물 작성
	public int addPost(int userId, String userNickName, MultipartFile file, String content) {
		String filePath = null;
		if(file != null) {
			filePath = FileManagerService.saveFile(userId, file);
			
			if(filePath == null) {
				return 0;
			}
		}
		
		return postDAO.insertPost(userId, userNickName, filePath, content);
	}
	//스포츠피드 게시물
	public List<Post> getPostList(int userId) {
		List<Post> postList = postDAO.selectPostList();
		return postList;
	}
}
