package com.sportstelling.user.bo;

import java.security.SecureRandom;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sportstelling.common.EncryptUtils;
import com.sportstelling.user.dao.UserDAO;
import com.sportstelling.user.model.Email;
import com.sportstelling.user.model.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserBO {
	@Autowired
	private UserDAO signDAO;
	@Autowired
	private JavaMailSender mailSender;
	private static final String FROM_ADDRESS = "yb010626@gmail.com";
	
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
	//로그인
	public User getSign(String loginId, String password) {
		String encryptPassword = EncryptUtils.md5(password);
		return signDAO.selectSignByLoginIdPassword(loginId, encryptPassword);
	}
	//아이디 찾기
	public User getId(String name, String email) {
		return signDAO.selectByNameEmail(name, email);
	}
	//비밀번호 찾기 (loginId, email 일치여부)
	public boolean getPassword(String loginId, String email) {
		User user = signDAO.selectByLoginIdEmail(loginId, email);
		
		if(user != null) {
			return true;
		} else {
			return false;
		}
	}
	//이메일 전송
	public Email sendEmail(String loginId, String email) {
		String randomPassword = this.getRandomPassword(10);
		Email dto = new Email();
		dto.setUserEmailAddress(email);
		dto.setTitle(loginId + "님의 SportsTelling 임시 비밀번호 안내 이메일입니다.");
		dto.setMessage(
				"안녕하세요. SportsTelling 임시 비밀번호 안내 관련 이메일입니다. ["
				+ loginId + "] 님의 임시 비밀번호는 "+ randomPassword + " 입니다."
				+ "로그인후 정보변경을 통해 비밀번호를 교체해주세요.");
		
		this.updatePassword(loginId, randomPassword, email);
		return dto;
	}
	
	//임시비밀번호 생성
	public String getRandomPassword(int size) {
		int index = 0;
		char[] charArray = new char[] {
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
				'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
				'!', '@', '#', '$', '%', '^', '&'
		};
		
		StringBuffer sb = new StringBuffer();
		SecureRandom sr = new SecureRandom();
		int len = charArray.length;
		
		for(int i = 0; i < size; i++) {
			index = sr.nextInt(len);
			sb.append(charArray[index]);
		}
		
		return sb.toString();
	}
	//임시 비밀번호로 변경
	public int updatePassword(String loginId, String password, String email) {
		String randomPassword = EncryptUtils.md5(password);
		return signDAO.updateUserPassword(loginId, randomPassword, email);
	}
	//STMP mailSend
	public void mailSend(Email email) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email.getUserEmailAddress());
		message.setFrom(UserBO.FROM_ADDRESS);
		message.setSubject(email.getTitle());
		message.setText(email.getMessage());
		
		mailSender.send(message);
	}
	//유저 정보 불러오기
	public List<User> getUser(String loginId) {
		List<User> userInfo = signDAO.selectUserByLoginId();
		return userInfo;
	}
}
