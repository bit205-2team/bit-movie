import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp extends JPanel implements ActionListener{
	
	Font fn = new Font("굴림",Font.BOLD,20);
	
	public SignUp() {
		JButton btnid = new JButton("중복확인");
		JButton sginupbtn = new JButton("회원가입");
		
		JLabel sginuplb = new JLabel("회원가입");
		JLabel idlb = new JLabel("ID");
		JLabel pawlb = new JLabel("password");
		JLabel namelb = new JLabel("name");
		JLabel birthlb = new JLabel("birth");
		JLabel telb = new JLabel("tel");
		JLabel emailb = new JLabel("email");
		
		JTextField textfieldid = new JTextField();
		JPasswordField textfieldpaw = new JPasswordField(12);
		JTextField textfieldname = new JTextField();
		JTextField textfieldbirth = new JTextField();
		JTextField textfieldtel = new JTextField();
		JTextField textfieldemail = new JTextField();
		
		setLayout(null);
		setBackground(Color.white);
		
		//회원가입 150,40 가 세
		sginuplb.setFont(new Font("굴림",Font.BOLD,30));
		sginuplb.setBounds(500,40,150,40);
		
		//ID
		idlb.setFont(new Font("굴림",Font.BOLD,30));
		idlb.setBounds(320,2,100,236);
		idlb.setHorizontalAlignment(JLabel.RIGHT);;
		textfieldid.setBounds(430,105,270,30);
		
		//중복확인
		btnid.setBounds(710,110,100,20);
		btnid.addActionListener(this);
		
		//password
		pawlb.setFont(new Font("굴림",Font.BOLD,30));
		pawlb.setBounds(260,50,250,236);
		textfieldpaw.setBounds(430,155,270,30);
		textfieldpaw.setEchoChar('*');
		//name
		namelb.setFont(new Font("굴림",Font.BOLD,30));
		namelb.setBounds(320,100,250,236);
		textfieldname.setBounds(430,205,270,30);
		
		//birth
		birthlb.setFont(new Font("굴림",Font.BOLD,30));
		birthlb.setBounds(335,150,250,236);
		textfieldbirth.setBounds(430,255,270,30);
		
		//tel
		telb.setFont(new Font("굴림",Font.BOLD,30));
		telb.setBounds(363,200,250,236);
		textfieldtel.setBounds(430,305,270,30);
		
		//email
		emailb.setFont(new Font("굴림",Font.BOLD,30));
		emailb.setBounds(323,250,250,236);
		textfieldemail.setBounds(430,355,270,30);
		
		//회원가입 버튼
		sginupbtn.setBounds(465,400,200,30);
		
		add(sginuplb);
		add(idlb);
		add(textfieldid);
		add(btnid);
		add(pawlb);
		add(textfieldpaw);
		
		add(textfieldname);
		add(namelb);
		
		add(textfieldbirth);
		add(birthlb);
		
		add(textfieldtel);
		add(telb);
		
		add(textfieldemail);
		add(emailb);
		
		add(sginupbtn);
		
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton button = (JButton)e.getSource();
		String btn = button.getText();
		if(btn.equals("중복확인")) {
			System.out.println("실행");
		}
		
	}
	
}