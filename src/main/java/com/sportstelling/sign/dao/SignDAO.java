package com.sportstelling.sign.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SignDAO {
	public int insertSign(
			@Param("loginId") String loginId
			, @Param("password") String password
			, @Param("name") String name
			, @Param("nickName") String nickName
			, @Param("email") String email);
	
	public int selectCountById(@Param("loginId") String loginId);
}
