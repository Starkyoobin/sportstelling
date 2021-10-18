package com.sportstelling.freepost.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sportstelling.common.FileManagerService;
import com.sportstelling.freepost.dao.FreeDAO;
import com.sportstelling.freepost.model.Free;

@Service
public class FreeBO {
	@Autowired
	private FreeDAO freeDAO;
	//자유게시판 게시물 작성
	public int addFreepost(int userId, String userNickName, String subject, MultipartFile file, String content) {
		String filePath = null;
		
		if(file != null) {
			filePath = FileManagerService.saveFile(userId, file);
			
			if(filePath == null) {
				return -1;
			}
		}
		return freeDAO.insertFreepost(userId, userNickName, subject, filePath, content);
	}
	//자유게시판 리스트
	public List<Free> getFreepostList() {
		return freeDAO.selectFreepostList();
	}
	//자유게시판 게시물 상세
	public Free getFreepost(int id) {
		return freeDAO.selectFreepostByFreeId(id);
	}
}
