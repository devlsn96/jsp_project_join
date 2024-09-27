package com.bucketplace.web.user;

import com.bucketplace.web.action.Action;
import com.bucketplace.web.action.ActionForward;
import com.bucketplace.web.user.dao.UsersDAO;
import com.bucketplace.web.user.dao.UsersDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserJoinAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		UsersDTO user = new UsersDTO();
		UsersDAO udao = new UsersDAO();
		
		// 요청받아온 키값을 dto에 세팅
		user.setUser_id(req.getParameter("user_id"));
		user.setName(req.getParameter("name"));
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
		user.setNickname(req.getParameter("nickname"));
		user.setTel(req.getParameter("tel"));
		
		// dao에서 MyBatis로 커넥션된 db의 insert처리되면
		if ( udao.join(user) ) {
			// 회원가입 성공처리
			forward.setRedirect(true);
			forward.setPath("/web/user/login.html");
		} else {
			// 회원가입 실패처리
			forward.setRedirect(true);
			forward.setPath("/index.html");
		}
		return forward;
	}

	

	
	
	
}
