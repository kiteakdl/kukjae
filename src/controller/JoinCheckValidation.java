package controller;

public class JoinCheckValidation {

	
	public boolean checkID(){
		boolean result = false;
		
		result = true;
		//DB ���� ���� �� �� ��
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
}
