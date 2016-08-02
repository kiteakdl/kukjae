package view;

import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.DateJComboBox;
import controller.JoinActionListener;

//300*400
//크기 수정 불가

class JoinMember_Excute3 {
	public static void main(String[] args) {
		JoinView ex = new JoinView();
	}
}

public class JoinView{
	/*계정정보 필드 선언*/
	private JPanel panel_accountInfo = new JPanel();
	
    private JLabel label_id = new JLabel("아이디");
    private JTextField field_id = new JTextField(16);
    private JLabel label_pw = new JLabel("비밀번호");
    private JPasswordField field_pw = new JPasswordField(16);
    private JLabel label_pw2 = new JLabel("비밀번호확인");
    private JPasswordField field_pw2 = new JPasswordField(16);
    private JButton btn_chk_id = new JButton("중복확인");

    /*상세정보 필드 선언*/
	private JPanel panel_basicInfo = new JPanel();
	
    private JLabel label_name = new JLabel("이름");
    private JTextField field_name = new JTextField(10);
    
    private JLabel label_sex = new JLabel("성별");
    private JPanel panel_sex = new JPanel();
    private ButtonGroup bg_sex = new ButtonGroup();
    private JRadioButton radio_sex_man = new JRadioButton("남자");
    private JRadioButton radio_sex_woman = new JRadioButton("여자");
    
    private JLabel label_birth = new JLabel("생일");
    private JPanel panel_birth = new JPanel();
    private DateJComboBox dt_combo = new DateJComboBox();
    private JComboBox<String> combo_year = dt_combo.getYear();
    private JComboBox<String> combo_month = dt_combo.getMonth();
    private JComboBox<String> combo_day = dt_combo.getDay();
    
    private JLabel label_email = new JLabel("이메일");
    private JTextField field_email = new JTextField(16);
    private JLabel label_phone = new JLabel("휴대전화번호");
    private JTextField field_phone = new JTextField(16);
    
    private JLabel label_addr = new JLabel("주소");
    private JTextArea field_addr = new JTextArea();
    
    /*하단 버튼 부분  필드 선언*/
	private JPanel panel_button = new JPanel();
	private JButton btn_submit = new JButton("가입하기");
	private JButton btn_cancel = new JButton("취소");
	
    
    public JoinView() {
        JFrame f = new JFrame("회원가입");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));
        
        /*계정정보*/
        panel_accountInfo.setBorder(BorderFactory.createTitledBorder("계정정보"));
        GroupLayout layout = new GroupLayout(panel_accountInfo);          
        panel_accountInfo.setLayout(layout);
        layout.setAutoCreateGaps(true); //컴포넌트간의 간격 자동 설정
        layout.setAutoCreateContainerGaps(true); //컨테이너간의 간격 자동 설정
        
        
        //세로
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(label_id)
                .addComponent(label_pw)
                .addComponent(label_pw2))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(field_id)            
                .addComponent(field_pw)
                .addComponent(field_pw2))
            	.addComponent(btn_chk_id)
        );
        
        //가로
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label_id)
                .addComponent(field_id)
                .addComponent(btn_chk_id))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label_pw)
                .addComponent(field_pw))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label_pw2)
                .addComponent(field_pw2))
            
        );
        /*끝 : 계정정보*/
        
        
        /*기본정보*/
        panel_basicInfo.setBorder(BorderFactory.createTitledBorder("기본정보"));
        GroupLayout layout2 = new GroupLayout(panel_basicInfo);          
        panel_basicInfo.setLayout(layout2);
        layout2.setAutoCreateGaps(true); //컴포넌트간의 간격 자동 설정
        layout2.setAutoCreateContainerGaps(true); //컨테이너간의 간격 자동 설정
    	
        bg_sex.add(radio_sex_man);
        bg_sex.add(radio_sex_woman);
        panel_sex.add(radio_sex_man);
        panel_sex.add(radio_sex_woman);
        panel_sex.add(field_name);

    	panel_birth.add(combo_year);
    	panel_birth.add(combo_month);
    	panel_birth.add(combo_day);
        
    	field_addr.setColumns(25);
    	field_addr.setRows(2);
    	field_addr.setLineWrap (true);
    	JScrollPane field_addr_scroll = new JScrollPane(field_addr); //주소 필드 크기 고정을 위한 스크롤 생성
    	
    	//세로
        layout2.setHorizontalGroup(layout2.createSequentialGroup()
                .addGroup(layout2.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(label_name)
                    .addComponent(label_sex)
                    .addComponent(label_birth)
                    .addComponent(label_email)
                    .addComponent(label_phone)
                    .addComponent(label_addr))
                .addGroup(layout2.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(field_name)
                    .addComponent(panel_sex)
                    .addComponent(panel_birth)
                    .addComponent(field_email)
                    .addComponent(field_phone)
                    .addComponent(field_addr_scroll))
            );
            
        //가로
        layout2.setVerticalGroup(layout2.createSequentialGroup()
                .addGroup(layout2.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(label_name)
	                    .addComponent(field_name))
                .addGroup(layout2.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label_sex)
                        .addComponent(panel_sex))
                .addGroup(layout2.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label_birth)
                        .addComponent(panel_birth))
                .addGroup(layout2.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label_email)
                        .addComponent(field_email))
                .addGroup(layout2.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label_phone)
                        .addComponent(field_phone))
                .addGroup(layout2.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label_addr)
                        .addComponent(field_addr_scroll))
            );
        /*끝 : 상세정보*/
        
        /*하단 버튼*/
        FlowLayout layout3 = new FlowLayout();
        panel_button.add(btn_submit);
        panel_button.add(btn_cancel);
        panel_button.setLayout(layout3);
        /*끝 : 하단 버튼*/
        
        /*리스너 연결*/
        btn_chk_id.addActionListener(new JoinActionListener(this));
        btn_submit.addActionListener(new JoinActionListener(this));
        btn_cancel.addActionListener(new JoinActionListener(this));
        field_pw2.addActionListener(new JoinActionListener(this));
        
        f.add(panel_accountInfo);
        f.add(panel_basicInfo);
        f.add(panel_button);
        
        
        f.add(Box.createVerticalGlue());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }


	public JPasswordField getField_pw() {
		return field_pw;
	}

	public JPasswordField getField_pw2() {
		return field_pw2;
	}

	public void setField_id(JTextField field_id) {
		this.field_id = field_id;
	}

	public JTextField getField_id() {
		return field_id;
	}
}