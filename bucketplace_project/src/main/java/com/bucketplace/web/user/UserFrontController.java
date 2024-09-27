package com.bucketplace.web.user;

import java.io.IOException;

import com.bucketplace.web.action.ActionForward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.us")
public class UserFrontController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	public void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		String requestURI = req.getRequestURI();
		ActionForward forward = new ActionForward();
		switch (requestURI) {
			// 로그인 버튼을 눌렀을때
			// /user/UserLogin.us 에 맞으면
			case "/user/UserLogin.us" : {
				// System.out.println("frontcontroller 도착");
				// /web/user/login/login.html" 으로 이동
				forward = new ActionForward(false, "/web/user/login.html");
				break;
			}
			// 회원가입을 누를때
			case "/user/UserJoin.us" : {
				forward = new UserJoinAction().execute(req, resp);
				break;
			}
			// 로그인 했을 때
			case "/user/UserLoginOk.us" : {
				forward = new UserLoginOkAction().execute(req,resp);
				break;
			}
			// 로그아웃 했을 때	
		}
		
		// 페이지 이동에 대한 일괄처리
		if ( forward != null ) {
			
			if ( forward.isRedirect() ) {
				// redirect 방식으로 이동할 경우
				resp.sendRedirect(forward.getPath());
			} else {
				// foward 방식으로 이동할 경우
				req.getRequestDispatcher(forward.getPath()).forward(req, resp);
			}
			
		}
	}
}
