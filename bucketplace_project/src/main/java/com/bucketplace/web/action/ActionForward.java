package com.bucketplace.web.action;

public class ActionForward {
	private boolean isRedirect;
	private String path;
	
	// 파라미터 없는 생성자 생성
	public ActionForward() {
	
	}
	// 여러개의 파라미터가 있는 생성자 생성
	public ActionForward(boolean isRedirect, String path) {
		super();
		this.isRedirect = isRedirect;
		this.path = path;
	}
	
	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
