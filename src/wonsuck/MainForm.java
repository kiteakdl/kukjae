package wonsuck;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class MainForm_sub extends JFrame implements ActionListener{
 private Dimension dim1, dim2;
 private int xpos, ypos;
 float WGT = 0, BMI = 0, FAT= 0;		// Weight(몸무게), BMI, Fast(지방) 상단부 보더레이아웃 요소
 Button INFOSET= new Button("인바디/체중기록");				//하단버튼
 Button STATUS = new Button("상세결과");			//하단버튼
 JTextField WGT_tf = new JTextField("몸무게");
 JTextField Mscl_tf = new JTextField("근육");
 JTextField BF_tf = new JTextField("체지방률");

 JLabel WGT_lb = new JLabel("체중(kg)", Label.LEFT);
 JLabel BF_lb = new JLabel("체지방률(%)",Label.LEFT);
 JLabel Mscl_lb = new JLabel("근육량(kg)",Label.LEFT);
 JLabel LOGO = new JLabel("InBody",Label.LEFT);
		
 public MainForm_sub(){//생성자
  super("인바디");
  this.init();
  this.start();
  this.setSize(300, 400);
  dim1 = Toolkit.getDefaultToolkit().getScreenSize();
  dim2 = this.getSize();
  xpos = (int)(dim1.getWidth()/2 - dim2.getWidth()/2);
  ypos = (int)(dim1.getHeight()/2 - dim2.getHeight()/2);
  this.setLocation(xpos, ypos);
  this.setVisible(true);
 }
 public void init(){
  //화면 구성
 // Panel Center_p = new Panel(new GridLayout(3,1,10,40));		// 중앙 정보 패널 3행 (체중 / 근육량 / 체지방율)
  Panel Cin_p = new Panel(new GridLayout(7,2,10,10));	// 중앙 패널 그리드레이아웃 ( 레이블과 텍스트필드 순차배치용)
  Panel LOGO_p = new Panel();
  Panel South_p = new Panel (new GridLayout(1,2));
  
  BorderLayout border = new BorderLayout();			//전체 보더레이아웃 패널
  this.setLayout(border);
  
  LOGO.setFont(new Font("HY견고딕 보통",Font.PLAIN,25));
  LOGO_p.add(LOGO);																// LOGO패널 - 노스  
  
  Cin_p.add(WGT_lb);
  Cin_p.add(WGT_tf);
  Cin_p.add(Mscl_lb);
  Cin_p.add(Mscl_tf);
  Cin_p.add(BF_lb);
  Cin_p.add(BF_tf);									// 중앙정보패널 - 센터
  
  South_p.add(INFOSET);
  South_p.add(STATUS);						// 하단버튼패널  - 사우스
  
  this.add(LOGO_p, "North");
  this.add(Cin_p, "Center");
  this.add(South_p, "South");				// 각 패널 보더레이아웃 프레임에 위치
  
 }
 public void start(){
  //Event, Thread
  
  
  this.addWindowListener(new WindowAdapter() {
   @Override
   public void windowClosing(WindowEvent e) {
    // TODO Auto-generated method stub
    super.windowClosing(e);
    System.exit(0);
   }
  }); 
 }
 @Override
 public void actionPerformed(ActionEvent e) {
  
 }
}
public class MainForm {
 //public void main(String[] ar){
 // MainForm_sub ex = new MainForm_sub();
 //}
}
 