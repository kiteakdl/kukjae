package view;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import controller.JoinView;

class LoginFrame extends JFrame implements ActionListener {
	BufferedImage img = null;
	JTextField loginTextField;
	JPasswordField passwordField;
	JButton bt, bt1;
	private int lay_w = 300, lay_h = 400;
	private Dimension dim1, dim2;
	private int xpos, ypos;
	// 생성자
	public LoginFrame() {
		super("Login_test");
		this.init();
		this.start();
		setSize(lay_w, lay_h);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dim1 = Toolkit.getDefaultToolkit().getScreenSize(); 
		dim2 = this.getSize(); 
		xpos = (int) (dim1.getWidth() / 2 - dim2.getWidth() / 2);
		ypos = (int) (dim1.getHeight() / 2 - dim2.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.setVisible(true);
		this.setLayout(null);
		// 이미지 받아오기
		try {
			img = ImageIO.read(new File("img_test/a_background.png"));
		} catch (IOException e) {
			System.out.println("이미지 불러오기 실패");
			System.exit(0);
		}
	}
	class MyPanel extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}
	public void init() {//
		// 레이아웃 설정
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, lay_w, lay_h);
		layeredPane.setLayout(null);
		// 패널1
		MyPanel panel = new MyPanel();
		panel.setBounds(0, 0, lay_w, lay_h);
		// 로그인 필드
		loginTextField = new JTextField(15 / 2);
		loginTextField.setBounds(40, 160, 200, 30);
		loginTextField.setOpaque(true); // 투명화
		loginTextField.setForeground(Color.green);
		loginTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		layeredPane.add(loginTextField);
		// 패스워드
		passwordField = new JPasswordField();
		passwordField.setBounds(40, 200, 200, 30);
		passwordField.setOpaque(true);
		passwordField.setForeground(Color.green);
		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		layeredPane.add(passwordField);
		// 로그인 버튼 추가
		bt = new JButton(new ImageIcon("img_test/a_signin.png"));
		bt.setBounds(10, 305, 280, 50);
		// 회원가입 버튼 추가
		bt1 = new JButton("SIGN IN~!");
		bt1.setForeground(Color.white);
		bt1.setBounds(140, 250, 118, 25);
		// 버튼 투명처리 및 버튼 액션 리스터 셋팅
		bt.setBorderPainted(true);		bt.setFocusPainted(true);		bt.setContentAreaFilled(false);
		bt1.setBorderPainted(true);		bt1.setFocusPainted(true);		bt1.setContentAreaFilled(false);
		layeredPane.add(bt);
		layeredPane.add(bt1);
		// 마지막추가들
		layeredPane.add(panel);

		add(layeredPane);
		setVisible(true);
	}
	public void start(){
		// Event, Thread
		bt.addActionListener(this);
		bt1.addActionListener(this);	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bt) {
			JoinView ex = new JoinView();
			setVisible(false);
			//JOptionPane.showMessageDialog(null, "Login_Button~!");
		}else if(e.getSource() == bt1){
			JOptionPane.showMessageDialog(null, "New account~!");
		}else {
			JOptionPane.showMessageDialog(null, "What th...");
		}		
	}
}