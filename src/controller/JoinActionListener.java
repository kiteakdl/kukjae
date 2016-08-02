package controller;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.JoinView;

public class JoinActionListener implements ActionListener{
	String id, pw, pw2 ;
//	JFrame frame = new JFrame();
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
			}else if(pw.length()==0 || pw2.length()==0){
				msg = "비밀번호를 입력하세요.";
				form.getField_pw().requestFocus();
			}else if(!chk.checkPW(pw, pw2)){
				msg = "비밀번호가 일치하지 않습니다.";
				form.getField_pw2().requestFocus();
			}else if(!chk.checkID()){
				msg = "ID 중복 여부 확인을 해주세요.";
			}else{
				isPassed = true;
			}
			
			if(isPassed) msg = "환영합니다. 가입되었습니다.";
			
			JOptionPane.showMessageDialog(null, msg);
			break;
			
		case "취소":
			int opCancel = JOptionPane.showConfirmDialog(null, "회원가입을 취소하시겠습니까?", "회원가입 취소", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(opCancel==0){
				System.exit(0);
			}
			break;
		}
	}

}



