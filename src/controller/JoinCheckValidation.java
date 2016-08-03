package controller;

import java.util.regex.Pattern;

public class JoinCheckValidation {

	
	public boolean checkID(){
		boolean result = false;
		
		result = true;
		//DB 쿼리 전송 및 값 비교
		return result;
	}
	
	
	public boolean checkPW(String pw, String pw2){
		boolean result = false;
		
		if((pw.length() > 0 || pw2.length() >0) && pw.equals(pw2)){
			 result = true;
		}else{
			result = false;
		}
		
		return result;
	}
	
	public boolean checkEmail(String email){
		boolean result = false;
		boolean isCorrect1 = Pattern.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+$", email);
		boolean isCorrect2 = Pattern.matches("^[_0-9a-zA-Z-]+@[0-9a-zA-Z-]+(.[_0-9a-zA-Z-]+)*$", email);
		
		if(isCorrect1==true || isCorrect2==true){
			result = true;
		}
		return result;
	}
	
	public boolean checkPhone(String phone){
		boolean result = Pattern.matches("[0-9]+", phone);
		return result;
	}
}
