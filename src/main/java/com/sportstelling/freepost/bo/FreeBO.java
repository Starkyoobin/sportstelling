package com.sportstelling.freepost.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sportstelling.common.FileManagerService;
import com.sportstelling.freepost.comment.bo.FreeCommentBO;
import com.sportstelling.freepost.comment.model.FreeComment;
import com.sportstelling.freepost.dao.FreeDAO;
import com.sportstelling.freepost.model.Free;
import com.sportstelling.freepost.model.FreeDetail;

@Service
public class FreeBO {
	@Autowired
	private FreeDAO freeDAO;
	@Autowired
	private FreeCommentBO commentBO;
	
	//게시물 작성
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
	//리스트
	public List<Free> getFreepostList() {
		return freeDAO.selectFreepostList();
	}
	//게시물 상세
	public FreeDetail getFreepost(int id) {
		List<FreeComment> commentList = commentBO.getCommentList(id);
		
		FreeDetail freeDetail = new FreeDetail();
		freeDetail.setFree(freeDAO.selectFreepostByFreeId(id));
		freeDetail.setCommentList(commentList);
		return freeDetail;
	}
	//수정 / 삭제 데이터 불러오기
	public Free getFreepostByIdUserId(int id, int userId) {
		return freeDAO.selectFreepostByIdUserId(id, userId);
	}
	//게시물 수정
	public int updateFreepost(int id, int userId, String subject, String content) {
		return freeDAO.updateFreepost(id, userId, subject, content);
	}
}
