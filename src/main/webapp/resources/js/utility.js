/**
 * Utility
 */

function langKorChkUtil(param) {
	console.log('langKorChk function::', param);
	
	var regex=  /^[ㄱ-ㅎ|ㅏ-ㅓ|가-힣\\s]*$/;
	if(regex.test(param)) {
		return true;
	}
}

function numberChkUtil(param) {
	console.log('numberChkUtil function::', param);
	var regex= /^[0-9]/g;
	
	if(regex.test(param)) {
		return true;
	}
}

function emailChkUtil(param) {
	console.log('emailChkUtil function::', param);
	var regex = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
	if(regex.test(param)) {
		return true;
	}
}

function passwordChkUtil(param) {
	console.log('passwordChkUtil function::', param);
	var regex = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/;
	
	if(regex.test(param)) {
		return true;
	}
}