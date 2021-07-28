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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp extends JPanel implements ActionListener{

   String[] labelname = {"회원가입","ID","password","name","birth","tel","email"};
   String[] btnname = {"중복확인","회원가입"};
   int[] sum = {500,380,260,320,335,363,323}; // x죄표
   int[] num = {50,100,150,200,250,300,350};  // y좌표
   int j = 105;
   
   public SignUp() {
      
	   
	JButton[] btnid = new JButton[2];
    JLabel label[] = new JLabel[labelname.length];
    JTextField textfield[] = new JTextField[7];
	
    
    for(int i = 0; i < btnname.length; i++) {
	   btnid[i] = new JButton(btnname[i]);
	      if(i==0) btnid[i].setBounds(710,110,100,20);
	      if(i==1) btnid[i].setBounds(500,400,150,30);
	    add(btnid[i]);
   }
	
   for(int i = 0; i < labelname.length; i++) { // 라벨
	   
         label[i] = new JLabel(labelname[i]);
         label[i].setFont(new Font("굴림",Font.BOLD,30));
         label[i].setBounds(sum[i],num[i],150,40);         
         
         add(label[i]);
         
      }
   		
   for(int i = 0; i < 6; i++) { //텍스트필드
   
         textfield[i] = new JTextField();
         textfield[i].setBounds(430, j, 270, 30);
         j += 50;
         
         add(textfield[i]);
      }
      
     
     setLayout(null);
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      
      JButton button = (JButton)e.getSource();
      String btn = button.getText();
      if(btn.equals("중복확인")) {
         SignUp signup = new SignUp();
         System.out.println("실행");
      }
      
   }
}