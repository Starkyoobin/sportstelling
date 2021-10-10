package com.sportstelling.email.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailDAO {
	public void updateUserPassword(
			@Param("loginId") String loginId
			, @Param("password") String password
			, @Param("email") String email);
}
