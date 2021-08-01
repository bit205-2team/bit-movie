import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import DBconnection.MovieDAO;

//추가파일
public class SignIn extends JPanel implements ActionListener{
	
	
	JPanel login = new JPanel();
	JPanel center = new JPanel();
	
	JPanel text = new JPanel();
	JPanel text1 = new JPanel();
	
	JLabel logLb = new JLabel("로그인");
	JButton btn = new JButton("로그인");
	
	JTextField id, pwd;
	
	public SignIn() {
		setBackground(Color.white);
		TitledBorder Loginpan = new TitledBorder(new TitledBorder(new LineBorder(Color.black,3)));
		TitledBorder Loginpan1 = new TitledBorder(new TitledBorder(new LineBorder(Color.black,3)));
		TitledBorder centerPan = new TitledBorder(new TitledBorder(new LineBorder(Color.black,2)));
		
		
		id = new JTextField(31);
		id.setBackground(Color.white);
		id.setBorder(Loginpan);
		id.setBounds(420, 100, 330, 60);
		
		pwd = new JTextField(31);
		pwd.setBorder(Loginpan1);
		pwd.setBounds(420, 170, 330, 60);

		login.setBounds(420,40,105,50);
		login.setBackground(Color.white);
		logLb.setFont(new Font("굴림",Font.BOLD,30));
		login.add(logLb);
		
		center.setBorder(centerPan);
		center.setBackground(Color.white);
		center.setBounds(-2,350,1188,350);
		
		btn.setBounds(430, 260, 310, 50);
		btn.setBackground(Color.pink);
		btn.addActionListener(this);
		
		setLayout(null);
		
		add(btn);
		add(id);
		add(pwd);
		add(center);
		add(login);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		MovieDAO dao = new MovieDAO();
		
		JButton button = (JButton)e.getSource();
	    String btn = button.getText();
		
	      if(btn.equals("로그인")) {
//	    	  System.out.println(id.getText()+"/"+pwd.getText());
	    	  if(dao.login(id.getText(), pwd.getText())) {
	    		  BitCinemaMain.userid = id.getText();
	    		  JOptionPane.showMessageDialog(null,"로그인 성공"); 
	    		  new BaseFrame(BitCinemaMain.userid);
	    	  }
	    	  else {
	    		  JOptionPane.showMessageDialog(null,"로그인 실패");
	    	  }
	      }
	      
	      
	}

}
