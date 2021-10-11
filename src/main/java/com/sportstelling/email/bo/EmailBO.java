package com.sportstelling.email.bo;

import java.security.SecureRandom;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportstelling.common.EncryptUtils;
import com.sportstelling.email.dao.EmailDAO;
import com.sportstelling.email.model.Email;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmailBO {
	@Autowired
	private EmailDAO emailDAO;
	
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
		return emailDAO.updateUserPassword(loginId, randomPassword, email);
	}
}
