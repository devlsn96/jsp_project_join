package com.bucketplace.web.user.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bucketplace.mybatis.SqlMapConfig;

public class UsersDAO {
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession session;

	public UsersDAO() {
		session = factory.openSession(true);
	}


	// 회원가입
	public boolean join(UsersDTO user) {
		boolean result = false;
		if ( session.insert("Users.join", user) == 1) {
			result = true;
		}
		return result;
	}

	// 로그인 처리
	public boolean login(String user_id, String password) {
		boolean result = false;
		HashMap<String, String> datas = new HashMap<>();
		
		datas.put("user_id", user_id);
		datas.put("password", password);
		
		if ( (Integer)session.selectOne("Users.login", datas) == 1) {
			result = true;
		}
		
		return result;
	}

}
