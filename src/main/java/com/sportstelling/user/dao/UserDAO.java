package com.sportstelling.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sportstelling.user.model.User;

@Repository
public interface UserDAO {
	//회원가입
	public int insertSign(
			@Param("loginId") String loginId
			, @Param("password") String password
			, @Param("name") String name
			, @Param("nickName") String nickName
			, @Param("email") String email);
	//ID 중복체크
	public int selectCountById(@Param("loginId") String loginId);
	//닉네임 중복체크
	public int selectCountByNickName(@Param("nickName") String nickName);
	//로그인
	public User selectSignByLoginIdPassword(
			@Param("loginId") String loginId
			, @Param("password") String password);
	//아이디 찾기
	public User selectByNameEmail(
			@Param("name") String name
			, @Param("email") String email);
	//비밀번호 찾기
	public User selectByLoginIdEmail(
			@Param("loginId") String loginId
			, @Param("email") String email);
	
}
