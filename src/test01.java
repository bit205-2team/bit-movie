import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
                  //JPanel ����
public class test01 extends JPanel {
   
   JPanel titlePanel = new JPanel();
   JPanel mainPanel =  new JPanel();
   
   JLabel titleLabel = new JLabel("���� ����");
   JLabel titleLabel2 = new JLabel(" | ");
   JLabel titleLabel1 = new JLabel("�󿵽ð�ǥ");
   JLabel setToplabel = new JLabel("�ο�/ �¼�");
   JLabel screenLabel = new JLabel("screen");
   
   public test01() {
        
        //setSize(1200,800);
         
     // ��Ʈ ����    
       setLayout(null);
       titleLabel.setFont(new Font("����",Font.BOLD, 20)); 
       titleLabel2.setFont(new Font("����",Font.BOLD, 20));
       titleLabel1.setFont(new Font("����",Font.BOLD, 20));
       
     // Ÿ��Ʋ �г�
      titlePanel.setBounds(10,10,1165,30);
       titlePanel.setBackground(Color.orange);  
       titlePanel.add(titleLabel);   // "���� ����"
       titlePanel.add(titleLabel2);  //  "|"
       titlePanel.add(titleLabel1);  // "�󿵽ð�ǥ"
         
         
       //main �г� **
       mainPanel.setBounds(0, 40, 1200, 722);
         
        
         
         
         
       add(mainPanel);
       add(titlePanel);
      
       //���۽ÿ� �ּ�ó�� 
//       setVisible(true);
//       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   }

   public static void main(String[] args) {
      new test01();

   }

}