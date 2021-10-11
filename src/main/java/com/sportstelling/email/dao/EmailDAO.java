package com.sportstelling.email.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailDAO {
	public int updateUserPassword(
			@Param("loginId") String loginId
			, @Param("password") String password
			, @Param("email") String email);
}
