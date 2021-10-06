package com.sportstelling.sign.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sportstelling.sign.model.Sign;

@Repository
public interface SignDAO {
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
	public Sign selectSignByLoginIdPassword(
			@Param("loginId") String loginId
			, @Param("password") String password);
}
