package com.sportstelling.sportsqna.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sportstelling.common.FileManagerService;
import com.sportstelling.sportsqna.dao.QnADAO;
import com.sportstelling.sportsqna.model.QnA;

@Service
public class QnABO {
	@Autowired
	private QnADAO qnaDAO;
	
	//스포츠Q&A 게시물 등록
	public int addQnA(int userId, String userNickName, String subject, MultipartFile file, String content) {
		String filePath = null;
		
		if(file != null) {
			filePath = FileManagerService.saveFile(userId, file);
			
			if(filePath == null) {
				return -1;
			}
		}
		return qnaDAO.insertQnA(userId, userNickName, subject, filePath, content);
	}
	//스포츠Q&A 게시물 리스트
	public List<QnA> getQnAList() {
		return qnaDAO.selectQnAList();
	}
	//스포츠Q&A 게시물 상세
	public QnA getQnA(int id) {
		return qnaDAO.selectQnAByQnAId(id);
	}
}
