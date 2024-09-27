/**
 * 
 */
// 회원가입 유효성 체크
// 태그 호출
	let frm = document.joinForm;
	// 입력값 가져오기
	let user_id = frm.getElementById("user_id");
	let password = frm.getElementById("password");
	let password_re = frm.getElementById("password_re");
	

	// 아이디 빈값 처리
	if (user_id.value == "") {
		alert("아이디를 입력해주세요");
		user_id.focus();
		return false;
	}
	
	// 비밀번호 빈값 처리
	if (password.value == "") {
		alert("비밀번호를 입력해주세요");
		password.focus();
		return false;
	}
	// 비밀번호 8자리 이상 처리
	if (password.value.length < 8) {
		alert("비밀번호의 자리수는 8자리 이상으로 작성해주세요");
		password.focus();
		return false;
	}
	// 비밀번호 == 비밀번호 확인 처리
	if (password.value != password_re.value) {
		alert("비밀번호 확인을 다시 하세요");
		password_re.focus();
		return false;
	}
	// 폼으로 전달
	frm.submit();
	
	// 아이디 중복 체크
	function checkId() {
		
	}
	
	// 로그인에 대한 유효성 검사
	    function login() {
	    	let frm = document.loginForm;
	    	let user_id = frm.user_id;
	    	let password = frm.password;
	    	// 아이디 빈값
	    	if (user_id.value == "") {
	    		alert("아이디를 입력하세요");
	    		user_id.focus();
	    		return false;
	    	}
	    	// 비밀번호 빈값 체크
	    	if (password.value == "") {
	    		alert("비밀번호를 입력하세요");
	    		password.focus();
	    		return false;
	    	}
	    	frm.submit();
	    }