import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
                  //JPanel 변경
public class test01 extends JPanel {
   
   JPanel titlePanel = new JPanel();
   JPanel mainPanel =  new JPanel();
   
   JLabel titleLabel = new JLabel("빠른 예매");
   JLabel titleLabel2 = new JLabel(" | ");
   JLabel titleLabel1 = new JLabel("상영시간표");
   JLabel setToplabel = new JLabel("인원/ 좌석");
   JLabel screenLabel = new JLabel("screen");
   
   public test01() {
        
        //setSize(1200,800);
         
     // 폰트 지정    
       setLayout(null);
       titleLabel.setFont(new Font("굴림",Font.BOLD, 20)); 
       titleLabel2.setFont(new Font("굴림",Font.BOLD, 20));
       titleLabel1.setFont(new Font("굴림",Font.BOLD, 20));
       
     // 타이틀 패널
      titlePanel.setBounds(10,10,1165,30);
       titlePanel.setBackground(Color.orange);  
       titlePanel.add(titleLabel);   // "빠른 예매"
       titlePanel.add(titleLabel2);  //  "|"
       titlePanel.add(titleLabel1);  // "상영시간표"
         
         
       //main 패널 **
       mainPanel.setBounds(0, 40, 1200, 722);
         
        
         
         
         
       add(mainPanel);
       add(titlePanel);
      
       //시작시에 주석처리 
//       setVisible(true);
//       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   }

   public static void main(String[] args) {
      new test01();

   }

}