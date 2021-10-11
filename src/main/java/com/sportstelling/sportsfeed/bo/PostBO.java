package com.sportstelling.sportsfeed.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sportstelling.common.FileManagerService;
import com.sportstelling.sportsfeed.dao.PostDAO;

@Service
public class PostBO {
	@Autowired
	private PostDAO postDAO;
	
	//스포츠피드 게시물 작성
	public int addPost(int userId, String userNickName, MultipartFile file, String content) {
		String imagePath = null;
		if(file != null) {
			imagePath = FileManagerService.saveFile(userId, file);
			if(imagePath == null) {
				return 0;
			}
		}
		
		return postDAO.insertPost(userId, userNickName, imagePath, content);
	}
}
