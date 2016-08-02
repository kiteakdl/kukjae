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
		case "�ߺ�Ȯ��":
			
			if(id.equals("")){
				msg =  "ID�� �Է��ϼ���";
			}else{
				canUseID = chk.checkID();
				//DB ���� ���� �� �� ��
				if(canUseID){
					msg = "��� ������ ID�Դϴ�.";
				}else{
					msg = "�̹� ������� ID�Դϴ�.";
				}
			}
			JOptionPane.showMessageDialog(null, msg);
			break;
			
		case "�����ϱ�":
			boolean isPassed = false;
			
			if(id.length()==0){
				msg =  "ID�� �Է��ϼ���.";
				form.getField_id().requestFocus();
			}else if(pw.length()==0 || pw2.length()==0){
				msg = "��й�ȣ�� �Է��ϼ���.";
				form.getField_pw().requestFocus();
			}else if(!chk.checkPW(pw, pw2)){
				msg = "��й�ȣ�� ��ġ���� �ʽ��ϴ�.";
				form.getField_pw2().requestFocus();
			}else if(!chk.checkID()){
				msg = "ID �ߺ� ���� Ȯ���� ���ּ���.";
			}else{
				isPassed = true;
			}
			
			if(isPassed) msg = "ȯ���մϴ�. ���ԵǾ����ϴ�.";
			
			JOptionPane.showMessageDialog(null, msg);
			break;
			
		case "���":
			int opCancel = JOptionPane.showConfirmDialog(null, "ȸ�������� ����Ͻðڽ��ϱ�?", "ȸ������ ���", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(opCancel==0){
				System.exit(0);
			}
			break;
		}
	}

}



