
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import DBconnection.MovieVO;
// 수정
public class SignUp extends JPanel implements ActionListener{

   String[] labelname = {"회원가입","ID","password","name","birth","tel","email"};
   String[] btnname = {"중복확인","회원가입"};
   int[] sum = {500,380,260,320,335,363,323}; // x죄표
   int[] num = {5,65,125,180,250,315,380};  // y좌표
   int j = 105;
   JTextField idtext,pawtext,nametext,birthtext,teltext,emailtext;
   
   public SignUp() {
     
	JButton[] btnid = new JButton[2];
    JLabel label[] = new JLabel[labelname.length];
	
//버튼 위치
    TitledBorder btn = new TitledBorder(new TitledBorder(new LineBorder(Color.gray,2)));
    for(int i = 0; i < btnname.length; i++) {
	   btnid[i] = new JButton(btnname[i]);
	      if(i==0) { btnid[i].setBounds(715,92,110,35); btnid[i].setBackground(Color.white); btnid[i].setBorder(btn);}
	      if(i==1) { btnid[i].setBounds(450,465,230,50); btnid[i].setBackground(Color.pink); }
	    add(btnid[i]);
	    btnid[i].addActionListener(this);
   }

// 라벨 위치
   for(int i = 0; i < labelname.length; i++) {
	   
         label[i] = new JLabel(labelname[i]);
         label[i].setFont(new Font("굴림",Font.BOLD,30));
         label[i].setBounds(sum[i],num[i],150,90);         
         
         add(label[i]);
         
      }
   
 // 텍스트필드 위치		
   TitledBorder Loginpan = new TitledBorder(new TitledBorder(new LineBorder(Color.black,3)));
   idtext = new JTextField();
   idtext.setBackground(Color.white);
   idtext.setBorder(Loginpan);
   idtext.setBounds(430, 90, 270, 40);
   add(idtext);

   pawtext = new JTextField();
   pawtext.setBorder(Loginpan);
   pawtext.setBounds(430, 150, 270, 40);
   add(pawtext);
   
   nametext = new JTextField();
   nametext.setBorder(Loginpan);
   nametext.setBounds(430, 210, 270, 40);
   add(nametext);
   
   birthtext = new JTextField();
   birthtext.setBorder(Loginpan);
   birthtext.setBounds(430, 275, 270, 40);
   add(birthtext);
   
   teltext = new JTextField();
   teltext.setBorder(Loginpan);
   teltext.setBounds(430, 340, 270, 40);
   add(teltext);
   
   emailtext = new JTextField();
   emailtext.setBorder(Loginpan);
   emailtext.setBounds(430, 405, 270, 40);
   add(emailtext);
   
   	 setBackground(Color.white);
     setLayout(null);
   }
   
   
   
   
   @Override
   public void actionPerformed(ActionEvent e) {
	   MovieDAO db = new MovieDAO();
	   MovieVO vo = new MovieVO();
	  
       JButton button = (JButton)e.getSource();
       String btn = button.getText();
  
      if(btn.equals("중복확인")) {
  
    	 if(db.idSelect(idtext.getText())) {
    	 JOptionPane.showMessageDialog(null,"이미 가입된 아이디입니다.");
    	 }else if(db.idSelect(idtext.getText())==false) {
    		 JOptionPane.showMessageDialog(null,"등록가능한 아이디입니다.");
    		 System.out.println(idtext.getText());
    	 }

      } 
      
      else if(btn.equals("회원가입")) {
    	  
    	  if(db.idSelect(idtext.getText())==false) {
    		 vo.setMember(idtext.getText(), pawtext.getText(), nametext.getText(), birthtext.getText(), teltext.getText(), emailtext.getText());
    		
    		 System.out.println(vo.getId()+"/"+vo.getBirth()+"/"+vo.getEmail());
    		 db.insertRecord(vo); 
    		 JOptionPane.showMessageDialog(null,"회원가입 완료");
    	  }
      }
      
   }
}