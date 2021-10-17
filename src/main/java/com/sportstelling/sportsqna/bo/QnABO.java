package com.sportstelling.sportsqna.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sportstelling.common.FileManagerService;
import com.sportstelling.sportsqna.comment.bo.CommentBO;
import com.sportstelling.sportsqna.comment.model.Comment;
import com.sportstelling.sportsqna.dao.QnADAO;
import com.sportstelling.sportsqna.model.QnA;
import com.sportstelling.sportsqna.model.QnADetail;

@Service
public class QnABO {
	@Autowired
	private QnADAO qnaDAO;
	@Autowired
	private CommentBO commentBO;
	
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
	public QnADetail getQnA(int id) {
		List<Comment> commentList = commentBO.getCommentList(id);
		
		QnADetail qnaDetail = new QnADetail();
		qnaDetail.setQna(qnaDAO.selectQnAByQnAId(id));
		qnaDetail.setCommentList(commentList);
		
		return qnaDetail;
	}
	//스포츠Q&A 게시물 수정 삭제 데이터 불러오기
	public QnA getQnAByIdUserId(int id, int userId) {
		return qnaDAO.selectQnAByIdUserId(id, userId);
	}
	//게시물 수정
	public int updateQnA(int id, int userId, String subject, String content) {
		
		return qnaDAO.updateQnA(id, userId, subject, content);
	}
	//게시물 삭제
	public int deleteQnA(int id, int userId) {
		commentBO.deleteByQnAId(id);
		
		return qnaDAO.deleteQnA(id, userId);
	}
}
