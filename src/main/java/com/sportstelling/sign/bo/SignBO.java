package com.sportstelling.sign.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportstelling.common.EncryptUtils;
import com.sportstelling.sign.dao.SignDAO;

@Service
public class SignBO {
	@Autowired
	private SignDAO signDAO;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	//회원가입
	public int addSign(String loginId, String password, String name, String nickName, String email) {
		//password 암호화
		String encryptPassword = EncryptUtils.md5(password);
		if(encryptPassword.equals("")) {
			logger.error("[SignBO signUp] 암호화 실패");
			return 0;
		}
		
		return signDAO.insertSign(loginId, encryptPassword, name, nickName, email);
	}
	//ID 중복체크
	public boolean isDuplicateId(String loginId) {
		if(signDAO.selectCountById(loginId) == 0) {
			return false;
		} else {
			return true;
		}
	}
	//닉네임 중복체크
	public boolean isDuplicateNickName(String nickName) {
		if(signDAO.selectCountByNickName(nickName) == 0) {
			return false;
		} else {
			return true;
		}
	}
}
