package com.bucketplace.web.user;

import com.bucketplace.web.action.Action;
import com.bucketplace.web.action.ActionForward;
import com.bucketplace.web.user.dao.UsersDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserLoginOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		UsersDAO udao = new UsersDAO();
		
		String user_id = req.getParameter("user_id");
		String password = req.getParameter("password");
		
		forward.setRedirect(true);
		if (udao.login(user_id, password)) {
			// 로그인 성공
			forward.setPath("/web/main/mainview.html");
		} else {
			// 로그인 실패
			forward.setPath("/web/user/login.html");
		}
		return forward;
	}

}
