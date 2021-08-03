
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SeatReservation extends JPanel implements ActionListener {
   static int b = 0 ;
   static List<String> list = new ArrayList<String>();
   static List<String> list1 = new ArrayList<String>();
   static int bb1 = 1;
   static int bb2 = 0;
   
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
   
  
   
   public SeatReservation() {

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
       btn[i].addActionListener(this);
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
      ImageIcon img1 = new ImageIcon("./img/cruella.jfif");
      
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
      
      peopleCombo.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
  		  JComboBox cd = (JComboBox)e.getSource();
  		  String index = cd.getSelectedItem().toString();
  		  
  		  if(index.equals("1��")) {
  			  bb1 = 1;
  		  } else if(index.equals("2��")) {
  			  bb1 = 2;
  		  } else if(index.equals("3��")) {
  			  bb1 = 3;
  		  } else if(index.equals("4��")) {
  			  bb1 = 4;
  		  }
  		    
  	  }


      });
      
      
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
   
   
   public void seatAC(String seat) {
	MovieDAO dao = new MovieDAO();
	int a = dao.seatCheck(seat);
	
   	if(list.indexOf(seat) != -1) {list.remove(list.indexOf(seat));}
   	if(list1.indexOf(seat) != -1) {a=0; list1.remove(list1.indexOf(seat));}
   	if(a==1) {JOptionPane.showMessageDialog(null,"�̹� ����� �¼��Դϴ�."); list1.add(seat);}
   	if(a==0 && list.indexOf(seat) == -1) {list.add(seat);}
   
   }
   
   public void actionPerformed(ActionEvent e) {
	   MovieDAO dao = new MovieDAO();
		
	   JToggleButton button = (JToggleButton)e.getSource();
	    String btn = button.getText();
	    
	   
	    
	    if(bb1>=bb2) {
	    	bb2++;
	    }
	    if(bb1<bb2) {
	    	JOptionPane.showMessageDialog(null,"�¼��� ��� �����ϼ̽��ϴ�.");
	    }
	    
	    System.out.println(list.size());
	    if(btn.equals("A1")) {
	    	seatAC("A-1");
	    } else if(btn.equals("A2")) {
	    	seatAC("A-2");
	    } else if(btn.equals("A3")) {
	    	seatAC("A-3");
	    } else if(btn.equals("A4")) {
	    	seatAC("A-4");
	    } else if(btn.equals("A5")) {
	    	seatAC("A-5");
	    } else if(btn.equals("A6")) {
	    	seatAC("A-6");
	    } else if(btn.equals("A7")) {
	    	seatAC("A-7");
	    } else if(btn.equals("A8")) {
	    	seatAC("A-8");
	    } else if(btn.equals("A9")) {
	    	seatAC("A-9");
	    } else if(btn.equals("A10")) {
	    	seatAC("A-10");
	    } else if(btn.equals("A11")) {
	    	seatAC("A-11");
	    } else if(btn.equals("A12")) {
	    	seatAC("A-12");
	    } else if(btn.equals("A13")) {
	    	seatAC("A-13");
	    } else if(btn.equals("A14")) {
	    	seatAC("A-14");
	    } else if(btn.equals("A15")) {
	    	seatAC("A-15");
	    } else if(btn.equals("A16")) {
	    	seatAC("A-16");
	    } else if(btn.equals("A17")) {
	    	seatAC("A-17");
	    } else if(btn.equals("A18")) {
	    	seatAC("A-18");
	    } else if(btn.equals("A19")) {
	    	seatAC("A-19");
	    } else if(btn.equals("A20")) {
	    	seatAC("A-20");
	    } else if(btn.equals("A21")) {
	    	seatAC("A-21");
	    } else if(btn.equals("A22")) {
	    	seatAC("A-22");
	    } else if(btn.equals("A23")) {
	    	seatAC("A-23");
	    } else if(btn.equals("A24")) {
	    	seatAC("A-24");
	    } else if(btn.equals("A25")) {
	    	seatAC("A-25");
	    } else if(btn.equals("A26")) {
	    	seatAC("A-26");
	    } else if(btn.equals("A27")) {
	    	seatAC("A-27");
	    } else if(btn.equals("A28")) {
	    	seatAC("A-28");
	    } else if(btn.equals("A29")) {
	    	seatAC("A-29");
	    } else if(btn.equals("A30")) {
	    	seatAC("A-30");
	    } else if(btn.equals("A31")) {
	    	seatAC("A-31");
	    } else if(btn.equals("A32")) {
	    	seatAC("A-32");
	    } else if(btn.equals("A33")) {
	    	seatAC("A-33");
	    } else if(btn.equals("A34")) {
	    	seatAC("A-34");
	    } else if(btn.equals("A35")) {
	    	seatAC("A-35");
	    }
   }
}

   