package Sign;

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

import DBconnection.MovieDAO;
import DBconnection.MovieVO;

public class SignUp extends JPanel implements ActionListener{

   String[] labelname = {"ȸ������","ID","password","name","birth","tel","email"};
   String[] btnname = {"�ߺ�Ȯ��","ȸ������"};
   int[] sum = {500,380,260,320,335,363,323}; // x��ǥ
   int[] num = {50,100,150,200,250,300,350};  // y��ǥ
   int j = 105;
   JTextField idtext,pawtext,nametext,birthtext,teltext,emailtext;
   
   public SignUp() {
     
	JButton[] btnid = new JButton[2];
    JLabel label[] = new JLabel[labelname.length];
	
//��ư ��ġ
    
    for(int i = 0; i < btnname.length; i++) {
	   btnid[i] = new JButton(btnname[i]);
	      if(i==0) btnid[i].setBounds(710,110,100,20);
	      if(i==1) btnid[i].setBounds(500,400,150,30);
	    add(btnid[i]);
	    btnid[i].addActionListener(this);
   }

// �� ��ġ
   for(int i = 0; i < labelname.length; i++) {
	   
         label[i] = new JLabel(labelname[i]);
         label[i].setFont(new Font("����",Font.BOLD,30));
         label[i].setBounds(sum[i],num[i],150,40);         
         
         add(label[i]);
         
      }
   
 // �ؽ�Ʈ�ʵ� ��ġ		
   
   idtext = new JTextField();
   idtext.setBounds(430, 105, 270, 30);
   add(idtext);
  
   pawtext = new JTextField();
   pawtext.setBounds(430, 155, 270, 30);
   add(pawtext);
   
   nametext = new JTextField();
   nametext.setBounds(430, 205, 270, 30);
   add(nametext);
   
   birthtext = new JTextField();
   birthtext.setBounds(430, 255, 270, 30);
   add(birthtext);
   
   teltext = new JTextField();
   teltext.setBounds(430, 305, 270, 30);
   add(teltext);
   
   emailtext = new JTextField();
   emailtext.setBounds(430, 355, 270, 30);
   add(emailtext);
   
   
     setLayout(null);
   }
   
   
   
   
   @Override
   public void actionPerformed(ActionEvent e) {
	   MovieDAO db = new MovieDAO();
	   MovieVO vo = new MovieVO();
	   
      JButton button = (JButton)e.getSource();
      String btn = button.getText();
  
      if(btn.equals("�ߺ�Ȯ��")) {
  
    	 if(db.idSelect(idtext.getText())) {
    	 JOptionPane.showMessageDialog(null,"�̹� ���Ե� ���̵��Դϴ�.");
    	 }else if(db.idSelect(idtext.getText())==false) {
    		 JOptionPane.showMessageDialog(null,"��ϰ����� ���̵��Դϴ�.");
    		 System.out.println(idtext.getText());
    	 }

      } 
      
      else if(btn.equals("ȸ������")) {
    	  
    	  if(db.idSelect(idtext.getText())==false) {
    		 vo.setUser_Member(idtext.getText(), pawtext.getText(), nametext.getText(), birthtext.getText(), teltext.getText(), emailtext.getText());
    		
    		 System.out.println(vo.getUser_id()+"/"+vo.getUser_birth());
    		 db.insertRecord(vo); 
    		 System.out.println(db.insertRecord(vo));
    	  }
      }
      
   }
}