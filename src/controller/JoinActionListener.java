package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import view.JoinView;
import view.LoginFrame;

public class JoinActionListener implements ActionListener{
	String id, pw, pw2, email, phone, name;
	boolean sex_man, sex_woman;
	int year, month, day;
	
	JoinView form;

	public JoinActionListener(JoinView form) {
		this.form = form;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		String text = b.getText().trim();
		id = form.getField_id().getText();
		pw = form.getField_pw().getText().trim();
		pw2 = form.getField_pw2().getText().trim();
		email = form.getField_email().getText().trim();
		phone= form.getField_phone().getText().trim();
		name = form.getField_name().getText().trim();
		sex_man = form.getRadio_sex_man().isSelected();
		sex_woman = form.getRadio_sex_woman().isSelected();
		year = form.getCombo_year().getSelectedIndex();
		month = form.getCombo_month().getSelectedIndex();
		day = form.getCombo_day().getSelectedIndex();
		
		String msg = "";
		boolean canUseID = false;
		JoinCheckValidation chk = new JoinCheckValidation();
		
		
		switch (text) {
		case "중복확인":
			
			if(id.equals("")){
				msg =  "ID를 입력하세요";
			}else{
				canUseID = chk.checkID();
				//DB 쿼리 전송 및 값 비교
				if(canUseID){
					msg = "사용 가능한 ID입니다.";
				}else{
					msg = "이미 사용중인 ID입니다.";
				}
			}
			JOptionPane.showMessageDialog(null, msg);
			break;
			
		case "가입하기":
			boolean isPassed = false;
			
			if(id.length()==0){
				msg =  "ID를 입력하세요.";
				form.getField_id().requestFocus();
			}else if(!chk.checkID()){
				msg = "ID 중복 여부 확인을 해주세요.";
			}else if(pw.length()==0 || pw2.length()==0){
				msg = "비밀번호를 입력하세요.";
				form.getField_pw().requestFocus();
			}else if(!chk.checkPW(pw, pw2)){
				msg = "비밀번호가 일치하지 않습니다.";
				form.getField_pw2().requestFocus();
			}else if(name.length()==0){
				msg = "이름을 입력하세요.";
				form.getField_name().requestFocus();
			}else if(!sex_man&&!sex_woman){
				msg = "성별을 선택해 주세요.";
			}else if(year+month+day<3){
				msg = "생일을 정확히 선택해 주세요.";		
			}else if(!chk.checkEmail(email)){
				msg = "정확한 이메일을 입력해 주세요.";
				form.getField_email().requestFocus();
			}else if(!chk.checkPhone(phone)){
				msg = "휴대전화번호는 '-'없이 숫자만 입력해 주세요.";
				form.getField_phone().requestFocus();
			}else{
				isPassed = true;
			}
			
			if(isPassed){
				//DB 연결 및 인서트 필요
				msg = "환영합니다. 가입되었습니다.";
				JOptionPane.showMessageDialog(null, msg);
				closeJoinView();
			}else{
				JOptionPane.showMessageDialog(null, msg);
			}
			break;
			
		case "취소":
			int opCancel = JOptionPane.showConfirmDialog(null, "회원가입을 취소하시겠습니까?", "회원가입 취소", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(opCancel==0){
				closeJoinView();
			}
			break;
		}//switch end
		
	}
	
	public void closeJoinView(){
		form.getJoinView().dispose();
		view.LoginFrame lf = new LoginFrame();
		lf.getLoginFrame().setVisible(true);
	}

}



