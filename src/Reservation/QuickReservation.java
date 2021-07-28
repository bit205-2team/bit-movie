package Reservation;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class QuickReservation extends JPanel {
   
   TitlePanel titlePanel = new TitlePanel(); // Ÿ��Ʋ �г�
   JPanel topPanel = new JPanel(); // �ο�/ �¼� ���� �� �г�(north ���� �г�)
   JPanel setScreenPanel = new JPanel(); // ��ũ�� �¼� ��ġ�� �� �г�  (Border)North= screen Center = seat
   JPanel screenPanel = new JPanel();    // ��ũ���� �� �г� 
   JPanel setseatPanel = new JPanel();   // �¼� ���̽� �г�
   JPanel seatPanel = new JPanel(); // �¼� �г�
   JPanel TicketingPanel = new JPanel(); // ���� �г�
   JPanel seatprice = new JPanel(); // �¼��� ����
   JPanel seatpriceNorth = new JPanel(); // �¼� ���ʶ���.
   JPanel peoplecount = new JPanel(); // �ο� üũ
   JPanel seatPriceCenter = new JPanel();
   JPanel peopleComboPanel = new JPanel();
   
   JLabel setToplabel = new JLabel("�ο�/ �¼�");
   JLabel screenLabel = new JLabel("screen");
   JLabel imgLabel = new JLabel();
   JLabel imgtextLable = new JLabel("  2D 1�� 3�� / A13, A14  ");
   JLabel imgtextLable1 = new JLabel(" 2021.07.17(ȭ) 13:10~15:20 11000��  ");
   JLabel seatPriceLabel = new JLabel("�¼��� �ݾ� �ȳ�");
   JLabel peopleComboLabel = new JLabel("�Ϲ�   ");
   
   String[] people = {"1��","2��","3��","4��"};
   JComboBox peopleCombo = new JComboBox(people);
   
  
   
   public QuickReservation() {

//      setSize(1200,500);
//      setVisible(true);
    
	//�� ��Ʈ����
	  peopleComboLabel.setFont(new Font("����",Font.BOLD, 20));
      setToplabel.setFont(new Font("����",Font.BOLD, 20));
      screenLabel.setFont(new Font("����",Font.BOLD, 30));
      imgtextLable1.setFont(new Font("����",Font.BOLD,20));
      

    //�ο� / �˼� �г�
      
      TitledBorder panLine = new TitledBorder(new TitledBorder(new LineBorder(Color.black,5))); 
      topPanel.add(setToplabel);
      topPanel.setBorder(panLine);
      topPanel.setBounds(10,50,1165,50);
      
    //��ũ�� �˼� �г� 
      
      TitledBorder setScreenpanLine = new TitledBorder(new TitledBorder(new LineBorder(Color.black,2))); // �¼� ��ũ�� �ʱ� �г�
      TitledBorder screenpanLine = new TitledBorder(new TitledBorder(new LineBorder(Color.black,4))); // ��ũ�� �г�
      TitledBorder seatPanelLine = new TitledBorder(new TitledBorder(new LineBorder(Color.black,4)));   // �¼� �г�
    
      setScreenPanel.setBorder(setScreenpanLine);
      setScreenPanel.setBounds(10,100,582,430);
     
      screenPanel.setBorder(screenpanLine);
      screenPanel.setBackground(Color.orange);
      screenPanel.setBounds(40, 120, 520, 45);
      screenPanel.add(screenLabel);
      
    //�¼� �г�
      
      seatPanel.setBorder(seatPanelLine);
    
      
      int num = 35;
      for(int i = 0; i < num; i++) {
       JToggleButton[] btn = new JToggleButton[num];
       String btname = "A";
       btname = btname+(i+1);
       btn[i] = new JToggleButton(btname);  
      
       btn[i].setBackground(Color.LIGHT_GRAY);
       if(i >= 14) btn[i].setBackground(Color.red);
       if(i >= 28) btn[i].setBackground(Color.green);
       
       seatPanel.setLayout(new GridLayout(5,6,10,5));
       seatPanel.add(btn[i]);
      }
      
      seatPanel.setBounds(65,210,470,300);
      
     //�¼� ���� �г�
      
      TitledBorder seatpanLine = new TitledBorder(new TitledBorder(new LineBorder(Color.black,2)));
      setseatPanel.setBorder(seatpanLine);
      setseatPanel.setBounds(592,100,582,430);
      
     //���� �г�
      
      TitledBorder Ticketing = new TitledBorder(new TitledBorder(new LineBorder(Color.black,4)));
      TicketingPanel.setBorder(Ticketing);
      TicketingPanel.setBounds(592,430,582,100);
      ImageIcon img1 = new ImageIcon(".\\src\\img\\poster.jpg");
      
      
      Image img = img1.getImage();
      Image im2 = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
      ImageIcon img2 = new ImageIcon(im2);
      imgLabel = new JLabel(img2);
      
      Box box1 = Box.createVerticalBox();
      Box box2 = Box.createVerticalBox();
      
      box1.add(imgtextLable);
      box1.add(Box.createVerticalStrut(15));
      box1.add(imgtextLable1);
      
      JButton reservationBtn = new JButton("�����ϱ�");
      reservationBtn.setBackground(Color.CYAN);
      box2.add(Box.createVerticalStrut(20));
      box2.add(reservationBtn);
      
      TicketingPanel.add(imgLabel);
      TicketingPanel.add(box1);
      TicketingPanel.add(box2);
      
   //�ο� �г�
      TitledBorder seatpriceLine = new TitledBorder(new TitledBorder(new LineBorder(Color.black,2)));
      TitledBorder seatpriceNorthLine = new TitledBorder(new TitledBorder(new LineBorder(Color.black,1)));
      
      Box btnBox = Box.createVerticalBox();
      Box btnBox1 = Box.createVerticalBox();
      
      
      String[] seatPriceString = {"9000","10000","11000"};
     
      btnBox.add(Box.createVerticalStrut(20));
      btnBox1.add(Box.createVerticalStrut(20));
      
      for(int i = 0; i < 3; i++) {
      JLabel[] labelbtn = new JLabel[3];
      labelbtn[i] = new JLabel("     ");  
      labelbtn[i].setOpaque(true);
      
      if(i==0) labelbtn[i].setBackground(Color.LIGHT_GRAY);
      if(i==1) labelbtn[i].setBackground(Color.green);
      if(i==2) labelbtn[i].setBackground(Color.red);
      
      JLabel[] label = new JLabel[3];
      label[i] = new JLabel(seatPriceString[i]);
      
      btnBox.add(labelbtn[i]);
      btnBox1.add(label[i]);
      btnBox.add(Box.createVerticalStrut(5));
      btnBox1.add(Box.createVerticalStrut(5));
      }
         
      peoplecount.setBorder(seatpriceLine);
      peoplecount.setLayout(new BorderLayout());
      
      seatPriceCenter.add(btnBox);
      seatPriceCenter.add(btnBox1);
      
      seatpriceNorth.setBorder(seatpriceNorthLine);
      seatpriceNorth.add(seatPriceLabel);
     
      peoplecount.add(seatpriceNorth, new BorderLayout().NORTH);
      peoplecount.add(seatPriceCenter,new BorderLayout().CENTER);

      peoplecount.setBounds(630, 190, 150, 150);
      peopleComboPanel.setBounds(830, 230, 180, 50);
      
      peopleCombo.setPreferredSize(new Dimension(100,40));
      
      peopleComboPanel.add(peopleComboLabel);
      peopleComboPanel.add(peopleCombo);
      
      setLayout(null);
      add(peopleComboPanel);
      add(titlePanel);
      add(peoplecount);
      add(TicketingPanel);
      add(seatPanel);
      add(screenPanel);
      add(setseatPanel);
      add(setScreenPanel);
      add(topPanel);

      

   }
   	class MyButtonTarget implements ActionListener {
	   
	   public void actionPerformed(ActionEvent e) {
		   System.out.println("�ȳ�");
	   }
   }
}