package com.bucketplace.web.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Action {
	// 설계도면역할 : forward방식으로 실행할 지에 대한 req, resp를 갖는 메서드를 호출
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp);

}
